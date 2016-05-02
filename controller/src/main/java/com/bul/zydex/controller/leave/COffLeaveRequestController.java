/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.model.COffLeaveRequest;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LeaveTypeMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval Patel
 */
public class COffLeaveRequestController extends COffLeaveRequestAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List<?> list = cOffLeaveRequestService.userWiseCoffList(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
        mv.setViewName("Leave/COffResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int reportingId = 0;
        user.getId();
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }

        mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
        mv.setViewName("Leave/CoffLeaveCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int reportingId = 0;
        user.getId();
        employeeMaster.setUserMaster(user);
        BindException errors = new BindException(cOffLeaveRequest, "cOffLeaveRequest");
        bind(request, cOffLeaveRequest);
        cOffLeaveRequestValidator.validate(cOffLeaveRequest, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
            if (!empDetailList.isEmpty()) {
                request.setAttribute("employeeMaster", empDetailList.get(0));
                Object[] arrayOfObject = (Object[]) empDetailList.get(0);
                String reportmanager = (String) arrayOfObject[6];
                if (!reportmanager.equals("")) {
                    reportingId = Integer.parseInt(reportmanager);
                }

                employeeMaster1.setId(reportingId);
            }
            List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
            if (!reportmanager1.isEmpty()) {
                employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
                request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
            }
            request.setAttribute("employeeMaster", empDetailList.get(0));
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());

            mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
            mv.setViewName("Leave/CoffLeaveCreate");

        } else {
            cOffLeaveRequest.setUserMaster(user);
            cOffLeaveRequest.setStatus(0);
            cOffLeaveRequestService.createOrUpdate(cOffLeaveRequest);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.setViewName("redirect:cOffLeaveRequest.htm?act=searchSubmit");
        }

        return mv;
    }

    public ModelAndView coffApproveRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        List<?> list = cOffLeaveRequestService.approverWiseCoffList(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
        mv.setViewName("Leave/COffApproveList");
        return mv;
    }

    public ModelAndView approveClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String id = request.getParameter("id");
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        UserRightMaster user1 = (UserRightMaster) request.getSession().getAttribute("userRight");
        int reportingId = 0;
        user.getId();
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
            if (!reportmanager.equals("")) {
                reportingId = Integer.parseInt(reportmanager);
            }

            employeeMaster1.setId(reportingId);
        }
        List<?> reportmanager1 = employeeMasterService.readByReportManager(employeeMaster1);
        if (!reportmanager1.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) reportmanager1.get(0);
            request.setAttribute("reportingManager", employeeMaster1.getEmployeeName());
        }
        String requestId = request.getParameter("id");
        cOffLeaveRequest = cOffLeaveRequestService.readById(Integer.parseInt(requestId));
        String overTimeDate = cOffLeaveRequest.getDateOf();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        int userId = cOffLeaveRequest.getUserMaster().getId();
        List<?> list = overTimeMasterService.overTimeComparision(userId, overTimeDate);
        if (!list.isEmpty()) {
            request.setAttribute("overTime", list.get(0));
        }
        mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
        mv.setViewName("Leave/CoffLeaveApprove");
        return mv;
    }

    public ModelAndView appproveSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        bind(request, cOffLeaveRequest);
        cOffLeaveRequest.setStatus(1);
        String fullOrHalf = request.getParameter("FullOrHalfId");
        LeaveTypeMaster leaveTypeMaster = new LeaveTypeMaster();
        String type = "C Off Leave";
        if (null != fullOrHalf || fullOrHalf != "") {
            List<?> coffLeave = leaveTypeMasterService.readLeaveType(type);
            if (!coffLeave.isEmpty()) {
                leaveTypeMaster = (LeaveTypeMaster) coffLeave.get(0);
                int userId = cOffLeaveRequest.getUserMaster().getId();
                UserMaster userMaster = new UserMaster();
                userMaster.setId(userId);
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster.setUserMaster(userMaster);
                List<?> empIdList = employeeMasterService.readByEmployeeUserId(employeeMaster);
                employeeMaster = (EmployeeMaster) empIdList.get(0);
                EmployeeLeaveBalance employeeLeaveBalance = new EmployeeLeaveBalance();
                EmployeeLeaveBalance employeeLeaveBalance1 = new EmployeeLeaveBalance();
                employeeLeaveBalance.setLeaveTypeMaster(leaveTypeMaster);
                employeeLeaveBalance.setEmployeeMaster(employeeMaster);
                List<?> empLeaveBalance = employeeLeaveBalanceService.readleaveWiseBalance(employeeLeaveBalance);
                employeeLeaveBalance1 = (EmployeeLeaveBalance) empLeaveBalance.get(0);
                if (fullOrHalf.equals("Fullday")) {
                    Float noLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                    noLeave = noLeave + 1;
                    employeeLeaveBalance1.setNoOfLeaveRemain(noLeave);
                } else {
                    Float noLeave = employeeLeaveBalance1.getNoOfLeaveRemain();
                    double d = 0.5;
                    double c = noLeave + d;
                    String leave = "" + c;
                    employeeLeaveBalance1.setNoOfLeaveRemain(Float.parseFloat(leave));
                }
                employeeLeaveBalanceService.update(employeeLeaveBalance1);
            }
        }

        cOffLeaveRequestService.createOrUpdate(cOffLeaveRequest);
        request.setAttribute("successMessage",
                "Information : The Information is saved Successfully.");
        mv.setViewName("redirect:cOffLeaveRequest.htm?act=coffApproveRequest");

        return mv;
    }

    public ModelAndView rejectSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        COffLeaveRequest cOffLeaveRequest1 = new COffLeaveRequest();
        bind(request, cOffLeaveRequest);
        int id = cOffLeaveRequest.getId();
        cOffLeaveRequest1 = cOffLeaveRequestService.readById(id);
        cOffLeaveRequest1.setStatus(2);

        cOffLeaveRequestService.createOrUpdate(cOffLeaveRequest1);
        request.setAttribute("successMessage",
                "Information : The Information is saved Successfully.");
        mv.setViewName("redirect:cOffLeaveRequest.htm?act=coffApproveRequest");

        return mv;
    }

    public ModelAndView userDashboardcOffPendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        List<?> list = cOffLeaveRequestService.userPendingRequest(id);
        request.setAttribute("coffPending", list.size());

        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id1 = employeeMaster.getId();
        List<?> list1 = cOffLeaveRequestService.approverWiseCoffPendingList(id1);
        request.setAttribute("coffApproverPending", list1.size());
//        mv.setViewName("forward:userMaster.htm?act=userDashboardShow");
        mv.setViewName("forward:noDueMaster.htm?act=userDashboard");
        return mv;
    }

    public ModelAndView searchPendingSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        List<?> list = cOffLeaveRequestService.userPendingRequest(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
        mv.setViewName("Leave/COffResult");
        return mv;
    }

    public ModelAndView coffApproveWisePendingRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        COffLeaveRequest cOffLeaveRequest = new COffLeaveRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        List<?> list = cOffLeaveRequestService.approverWiseCoffPendingList(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("cOffLeaveRequest", cOffLeaveRequest);
        mv.setViewName("Leave/COffApproveList");
        return mv;
    }

}
