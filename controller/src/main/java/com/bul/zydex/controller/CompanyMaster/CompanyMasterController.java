/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CompanyMaster;

import com.bul.zydex.model.CompanyMaster;
import com.bul.zydex.model.PlantMaster;
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
public class CompanyMasterController extends CompanyMasterAbstract {

    public ModelAndView showlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Company/showlist");
        return mv;
    }

    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Company/create");
        return mv;
    }

    public ModelAndView createsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String city = request.getParameter("city");

        CompanyMaster companyMaster = new CompanyMaster();
        companyMaster.setCompanyCode(code);
        companyMaster.setDescription(description);
        companyMaster.setCity(city);

        if (!companyMasterService.isExist(companyMaster)) {
            companyMasterService.create(companyMaster);
            mv.setViewName("redirect:companyMaster.htm?act=showlist");
            session.setAttribute("successMessage", " Company Created successfully");
        } else {
            session.setAttribute("failureMessage", "Company Already Exist. Please enter new Details");
            mv.setViewName("redirect:companyMaster.htm?act=create");
        }
        return mv;
    }

    public ModelAndView companyedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        CompanyMaster companyMaster = companyMasterService.readById(Integer.parseInt(id));

        mv.getModelMap().put("companyMaster", companyMaster);
        mv.setViewName("Company/edit");
        return mv;
    }

    public ModelAndView companyeditsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");

        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String city = request.getParameter("city");
        CompanyMaster companyMaster = companyMasterService.readById(Integer.parseInt(id));

        companyMaster.setCompanyCode(code);
        companyMaster.setDescription(description);
        companyMaster.setCity(city);
        companyMasterService.update(companyMaster);

        session.setAttribute("successMessage", "Company Edited successfully");
        mv.setViewName("redirect:companyMaster.htm?act=showlist");
        return mv;
    }

    public ModelAndView companydelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            companyMasterService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:companyMaster.htm?act=showlist");
        return mv;
    }

    public ModelAndView deleteProjectById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            companyMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {
            request.setAttribute("failureMessage", "this company master is used some where...");
        }

        mv.setViewName("redirect:companyMaster.htm?act=showlist");
        return mv;
    }

    public ModelAndView compMasterPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                    orderColumn = "companyCode";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "description";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }
        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "city";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = companyMasterService.getCompanyMasterPagination(start, length, searchValue, orderColumn, orderDir);
        int totalRecords = companyMasterService.getTotalMasterCount();
        int filteredRecords = companyMasterService.getFilteredMasterCount(searchValue);

        JSONArray dataArray = new JSONArray();
        boolean isDesc = "desc".equalsIgnoreCase(orderDir);
        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {
            CompanyMaster companyMaster = (CompanyMaster) obj;
            JSONObject json = new JSONObject();

//            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + companyMaster.getId() + "'>");
            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("companyCode", companyMaster.getCompanyCode() != null ? companyMaster.getCompanyCode() : "");
            json.put("description", companyMaster.getDescription() != null ? companyMaster.getDescription() : "");
            json.put("city", companyMaster.getCity() != null ? companyMaster.getCity() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='companyMaster.htm?act=companyedit&id="
                    + companyMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + companyMaster.getId() + "'>"
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
