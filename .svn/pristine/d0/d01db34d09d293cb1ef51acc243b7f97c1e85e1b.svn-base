/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LeaveEncashment;
import com.bul.zydex.model.LeaveTypeMaster;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class LeaveEncashmentController extends LeaveEncashmentAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        readleaveType(request);
        leaveEncashment.setLeaveTypeMaster(new LeaveTypeMaster());
        mv.getModelMap().put("leaveEncashment", leaveEncashment);
        mv.setViewName("Leave/LeaveEncashmentCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        BindException errors = new BindException(leaveEncashment, "leaveEncashment");
        bind(request, leaveEncashment);
        leaveEncashmentValidator.validate(leaveEncashment, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            readleaveType(request);
//            leaveEncashment.setLeaveTypeMaster(new LeaveTypeMaster());
            mv.getModelMap().put("leaveEncashment", leaveEncashment);
            mv.setViewName("Leave/LeaveEncashmentCreate");

        } else {
            EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date cDate = new Date();
            leaveEncashment.setEmployeeMasterByCreatorEmpId(employeeMaster);
            leaveEncashment.setCreatedDate(sdf.format(cDate));
            leaveEncashment.setStatus(0);
            List empNLeaveList = leaveEncashmentService.readByEmpNLeaveId(leaveEncashment);
            if (empNLeaveList.isEmpty()) {

                if (Float.parseFloat(leaveEncashment.getTotalLeave()) >= Float.parseFloat(leaveEncashment.getNoOfLeaveEncashment())) {
                    leaveEncashment.setStatus(0);
                    leaveEncashmentService.create(leaveEncashment);
                    request.setAttribute("successMessage",
                            "Information : The Information Is Saved Successfully.");
                    mv = searchSubmit(request, response);

                } else {
                    request.setAttribute("failureMessage",
                            "Error : The Entered No. Of Leave Encashment Is Under Or Equal Total Leave.");
                    readleaveType(request);
//                    leaveEncashment.setLeaveTypeMaster(new LeaveTypeMaster());
                    mv.getModelMap().put("leaveEncashment", leaveEncashment);
                    mv.setViewName("Leave/LeaveEncashmentCreate");
                }
            } else {
                request.setAttribute("failureMessage",
                        "Error : This Leave Type Is Already In Pending.");
                readleaveType(request);
//                leaveEncashment.setLeaveTypeMaster(new LeaveTypeMaster());
                mv.getModelMap().put("leaveEncashment", leaveEncashment);
                mv.setViewName("Leave/LeaveEncashmentCreate");

            }

        }
        return mv;
    }

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEncashment.setEmployeeMasterByCreatorEmpId(employeeMaster);
        List<?> list = leaveEncashmentService.readByEmpId(leaveEncashment);

        mv.getModelMap().put("list", list);
        mv.getModelMap().put("leaveEncashment", leaveEncashment);
        mv.setViewName("Leave/LeaveEncashmentResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        String id = request.getParameter("id");
        leaveEncashment = leaveEncashmentService.readById(Integer.parseInt(id));
        leaveTypeMaster = leaveTypeMasterService.readById(leaveEncashment.getLeaveTypeMaster().getId());
        leaveEncashment.setLeaveTypeMaster(leaveTypeMaster);
        mv.getModelMap().put("leaveEncashment", leaveEncashment);
        mv.setViewName("Leave/LeaveEncashmentEdit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        BindException errors = new BindException(leaveEncashment, "leaveEncashment");
        bind(request, leaveEncashment);
        leaveEncashmentValidator.validate(leaveEncashment, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("leaveEncashment", leaveEncashment);
            mv.setViewName("Leave/LeaveEncashmentEdit");

        } else {

            if (Float.parseFloat(leaveEncashment.getTotalLeave()) >= Float.parseFloat(leaveEncashment.getNoOfLeaveEncashment())) {
                EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date cDate = new Date();
                leaveEncashment.setEmployeeMasterByCreatorEmpId(employeeMaster);
                leaveEncashment.setCreatedDate(sdf.format(cDate));
                leaveEncashment.setStatus(0);
                leaveEncashmentService.update(leaveEncashment);
                request.setAttribute("successMessage",
                        "Information : The Information is Updated Successfully.");
                mv = searchSubmit(request, response);
            } else {
                request.setAttribute("failureMessage",
                        "Error : The Entered No. Of Leave Encashment Is Under Or Equal Total Leave.");
                leaveTypeMaster = leaveTypeMasterService.readById(leaveEncashment.getLeaveTypeMaster().getId());
                leaveEncashment.setLeaveTypeMaster(leaveTypeMaster);//                    leaveEncashment.setLeaveTypeMaster(new LeaveTypeMaster());
                mv.getModelMap().put("leaveEncashment", leaveEncashment);
                mv.setViewName("Leave/LeaveEncashmentEdit");
            }

        }

        return mv;
    }

    public ModelAndView deleteSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String currencyId[] = request.getParameterValues("checkId");
        for (String z : currencyId) {
            try {
                leaveEncashmentService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = searchSubmit(request, response);
        return mv;
    }

    public void readNoLeaveAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        String leaveStr = request.getParameter("leaveId");
        PrintWriter out = response.getWriter();
        if (null != leaveStr && !leaveStr.equals("")) {
            employeeLeaveBalance.setEmployeeMaster(employeeMaster);
            LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
            leaveTypeMaster.setId(Integer.parseInt(leaveStr));
            employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
            List list = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
            try {
                employeeLeaveBalance = (EmployeeLeaveBalance) list.get(0);
                out.print(employeeLeaveBalance.getNoOfLeaveRemain());
            } catch (Exception e) {

            }

        }

    }

    public ModelAndView approveNRejectResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        leaveEncashment.setStatus(0);
        List<?> list = leaveEncashmentService.readStatusByHr(leaveEncashment);

        mv.getModelMap().put("list", list);
        mv.setViewName("Leave/LeaveEncashmentHrResult");
        return mv;
    }

    public ModelAndView approveNRejectClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        leaveEncashment = leaveEncashmentService.readById(Integer.parseInt(id));
        leaveTypeMaster = leaveTypeMasterService.readById(leaveEncashment.getLeaveTypeMaster().getId());
        employeeMaster = employeeMasterService.readById(leaveEncashment.getEmployeeMasterByCreatorEmpId().getId());
        leaveEncashment.setLeaveTypeMaster(leaveTypeMaster);
        leaveEncashment.setEmployeeMasterByCreatorEmpId(employeeMaster);
        mv.getModelMap().put("leaveEncashment", leaveEncashment);
        mv.setViewName("Leave/LeaveEncashmentHrView");
        return mv;
    }

    public ModelAndView approveNRejectSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        LeaveEncashment leaveEncashment = new LeaveEncashment();
        String id = request.getParameter("id");
        String btnSubmit = request.getParameter("btnSubmit");
        leaveEncashment = leaveEncashmentService.readById(Integer.parseInt(id));
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        leaveEncashment.setEmployeeMasterByApproverEmpId(employeeMaster);
        Date cDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        leaveEncashment.setApprovedDate(sdf.format(cDate));
//        leaveEncashment.set

        if (btnSubmit.equals("approve")) {
            leaveEncashment.setStatus(1);
            EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
            employeeLeaveBalance.setEmployeeMaster(leaveEncashment.getEmployeeMasterByCreatorEmpId());
            employeeLeaveBalance.setLeaveTypeMaster(leaveEncashment.getLeaveTypeMaster());
            try {
                List list = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                employeeLeaveBalance = (EmployeeLeaveBalance) list.get(0);
                employeeLeaveBalance.setNoOfLeaveRemain(Float.parseFloat(leaveEncashment.getTotalLeave()) - Float.parseFloat(leaveEncashment.getNoOfLeaveEncashment()));
                employeeLeaveBalanceService.update(employeeLeaveBalance);
            } catch (Exception e) {
            }
            leaveEncashmentService.update(leaveEncashment);

        } else if (btnSubmit.equals("rework")) {
            String hrRemark = request.getParameter("hrRemark");
            leaveEncashment.setHrRemark(hrRemark);
            leaveEncashment.setStatus(2);
            leaveEncashmentService.update(leaveEncashment);
        } else if (btnSubmit.equals("reject")) {
            String hrRemark = request.getParameter("hrRemark");
            leaveEncashment.setHrRemark(hrRemark);
            leaveEncashment.setStatus(3);
            leaveEncashmentService.update(leaveEncashment);

        }
        mv.getModelMap().put("leaveEncashment", leaveEncashment);
        mv = approveNRejectResult(request, response);
        return mv;
    }

}
