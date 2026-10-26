/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.VendorInviteSource;

import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.VendorInviteSource;
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
public class VendorInviteSourceController extends VendorInviteSourceAbstract {

    public ModelAndView showVendorInviteSourceList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("VendorInviteSource/ShowVendorInviteSourceList");
        return mv;
    }

    public ModelAndView createVendorInviteSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("VendorInviteSource/CreateVendorInviteSource");
        return mv;
    }

    public ModelAndView submitVendorInviteSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String source = request.getParameter("source");

        VendorInviteSource vendorInviteSource = new VendorInviteSource();
        vendorInviteSource.setSource(source);
        if (!VendorInviteSourceService.isExist(vendorInviteSource)) {
            VendorInviteSourceService.create(vendorInviteSource);

            session.setAttribute("successMessage", "Vendor Invite Source Created Successfully");
            mv.setViewName("redirect:vendorInviteSource.htm?act=showVendorInviteSourceList");
        } else {

            session.setAttribute("failureMessage", "Vendor Invite Source Already Exist. Please Enter New Source Name");
            mv.setViewName("redirect:vendorInviteSource.htm?act=createVendorInviteSource");
        }

        return mv;
    }

    public ModelAndView editVendorInviteSource(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        VendorInviteSource vendorInviteSource = VendorInviteSourceService.readById(Integer.parseInt(id));
        mv.getModelMap().put("vendorInviteSource", vendorInviteSource);
        mv.setViewName("VendorInviteSource/EditVendorInviteSource");
        return mv;
    }

    public ModelAndView editVendorInviteSourceSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String source = request.getParameter("source");
        VendorInviteSource vendorInviteSource = VendorInviteSourceService.readById(Integer.parseInt(id));
        vendorInviteSource.setSource(source);
        VendorInviteSourceService.update(vendorInviteSource);

        session.setAttribute("successMessage", "Vendor Invite Source Edited Successfully");
        mv.setViewName("redirect:vendorInviteSource.htm?act=showVendorInviteSourceList");
        return mv;
    }

    public ModelAndView deleteVendorInviteSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            VendorInviteSourceService.delete(Integer.parseInt(checkedValues));
        }
        mv.setViewName("redirect:vendorInviteSource.htm?act=showVendorInviteSourceList");
        return mv;
    }

    public ModelAndView deleteById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        try {
            VendorInviteSourceService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:vendorInviteSource.htm?act=showVendorInviteSourceList");
        return mv;

    }

    public ModelAndView vendorInviteSourcePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
                    orderColumn = "source";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = VendorInviteSourceService.getVendorInviteSourcePagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = VendorInviteSourceService.getTotalVendorInviteSourceCount();

        int filteredRecords = VendorInviteSourceService.getFilteredVendorInviteSourceCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            VendorInviteSource vendorInviteSource = (VendorInviteSource) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + vendorInviteSource.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("source", vendorInviteSource.getSource() != null ? vendorInviteSource.getSource() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='vendorInviteSource.htm?act=editVendorInviteSource&id="
                    + vendorInviteSource.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + vendorInviteSource.getId() + "'>"
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
