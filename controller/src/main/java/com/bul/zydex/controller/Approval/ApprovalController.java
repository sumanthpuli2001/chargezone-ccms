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
        
        mv = createApprovalSetting(request, response);
        
        return mv;
        
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
}
