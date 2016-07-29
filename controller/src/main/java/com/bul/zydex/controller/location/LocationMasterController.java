package com.bul.zydex.controller.location;

import com.bul.zydex.model.LocationMaster;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class LocationMasterController extends LocationMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response, LocationMaster locationMaster) throws Exception {
        List<?> locationList = locationMasterService.read();
        return new ModelAndView("Location/LocationList", "locationList", locationList);
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response, LocationMaster locationMaster) throws Exception {
         if (locationMaster.getId() != null) {
            locationMaster = locationMasterService.readById(locationMaster.getId());
        }
        return new ModelAndView("Location/LocationCreate", "locationMaster", locationMaster);

    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, LocationMaster locationMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        bind(request, locationMaster);
        BindException errors = new BindException(locationMaster, "locationMaster");
        locationMasterValidator.validate(locationMaster, errors);
        if (errors.hasErrors()) {
            if (errors.hasFieldErrors("location")) {
                mv.addObject("failureMessage", "Error : Information Is Not Valid.");
                mv.addAllObjects(errors.getModel());
                mv.setViewName("Location/LocationCreate");
            }
        } else {
            if (locationMasterService.isExist(locationMaster)) {
                locationMasterService.createOrUpdate(locationMaster);
                List<?> locationList = locationMasterService.read();
                mv.addObject("locationList", locationList);
                mv.addObject("successMessage", "Information : Information Saved Successfully.");
                mv.setViewName("Location/LocationList");
            } else {
                mv.addObject("failureMessage", "Error : Information Is Already Exist. ");
                mv.setViewName("Location/LocationCreate");
            }
        }
        mv.getModelMap().put("locationMaster", locationMaster);
        return mv;
    }

    public ModelAndView deleteClick(HttpServletRequest request, HttpServletResponse response, LocationMaster locationMaster) throws Exception {
        String[] checkId = request.getParameterValues("checkId");
        String checkStr = "";
        ModelAndView mv = new ModelAndView();
        int count = 0;
//        List<String> checkIdList = Arrays.asList(checkId);
//            checkIdList.forEach((checkedValues) -> departmentMasterService.delete(Integer.parseInt(checkedValues)));
        boolean flag = false;
        for (String checkedValues : checkId) {
            try {
                locationMasterService.delete(Integer.parseInt(checkedValues));
            } catch (Exception e) {
                try {
                    locationMaster = locationMasterService.readById(Integer.parseInt(checkedValues));
                    if (count == 0) {
                        checkStr += locationMaster.getLocation();
                    } else {
                        checkStr += "," + locationMaster.getLocation();
                    }
                    count++;
                    flag = true;
                } catch (Exception ee) {

                }
            }
        }
        if (flag) {
            mv.addObject("failureMessage", "Error : In Use, Can't Be Deleted.....  " + "<b>" + checkStr + "</b>");
        } else {
            mv.addObject("successMessage", "Information Is Deleted Successfully.");
        }
        mv.setViewName("forward:locationMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response, LocationMaster locationMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List iterateEmployee = locationMasterService.readEmpByLocation();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (Object o : iterateEmployee) {
            Object[] temparray = (Object[]) o;
            sb.append("['").append(temparray[0]).append("', ").append(temparray[1]).append("],");
        }
        String locationWiseEmployeeString= sb.toString();
        if (locationWiseEmployeeString.length()>1) {
        mv.addObject("locationWiseEmployee", sb.toString().substring(0, sb.toString().length() - 1));
        }
        mv.setViewName("forward:departmentMaster.htm?act=hrDashboardResignation");
        return mv;
    }

}
