/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Approval;

import com.bul.zydex.model.ApprovalMaster;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LeaveEmployeeDetail;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vikas
 */
public class ApprovalController extends ApprovalAbstract {

    public ModelAndView createApprovalSetting(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApprovalMaster approvalMaster = new ApprovalMaster();
        ApprovalUser approvalUser = new ApprovalUser();
        bind(request, approvalUser);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
//          EmployeeMaster employeeMaster= new EmployeeMaster();
        selectedEmployeeFor360Feedback(request, employeeMaster);
//        selectEmployeeForParticularManager(request, response);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("approvalMaster", approvalMaster);
        mv.getModelMap().put("approvalUser", approvalUser);
        mv.setViewName("Approval/CreateApproval");
        return mv;
    }

    public ModelAndView approvalSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApprovalMaster approvalMaster = new ApprovalMaster();
        LeaveEmployeeDetail leaveEmployeeDetail = new LeaveEmployeeDetail();
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        BindException errors = new BindException(approvalMaster, "approvalMaster");
        bind(request, approvalMaster);

//        ApprovalMaster approvalMaster1  = (ApprovalMaster) request.getSession().getAttribute("approvalinfo");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
//        approvalMaster.setCreatedBy(approvalMaster1);
        approvalMaster.setCreatedDate(sdf.format(cDate));
        approvalMaster.setStatus(0);
        approvalMasterService.create(approvalMaster);

        mv = createApprovalSetting(request, response);
        return mv;
    }

    public ModelAndView submitApproval(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ApprovalMaster approvalMaster = new ApprovalMaster();
        ApprovalUser approvalUser = new ApprovalUser();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        BindException errors = new BindException(approvalMaster, "approvalMaster");
        bind(request, approvalMaster);
        int otherDetailCount = 0;
        String apName = request.getParameter("name");
        approvalMaster.setName(apName);
        ApprovalMaster am = approvalMasterService.readByapprovalname(apName);
//        if (apName == am.getName()) {
            String id = request.getParameter("id");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            approvalMaster.setCreatedBy(employeeMaster1.getId());
            approvalMaster.setCreatedDate(sdf.format(cDate));
            approvalMaster.setStatus(0);
            approvalMasterService.create(approvalMaster);

            otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
            for (int i = 0; i <= otherDetailCount; i++) {
                if (null != request.getParameter("policyId" + i) && null != request.getParameter("policyNumber" + i)) {
                    if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("policyNumber" + i).equals("")) {
                        int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                        employeeMaster = employeeMasterService.readById(policyId);
//                    employeeMaster.setId(policyId);
                        approvalUser.setEmployeeMaster(employeeMaster);
                        approvalUser.setApprovalMaster(approvalMaster);
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        Date cDate1 = new Date();
                        approvalUser.setCreatedDate(sdf1.format(cDate1));
                        approvalUser.setCreatedBy(employeeMaster1.getId());
                        String policyNumber = request.getParameter("policyNumber" + i);
                        approvalUser.setLevel(Integer.parseInt(policyNumber));
                        approvalUser.setStatus(0);
                        approvalUserService.create(approvalUser);
//                        policyMaster.setId(policyId);

                    }
                }
            }

            mv = approvalList(request, response);

            return mv;
//        }
//        request.setAttribute("failureMessage",
//                "Info :  This Module Already Asign Approval Level.");
//        mv = createApprovalSetting(request, response);
//        return mv;
    }

    public ModelAndView approvalList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApprovalMaster approvalMaster = new ApprovalMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        List<?> approvalMasterList = approvalUserService.readapprovalempId();
        mv.getModelMap().put("list", approvalMasterList);
        mv.getModelMap().put("approvalMaster", approvalMaster);
        mv.setViewName("Approval/ApprovalList");
        return mv;
    }

    public ModelAndView viewApprovalDetail(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        ApprovalMaster approvalMaster = new ApprovalMaster();
        ApprovalMaster approvalMaster2 = new ApprovalMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        int emid = 0;
        List<?> approvalUser1 = approvalUserService.reademyId(Integer.parseInt(id));
        ApprovalUser au = (ApprovalUser) approvalUser1.get(0);
//        List<?> approvalUserList = approvalUserService.readByApprovalId(Integer.parseInt(id));
        List<?> approvalUserList = approvalUserService.readByApprovalFetch(Integer.parseInt(id));
        List employeeMasterList = new ArrayList();
        for (int i = 0; i < approvalUser1.size(); i++) {
            ApprovalUser au1 = (ApprovalUser) approvalUser1.get(i);
            employeeMasterList.add(au1.getEmployeeMaster());
            emid = au1.getEmployeeMaster().getId();
        }

//        approvalMaster = approvalMasterService.readById(approvalUser.getApprovalMaster().getId());
        approvalMaster = approvalMasterService.readById(Integer.parseInt(id));
        List<?> approvalUser = approvalUserService.readByApId(Integer.parseInt(id));

        employeeMaster = employeeMasterService.readById(emid);
        selectedEmployeeFor360Feedback1(request, employeeMasterList);
        selectEmployee(request, response);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("approvalUser", approvalUser);
        mv.getModelMap().put("au", au);
        mv.getModelMap().put("approvalMaster", approvalMaster);
        mv.setViewName("Approval/ViewApprovalDetail");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        int otherDetailCount = 0;
        EmployeeMaster employeeMaster1 = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        ApprovalMaster approvalMaster = new ApprovalMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        ApprovalUser approvalUser = new ApprovalUser();
        String approvalMasterId = request.getParameter("id");
        BindException errors = new BindException(approvalMaster, "approvalMaster");
        bind(request, approvalMaster);
        String policyId1 = request.getParameter("policyId1");
        String[] policyIdList = policyId1.split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        ApprovalMaster approvalMaster1 = approvalMasterService.approvalId(approvalMaster.getId());
        approvalMaster.setUpdatedDate(sdf.format(cDate));
        approvalMasterService.update(approvalMaster);

        ///deleted the previous Approval user
        List<?> approvalUserDetail = approvalUserService.readApprovalUser(approvalMasterId);
        for (Object userobject : approvalUserDetail) {
            Object[] approval = (Object[]) userobject;
            Integer approvalUserId = (Integer) approval[0];
            approvalUserService.delete(approvalUserId);
        }

        /////code for multiple Employee
        otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 0; i < policyIdList.length; i++) {
//            if (null != request.getParameter("policyId" + i) && null != request.getParameter("policyNumber" + i)) {
//                if (!request.getParameter("policyId" + i).equals("") && !request.getParameter("policyNumber" + i).equals("")) {
//                    int policyId = Integer.parseInt(request.getParameter("policyId" + i));
            employeeMaster = employeeMasterService.readById(Integer.parseInt("" + policyIdList[i]));
//                    employeeMaster.setId(policyId);
            approvalUser.setEmployeeMaster(employeeMaster);
            approvalUser.setApprovalMaster(approvalMaster);
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate1 = new Date();
            approvalUser.setCreatedDate(sdf1.format(cDate1));
            approvalUser.setCreatedBy(employeeMaster1.getId());
            String policyNumber = request.getParameter("policyNumber" + i);
            approvalUser.setLevel(i + 1);
            approvalUser.setStatus(0);
            approvalUserService.create(approvalUser);
//                        policyMaster.setId(policyId);
//
//                }
//            }
        }

        mv = approvalList(request, response);
        return mv;

    }

    public ModelAndView deleteApprovalSetting(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        String[] empId = request.getParameterValues("checkId");
        for (String z : empId) {
            try {

                ApprovalUser approvalUser = new ApprovalUser();
                List<?> list = approvalUserService.approvaldelete(z);
                for (Object object : list) {
                    approvalUser = (ApprovalUser) object;
                    approvalUserService.delete(approvalUser.getId());
                }

                approvalMasterService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info :  Records Deleted Successfully.");
            } catch (Exception e) {

            }
        }
        mv = approvalList(request, response);
        return mv;
    }
}
