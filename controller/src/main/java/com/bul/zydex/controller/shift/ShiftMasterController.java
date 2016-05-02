/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.ShiftMaster;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author AJAY
 */
public class ShiftMasterController extends ShiftMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftMaster shiftMaster = new ShiftMaster();
        mv.getModelMap().put("shiftMaster", shiftMaster);
        mv.setViewName("Shift/ShiftCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftMaster shiftMaster = new ShiftMaster();
        BindException errors = new BindException(shiftMaster, "shiftMaster");
        String ofDay = "";
        String weekOf[] = request.getParameterValues("weekOf");
        if (weekOf != null) {
            for (String s : weekOf) {
                ofDay += s + ",";
            }
        }
        shiftMaster.setWeekof(ofDay);
        shiftMaster.setEarlyHours("");
        bind(request, shiftMaster);
        shiftMasterValidator.validate(shiftMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
//            mv = createClick(request, response);
            mv.setViewName("Shift/ShiftCreate");
        } else {
            shiftMasterService.create(shiftMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

            mv.setViewName("redirect:shiftMaster.htm?act=searchSubmit");
        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftMaster shiftMaster = new ShiftMaster();
        List<?> list = shiftMasterService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("shiftMaster", shiftMaster);
        mv.setViewName("Shift/ShiftResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftMaster shiftMaster = new ShiftMaster();
        String id = request.getParameter("id");
        shiftMaster = shiftMasterService.readById(Integer.parseInt(id));
        String weekOf = shiftMaster.getWeekof();
        List ofDayList = new ArrayList();
        String OfDay[] = weekOf.split(",");
        for (String z : OfDay) {
            ofDayList.add(z);
        }
        mv.getModelMap().put("shiftMaster", shiftMaster);
        request.setAttribute("weekOf", weekOf);
        mv.setViewName("Shift/ShiftEdit");
        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftMaster shiftMaster = new ShiftMaster();
        String shiftId[] = request.getParameterValues("checkId");
        for (String z : shiftId) {
            try {
                shiftMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ShiftMaster shiftMaster = new ShiftMaster();

        BindException errors = new BindException(shiftMaster, "shiftMaster");
        String ofDay = "";
        if (null != request.getParameterValues("weekOf")) {
            String weekOf[] = request.getParameterValues("weekOf");
            for (String s : weekOf) {
                ofDay += s + ",";
            }
        }
        shiftMaster.setWeekof(ofDay);
        String id = request.getParameter("id");
        shiftMaster.setId(Integer.parseInt(id));
        shiftMaster.setEarlyHours("");
        bind(request, shiftMaster);
        shiftMasterValidator.validate(shiftMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            shiftMasterService.update(shiftMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");

            mv = searchSubmit(request, response);
        }
        return mv;
    }

    public void readShiftNameAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PrintWriter out = response.getWriter();
        ShiftMaster shiftMaster = new ShiftMaster();
        String shiftName = request.getParameter("shiftName");
        shiftMaster.setShiftName(shiftName);
        List<?> list = shiftMasterService.checkExistingShift(shiftMaster);

        boolean flag = true;
        if (!list.isEmpty()) {
            flag = false;
        }
        out.print(flag);
    }

}
