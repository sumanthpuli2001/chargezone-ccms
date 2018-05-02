/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.model.RetirementAge;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hussain
 */
public class RetirementAgeController extends RetirementAgeAbstract {
    
    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, RetirementAge retirementAge) throws Exception {
        ModelAndView mv = new ModelAndView("Company/RetirementShow", "retirementAge", retirementAge);
//        RetirementAge retirementAge=new RetirementAge();
        List<?> companyList = retirementAgeService.read();
        mv.addObject("companyList", companyList);
        return mv;

    }

    public ModelAndView createNew(HttpServletRequest request, HttpServletResponse response, RetirementAge retirementAge) throws Exception {

        return new ModelAndView("Company/RetirementCreate", "retirementAge", retirementAge);
    }
    
    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, RetirementAge retirementAge) throws Exception {
        BindException errors = new BindException(retirementAge, "retirementAge");
        bind(request, retirementAge);
        ModelAndView mv = new ModelAndView();
        companyMasterValidator.validate(retirementAge, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("retirementAge", retirementAge);
            mv.setViewName("Company/RetirementCreate");
        } else {
//            if (retirementAgeService.isExist(retirementAge)) {
                retirementAgeService.createOrUpdate(retirementAge);
                List<?> companyList = retirementAgeService.read();
                mv.addObject("companyList", companyList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Company/RetirementShow");
//            } else {
//                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
//                mv.setViewName("Company/RetirementCreate");
//            }
        }
        mv.getModelMap().put("retirementAge", retirementAge);
        return mv;
    }
     public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, RetirementAge retirementAge) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                retirementAgeService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    retirementAge = retirementAgeService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += retirementAge.getRetireAge();
                    } else {
                        checkStr += "," + retirementAge.getRetireAge();
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
        mv.setViewName("forward:retirementAge.htm?act=showList");
        return mv;
    }
}
