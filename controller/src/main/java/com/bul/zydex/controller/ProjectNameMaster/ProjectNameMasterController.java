/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProjectNameMaster;

import com.bul.zydex.model.ProjectNameMaster;
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
public class ProjectNameMasterController extends ProjectNameMasterAbstract {

    public ModelAndView ProjectNameMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("ProjectNameMaster/ProjectNameMasterList");
        return mv;
    }

    public ModelAndView projectNameMasterAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "projectName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = projectNameMasterService.getProjectNameMasterPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = projectNameMasterService.getProjectNameMasterCount();

        int filteredRecords = projectNameMasterService.getFilteredProjectNameMasterCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ProjectNameMaster projectNameMaster = (ProjectNameMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + projectNameMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("projectName", projectNameMaster.getProjectName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='projectNameMaster.htm?act=ProjectNameMasterEdit&id="
                    + projectNameMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + projectNameMaster.getId() + "'>"
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

    public ModelAndView ProjectNameMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("ProjectNameMaster/ProjectNameMasterCreate");
        return mv;
    }

    public ModelAndView submitProjectNameMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ProjectNameMaster projectNameMaster = new ProjectNameMaster();
        String projectname = request.getParameter("projectname");
        projectNameMaster.setProjectName(projectname);

        if (projectNameMasterService.isExist(projectNameMaster)) {
            projectNameMasterService.create(projectNameMaster);
            session.setAttribute("successMessage", "ProjectNameMaster Created Successfully.");
            mv.setViewName("redirect:projectNameMaster.htm?act=ProjectNameMasterList");
        } else {
            session.setAttribute("failureMessage", "Project Name Already Exist. Please enter new Project Name");
            mv.setViewName("redirect:projectNameMaster.htm?act=ProjectNameMasterCreate");
        }

        return mv;
    }

    public ModelAndView deleteProjectNameMasterList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            projectNameMasterService.delete(Integer.parseInt(checkedValues));
        }
        
        mv.setViewName("redirect: projectNameMaster.htm?act=ProjectNameMasterList");

        return mv;
    }

    public ModelAndView deleteProjectNameMasterById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            projectNameMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:projectNameMaster.htm?act=ProjectNameMasterList");
        return mv;
    }

    public ModelAndView ProjectNameMasterEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ProjectNameMaster projectNameMaster = projectNameMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("list", projectNameMaster);
        mv.setViewName("ProjectNameMaster/ProjectNameMasterEdit");
        return mv;
    }

    public ModelAndView ProjectNameMasterEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String projectname = request.getParameter("projectname");
        ProjectNameMaster projectNameMaster = projectNameMasterService.readById(Integer.parseInt(id));
        projectNameMaster.setProjectName(projectname);
        projectNameMasterService.update(projectNameMaster);
        session.setAttribute("successMessage", "Project Name Master Edited successfully");
        mv.setViewName("redirect:projectNameMaster.htm?act=ProjectNameMasterList");
        return mv;
    }

}
