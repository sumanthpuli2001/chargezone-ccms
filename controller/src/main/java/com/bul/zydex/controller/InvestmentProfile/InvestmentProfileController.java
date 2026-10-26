/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.InvestmentProfile;

import com.bul.zydex.model.InvestmentProfile;
import com.bul.zydex.model.MaterialTypeMaster;
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
public class InvestmentProfileController extends InvestmentProfileAbstract {

    public ModelAndView InvestmentProfileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("InvestmentProfile/InvestmentProfileList");
        return mv;
    }

    public ModelAndView InvestmentProfileCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("InvestmentProfile/InvestmentProfileCreate");
        return mv;
    }

    public ModelAndView submitInvestmentProfileCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String investmentprofile = request.getParameter("investmentprofile");
        HttpSession session = request.getSession(false);
        InvestmentProfile investmentprofile1 = new InvestmentProfile();
        investmentprofile1.setInvestmentProfile(investmentprofile);

        if (!investmentProfileService.isExist(investmentprofile1)) {
            investmentProfileService.create(investmentprofile1);
            session.setAttribute("successMessage", "InvestmentProfile Created successfully");
            mv.setViewName("redirect:investmentProfile.htm?act=InvestmentProfileList");
        } else {
            session.setAttribute("failureMessage", "Investment Profile Already Exist. Please enter new Details");
            mv.setViewName("redirect:investmentProfile.htm?act=InvestmentProfileCreate");
        }
        return mv;
    }

    public ModelAndView InvestmentProfileDeleteAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            investmentProfileService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:investmentProfile.htm?act=InvestmentProfileList");
        return mv;
    }

    public ModelAndView deleteProfileById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            investmentProfileService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:investmentProfile.htm?act=InvestmentProfileList");
        return mv;
    }

    public ModelAndView InvestmentProfileEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        InvestmentProfile investmentProfile = investmentProfileService.readById(Integer.parseInt(id));
        mv.getModelMap().put("investmentProfile", investmentProfile);

        mv.setViewName("InvestmentProfile/InvestmentProfileEdit");
        return mv;
    }

    public ModelAndView InvestmentProfileEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);

        String investmentprofile = request.getParameter("investmentprofile");
        InvestmentProfile investmentProfile = investmentProfileService.readById(Integer.parseInt(id));
        investmentProfile.setInvestmentProfile(investmentprofile);
        investmentProfileService.update(investmentProfile);
        session.setAttribute("successMessage", "InvestmentProfile Created successfully");

        mv.setViewName("redirect:investmentProfile.htm?act=InvestmentProfileList");
        return mv;
    }

    public ModelAndView investPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "investmentProfile";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = investmentProfileService.getInvestPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = investmentProfileService.getTotalInvestCount();
        int filteredRecords = investmentProfileService.getFilteredInvestCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            InvestmentProfile investmentProfile = (InvestmentProfile) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + investmentProfile.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("investmentProfile", investmentProfile.getInvestmentProfile() != null ? investmentProfile.getInvestmentProfile() : "");
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='investmentProfile.htm?act=InvestmentProfileEdit&id="
                    + investmentProfile.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + investmentProfile.getId() + "'>"
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
