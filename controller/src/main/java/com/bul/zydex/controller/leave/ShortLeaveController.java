/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.ShortLeave;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Khurshid Khokhar <Khokharkhurshid123@gmail.com>
 */
public class ShortLeaveController extends ShortLeaveAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShortLeave shortLeave = new ShortLeave();
//        shortLeave.setDepartmentMaster(new DepartmentMaster());
        shortLeave.setZydexLocationMaster(new ZydexLocationMaster());
        zydexLocationList(request);
        mv.getModelMap().put("shortLeave", shortLeave);
        mv.setViewName("Leave/ShortLeaveCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShortLeave shortLeave = new ShortLeave();
        BindException errors = new BindException(shortLeave, "shortLeave");
         zydexLocationList(request);
        bind(request, shortLeave);
        ShortLeaveValidator.validate(shortLeave, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
               mv.addAllObjects(errors.getModel());
                 mv.setViewName("Leave/ShortLeaveCreate");
//            mv.getModelMap().put("shortLeave", shortLeave);
//            mv = createClick(request, response);
        } else {
            if (!shortLeaveService.isExist(shortLeave)) {
                shortLeaveService.create(shortLeave);
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
                mv.setViewName("redirect:shortLeave.htm?act=searchSubmit");
            } else {
                request.setAttribute("failureMessage",
                        "Information : The Information is Already Exist.");
                mv = createClick(request, response);
            }
        }

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> shortLeaveList = shortLeaveService.read();
        for (Object o1 : shortLeaveList) {
            ShortLeave shortLeave = new ShortLeave();
            shortLeave = (ShortLeave) o1;
            shortLeave.setZydexLocationMaster(
                    zydexLocationMasterService.readById(Integer.parseInt("" + shortLeave.getZydexLocationMaster().getId())));
            mv.getModelMap().put("shortLeave", shortLeave);
        }

        mv.getModelMap().put("list", shortLeaveList);
        mv.setViewName("Leave/ShortLeaveResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShortLeave shortLeave = new ShortLeave();
        String id = request.getParameter("id");
        shortLeave = shortLeaveService.readById(Integer.parseInt(id));
        shortLeave.setZydexLocationMaster(
                zydexLocationMasterService.readById(Integer.parseInt("" + shortLeave.getZydexLocationMaster().getId())));
        mv.getModelMap().put("shortLeave", shortLeave);
        mv.setViewName("Leave/ShortLeaveView");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShortLeave shortLeave = new ShortLeave();
        BindException errors = new BindException(shortLeave, "shortLeave");
        shortLeave.setId(Integer.parseInt(request.getParameter("id")));
        bind(request, shortLeave);
        ShortLeaveValidator.validate(shortLeave, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            shortLeaveService.update(shortLeave);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");
            mv = searchSubmit(request, response);
        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String leaveTypeId[] = request.getParameterValues("checkId");
        for (String z : leaveTypeId) {
            try {
                shortLeaveService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

}
