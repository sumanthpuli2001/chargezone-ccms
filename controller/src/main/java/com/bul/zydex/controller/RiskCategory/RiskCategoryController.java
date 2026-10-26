/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.RiskCategory;

import com.bul.zydex.model.Riskcategory;
import com.bul.zydex.model.UserMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class RiskCategoryController extends RiskCategoryAbstract {

    public ModelAndView showRiskCategoryList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("RiskCategory/ShowRiskCategoryList");
        return mv;
    }

    public ModelAndView createRiskCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("RiskCategory/CreateRiskCategory");
        return mv;
    }

    public ModelAndView submitRiskCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String category = request.getParameter("category");

        Riskcategory riskCategory = new Riskcategory();
        riskCategory.setCategory(category);

        if (!RiskCategoryService.isExist(riskCategory)) {
            RiskCategoryService.create(riskCategory);

            session.setAttribute("successMessage", "Risk Category Created Successfully");
            mv.setViewName("redirect:riskCategory.htm?act=showRiskCategoryList");

        } else {

            session.setAttribute("failureMessage", "Risk Category Already Exist. Please Enter New Category Name");
            mv.setViewName("redirect:riskCategory.htm?act=createRiskCategory");
        }

        return mv;
    }

    public ModelAndView deleteRiskCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            RiskCategoryService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:riskCategory.htm?act=showRiskCategoryList");
        return mv;

    }

    public ModelAndView deleteRiskById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            RiskCategoryService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:riskCategory.htm?act=showRiskCategoryList");
        return mv;

    }

    public ModelAndView editRiskCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        Riskcategory riskcategory = RiskCategoryService.readById(Integer.parseInt(id));
        mv.getModelMap().put("riskcategory", riskcategory);
        mv.setViewName("RiskCategory/EditRiskCategory");
        return mv;
    }

    public ModelAndView editRiskCategorySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String category = request.getParameter("category");
        Riskcategory riskcategory = RiskCategoryService.readById(Integer.parseInt(id));
        riskcategory.setCategory(category);

        RiskCategoryService.update(riskcategory);
        session.setAttribute("successMessage", "Information: Risk Category Edited Successfully");

        mv.setViewName("redirect:riskCategory.htm?act=showRiskCategoryList");
        return mv;
    }

    public ModelAndView riskCategoryPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "category";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = RiskCategoryService.getRiskCategoryPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = RiskCategoryService.getTotalRiskCategoryCount();

        int filteredRecords = RiskCategoryService.getFilteredRiskCategoryCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            Riskcategory riskCategory = (Riskcategory) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + riskCategory.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("category", riskCategory.getCategory() != null ? riskCategory.getCategory() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='riskCategory.htm?act=editRiskCategory&id="
                    + riskCategory.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + riskCategory.getId() + "'>"
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
