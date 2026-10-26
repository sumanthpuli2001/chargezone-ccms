/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.TermsCondtion;

import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.model.TermsConditionParameter;
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
public class TermsConditionParameterController extends TermsConditionAbstract {

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

        mv.setViewName("TermsCondition/ShowTermsConditionParameterList");
        return mv;
    }

    public ModelAndView createTermsConditionParameter(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        List list = termsConditionService.read();
        mv.getModelMap().put("list", list);

        mv.setViewName("TermsCondition/CreateTermsConditionParameter");
        return mv;
    }

    public ModelAndView submitTermsConditionParameter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String name = request.getParameter("name");
        String termsConditionName = request.getParameter("termsConditionName");
        String description = request.getParameter("description");

        TermsConditionParameter termsConditionParameter = new TermsConditionParameter();
        TermsCondition termsCondition = termsConditionService.readById(Integer.parseInt(termsConditionName));
        termsConditionParameter.setName(name);
        termsConditionParameter.setTermsCondition(termsCondition);
        termsConditionParameter.setDescription(description);

        if (!termsConditionParameterService.isExist(termsConditionParameter)) {
            termsConditionParameterService.create(termsConditionParameter);
            session.setAttribute("successMessage", "Terms Condition Parameter Created successfully");
            mv.setViewName("redirect:termsConditionParameter.htm?act=showList");
        } else {
            List list = termsConditionService.read();
            mv.getModelMap().put("list", list);
            session.setAttribute("failureMessage", "Terms Condition Parameter Already Exist. Please enter new Data");
            mv.setViewName("redirect:termsConditionParameter.htm?act=createTermsConditionParameter");
        }

        return mv;
    }

    public ModelAndView deleteTermsConditionParameter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String[] checkId = request.getParameterValues("checkId");
        for (String checkedValues : checkId) {
            termsConditionParameterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:termsConditionParameter.htm?act=showList");
        return mv;
    }

    public ModelAndView editTermsConditionParameter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        List list1 = termsConditionParameterService.readByIds(Integer.parseInt(id));
        List list = termsConditionService.read();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", list1);
        mv.setViewName("TermsCondition/EditTermsConditionParameter");
        return mv;
    }

    public ModelAndView editTermsConditionParameterSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String termsConditionName = request.getParameter("termsConditionName");
        String description = request.getParameter("description");

        TermsCondition termsCondition = termsConditionService.readById(Integer.parseInt(termsConditionName));
        TermsConditionParameter termsConditionParameter = termsConditionParameterService.readById(Integer.parseInt(id));
        termsConditionParameter.setName(name);
        termsConditionParameter.setTermsCondition(termsCondition);
        termsConditionParameter.setDescription(description);
        termsConditionParameterService.update(termsConditionParameter);

        session.setAttribute("successMessage", "Terms Condition Parameter edited successfully");
        mv.setViewName("redirect:termsConditionParameter.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteTermsandConditionById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            termsConditionParameterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:termsConditionParameter.htm?act=showList");
        return mv;
    }

    public ModelAndView DeleteAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            termsConditionParameterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:termsConditionParameter.htm?act=showList");
        return mv;
    }

    public ModelAndView termsConditionParameterAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "a.id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "a.id";
                    break;
                case "2":
                    orderColumn = "b.name";
                    break;
                case "3":
                    orderColumn = "a.name";
                    break;
                case "4":
                    orderColumn = "a.description";
                    break;

                default:
                    orderColumn = "a.id";
                    break;
            }
        }

        List list = termsConditionParameterService.getTermsConditionParameterPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = termsConditionParameterService.getTermsConditionParameterCount();
        int filteredRecords = termsConditionParameterService.getFilteredTermsConditionParameterCount(searchValue);
        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            Object[] row = (Object[]) obj;

            int id = (int) row[0];
            String termsCondition = (String) row[1];
            String name = (String) row[2];
            String description = (String) row[3];

            JSONObject json = new JSONObject();

            json.put("checkbox",
                    "<input type='checkbox' class='rowCheckbox' value='"
                    + id + "'>");
            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("termsCondition", termsCondition);
            json.put("name", name);
            json.put("description", description);

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='termsConditionParameter.htm?act=editTermsConditionParameter&id="
                    + id + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src='StorageYard/assets/images/edit-icon.svg' style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' class='delete-btn1 d-block text-danger p-1 mx-1' data-id='"
                    + id + "'>"
                    + "<img src='StorageYard/assets/images/delete-icon.svg' style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>");

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
