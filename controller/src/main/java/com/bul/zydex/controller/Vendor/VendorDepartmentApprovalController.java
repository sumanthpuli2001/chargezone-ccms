/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vendor;

import com.bul.zydex.model.ValuationClassMaster;
import com.bul.zydex.model.VendorDepartmentApproval;
import java.util.List;
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
public class VendorDepartmentApprovalController extends VendorDepartmentApprovalAbstract {

    public ModelAndView showVendorDepartmentApprovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("Vendor/ShowVendorDepartmentApprovalList");
        return mv;
    }

    public ModelAndView createVendorDepartmentApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        List list = departmentMasterService.read();
        request.setAttribute("list", list);
        List list1 = employeeMasterService.read();
        request.setAttribute("list1", list1);

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

        mv.setViewName("Vendor/CreateVendorDepartmentApproval");
        return mv;
    }

    public ModelAndView submitDepartmentApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String departmentId = request.getParameter("departmentId");
        String approvalName = request.getParameter("approvalName");
        VendorDepartmentApproval vendorDepartmentApproval = new VendorDepartmentApproval();
        vendorDepartmentApproval.setDepartmentId(departmentId);
        vendorDepartmentApproval.setApprovalName(approvalName);

        if (!vendorDepartmentApprovalService.isExist(vendorDepartmentApproval)) {
            vendorDepartmentApprovalService.create(vendorDepartmentApproval);

            session.setAttribute("successMessage", "Vendor Department  Created Successfully");
            mv.setViewName("redirect:vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList");

        } else {

            session.setAttribute("failureMessage", "Vendor Department  Already Exist. Please Enter Vendor Department ");
            mv.setViewName("redirect:vendorDepartmentApproval.htm?act=createVendorDepartmentApproval");
        }

        return mv;
    }

    public ModelAndView deleteVendorApprovalById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            vendorDepartmentApprovalService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList");
        return mv;
    }

    public ModelAndView deletevendorDepartmentApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            vendorDepartmentApprovalService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList");
        return mv;
    }

    public ModelAndView editVendorDepartmentApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List list = departmentMasterService.read();
        String id = request.getParameter("id");
        request.setAttribute("list", list);
        List list1 = employeeMasterService.read();
        request.setAttribute("list1", list1);
        VendorDepartmentApproval vendorDepartmentApproval = vendorDepartmentApprovalService.readById(Integer.parseInt(id));
        mv.getModelMap().put("vendorDepartmentApproval", vendorDepartmentApproval);
        mv.setViewName("Vendor/EditVendorDepartmentApproval");
        return mv;
    }

    public ModelAndView submitEditDepartmentApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String departmentId = request.getParameter("departmentId");
        String approvalName = request.getParameter("approvalName");
        VendorDepartmentApproval vendorDepartmentApproval = vendorDepartmentApprovalService.readById(Integer.parseInt(id));
        vendorDepartmentApproval.setDepartmentId(departmentId);
        vendorDepartmentApproval.setApprovalName(approvalName);
        vendorDepartmentApprovalService.update(vendorDepartmentApproval);

        session.setAttribute("successMessage", "Vendor Department edit successfully");
        mv.setViewName("redirect:vendorDepartmentApproval.htm?act=showVendorDepartmentApprovalList");

        return mv;
    }

    public ModelAndView venDeptPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "departmentId";
                    break;
                case "3":
                    orderColumn = "approvalName";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = vendorDepartmentApprovalService.getVenDeptPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = vendorDepartmentApprovalService.getTotalVenDeptCount();

        int filteredRecords = vendorDepartmentApprovalService.getFilteredVenDeptCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            VendorDepartmentApproval vendorDepartmentApproval = (VendorDepartmentApproval) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + vendorDepartmentApproval.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("departmentId", vendorDepartmentApproval.getDepartmentId() != null ? vendorDepartmentApproval.getDepartmentId() : "");
            json.put("approvalName", vendorDepartmentApproval.getApprovalName() != null ? vendorDepartmentApproval.getApprovalName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='vendorDepartmentApproval.htm?act=editVendorDepartmentApproval&id="
                    + vendorDepartmentApproval.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + vendorDepartmentApproval.getId() + "'>"
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
