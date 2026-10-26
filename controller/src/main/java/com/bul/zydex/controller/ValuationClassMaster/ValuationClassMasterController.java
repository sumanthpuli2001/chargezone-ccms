/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ValuationClassMaster;

import com.bul.zydex.controller.ProductTypeMaster.*;
import com.bul.zydex.model.ProductTypeMaster;
import com.bul.zydex.model.RightMaster;
import com.bul.zydex.model.ValuationClassMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bulwarks-2
 */
public class ValuationClassMasterController extends ValuationClassMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ValuationClassMaster/ShowList");
        return mv;
    }

    public ModelAndView createValuationClassMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ValuationClassMaster/CreateValuationClassMaster");
        return mv;
    }

    public ModelAndView submitValuationClassMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        ValuationClassMaster valuationClassMaster = new ValuationClassMaster();

        String valuationClass = request.getParameter("valuationClass");
        String description = request.getParameter("description");
        valuationClassMaster.setValuationClass(valuationClass);
        valuationClassMaster.setDescription(description);

        if (!valuationClassMasterService.isExist(valuationClassMaster)) {
            valuationClassMasterService.create(valuationClassMaster);
            
            session.setAttribute("successMessage", "Valuation Master Created successfully ");
            mv.setViewName("redirect:valuationClassMaster.htm?act=showList");
        } else {
            session.setAttribute("failureMessage", "Valuation Master Already Exist. Please enter new Details");
            mv.setViewName("redirect:valuationClassMaster.htm?act=createValuationClassMaster");
        }

        return mv;
    }

    public ModelAndView deletevaluationById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            valuationClassMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }
        mv.setViewName("redirect:valuationClassMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteValuationTypeMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            valuationClassMasterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:valuationClassMaster.htm?act=showList");
        return mv;

    }

    public ModelAndView editValuationClassMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        ValuationClassMaster valuationClassMaster = valuationClassMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("valuationClassMaster", valuationClassMaster);
        mv.setViewName("ValuationClassMaster/EditValuationClassMaster");
        return mv;
    }

    public ModelAndView submitEditValuationClassMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String valuationClass = request.getParameter("valuationClass");
        String description = request.getParameter("description");
        ValuationClassMaster valuationClassMaster = valuationClassMasterService.readById(Integer.parseInt(id));
        valuationClassMaster.setValuationClass(valuationClass);
        valuationClassMaster.setDescription(description);
        valuationClassMasterService.update(valuationClassMaster);

        mv.getModelMap().put("valuationClassMaster", valuationClassMaster);
        session.setAttribute("successMessage", "Valuation Master Edited successfully ");
        mv.setViewName("redirect:valuationClassMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView valPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "valuationClass";
                    break;
                case "3":
                    orderColumn = "description";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }        

        List list = valuationClassMasterService.getValPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = valuationClassMasterService.getTotalValCount();
        int filteredRecords = valuationClassMasterService.getFilteredValCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;
        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {
            ValuationClassMaster valuationClassMaster = (ValuationClassMaster) obj;
            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + valuationClassMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("valuationClass", valuationClassMaster.getValuationClass() != null ? valuationClassMaster.getValuationClass() : "");
            json.put("description", valuationClassMaster.getDescription() != null ? valuationClassMaster.getDescription() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='valuationClassMaster.htm?act=editValuationClassMaster&id="
                    + valuationClassMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + valuationClassMaster.getId() + "'>"
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
