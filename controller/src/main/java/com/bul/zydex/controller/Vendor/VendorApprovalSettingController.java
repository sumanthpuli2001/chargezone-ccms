/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vendor;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TenderApprovalSetting;
import com.bul.zydex.model.TenderApprovalUser;
import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorApprovalSetting;
import com.bul.zydex.model.VendorApprovalUser;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bulwarks-2
 */
public class VendorApprovalSettingController extends VendorApprovalSettingAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VendorApprovalSetting vendorApprovalSetting = new VendorApprovalSetting();

        mv.getModelMap().put("vendorApprovalSetting", vendorApprovalSetting);

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

        mv.setViewName("Vendor/VendorApprovalSettingList");
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

        VendorApprovalSetting vendorApprovalSetting = new VendorApprovalSetting();
        // Edit Form

        try {
            vendorApprovalSetting = vendorApprovalSettingService.readById(Integer.parseInt(id));
        } catch (Exception e) {

        }
        List<EmployeeMaster> employeeMaster1 = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().addAttribute("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("vendorApprovalSetting", vendorApprovalSetting);

        mv.setViewName("Vendor/VendorApprovalSettingCreate");
        return mv;
    }

    public ModelAndView createTenderApprovalSettingForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        VendorApprovalSetting vendorApprovalSetting = new VendorApprovalSetting();
        mv.getModelMap().put("vendorApprovalSetting", vendorApprovalSetting);
        mv.setViewName("Vendor/VendorApprovalSettingCreate");
        return mv;
    }

    public ModelAndView approvalWorkFlowSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        VendorApprovalSetting vendorApprovalSetting = new VendorApprovalSetting();
        VendorApprovalUser vendorApprovalUser = new VendorApprovalUser();

        String id = request.getParameter("id");

        String approvalName = request.getParameter("approvalName");

        vendorApprovalSetting.setApprovalName(approvalName);

        if (!vendorApprovalSettingService.isExist(vendorApprovalSetting)) {
            vendorApprovalSettingService.create(vendorApprovalSetting);

            int approveId = vendorApprovalSetting.getId();

            VendorApprovalSetting vendorApprovalSetting1 = vendorApprovalSettingService.readById(approveId);

            List employeeMaster1 = employeeMasterService.read();

            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();

            UserRights userRights = userRightsService.readByUser(username);

            EmployeeMaster employeeMaster = employeeMasterService.read(username);

            String employeeCode = employeeMaster.getEmployeeCode();
            vendorApprovalUser.setUserId(employeeCode);

            String[] userLists = request.getParameterValues("userList");

            try {

                for (int i = 0; i < userLists.length; i++) {

                    VendorApprovalUser vendorApprovalUser1 = new VendorApprovalUser();
                    vendorApprovalUser1.setLevel(i + 1);
                    vendorApprovalUser1.setUserId(userLists[i]);
                    vendorApprovalUser1.setVendorApprovalSetting(vendorApprovalSetting);
                    vendorApprovalUserService.create(vendorApprovalUser1);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            mv.getModelMap().put("id", id);

            mv.getModelMap().put("employeeMaster1", employeeMaster1);
            mv.getModelMap().put("vendorApprovalSetting", vendorApprovalSetting);
            mv.getModelMap().put("vendorApprovalUser", vendorApprovalUser);

            session.setAttribute("successMessage", "Vendor Approval  Created Successfully");
            mv.setViewName("redirect:vendorApprovalSetting.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "Vendor Approval  Already Exist. Please Enter Vendor Approval ");
            mv.setViewName("redirect:vendorApprovalSetting.htm?act=viewClick");
        }

        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        VendorApprovalSetting appSetting = vendorApprovalSettingService.readById(Integer.parseInt(id));

        List<EmployeeMaster> empByData = new ArrayList<>();
        List<?> userVendor = vendorApprovalUserService.readByIdToList(id);

        ListIterator<VendorApprovalUser> itr = (ListIterator<VendorApprovalUser>) userVendor.listIterator();
        while (itr.hasNext()) {
            VendorApprovalUser s = itr.next();

            EmployeeMaster userList = employeeMasterService.read(s.getUserId());

            empByData.add(userList);
        }

        List<EmployeeMaster> allEmployee = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().addAttribute("appSetting", appSetting);

        mv.getModelMap().addAttribute("userTender", userVendor);
        mv.getModelMap().addAttribute("employeeMaster1", allEmployee);

        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Vendor/VendorApprovalSettingEdit");
        return mv;
    }

     public ModelAndView vendorApprovalMatrixUserAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        ModelAndView mv = new ModelAndView();
        VendorApprovalSetting appSetting = vendorApprovalSettingService.readById(Integer.parseInt(id));

        List<EmployeeMaster> empByData = new ArrayList<>();
        List<?> userVendor = vendorApprovalUserService.readByIdToList(id);

        ListIterator<VendorApprovalUser> itr = (ListIterator<VendorApprovalUser>) userVendor.listIterator();
        while (itr.hasNext()) {
            VendorApprovalUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);
        }

        mv.getModelMap().addAttribute("appSetting", appSetting);
        mv.getModelMap().addAttribute("userTender", userVendor);

        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Vendor/VendorApprovalMatrixUserAjax");
        return mv;
    }
    
    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String approvalName = request.getParameter("approvalName");

        VendorApprovalSetting appSettingSuper = new VendorApprovalSetting();
        appSettingSuper.setId(Integer.parseInt(id));
        appSettingSuper.setApprovalName(approvalName);
        vendorApprovalSettingService.createOrUpdate(appSettingSuper);

        List<?> moseData = vendorApprovalUserService.readByIdToList(id);

        String[] userLists = request.getParameterValues("userList");

        try {

            for (int i = 0; i < userLists.length; i++) {
                if (userLists[i] != null && userLists[i] != "") {
                    VendorApprovalUser vendorApprovalUser1 = new VendorApprovalUser();
                    vendorApprovalUser1.setLevel(i + 1);
                    vendorApprovalUser1.setUserId(userLists[i]);
                    vendorApprovalUser1.setVendorApprovalSetting(appSettingSuper);
                    vendorApprovalUserService.create(vendorApprovalUser1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.setAttribute("successMessage", "Vendor Approval Edited successfully");

        mv.setViewName("redirect:vendorApprovalSetting.htm?act=showList");

        return mv;
    }

    public ModelAndView deleteVendorapprovalSetting(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            List list = vendorApprovalUserService.readByIdToList(checkedValues);

            for (Object obj : list) {
                VendorApprovalUser user = (VendorApprovalUser) obj;
                vendorApprovalUserService.delete(user.getId());
            }

            vendorApprovalSettingService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:vendorApprovalSetting.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteuser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String apprId = request.getParameter("apprId");

        try {
            vendorApprovalUserService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:vendorApprovalSetting.htm?act=editClick&id=" + apprId);
        return mv;

    }

    public ModelAndView deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        List vendorapprovaluser = vendorApprovalUserService.readByIdToList(id);

        try {

            for (Object o : vendorapprovaluser) {

                VendorApprovalUser vendorApprovalUser = (VendorApprovalUser) o;
                int id3 = vendorApprovalUser.getId();
                vendorApprovalUserService.delete(id3);

            }
        } catch (Exception e) {

        }

        try {
            vendorApprovalSettingService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:vendorApprovalSetting.htm?act=showList");
        return mv;

    }

    public ModelAndView vendorPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        List list = vendorApprovalSettingService.getVendorPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = vendorApprovalSettingService.getTotalVendorCount();

        int filteredRecords = vendorApprovalSettingService.getFilteredVendorCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            VendorApprovalSetting vendorApprovalSetting = (VendorApprovalSetting) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + vendorApprovalSetting.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("approvalName", vendorApprovalSetting.getApprovalName() != null ? vendorApprovalSetting.getApprovalName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='vendorApprovalSetting.htm?act=editClick&id="
                    + vendorApprovalSetting.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + vendorApprovalSetting.getId() + "'>"
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
