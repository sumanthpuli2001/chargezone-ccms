/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller;

import com.bul.zydex.model.IntervalMaster;
import com.bul.zydex.service.IntervalMasterService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BlackBull
 */
public class IntervalMasterController extends IntervalMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        IntervalMaster intervalMaster = new IntervalMaster();
        bind(request, intervalMaster);
        List intervalList = intervalMasterService.read();
        mv.getModelMap().put("intervalList", intervalList);
        mv.getModelMap().put("intervalMaster", intervalMaster);
        mv.setViewName("Common/IntervalMasterPage");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        IntervalMaster intervalMaster = new IntervalMaster();
        bind(request, intervalMaster);
        if (intervalMaster != null) {
            intervalMasterService.create(intervalMaster);
            request.setAttribute("successmessage", "The Data Saved Succesully");
        } else {
            request.setAttribute("failuremessage", "The Data Save Unsucessfull");
        }
        List intervalList = intervalMasterService.read();
        mv.getModelMap().put("intervalList", intervalList);
        mv.getModelMap().put("intervalMaster", intervalMaster);
        mv.setViewName("Common/IntervalMasterPage");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        IntervalMaster intervalMaster = new IntervalMaster();
        bind(request, intervalMaster);
        String id = request.getParameter("id");
        intervalMaster = intervalMasterService.readById(Integer.parseInt(id));
        intervalMaster.setId(Integer.parseInt(id));
        mv.getModelMap().put("intervalMaster", intervalMaster);
        mv.setViewName("Common/IntervalMasterEditPage");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        IntervalMaster intervalMaster = new IntervalMaster();
        bind(request, intervalMaster);
        String id = request.getParameter("id");
        intervalMasterService.update(intervalMaster);
        intervalMaster = intervalMasterService.readById(Integer.parseInt(id));
        List intervalList = intervalMasterService.read();
        mv.getModelMap().put("intervalList", intervalList);
        mv.getModelMap().put("intervalMaster", intervalMaster);
        mv.setViewName("Common/IntervalMasterPage");
        return mv;
    }
}
