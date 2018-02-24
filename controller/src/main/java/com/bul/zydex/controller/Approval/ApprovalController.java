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

}
