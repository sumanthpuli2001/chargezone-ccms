/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OapMaster;

import com.bul.zydex.model.CommitteeApprovalUser;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.OapMaster;
import com.bul.zydex.model.OapMasterUser;
import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sumanth
 */
public class OapMasterController extends OapMasterAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = oapMasterService.read();
        mv.getModelMap().addAttribute("list", list);

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

        mv.setViewName("Oap/OapForm");
        return mv;
    }

    public ModelAndView OapMasterCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        List employeeMaster1 = employeeMasterService.readByDrow();

        mv.getModelMap().addAttribute("employeeMaster1", employeeMaster1);

        mv.setViewName("Oap/OapMasterCreate");
        return mv;
    }

    public ModelAndView OapMasterEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
       ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(id));

        List<EmployeeMaster> empByData = new ArrayList<>();

        List<?> oapMasterUser = oapMasterUserService.readByIdToList1(id);
        ListIterator<OapMasterUser> itr = (ListIterator<OapMasterUser>) oapMasterUser.listIterator();
        while (itr.hasNext()) {
            OapMasterUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);

        }
        List<EmployeeMaster> allEmployee = (List<EmployeeMaster>) employeeMasterService.read();

        mv.getModelMap().put("oapMaster", oapMaster);
        mv.getModelMap().put("oapMasterUser", oapMasterUser);
        mv.getModelMap().addAttribute("employeeMaster1", allEmployee);
        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Oap/OapMasterEdit");
        return mv;
    }
    
    public ModelAndView oapApprovalMatrixUserAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(id));
        List<EmployeeMaster> empByData = new ArrayList<>();

        List<?> oapMasterUser = oapMasterUserService.readByIdToList1(id);
        ListIterator<OapMasterUser> itr = (ListIterator<OapMasterUser>) oapMasterUser.listIterator();
        while (itr.hasNext()) {
            OapMasterUser s = itr.next();
            EmployeeMaster userList = employeeMasterService.read(s.getUserId());
            empByData.add(userList);
        }

        mv.getModelMap().put("oapMaster", oapMaster);
        mv.getModelMap().put("oapMasterUser", oapMasterUser);
        request.setAttribute("empByData", empByData);
        request.setAttribute("length", empByData.size());
        request.setAttribute("id", id);

        mv.setViewName("Oap/OapApprovalMatrixUserAjax");
        return mv;
    }

    public ModelAndView OapMasterEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        String id = request.getParameter("id");
        String approvalName = request.getParameter("approvalName");
        OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(id));
        oapMaster.setApprovalName(approvalName);
        oapMasterService.createOrUpdate(oapMaster);

        String[] userLists = request.getParameterValues("userList");

        try {

            for (int i = 0; i < userLists.length; i++) {
                if (userLists[i] != null && userLists[i] != "") {
                    OapMasterUser oapMasterUser = new OapMasterUser();
                    oapMasterUser.setLevel(i + 1);
                    oapMasterUser.setOapMaster(oapMaster);
                    oapMasterUser.setUserId(userLists[i]);
                    oapMasterUserService.create(oapMasterUser);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mv.getModelMap().put("approvalName", approvalName);
        session.setAttribute("successMessage", "OAP master Edited successfully");

        mv.setViewName("redirect:oapMaster.htm?act=showList");

        return mv;
    }

    // Create Submit
    public ModelAndView OapMasterCreateSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        String approvalName = request.getParameter("approvalName");

        OapMaster oapMaster = new OapMaster();

        oapMaster.setApprovalName(approvalName);

        if (!oapMasterService.isExist(oapMaster)) {
            oapMasterService.create(oapMaster);

            int id = oapMaster.getId();
            OapMaster opMaster = oapMasterService.readById(id);

            String[] userLists = request.getParameterValues("userList");

            try {

                for (int i = 0; i < userLists.length; i++) {
                    OapMasterUser oapMasterUser = new OapMasterUser();
                    oapMasterUser.setLevel(i + 1);
                    oapMasterUser.setOapMaster(opMaster);
                    oapMasterUser.setUserId(userLists[i]);
                    oapMasterUserService.create(oapMasterUser);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("successMessage", "OAP master  Created Successfully");
            mv.setViewName("redirect:oapMaster.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "OAP master  Already Exist. Please Enter OAP master ");
            mv.setViewName("redirect:oapMaster.htm?act=OapMasterCreate");
        }

        return mv;
    }

    public ModelAndView OapMasterDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String value = request.getParameter("delete");
        String[] checkId = request.getParameterValues("checkId");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");

        for (String checkedValues : checkId) {
            List<?> moseData = oapMasterUserService.readByIdToList1(checkedValues);
            ListIterator<OapMasterUser> itr = (ListIterator<OapMasterUser>) moseData.listIterator();
            while (itr.hasNext()) {
                OapMasterUser s = itr.next();
                oapMasterUserService.delete(s.getId());

            }
            oapMasterService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:oapMaster.htm?act=showList");
        return mv;

    }

    // Single delete in list 
    public void deletesingleIds(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();

        try {
            String id = request.getParameter("id");
            oapMasterService.delete(Integer.parseInt(id));
            json.put("success", true);
            json.put("message", "OAP & AOC Approval deleted successfully");
        } catch (DataIntegrityViolationException e) {
            json.put("success", false);
            json.put("message", "OAP & AOC Approval is being used somewhere");
            e.printStackTrace();
        } catch (Exception e) {
            json.put("success", false);
            json.put("message", "Something went wrong while deleting");
            e.printStackTrace();
        }

        response.getWriter().write(json.toString());
        response.getWriter().flush();

    }

    // Multiple Delete in list
    public void deleteOap(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject json = new JSONObject();

        try {
            String ids = request.getParameter("ids");
            String[] idArray = ids.split(",");
            List<String> failedNames = new ArrayList<>();
            int deletedCount = 0;
            for (String id : idArray) {
                OapMaster oapMaster = oapMasterService.readById(Integer.parseInt(id));
                try {
                    oapMasterService.delete(Integer.parseInt(id));
                    deletedCount++;
                } catch (DataIntegrityViolationException e) {
                    failedNames.add(oapMaster.getApprovalName());
                    e.printStackTrace();
                } catch (Exception e) {
                    failedNames.add(oapMaster.getApprovalName());
                    e.printStackTrace();
                }
            }

            if (failedNames.isEmpty()) {
                json.put("success", true);
                json.put("message",
                        "OAP & AOC Approval(s) deleted successfully");
            } else {
                json.put("success", false);
                json.put("message",
                        deletedCount
                        + " deleted. Could not delete: "
                        + String.join(", ", failedNames)
                        + " because they are being used somewhere.");
            }
        } catch (Exception e) {
            json.put("success", false);
            json.put("message", "Something went wrong while deleting");
            e.printStackTrace();
        }

        response.getWriter().write(json.toString());
        response.getWriter().flush();

    }

    // Edit page jsp - Single Delete method
    public ModelAndView deleteusers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String apprId = request.getParameter("apprId");

        try {
            oapMasterUserService.delete(Integer.parseInt(id));
        } catch (Exception e) {

        }

        mv.setViewName("redirect:oapMaster.htm?act=OapMasterEdit&id=" + apprId);
        return mv;

    }

    public ModelAndView oapPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        List list = oapMasterService.getApprovalNamePagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = oapMasterService.getTotalApprovalNameCount();

        int filteredRecords = oapMasterService.getFilteredApprovalNameCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            OapMaster oapMaster = (OapMaster) obj;

            JSONObject json = new JSONObject();

//            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + oapMaster.getId() + "'>");
            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }
            json.put("approvalName", oapMaster.getApprovalName() != null ? oapMaster.getApprovalName() : "");

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='oapMaster.htm?act=OapMasterEdit&id="
                    + oapMaster.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    //                    + "<a href='javascript:void(0);' "
                    //                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    //                    + "data-id='" + oapMaster.getId() + "'>"
                    //                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
                    //                    + "style='width:18px;height:18px;'>"
                    //                    + "</a>"
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
