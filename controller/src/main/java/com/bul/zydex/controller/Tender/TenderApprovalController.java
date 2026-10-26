/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Tender;

import com.bul.zydex.model.CommitteeApprovalSetting;
import com.bul.zydex.model.CommitteeApprovalUser;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TenderApprovalSetting;
import com.bul.zydex.model.TenderApprovalUser;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Bulwark-4
 */
public class TenderApprovalController extends TenderApprovalAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderApprovalSetting tenderApprovalSetting = new TenderApprovalSetting();
        List list = tenderApprovalSettingService.read();
        mv.getModelMap().addAttribute("list", list);
        mv.getModelMap().put("tenderApprovalSetting", tenderApprovalSetting);

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

        mv.setViewName("Tender/TenderApprovalSettingList");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        String id = request.getParameter("id");

        TenderApprovalSetting tenderApprovalSetting = new TenderApprovalSetting();
        // Edit Form

        try {
            tenderApprovalSetting = tenderApprovalSettingService.readById(Integer.parseInt(id));
        } catch (Exception e) {

        }
        List<EmployeeMaster> employeeMaster1 = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().addAttribute("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("tenderApprovalSetting", tenderApprovalSetting);

        mv.setViewName("Tender/TenderApprovalSettingCreate");
        return mv;
    }

    public ModelAndView createTenderApprovalSettingForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderApprovalSetting tenderApprovalSetting = new TenderApprovalSetting();
        mv.getModelMap().put("tenderApprovalSetting", tenderApprovalSetting);
        mv.setViewName("Tender/TenderApprovalSettingCreate");
        return mv;
    }

    public ModelAndView approvalWorkFlowSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        TenderApprovalSetting tenderApprovalSetting = new TenderApprovalSetting();
        TenderApprovalUser tenderApprovalUser = new TenderApprovalUser();

        String id = request.getParameter("id");

        String approvalName = request.getParameter("approvalName");

        tenderApprovalSetting.setApprovalName(approvalName);

        if (!tenderApprovalSettingService.isExist(tenderApprovalSetting)) {

            tenderApprovalSettingService.create(tenderApprovalSetting);

            int approveId = tenderApprovalSetting.getId();

            TenderApprovalSetting tenderApprovalSetting1 = tenderApprovalSettingService.readById(approveId);

            List employeeMaster1 = employeeMasterService.read();

            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();

            UserRights userRights = userRightsService.readByUser(username);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);

            String employeeCode = employeeMaster.getEmployeeCode();
            tenderApprovalUser.setUserId(employeeCode);

//        int policyCount = Integer.parseInt(request.getParameter("policyCount"));
            String[] userList = request.getParameterValues("userList");

            tenderApprovalUser.setTenderApprovalSetting(tenderApprovalSetting1);
            for (int i = 0; i < userList.length; i++) {
                String userLists = (userList != null && userList.length > i && userList[i] != null) ? userList[i].trim() : "";

                tenderApprovalUser.setLevel(i + 1);

                tenderApprovalUser.setUserId(userLists);

                tenderApprovalUserService.create(tenderApprovalUser);

            }

            mv.getModelMap().put("id", id);

            mv.getModelMap().put("employeeMaster1", employeeMaster1);
            mv.getModelMap().put("tenderApprovalSetting", tenderApprovalSetting);
            mv.getModelMap().put("tenderApprovalUser", tenderApprovalUser);

            session.setAttribute("successMessage", "Tender Approval  Created Successfully");
            mv.setViewName("redirect:tenderApproval.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "Tender Approval  Already Exist. Please Enter Tender Approval ");
            mv.setViewName("redirect:tenderApproval.htm?act=viewClick");
        }

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        TenderApprovalSetting appSetting = tenderApprovalSettingService.readById(Integer.parseInt(id));

        List<EmployeeMaster> empByData = new ArrayList<>();
        List<?> userTender = tenderApprovalUserService.readByIdToList(id);

        ListIterator<TenderApprovalUser> itr = (ListIterator<TenderApprovalUser>) userTender.listIterator();
        while (itr.hasNext()) {
            TenderApprovalUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);
        }

        List<EmployeeMaster> allEmployee = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().addAttribute("appSetting", appSetting);
        mv.getModelMap().addAttribute("userTender", userTender);
        mv.getModelMap().addAttribute("employeeMaster1", allEmployee);

        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Tender/TenderApprovalSettingEdit");
        return mv;
    }

    public ModelAndView tenderApprovalMatrixUserAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        TenderApprovalSetting appSetting = tenderApprovalSettingService.readById(Integer.parseInt(id));

        List<EmployeeMaster> empByData = new ArrayList<>();
        List<?> userTender = tenderApprovalUserService.readByIdToList(id);

        ListIterator<TenderApprovalUser> itr = (ListIterator<TenderApprovalUser>) userTender.listIterator();

        while (itr.hasNext()) {
            TenderApprovalUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);
        }

        mv.getModelMap().addAttribute("appSetting", appSetting);

        mv.getModelMap().addAttribute("userTender", userTender);

        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Tender/TenderApprovalMatrixUserAjax");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String approvalName = request.getParameter("approvalName");

        TenderApprovalSetting appSettingSuper = new TenderApprovalSetting();
        appSettingSuper.setId(Integer.parseInt(id));
        appSettingSuper.setApprovalName(approvalName);
        tenderApprovalSettingService.createOrUpdate(appSettingSuper);

        String[] userLists = request.getParameterValues("userList");

        try {

            for (int i = 0; i < userLists.length; i++) {
                if (userLists[i] != null && userLists[i] != "") {
                    TenderApprovalUser tenderApprovalUser1 = new TenderApprovalUser();
                    tenderApprovalUser1.setLevel(i + 1);
                    tenderApprovalUser1.setUserId(userLists[i]);
                    tenderApprovalUser1.setTenderApprovalSetting(appSettingSuper);
                    tenderApprovalUserService.create(tenderApprovalUser1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("successMessage", "Tender Approval Edited successfully");
        mv.setViewName("redirect:tenderApproval.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteapprovalSettingTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            List list = tenderApprovalUserService.readByIdToList(checkedValues);

            for (Object obj : list) {
                TenderApprovalUser user = (TenderApprovalUser) obj;
                tenderApprovalUserService.delete(user.getId());
            }

            tenderApprovalSettingService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:tenderApproval.htm?act=showList");
        return mv;
    }

    public ModelAndView showList1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        CommitteeApprovalSetting committeeApprovalSetting = new CommitteeApprovalSetting();
//
//        mv.getModelMap().put("committeeApprovalSetting", committeeApprovalSetting);

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

        mv.setViewName("Tender/CommitteeApprovalSettingList");
        return mv;
    }

    public ModelAndView viewClick1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

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
        CommitteeApprovalSetting committeeApprovalSetting = new CommitteeApprovalSetting();
        // Edit Form

        try {
            committeeApprovalSetting = committeeApprovalSettingService.readById(Integer.parseInt(id));
        } catch (Exception e) {

        }
        List<EmployeeMaster> employeeMaster1 = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().addAttribute("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("committeeApprovalSetting", committeeApprovalSetting);

        mv.setViewName("Tender/CommitteeApprovalSettingCreate");
        return mv;
    }

    public ModelAndView createCommitteeApprovalSettingForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CommitteeApprovalSetting committeeApprovalSetting = new CommitteeApprovalSetting();
        mv.getModelMap().put("committeeApprovalSetting", committeeApprovalSetting);
        mv.setViewName("Tender/CommitteeApprovalSettingCreate");
        return mv;
    }

    public ModelAndView approvalWorkFlowSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        CommitteeApprovalSetting committeeApprovalSetting = new CommitteeApprovalSetting();
        CommitteeApprovalUser committeeApprovalUser = new CommitteeApprovalUser();

        String id = request.getParameter("id");

        String approvalName = request.getParameter("approvalName");

        committeeApprovalSetting.setApprovalName(approvalName);

        if (!committeeApprovalSettingService.isExist(committeeApprovalSetting)) {
            committeeApprovalSettingService.create(committeeApprovalSetting);
            int approveId = committeeApprovalSetting.getId();

            CommitteeApprovalSetting committeeApprovalSetting1 = committeeApprovalSettingService.readById(approveId);

            List employeeMaster1 = employeeMasterService.read();

            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();

            UserRights userRights = userRightsService.readByUser(username);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);

            String employeeCode = employeeMaster.getEmployeeCode();
            committeeApprovalUser.setUserId(employeeCode);

            String[] userLists = request.getParameterValues("userList");

            try {

                for (int i = 0; i < userLists.length; i++) {

                    CommitteeApprovalUser committeeApprovalUser1 = new CommitteeApprovalUser();
                    committeeApprovalUser1.setLevel(i + 1);
                    committeeApprovalUser1.setUserId(userLists[i]);
                    committeeApprovalUser1.setCommitteeApprovalSetting(committeeApprovalSetting);
                    committeeApprovalUserService.create(committeeApprovalUser1);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            mv.getModelMap().put("id", id);

            mv.getModelMap().put("employeeMaster1", employeeMaster1);
            mv.getModelMap().put("committeeApprovalSetting", committeeApprovalSetting);
            mv.getModelMap().put("committeeApprovalUser", committeeApprovalUser);

            session.setAttribute("successMessage", "Committee Approval  Created Successfully");
            mv.setViewName("redirect:tenderApproval.htm?act=showList1");

        } else {

            session.setAttribute("failureMessage", "Committee Approval  Already Exist. Please Enter Committee Approval ");
            mv.setViewName("redirect:tenderApproval.htm?act=viewClick1");
        }

        return mv;
    }

    public ModelAndView editClick1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();

        CommitteeApprovalSetting appSetting = committeeApprovalSettingService.readById(Integer.parseInt(id));
        List<EmployeeMaster> empByData = new ArrayList<>();
        List<?> committeeUser = committeeApprovalUserService.readByIdToList1(id);

        ListIterator<CommitteeApprovalUser> itr = (ListIterator<CommitteeApprovalUser>) committeeUser.listIterator();
        while (itr.hasNext()) {
            CommitteeApprovalUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);
        }

        List<EmployeeMaster> allEmployee = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().addAttribute("appSetting", appSetting);

        mv.getModelMap().addAttribute("committeeUser", committeeUser);
        mv.getModelMap().addAttribute("employeeMaster1", allEmployee);

        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Tender/CommitteeApprovalSettingEdit");
        return mv;
    }

    public ModelAndView committeeApprovalSettingAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();

        CommitteeApprovalSetting appSetting = committeeApprovalSettingService.readById(Integer.parseInt(id));
        List<EmployeeMaster> empByData = new ArrayList<>();
        List<?> committeeUser = committeeApprovalUserService.readByIdToList1(id);

        ListIterator<CommitteeApprovalUser> itr = (ListIterator<CommitteeApprovalUser>) committeeUser.listIterator();
        while (itr.hasNext()) {
            CommitteeApprovalUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);
        }

        mv.getModelMap().addAttribute("appSetting", appSetting);
        mv.getModelMap().addAttribute("committeeUser", committeeUser);

        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Tender/committeeApprovalSettingAjax");
        return mv;
    }

    public ModelAndView editSubmit1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String approvalName = request.getParameter("approvalName");

        CommitteeApprovalSetting appSettingSuper = new CommitteeApprovalSetting();
        appSettingSuper.setId(Integer.parseInt(id));
        appSettingSuper.setApprovalName(approvalName);
        committeeApprovalSettingService.createOrUpdate(appSettingSuper);

        String[] userLists = request.getParameterValues("userList");

        try {

            for (int i = 0; i < userLists.length; i++) {
                if (userLists[i] != null && userLists[i] != "") {
                    CommitteeApprovalUser committeeApprovalUser1 = new CommitteeApprovalUser();
                    committeeApprovalUser1.setLevel(i + 1);
                    committeeApprovalUser1.setUserId(userLists[i]);
                    committeeApprovalUser1.setCommitteeApprovalSetting(appSettingSuper);
                    committeeApprovalUserService.create(committeeApprovalUser1);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("successMessage", " Committee Approval  Edited successfully");
        mv.setViewName("redirect:tenderApproval.htm?act=showList1");

        return mv;
    }

    public ModelAndView deleteapprovalSettingTender1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            List list = committeeApprovalUserService.readByIdToList1(checkedValues);

            for (Object obj : list) {
                CommitteeApprovalUser user = (CommitteeApprovalUser) obj;
                committeeApprovalUserService.delete(user.getId());
            }

            committeeApprovalSettingService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:tenderApproval.htm?act=showList1");
        return mv;
    }

    public ModelAndView deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List tenderapprovaluser = tenderApprovalUserService.readByIdToList(id);

        try {

            for (Object o : tenderapprovaluser) {

                TenderApprovalUser tenderApprovalUser = (TenderApprovalUser) o;
                int id3 = tenderApprovalUser.getId();
                tenderApprovalUserService.delete(id3);

            }
        } catch (Exception e) {

        }

        try {
            tenderApprovalSettingService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:tenderApproval.htm?act=showList");
        return mv;

    }

    public ModelAndView deleteuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String apprId = request.getParameter("apprId");

        try {
            tenderApprovalUserService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:tenderApproval.htm?act=editClick&id=" + apprId);
        return mv;

    }

    public ModelAndView deletesingleId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        List committeeapprovaluser = committeeApprovalUserService.readByIdToList1(id);

        try {

            for (Object o : committeeapprovaluser) {

                CommitteeApprovalUser committeeApprovalUser = (CommitteeApprovalUser) o;
                int id3 = committeeApprovalUser.getId();
                committeeApprovalUserService.delete(id3);

            }
        } catch (Exception e) {

        }

        try {
            committeeApprovalSettingService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:tenderApproval.htm?act=showList1");
        return mv;

    }

    public ModelAndView deleteusers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String apprId = request.getParameter("apprId");

        try {
            committeeApprovalUserService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:tenderApproval.htm?act=editClick1&id=" + apprId);
        return mv;

    }

    public ModelAndView tenderPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "approvalName";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "approvalName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = tenderApprovalSettingService.getTenderPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = tenderApprovalSettingService.getTotalTenderCount();

        int filteredRecords = tenderApprovalSettingService.getFilteredTenderCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            TenderApprovalSetting tenderApprovalSetting = (TenderApprovalSetting) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + tenderApprovalSetting.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("approvalName", tenderApprovalSetting.getApprovalName() != null ? tenderApprovalSetting.getApprovalName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='tenderApproval.htm?act=editClick&id="
                    + tenderApprovalSetting.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + tenderApprovalSetting.getId() + "'>"
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

    public ModelAndView commiteePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "approvalName";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "2":
                    orderColumn = "approvalName";
                    break;
                default:
                    orderColumn = "approvalName";
                    break;
            }
        }

        List list = committeeApprovalSettingService.getCommitteePagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = committeeApprovalSettingService.getTotalCommitteeCount();

        int filteredRecords = committeeApprovalSettingService.getFilteredCommitteeCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir) && "2".equals(orderColumnIndex);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            CommitteeApprovalSetting committeeApprovalSetting = (CommitteeApprovalSetting) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + committeeApprovalSetting.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("approvalName", committeeApprovalSetting.getApprovalName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='tenderApproval.htm?act=editClick1&id="
                    + committeeApprovalSetting.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + committeeApprovalSetting.getId() + "'>"
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
