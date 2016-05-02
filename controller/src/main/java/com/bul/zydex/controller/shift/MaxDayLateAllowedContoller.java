/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.MaxDayLateAllowed;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class MaxDayLateAllowedContoller extends MaxDayLateAllowedAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MaxDayLateAllowed maxDayLateAllowed = new MaxDayLateAllowed();
        mv.getModelMap().put("maxDayLateAllowed", maxDayLateAllowed);
        mv.setViewName("Shift/MaxDayLateAllowedCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MaxDayLateAllowed maxDayLateAllowed = new MaxDayLateAllowed();
        BindException errors = new BindException(maxDayLateAllowed, "maxDayLateAllowed");

        bind(request, maxDayLateAllowed);
        maxDayLateAllowedValidator.validate(maxDayLateAllowed, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = createClick(request, response);
        } else {
            maxDayLateAllowedService.create(maxDayLateAllowed);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv.setViewName("redirect:maxDayLateAllowed.htm?act=searchSubmit");
        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MaxDayLateAllowed maxDayLateAllowed = new MaxDayLateAllowed();
        List<?> list = maxDayLateAllowedService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("maxDayLateAllowed", maxDayLateAllowed);
        mv.setViewName("Shift/MaxDayLateAllowedResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MaxDayLateAllowed maxDayLateAllowed = new MaxDayLateAllowed();
        String id = request.getParameter("id");
        maxDayLateAllowed = maxDayLateAllowedService.readById(Integer.parseInt(id));
        mv.getModelMap().put("maxDayLateAllowed", maxDayLateAllowed);
        mv.setViewName("Shift/MaxDayLateAllowedEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MaxDayLateAllowed maxDayLateAllowed = new MaxDayLateAllowed();
        BindException errors = new BindException(maxDayLateAllowed, "maxDayLateAllowed");

        bind(request, maxDayLateAllowed);
        maxDayLateAllowedValidator.validate(maxDayLateAllowed, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            maxDayLateAllowedService.update(maxDayLateAllowed);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");

            mv.setViewName("redirect:maxDayLateAllowed.htm?act=searchSubmit");
        }
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        MaxDayLateAllowed maxDayLateAllowed = new MaxDayLateAllowed();
        String maxDayId[] = request.getParameterValues("checkId");
        for (String z : maxDayId) {
            try {
                maxDayLateAllowedService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv.setViewName("redirect:maxDayLateAllowed.htm?act=searchSubmit");
        return mv;
    }
}
