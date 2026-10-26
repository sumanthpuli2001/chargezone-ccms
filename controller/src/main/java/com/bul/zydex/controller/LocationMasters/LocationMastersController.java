/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.LocationMasters;

import com.bul.zydex.model.LocationMasters;
import com.bul.zydex.service.LocationMasters.LocationMastersService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sumanth
 */
public class LocationMastersController extends LocationMastersAbstract {

    public ModelAndView showlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("location/showlist");
        return mv;
    }

    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        List list10 = companyMasterService.read();
        List list11 = plantMastersService.read();

        request.setAttribute("list11", list11);
        request.setAttribute("list10", list10);

        if (session != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }
        mv.setViewName("location/create");
        return mv;
    }

    public ModelAndView createsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        LocationMasters locationMasters = new LocationMasters();
        String comapnycode = request.getParameter("comapnycode");
        String plantcode = request.getParameter("plantcode");
        String locationcode = request.getParameter("locationcode");
        String locationname = request.getParameter("locationname");
        String address = request.getParameter("address");

        locationMasters.setCompanyCode(comapnycode);
        locationMasters.setPlantCode(plantcode);
        locationMasters.setLoactionCode(locationcode);
        locationMasters.setLoactionName(locationname);
        locationMasters.setAddress(address);

        if (!locationMastersService.isExist(locationMasters)) {
            locationMastersService.create(locationMasters);
            session.setAttribute("successMessage", "Location Created Successfully");
            mv.setViewName("redirect:locationMasters.htm?act=showlist");
        } else {
           
            session.setAttribute("failureMessage", "Location Detail Already Exist. Please enter New Details");
            mv.setViewName("redirect:locationMasters.htm?act=create");
        }

        return mv;
    }

    public ModelAndView locationedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        LocationMasters locationMasters = locationMastersService.readById(Integer.parseInt(id));

        String companymaster = locationMasters.getCompanyCode();

        String plant = locationMasters.getPlantCode();
        List list10 = companyMasterService.read();

        List list11 = plantMastersService.read();

        request.setAttribute("list11", list11);
        request.setAttribute("list10", list10);
        mv.getModelMap().put("companymaster", companymaster);
        mv.getModelMap().put("plant", plant);

        mv.getModelMap().put("locationMasters", locationMasters);
        mv.setViewName("location/edit");
        return mv;
    }

    public ModelAndView locationeditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");

        String comapnycode = request.getParameter("comapnycode");
        String plantcode = request.getParameter("plantcode");
        String locationcode = request.getParameter("locationcode");
        String locationname = request.getParameter("locationname");
        String address = request.getParameter("address");

        LocationMasters locationMasters = locationMastersService.readById(Integer.parseInt(id));

        locationMasters.setCompanyCode(comapnycode);
        locationMasters.setPlantCode(plantcode);
        locationMasters.setLoactionCode(locationcode);
        locationMasters.setLoactionName(locationname);
        locationMasters.setAddress(address);
        locationMastersService.update(locationMasters);

        session.setAttribute("successMessage", "Information: Location  Edited successfully");
        mv.setViewName("redirect:locationMasters.htm?act=showlist");
        return mv;
    }

    public ModelAndView locationdelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            locationMastersService.delete(Integer.parseInt(checkedValues));
        }
       
        mv.setViewName("redirect:locationMasters.htm?act=showlist");

        return mv;
    }

    public ModelAndView deleteLocationById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            locationMastersService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:locationMasters.htm?act=showlist");
        return mv;
    }

    public ModelAndView locationMastersAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "companyCode";
                    break;
                case "3":
                    orderColumn = "plantCode";
                    break;
                case "4":
                    orderColumn = "loactionCode";
                    break;
                case "5":
                    orderColumn = "loactionName";
                    break;
                case "6":
                    orderColumn = "address";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = locationMastersService.getLocationMastersPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = locationMastersService.getTotalLocationMastersCount();
        int filteredRecords = locationMastersService.getFilteredLocationMastersCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            LocationMasters locationMasters = (LocationMasters) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + locationMasters.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("companyCode", locationMasters.getCompanyCode());
            json.put("plantCode", locationMasters.getPlantCode());
            json.put("loactionCode", locationMasters.getLoactionCode());
            json.put("loactionName", locationMasters.getLoactionName());
            json.put("address", locationMasters.getAddress());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='locationMasters.htm?act=locationedit&id="
                    + locationMasters.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + locationMasters.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );
            dataArray.put(json);
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

}
