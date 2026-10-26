/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.TermsCondtion;

import com.bul.zydex.model.MaterialTypeMaster;
import com.bul.zydex.model.TermsCondition;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
public class TermsConditionController extends TermsConditionAbstract {

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
        mv.setViewName("TermsCondition/ShowList");
        return mv;
    }

    public ModelAndView createTermsCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("TermsCondition/CreateTermsCondition");
        return mv;
    }

    public ModelAndView submitTermsCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String name = request.getParameter("name");
        TermsCondition termsCondition = new TermsCondition();
        termsCondition.setName(name);

        if (!termsConditionService.isExist(termsCondition)) {
            termsConditionService.create(termsCondition);

            session.setAttribute("successMessage", "Terms Condition  Created Successfully");
            mv.setViewName("redirect:termsCondition.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "Terms Condition  Already Exist. Please Enter Terms Condition ");
            mv.setViewName("redirect:termsCondition.htm?act=createTermsCondition");
        }

        return mv;
    }

    public void deleteTermsCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();

        try {
            String ids = request.getParameter("ids");
            String[] idArray = ids.split(",");
            List<String> failedNames = new ArrayList<>();
            int deletedCount = 0;
            for (String id : idArray) {
                TermsCondition termsCondition  = termsConditionService.readById(Integer.parseInt(id));
                try {
                    termsConditionService.delete(Integer.parseInt(id));
                    deletedCount++;
                } catch (DataIntegrityViolationException e) {
                    failedNames.add(termsCondition.getName());
                    e.printStackTrace();
                } catch (Exception e) {
                    failedNames.add(termsCondition.getName());
                    e.printStackTrace();
                }
            }

            if (failedNames.isEmpty()) {
                json.put("success", true);
                json.put("message",
                        "Terms & Condition(s) deleted successfully");
            } else {
                json.put("success", false);
                json.put("message",
                        deletedCount
                        + " deleted. Could not delete: "
                        + String.join(", ", failedNames)
                        + " because they are being used somewhere.");
            }
        } catch (Exception e) {
            json.put("success", false);
            json.put("message", "Something went wrong while deleting");
            e.printStackTrace();
        }

        response.getWriter().write(json.toString());
        response.getWriter().flush();
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();

        try {
            String id = request.getParameter("id");
            termsConditionService.delete(Integer.parseInt(id));
            json.put("success", true);
            json.put("message", "Terms & Condition deleted successfully");
        } catch (DataIntegrityViolationException e) {
            json.put("success", false);
            json.put("message", "Terms and Condition is being used somewhere");
            e.printStackTrace();
        } catch (Exception e) {
            json.put("success", false);
            json.put("message", "Something went wrong while deleting");
            e.printStackTrace();
        }

        response.getWriter().write(json.toString());
        response.getWriter().flush();

    }

    public ModelAndView editTermsCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        TermsCondition termsCondition = termsConditionService.readById(Integer.parseInt(id));
        mv.getModelMap().put("termsCondition", termsCondition);
        mv.setViewName("TermsCondition/EditTermsCondition");
        return mv;
    }

    public ModelAndView editTermsConditionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        TermsCondition termsCondition = termsConditionService.readById(Integer.parseInt(id));
        termsCondition.setName(name);

        termsConditionService.update(termsCondition);

        request.setAttribute("successMessage",
                " Terms Condition edit successfully");
        mv.setViewName("redirect:termsCondition.htm?act=showList");
        return mv;
    }

    public ModelAndView termsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "name";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;

                case "2":
                    orderColumn = "name";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = termsConditionService.getTermsConditionPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = termsConditionService.getTotalTermsConditionCount();

        int filteredRecords = termsConditionService.getFilteredTermsConditionCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            TermsCondition termsCondition = (TermsCondition) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + termsCondition.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("name", termsCondition.getName() != null ? termsCondition.getName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='termsCondition.htm?act=editTermsCondition&id="
                    + termsCondition.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + termsCondition.getId() + "'>"
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
