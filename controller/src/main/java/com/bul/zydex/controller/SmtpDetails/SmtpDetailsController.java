/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.SmtpDetails;

import com.bul.zydex.model.PlantMaster;
import com.bul.zydex.model.SmtpDetails;
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
public class SmtpDetailsController extends SmtpDetailsAbstract {

    public ModelAndView showSmtpDetailsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        List list = smtpDetailsService.read();
        request.setAttribute("list", list);

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

//     mv.getModelMap().put("smtpDetails",smtpDetails);
        mv.setViewName("SmtpDetails/ShowSmtpDetailsList");
        return mv;
    }

    public ModelAndView createSmtpDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        SmtpDetails smtpDetails = new SmtpDetails();
        mv.getModelMap().put("smtpDetails", smtpDetails);

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

        mv.setViewName("SmtpDetails/CreateSmtpDetails");
        return mv;
    }

    public ModelAndView submitSmtpDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        String ip = request.getParameter("ip");
        String port = request.getParameter("port");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String sslApply = request.getParameter("sslApply");
        if (sslApply == null) {
            sslApply = "0";
        }

        SmtpDetails smtpDetails = new SmtpDetails();

        smtpDetails.setIp(ip);
        smtpDetails.setPort(port);
        smtpDetails.setUserName(userName);
        smtpDetails.setUserPassword(userPassword);
        smtpDetails.setSslApply(sslApply);

        if (!smtpDetailsService.isExist(smtpDetails)) {
            smtpDetailsService.create(smtpDetails);

            session.setAttribute("successMessage", "SmtpDetails  Created Successfully");
            mv.setViewName("redirect:smtpDetails.htm?act=showSmtpDetailsList");

        } else {

            session.setAttribute("failureMessage", "SmtpDetails  Already Exist. Please Enter SmtpDetails ");
            mv.setViewName("redirect:smtpDetails.htm?act=createSmtpDetails");
        }

        return mv;
    }

    public ModelAndView deleteSmtpDetailsById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            smtpDetailsService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:smtpDetails.htm?act=showSmtpDetailsList");
        return mv;
    }

    public ModelAndView deleteSmtpDetailsDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            smtpDetailsService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:smtpDetails.htm?act=showSmtpDetailsList");
        return mv;
    }

    public ModelAndView editSmtpDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        SmtpDetails smtpDetails = smtpDetailsService.readById(Integer.parseInt(id));
        mv.getModelMap().put("smtpDetails", smtpDetails);
        mv.setViewName("SmtpDetails/EditSmtpDetails");
        return mv;
    }

    public ModelAndView editSmtpDetailsSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String ip = request.getParameter("ip");
        String id = request.getParameter("id");
        String port = request.getParameter("port");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String sslApply = request.getParameter("sslApply");
        if (sslApply == null) {
            sslApply = "0";
        }

        SmtpDetails smtpDetails = new SmtpDetails();
        smtpDetails.setIp(ip);
        smtpDetails.setId(Integer.parseInt(id));
        smtpDetails.setPort(port);
        smtpDetails.setUserName(userName);
        smtpDetails.setUserPassword(userPassword);
        smtpDetails.setSslApply(sslApply);

        smtpDetailsService.update(smtpDetails);

        SmtpDetails smtpDetails1 = smtpDetailsService.readById(Integer.parseInt(id));
        mv.getModelMap().put("smtpDetails", smtpDetails1);
        session.setAttribute("successMessage",
                "SmtpDetails edit successfully");

        mv.setViewName("redirect:smtpDetails.htm?act=showSmtpDetailsList");
        return mv;

    }

    public ModelAndView smtpPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "ip";
                    break;
                case "3":
                    orderColumn = "port";
                    break;
                case "4":
                    orderColumn = "userName";
                    break;
                case "5":
                    orderColumn = "userPassword";
                    break;
                case "6":
                    orderColumn = "sslApply";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = smtpDetailsService.getSmtpPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = smtpDetailsService.getTotalSmtpCount();

        int filteredRecords = smtpDetailsService.getFilteredSmtpCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            SmtpDetails smtpDetails = (SmtpDetails) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + smtpDetails.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("ip", smtpDetails.getIp() != null ? smtpDetails.getIp() : "");
            json.put("port", smtpDetails.getPort()!= null ? smtpDetails.getPort() : "");
            json.put("userName", smtpDetails.getUserName() != null ? smtpDetails.getUserName() : "");
            json.put("userPassword", smtpDetails.getUserPassword() != null ? smtpDetails.getUserPassword() : "");
            json.put("sslApply", "1".equals(smtpDetails.getSslApply()) ? "Yes" : "No");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='smtpDetails.htm?act=editSmtpDetails&id="
                    + smtpDetails.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + smtpDetails.getId() + "'>"
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
