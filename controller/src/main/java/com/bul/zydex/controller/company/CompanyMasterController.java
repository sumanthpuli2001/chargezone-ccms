/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.company;

import com.bul.zydex.model.Company;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author OptiPlex
 */
public class CompanyMasterController extends CompanyMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, Company companyMaster) throws Exception {
        ModelAndView mv = new ModelAndView("Company/CompanyList", "companyMaster", companyMaster);
        List<?> companyList = companyMasterService.read();
        mv.addObject("companyList", companyList);
        return mv;

    }

    public ModelAndView createNew(HttpServletRequest request, HttpServletResponse response, Company companyMaster) throws Exception {

        return new ModelAndView("Company/CompanyCreate", "companyMaster", companyMaster);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, Company companyMaster) throws Exception {
        BindException errors = new BindException(companyMaster, "companyMaster");
        bind(request, companyMaster);
        ModelAndView mv = new ModelAndView();
//        CompanyMasterValidator.validate(companyMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("companyMaster", companyMaster);
            mv.setViewName("Company/CompanyCreate");
        } else {
            if ("" != companyMaster.getCompanyName()) {
                if (companyMasterService.isExist(companyMaster)) {
                    companyMasterService.createOrUpdate(companyMaster);
                    List<?> companyList = companyMasterService.read();
                    mv.addObject("companyList", companyList);
                    mv.addObject("successMessage", "Information : Information Saved Successfully.");
                    mv.setViewName("Company/CompanyList");
                    return mv;
                } else {
                    mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
                    mv.setViewName("Company/CompanyCreate");
                }
            }
            mv.setViewName("Company/CompanyCreate");
            mv.addObject("failureMessage", "Error : Please Enter CompanyName. ");
        }
        mv.getModelMap().put("companyMaster", companyMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, Company companyMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                companyMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    companyMaster = companyMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += companyMaster.getCompanyName();
                    } else {
                        checkStr += "," + companyMaster.getCompanyName();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            request.setAttribute("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            request.setAttribute("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:companyMaster.htm?act=showList");
        return mv;
    }
}
