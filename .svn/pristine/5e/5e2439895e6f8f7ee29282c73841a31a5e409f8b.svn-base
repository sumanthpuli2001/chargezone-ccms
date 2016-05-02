/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.location;

import com.bul.zydex.controller.location.VisitorVisitedLocationAbstract;
import com.bul.zydex.model.VisitorVisitedLocation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BlackBull
 */
public class VisitorVisitedLocationController extends VisitorVisitedLocationAbstract {

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        bind(request, visitorVisitedLocation);
        List<?> locationList = visitorVisitedLocationService.read();
        request.setAttribute("locationList", locationList);
        mv.getModelMap().put("visitorVisitedLocation", visitorVisitedLocation);
        mv.setViewName("VisitorManagement/VisitorVisitedLocation");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        bind(request, visitorVisitedLocation);
        String Location = visitorVisitedLocation.getLocation();
        List List = visitorVisitedLocationService.isExist(Location);
        if (!List.isEmpty()) {
            request.setAttribute("failuremessage", "Data Already Exist");
        } else {
            visitorVisitedLocationService.create(visitorVisitedLocation);
            request.setAttribute("successmessage", "Data Added Successfully");
        }
        List<?> locationList = visitorVisitedLocationService.read();
        request.setAttribute("locationList", locationList);
        mv.getModelMap().put("visitorVisitedLocation", visitorVisitedLocation);
        mv.setViewName("VisitorManagement/VisitorVisitedLocation");
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String[] id = request.getParameterValues("id");
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        bind(request, visitorVisitedLocation);
        try {
            if (id != null) {
                for (int i = 0; i < id.length; i++) {
                    visitorVisitedLocationService.delete(Integer.parseInt(id[i]));
                    request.setAttribute("successmessage", "Name Deleted Successfully");
                    mv=createClick(request, response);
                }
            } else {
                request.setAttribute("failuremessage", "Name Cannot Be Deleted");
                mv=createClick(request, response);
            }

        } catch (Exception e) {
            System.err.println(e + "Exception Occured");
        }
        List<?> locationList = visitorVisitedLocationService.read();
        request.setAttribute("locationList", locationList);
        mv.getModelMap().put("visitorVisitedLocation", visitorVisitedLocation);
        mv.setViewName("VisitorManagement/VisitorVisitedLocation");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        bind(request, visitorVisitedLocation);
        String id = request.getParameter("id");
        visitorVisitedLocation = visitorVisitedLocationService.readById(Integer.parseInt(id));
        visitorVisitedLocation.setId(Integer.parseInt(id));
        mv.getModelMap().put("visitorVisitedLocation", visitorVisitedLocation);
        mv.setViewName("VisitorManagement/VisitorVisitedLocationEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VisitorVisitedLocation visitorVisitedLocation = new VisitorVisitedLocation();
        bind(request, visitorVisitedLocation);
        String id = request.getParameter("id");
        String Location = visitorVisitedLocation.getLocation();
        List Loc_Exist = visitorVisitedLocationService.isExist(Location);
        try {
            if (Loc_Exist.isEmpty()) {
                visitorVisitedLocationService.update(visitorVisitedLocation);
                request.setAttribute("successmessage","Data Updated Successfully");
            }else{
                request.setAttribute("failuremessage","Data Already Exist");
            }
        } catch (Exception e) {
        }
        mv.getModelMap().put("visitorVisitedLocation", visitorVisitedLocation);
        mv=createClick(request, response);
        return mv;
    }

}
