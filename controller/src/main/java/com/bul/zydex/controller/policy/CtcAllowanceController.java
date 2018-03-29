/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.model.CtcAllowance;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hussain
 */
public class CtcAllowanceController extends CtcAllowanceAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, CtcAllowance ctcAllowance) throws Exception {
        ModelAndView mv = new ModelAndView("Policy/ctcList", "ctcAllowance", ctcAllowance);
        List<?> ctcList = ctcAllowanceService.read();
        mv.addObject("ctcList", ctcList);
        return mv;

    }
     public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, CtcAllowance ctcAllowance) throws Exception {

        return new ModelAndView("Policy/ctcCreate", "ctcAllowance", ctcAllowance);
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response,CtcAllowance ctcAllowance) throws Exception {
        BindException errors = new BindException(ctcAllowance, "ctcAllowance");
        bind(request, ctcAllowance);
//        CtcValidator.validate(ctcAllowance, errors);
        ModelAndView mv = new ModelAndView();
//        if (errors.hasErrors()) {
//            request.setAttribute("failureMessage", "Error : Information Is Not Valid.");
//            mv.addAllObjects(errors.getModel());
//            mv.setViewName("Policy/ctcCreate");
//        } else {
            if (ctcAllowanceService.isExist(ctcAllowance)) {
                ctcAllowanceService.createOrUpdate(ctcAllowance);
                List<?> ctcList = ctcAllowanceService.read();
                mv.addObject("ctcList", ctcList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Policy/ctcList");
            } else {
                mv.setViewName("Policy/ctcCreate");
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
            }
//        }
        mv.getModelMap().put("ctcAllowance", ctcAllowance);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, CtcAllowance ctcAllowance) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                ctcAllowanceService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    ctcAllowance = ctcAllowanceService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += ctcAllowance.getCtcName();
                    } else {
                        checkStr += "," + ctcAllowance.getCtcName();
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
        mv.setViewName("forward:ctcAllowance.htm?act=showList");
        return mv;
    }

}
