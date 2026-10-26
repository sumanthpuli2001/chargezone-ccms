/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProfitCenter;

import com.bul.zydex.model.CanopyVarient;
import com.bul.zydex.model.ProfitCenter;
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
public class ProfitCenterController extends ProfitCenterAbstract {

    public ModelAndView profitCenterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProfitCenter profitCenter = new ProfitCenter();
        HttpSession session = request.getSession(false);

        mv.getModelMap().put("profitCenter", profitCenter);
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
        mv.setViewName("profitCenter/profitCenterList");
        return mv;
    }

    public ModelAndView profitCenterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("profitCenter/profitCenterCreate");
        return mv;
    }

    public ModelAndView submitprofitCenterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String profitCenter = request.getParameter("profitCenter");
        ProfitCenter profitCenter1 = new ProfitCenter();
        profitCenter1.setProfitCenter(profitCenter);

        if (!profitCenterService.isExist(profitCenter1)) {
            profitCenterService.create(profitCenter1);
            
            session.setAttribute("successMessage", "Profit Center Created successfully");
            mv.setViewName("redirect:profitCenter.htm?act=profitCenterList");
        } else {
            session.setAttribute("failureMessage", "Profit Center Already Exist. Please enter new Details");
            mv.setViewName("redirect:profitCenter.htm?act=profitCenterCreate");
        }

        return mv;
    }

    public ModelAndView deleteprofitCenterList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            profitCenterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:profitCenter.htm?act=profitCenterList");
        return mv;
    }

    public ModelAndView deleteProfitById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            profitCenterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:profitCenter.htm?act=profitCenterList");
        return mv;
    }

    public ModelAndView profitCenterEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ProfitCenter profitCenter1 = profitCenterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("profitCenter1", profitCenter1);
        mv.setViewName("profitCenter/profitCenterEdit");
        return mv;
    }

    public ModelAndView profitCenterEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        String profitCenter = request.getParameter("profitCenter");

        ProfitCenter profitCenter1 = profitCenterService.readById(Integer.parseInt(id));
        profitCenter1.setProfitCenter(profitCenter);
        profitCenterService.update(profitCenter1);

        session.setAttribute("successMessage", "Profit Center Edited Successfully");
        mv.setViewName("redirect:profitCenter.htm?act=profitCenterList");
        return mv;
    }

    public ModelAndView profitPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "profitCenter";
                    break;
                default:
                    orderColumn = "profitCenter";
                    break;
            }
        }

        List list = profitCenterService.getProfitPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = profitCenterService.getTotalProfitCount();
        int filteredRecords = profitCenterService.getFilteredProfitCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo;
        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {
            ProfitCenter profitCenter = (ProfitCenter) obj;
            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + profitCenter.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("profitCenter", profitCenter.getProfitCenter() != null ? profitCenter.getProfitCenter() : "");
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='profitCenter.htm?act=profitCenterEdit&id="
                    + profitCenter.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + profitCenter.getId() + "'>"
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
