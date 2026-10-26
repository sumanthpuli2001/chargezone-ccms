/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.AuditorMaster;

import com.bul.zydex.model.AuditorMaster;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.model.VendorSelfDeclaration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
public class AuditorMasterController extends AuditorMasterAbstract {

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

        mv.setViewName("Auditor/ShowList");
        return mv;
    }

    public ModelAndView newPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        mv.setViewName("Auditor/NewPage");
        return mv;
    }

    public ModelAndView newPageSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String auditor_code = request.getParameter("auditor_code");
        String auditor_name = request.getParameter("auditor_name");
        String auditor_address = request.getParameter("auditor_address");
        String auditor_email_id = request.getParameter("auditor_email_id");
        String auditor_mobile_no = request.getParameter("auditor_mobile_no");
        String auditor_status = request.getParameter("auditor_status");
        String auditor_remark = request.getParameter("auditor_remark");
        String auditor_role = request.getParameter("auditorRole");

        AuditorMaster auditorMaster = new AuditorMaster();
        auditorMaster.setAuditorCode(auditor_code);
        auditorMaster.setAuditorName(auditor_name);
        auditorMaster.setAuditorAddress(auditor_address);
        auditorMaster.setAuditorEmail(auditor_email_id);
        auditorMaster.setAuditorMobileNo(auditor_mobile_no);
        auditorMaster.setAuditorStatus(auditor_status);
        auditorMaster.setAuditorRemark(auditor_remark);
        auditorMaster.setAuditorRole(auditor_role);

        if (!auditorMasterService.isExist(auditorMaster)) {
            List userMaster1 = userMasterService.readUser(auditor_code);
            if (userMaster1.isEmpty()) {
                auditorMasterService.create(auditorMaster);

                UserMaster userMaster = new UserMaster();
                userMaster.setLoginName(auditor_code);
                userMaster.setPassword("Admin@123");
                userMaster.setUserFullName(auditor_name);
                userMaster.setUserType(3);
                userMaster.setPwdChange(0);
                userMaster.setLock1(0);
                userMaster.setUserTry(0);
                userMasterService.create(userMaster);

                session.setAttribute("successMessage", "Auditor Created Successfully");
                mv.setViewName("redirect:auditorMaster.htm?act=showList");
            } else {
                session.setAttribute("failureMessage", "Auditor Name Already Exist. Please Enter Different Auditor Code");
                mv.setViewName("redirect:auditorMaster.htm?act=newPage");
            }
        } else {
            session.setAttribute("failureMessage", "Auditor Already Exist. Please Enter Auditor");
            mv.setViewName("redirect:auditorMaster.htm?act=newPage");
        }

//            request.setAttribute("successMessage",
//                    "Information: New Auditor Created Successfully");
//            mv.setViewName("forward:auditorMaster.htm?act=showList");
//
//        } else {
//
//            request.setAttribute("failureMessage",
//                    "Information:  Auditor is Already Existing");
//            mv.setViewName("forward:auditorMaster.htm?act=showList");
//        }
        return mv;
    }

    public ModelAndView editPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        AuditorMaster auditorMaster = auditorMasterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("auditorMaster", auditorMaster);

        mv.setViewName("Auditor/EditPage");
        return mv;
    }

    public ModelAndView editPageSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");

        String auditor_code = request.getParameter("auditor_code");
        String auditor_name = request.getParameter("auditor_name");
        String auditor_address = request.getParameter("auditor_address");
        String auditor_email_id = request.getParameter("auditor_email_id");
        String auditor_mobile_no = request.getParameter("auditor_mobile_no");
        String auditor_status = request.getParameter("auditor_status");
        String auditor_remark = request.getParameter("auditor_remark");
        String auditor_role = request.getParameter("auditorRole");

        AuditorMaster auditorMaster = auditorMasterService.readById(Integer.parseInt(id));
        auditorMaster.setAuditorCode(auditor_code);
        auditorMaster.setAuditorName(auditor_name);
        auditorMaster.setAuditorAddress(auditor_address);
        auditorMaster.setAuditorEmail(auditor_email_id);
        auditorMaster.setAuditorMobileNo(auditor_mobile_no);
        auditorMaster.setAuditorStatus(auditor_status);
        auditorMaster.setAuditorRemark(auditor_remark);
        auditorMaster.setAuditorRole(auditor_role);

        auditorMasterService.update(auditorMaster);
        request.setAttribute("successMessage", " Auditor Edited  Successfully");
        mv.setViewName("redirect:auditorMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteAuditor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        if (ids != null && !ids.isEmpty()) {
            String[] idArray = ids.split(",");
            for (String checkedValue : idArray) {
                int auditorId = Integer.parseInt(checkedValue.trim());

                // First read the entity to make sure it exists
                AuditorMaster auditor = auditorMasterService.readById(auditorId);

                if (auditor != null) {

                    userMasterService.deleteByLoginName(auditor.getAuditorCode());
                    auditorMasterService.delete(auditorId);
                }
            }
        }

        mv.setViewName("redirect:auditorMaster.htm?act=showList");

        return mv;
    }

    public ModelAndView auditordeleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        AuditorMaster auditor = auditorMasterService.readById(Integer.parseInt(id));
        try {
            userMasterService.deleteByLoginName(auditor.getAuditorCode());

            auditorMasterService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:auditorMaster.htm?act=showList");
        return mv;
    }

    public ModelAndView loginHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String user11 = user.getLoginName();

        String name = user.getLoginName();
        List list = vendorInformationService.readForAuditor(name);
        session.setAttribute("list", list);
        mv.getModelMap().put("list", list);

        mv.getModelMap().put("userMaster", user11);
        session.setAttribute("user11", user11);

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
        mv.setViewName("Auditor/LoginHomePage");
        return mv;
    }

    public ModelAndView auditorPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "auditorCode";
                    break;
                case "3":
                    orderColumn = "auditorName";
                    break;
                case "4":
                    orderColumn = "auditorAddress";
                    break;
                case "5":
                    orderColumn = "auditorEmail";
                    break;
                case "6":
                    orderColumn = "auditorMobileNo";
                    break;
                case "7":
                    orderColumn = "auditorStatus";
                    break;
                case "8":
                    orderColumn = "auditorRemark";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }
        List list = auditorMasterService.getAuditorPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = auditorMasterService.getTotalAuditorCount();

        int filteredRecords = auditorMasterService.getFilteredAuditorCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            AuditorMaster auditorMaster = (AuditorMaster) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + auditorMaster.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("auditorCode", auditorMaster.getAuditorCode() != null ? auditorMaster.getAuditorCode() : "");
            json.put("auditorName", auditorMaster.getAuditorName() != null ? auditorMaster.getAuditorName() : "");
            json.put("auditorAddress", auditorMaster.getAuditorAddress() != null ? auditorMaster.getAuditorAddress() : "");
            json.put("auditorEmail", auditorMaster.getAuditorEmail() != null ? auditorMaster.getAuditorEmail() : "");
            json.put("auditorMobileNo", auditorMaster.getAuditorMobileNo() != null ? auditorMaster.getAuditorMobileNo() : "");
            json.put("auditorRole", auditorMaster.getAuditorRole() != null ? auditorMaster.getAuditorRole() : "");
            json.put("auditorStatus", "1".equals(auditorMaster.getAuditorStatus()) ? "Active" : "Inactive");
            json.put("auditorRemark", auditorMaster.getAuditorRemark() != null ? auditorMaster.getAuditorRemark() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='auditorMaster.htm?act=editPage&id="
                    + auditorMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + auditorMaster.getId() + "'>"
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
