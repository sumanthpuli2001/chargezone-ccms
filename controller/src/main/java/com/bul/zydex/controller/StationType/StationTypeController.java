/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.StationType;

import com.bul.zydex.model.MaterialTypeMaster;
import com.bul.zydex.model.StationType;
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
public class StationTypeController extends StationTypeAbstract {

    public ModelAndView StationTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("StationType/StationTypeList");
        return mv;
    }

    public ModelAndView StationTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("StationType/StationTypeCreate");
        return mv;
    }

    public ModelAndView submitStationTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String stationtype = request.getParameter("stationtype");

        StationType stationType = new StationType();
        stationType.setStationType(stationtype);

        if (!stationTypeService.isExist(stationType)) {
            stationTypeService.create(stationType);
            session.setAttribute("successMessage", "StationType Created successfully");
            mv.setViewName("redirect:stationType.htm?act=StationTypeList");
        } else {
            session.setAttribute("failureMessage", "Station Type Already Exist. Please enter new Details");
            mv.setViewName("redirect:stationType.htm?act=StationTypeCreate");
        }
        return mv;
    }

    public ModelAndView deleteStationTypeById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            stationTypeService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:stationType.htm?act=StationTypeList");
        return mv;
    }

    public ModelAndView deleteStationTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            stationTypeService.delete(Integer.parseInt(checkedValues));
        }
        
        mv.setViewName("redirect:stationType.htm?act=StationTypeList");

        return mv;
    }

    public ModelAndView StationTypeEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        StationType stationType = stationTypeService.readById(Integer.parseInt(id));

        mv.getModelMap().put("stationType", stationType);
        mv.setViewName("StationType/StationTypeEdit");
        return mv;
    }

    public ModelAndView StationTypeEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        String stationtype = request.getParameter("stationtype");

        StationType stationType = stationTypeService.readById(Integer.parseInt(id));
        stationType.setStationType(stationtype);
        stationTypeService.update(stationType);

        session.setAttribute("successMessage", "StationType Edited successfully");
        mv.setViewName("redirect:stationType.htm?act=StationTypeList");
        return mv;
    }

    public ModelAndView stationTypePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "id";
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "stationType";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = stationTypeService.getstationTypePagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = stationTypeService.getstationTypeCount();
        int filteredRecords = stationTypeService.getFilteredstationTypeCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {
            StationType stationType = (StationType) obj;
            JSONObject json = new JSONObject();
            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + stationType.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("stationType", stationType.getStationType() != null ? stationType.getStationType() : "");
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='stationType.htm?act=StationTypeEdit&id="
                    + stationType.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + stationType.getId() + "'>"
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
