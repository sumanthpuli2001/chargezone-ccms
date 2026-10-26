/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ProjectType;

import com.bul.zydex.model.ProfitCenter;
import com.bul.zydex.model.ProjectType;
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
public class ProjectTypeController extends ProjectTypeAbstract {

    public ModelAndView ProjectTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProjectType projectType = new ProjectType();
        HttpSession session = request.getSession(false);

        mv.getModelMap().put("projectType", projectType);
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
        mv.setViewName("ProjectType/ProjectTypeList");
        return mv;
    }

    public ModelAndView ProjectTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("ProjectType/ProjectTypeCreate");
        return mv;
    }

    public ModelAndView submitProjectTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Projecttype = request.getParameter("Projecttype");
        HttpSession session = request.getSession(false);

        ProjectType projectType = new ProjectType();
        projectType.setProjectType(Projecttype);
        if (!projectTypeService.isExist(projectType)) {
            projectTypeService.create(projectType);
            session.setAttribute("successMessage", "Project Type Created successfully");
            mv.setViewName("redirect:projectType.htm?act=ProjectTypeList");
        } else {
            session.setAttribute("failureMessage", "Project Type Already Exist. Please enter new Details");
            mv.setViewName("redirect:projectType.htm?act=ProjectTypeCreate");
        }

        return mv;
    }

    public ModelAndView deleteProjectTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            projectTypeService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:projectType.htm?act=ProjectTypeList");

        return mv;
    }

    public ModelAndView deleteProjectTypeById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            projectTypeService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:projectType.htm?act=ProjectTypeList");
        return mv;
    }

    public ModelAndView ProjectTypeEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        ProjectType projectType = projectTypeService.readById(Integer.parseInt(id));

        mv.getModelMap().put("projectType", projectType);
        mv.setViewName("ProjectType/ProjectTypeEdit");
        return mv;
    }

    public ModelAndView ProjectTypeEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String projecttype = request.getParameter("projecttype");
        ProjectType projectType = projectTypeService.readById(Integer.parseInt(id));
        projectType.setProjectType(projecttype);
        projectTypeService.update(projectType);

        session.setAttribute("successMessage", "ProjectType edit successfully");
        mv.setViewName("redirect:projectType.htm?act=ProjectTypeList");

        return mv;
    }

    public ModelAndView proTypePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "projectType";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = projectTypeService.getProTypePagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = projectTypeService.getTotalProTypeCount();
        int filteredRecords = projectTypeService.getFilteredProTypeCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;
        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {
            ProjectType projectType = (ProjectType) obj;
            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + projectType.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("projectType", projectType.getProjectType() != null ? projectType.getProjectType() : "");
            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='projectType.htm?act=ProjectTypeEdit&id="
                    + projectType.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + projectType.getId() + "'>"
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
