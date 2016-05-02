/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.shift;

import com.bul.zydex.model.HoursBasis;
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
public class HoursBasisController extends HoursBasisAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HoursBasis hoursBasis = new HoursBasis();

        mv.getModelMap().put("hoursBasis", hoursBasis);
        mv.setViewName("Shift/HoursBasisCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HoursBasis hoursBasis = new HoursBasis();
        BindException errors = new BindException(hoursBasis, "hoursBasis");
        String ofDay = "";
        String weekOf[] = request.getParameterValues("weekOf");
        if (weekOf != null) {
            for (String s : weekOf) {
                ofDay += s + ",";
            }
        }
        hoursBasis.setWeekof(ofDay);
        bind(request, hoursBasis);
        hoursBasisValidator.validate(hoursBasis, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("hoursBasis", hoursBasis);
            mv.setViewName("Shift/HoursBasisCreate");
//            mv = createClick(request, response);
        } else {
            hoursBasisService.create(hoursBasis);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.setViewName("redirect:hoursBasis.htm?act=searchSubmit");
        }

        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HoursBasis hoursBasis = new HoursBasis();
        List<?> list = hoursBasisService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("hoursBasis", hoursBasis);
        mv.setViewName("Shift/HoursBasisResult");

        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HoursBasis hoursBasis = new HoursBasis();
        String id = request.getParameter("id");
        hoursBasis = hoursBasisService.readById(Integer.parseInt(id));
        String weekOf = hoursBasis.getWeekof();
        List ofDayList = new ArrayList();
        String OfDay[] = weekOf.split(",");
        for (String z : OfDay) {
            ofDayList.add(z);
        }
        mv.getModelMap().put("hoursBasis", hoursBasis);
        request.setAttribute("ofDayList", ofDayList);
        request.setAttribute("weekOf", weekOf);
        mv.setViewName("Shift/HoursBasisEdit");

        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HoursBasis hoursBasis = new HoursBasis();
        BindException errors = new BindException(hoursBasis, "hoursBasis");
        String ofDay = "";
        String weekOf[] = request.getParameterValues("weekOf");
        if (weekOf != null) {
            for (String s : weekOf) {
                ofDay += s + ",";
            }
        }
        hoursBasis.setWeekof(ofDay);
        String id = request.getParameter("id");
        hoursBasis.setId(Integer.parseInt(id));
        bind(request, hoursBasis);
        hoursBasisValidator.validate(hoursBasis, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv = viewClick(request, response);
        } else {
            hoursBasisService.update(hoursBasis);
            request.setAttribute("successMessage",
                    "Information : The Information is Updated Successfully.");

            mv.setViewName("redirect:hoursBasis.htm?act=searchSubmit");
        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String hoursId[] = request.getParameterValues("checkId");
        for (String z : hoursId) {
            try {
                hoursBasisService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv.setViewName("redirect:hoursBasis.htm?act=searchSubmit");

        return mv;
    }

}
