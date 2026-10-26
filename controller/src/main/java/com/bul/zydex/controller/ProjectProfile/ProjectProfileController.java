/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProjectProfile;

import com.bul.zydex.model.InvestmentProfile;
import com.bul.zydex.model.ProjectProfile;
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
public class ProjectProfileController extends ProjectProfileAbstract {

    public ModelAndView ProjectProfileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ProjectProfile/ProjectProfileList");
        return mv;
    }

    public ModelAndView ProjectProfileCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ProjectProfile/ProjectProfileCreate");
        return mv;
    }

    public ModelAndView submitProjectProfileCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String projectprofile = request.getParameter("projectprofile");
        HttpSession session = request.getSession(false);

        ProjectProfile projectProfile = new ProjectProfile();
        projectProfile.setProjectProfile(projectprofile);

        if (!projectProfileService.isExist(projectProfile)) {
            projectProfileService.create(projectProfile);
            session.setAttribute("successMessage", "Project Profile created successfully.");
            mv.setViewName("redirect:projectProfile.htm?act=ProjectProfileList");
        } else {
            session.setAttribute("failureMessage", "Project Profile Already Exist. Please enter new Details");
            mv.setViewName("redirect:projectProfile.htm?act=ProjectProfileCreate");
        }

        return mv;
    }

    public ModelAndView deleteProjectProfileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            projectProfileService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect: projectProfile.htm?act=ProjectProfileList");
        return mv;
    }

    public ModelAndView deleteProjectProfileById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            projectProfileService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:projectProfile.htm?act=ProjectProfileList");
        return mv;
    }

    public ModelAndView ProjectProfileEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ProjectProfile projectProfile = projectProfileService.readById(Integer.parseInt(id));

        mv.getModelMap().put("projectProfile", projectProfile);
        mv.setViewName("ProjectProfile/ProjectProfileEdit");
        return mv;
    }

    public ModelAndView ProjectProfileEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String projectprofile = request.getParameter("projectprofile");
        HttpSession session = request.getSession(false);

        ProjectProfile projectProfile = projectProfileService.readById(Integer.parseInt(id));
        projectProfile.setProjectProfile(projectprofile);
        projectProfileService.update(projectProfile);
        
        session.setAttribute("successMessage", "ProjectProfile Edited Successfully");
        mv.setViewName("redirect:projectProfile.htm?act=ProjectProfileList");

        return mv;
    }

    public ModelAndView proProfilePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "projectProfile";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = projectProfileService.getprojectProfilePagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = projectProfileService.getTotalprojectProfileCount();
        int filteredRecords = projectProfileService.getFilteredprojectProfileCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {
            ProjectProfile projectProfile = (ProjectProfile) obj;
            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + projectProfile.getId() + "'>");
            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("projectProfile", projectProfile.getProjectProfile() != null ? projectProfile.getProjectProfile() : "");
            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='projectProfile.htm?act=ProjectProfileEdit&id="
                    + projectProfile.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + projectProfile.getId() + "'>"
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
