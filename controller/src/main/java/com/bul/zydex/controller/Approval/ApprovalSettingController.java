/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.ApprovalSetting;
import com.bul.zydex.model.SapConnection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class ApprovalSettingController extends ApprovalSettingAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        ApprovalSetting approvalSetting = new ApprovalSetting();
        List list = approvalSettingService.readByrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("approvalSetting", approvalSetting);

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

        mv.setViewName("Approval/ApprovalList");
        return mv;

    }

    public ModelAndView createapprovalSetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ApprovalSetting approvalSetting = new ApprovalSetting();
        readEmployee(request, response);
        mv.getModelMap().put("approvalSetting", approvalSetting);

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
        mv.setViewName("Approval/ApprovalCreate");
        return mv;
    }

    public ModelAndView submitapprovalSetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ApprovalSetting approvalSetting = new ApprovalSetting();
        bind(request, approvalSetting);

        List rfId = approvalSettingService.readOne(approvalSetting.getApprovalOne());

        if (rfId.isEmpty()) {
            approvalSettingService.create(approvalSetting);

            UserMaster user = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Approval Created").setDrow("Y");
            logService.create(lm);
            mv.setViewName("redirect:approvalSetting.htm?act=showList");
            session.setAttribute("successMessage", " Approval Created successfully");

        } else {

            session.setAttribute("failureMessage", "Approval  Already Exist. Please Enter  New Approval ");
            mv.setViewName("redirect:approvalSetting.htm?act=createapprovalSetting");

        }

        return mv;

    }

    public ModelAndView deleteapprovalSetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            approvalSettingService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:approvalSetting.htm?act=showList");

        return mv;
    }

    public ModelAndView deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {

            approvalSettingService.delete(Integer.parseInt(id));

        } catch (Exception e) {

        }

        mv.setViewName("redirect:approvalSetting.htm?act=showList");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String Code = request.getParameter("id");
        ApprovalSetting approvalSetting = approvalSettingService.read(Code);
        readEmployee(request, response);
        mv.getModelMap().put("approvalSetting", approvalSetting);
        //------for Log entry---------
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee view").setDrow("Y");
        logService.create(lm);
        mv.setViewName("Approval/ApprovalEdit");
        return mv;
    }

    public ModelAndView editApprovalSettingSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        ApprovalSetting approvalSetting = new ApprovalSetting();
        bind(request, approvalSetting);
        approvalSettingService.update(approvalSetting);

        //------for Log entry---------
        UserMaster user = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Employee edited").setDrow("Y");
        logService.create(lm);

        session.setAttribute("successMessage", " Approval Edited successfully");
        mv.setViewName("redirect:approvalSetting.htm?act=showList");
        return mv;
    }

    public ModelAndView approvalPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "approvalOne";
                    break;
                case "3":
                    orderColumn = "approvalTwo";
                    break;
                case "4":
                    orderColumn = "approvalThree";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = approvalSettingService.getApprovalPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = approvalSettingService.getApprovalCount();

        int filteredRecords = approvalSettingService.getFilteredApprovalCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            ApprovalSetting approvalSetting = (ApprovalSetting) obj;

            JSONObject json = new JSONObject();

//            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + approvalSetting.getId() + "'>");
            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("approvalOne", approvalSetting.getApprovalOne() != null ? approvalSetting.getApprovalOne() : "");
            json.put("approvalTwo", approvalSetting.getApprovalTwo() != null ? approvalSetting.getApprovalTwo() : "");
            json.put("approvalThree", approvalSetting.getApprovalThree() != null ? approvalSetting.getApprovalThree() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='approvalSetting.htm?act=viewClick&id="
                    + approvalSetting.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
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
