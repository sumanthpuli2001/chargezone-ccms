/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.nodue;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.util.CallingCounter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dhruv
 */
public class NoDueMasterController extends NoDueMasterAbstract {
    
    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        try {
            String employeeId = request.getParameter("employeeId");
            NoDueMaster noDueMaster = new NoDueMaster();
            int empId = Integer.parseInt(employeeId);
            List<?> getNoDueList = noDueMasterService.getNoDueByEmpId(empId);
            if (!getNoDueList.isEmpty()) {
                noDueMaster = (NoDueMaster) getNoDueList.get(0);
            }
            EmployeeMaster employeeMaster = new EmployeeMaster();
            UserMaster user = (UserMaster) request.getSession().getAttribute("user");
            user.getId();
            employeeMaster.setUserMaster(user);
            List<?> empList = employeeMasterService.readByUserName(employeeMaster);
            setStatus(request);
            
            request.setAttribute("list", empList);
            mv.getModelMap().put("noDueMaster", noDueMaster);
        } catch (Exception e) {
            
        }
        mv.setViewName("NoDues/NoDuesFormCreate");
        return mv;
        
    }
    
    public ModelAndView submitNoDueForm(HttpServletRequest request, HttpServletResponse response, NoDueMaster noDueMaster) throws Exception {
        final Boolean existingNoDueDataToggle = true;
        
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        //this is toggle of isExistingNoDueDataExist setted on dashboard page @ first time login.
//         = new NoDueMaster();
        UserRightMaster userRightMaster = (UserRightMaster) request.getSession().getAttribute("userRight");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        bind(request, noDueMaster);
        BindException errors = new BindException(noDueMaster, "noDueMaster");
//        if(noDueMaster.get)
        int empid = Integer.parseInt(request.getParameter("empId"));
//        employeeMaster.setId(empid);
        employeeMaster = employeeMasterService.readById(empid);
//        employeeMaster1.setId(1);
        noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
//        noDueMaster.setEmployeeMasterByApproverId(employeeMaster1);
        noDueMasterValidator.validate(noDueMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
        } else {
            List<?> getNoDueList = noDueMasterService.getNoDueByEmpId(empid);
            if (!getNoDueList.isEmpty()) {
                NoDueMaster noDueMasterForUpdate = (NoDueMaster) getNoDueList.get(0);
//                int noDueId = noDueMasterForUpdate.getEmployeeMasterByEmpId().getId();
//                NonoDueMasterService.readById(noDueId);
//                noDueMaster.setId(noDueId);
                bind(request, noDueMasterForUpdate);
                
                if (userRightMaster.isEmployeeExit()) {
                    if (null != request.getParameter("conDeptID") && request.getParameter("conDeptID").equals("checked")) {
                        
                    } else {
                        if (null == noDueMasterForUpdate.getEquipments() || noDueMasterForUpdate.getEquipments().equals("")) {
                            
                            noDueMasterForUpdate.setEquipments("");
                            noDueMasterForUpdate.setEquipmentsRemarks("");
                            noDueMasterForUpdate.setSpecialTool("");
                            noDueMasterForUpdate.setSpecialToolRemark("");
                            noDueMasterForUpdate.setComputerFiles("");
                            noDueMasterForUpdate.setComputerFilesRemark("");
                            noDueMasterForUpdate.setAdvanceAmount("");
                            noDueMasterForUpdate.setAdvanceAmountRemark("");
                            noDueMasterForUpdate.setDeptOtherText("");
                            noDueMasterForUpdate.setDeptOther("");
                            noDueMasterForUpdate.setDeptOtherRemark("");
                        }
                        
                    }
                    if (null != request.getParameter("itDept") && request.getParameter("itDept").equals("checked")) {
                        
                    } else {
                        if (null == noDueMasterForUpdate.getCompanyMobile() || noDueMasterForUpdate.getCompanyMobile().equals("")) {
                            
                            noDueMasterForUpdate.setCompanyMobile("");
                            noDueMasterForUpdate.setCompanyMobileRemark("");
                            noDueMasterForUpdate.setComputerChecked("");
                            noDueMasterForUpdate.setComputerCheckedRemark("");
                            noDueMasterForUpdate.setEmail("");
                            noDueMasterForUpdate.setEmailRemark("");
                            noDueMasterForUpdate.setComputerTransfered("");
                            noDueMasterForUpdate.setComputerTransferedRemark("");
                            noDueMasterForUpdate.setItOtherText("");
                            noDueMasterForUpdate.setItOtherRemark("");
                            noDueMasterForUpdate.setItOther("");
                        }
                        
                    }
                    if (null != request.getParameter("fDept") && request.getParameter("fDept").equals("checked")) {
                        
                    } else {
                        if (null == noDueMasterForUpdate.getAdvanceCleared() || noDueMasterForUpdate.getAdvanceCleared().equals("")) {
                            noDueMasterForUpdate.setAdvanceCleared("");
                            noDueMasterForUpdate.setAdvanceClearedRemark("");
                            noDueMasterForUpdate.setPendingBills("");
                            noDueMasterForUpdate.setPendingBillsRemark("");
                            noDueMasterForUpdate.setSalaryAdvanceOrLoan("");
                            noDueMasterForUpdate.setSalaryAdvanceOrLoanRemark("");
                            noDueMasterForUpdate.setFinanceOther("");
                            noDueMasterForUpdate.setFinanceOtherRemark("");
                            noDueMasterForUpdate.setFinanceOtherText("");
                        }
                        
                    }
                    
                }
                noDueMasterService.update(noDueMasterForUpdate);
            } else {
                
                if (userRightMaster.isEmployeeExit()) {
                    if (null != request.getParameter("conDeptID") && request.getParameter("conDeptID").equals("checked")) {
                        
                    } else {
                        noDueMaster.setEquipments("");
                        noDueMaster.setEquipmentsRemarks("");
                        noDueMaster.setSpecialTool("");
                        noDueMaster.setSpecialToolRemark("");
                        noDueMaster.setComputerFiles("");
                        noDueMaster.setComputerFilesRemark("");
                        noDueMaster.setAdvanceAmount("");
                        noDueMaster.setAdvanceAmountRemark("");
                        noDueMaster.setDeptOtherText("");
                        noDueMaster.setDeptOther("");
                        noDueMaster.setDeptOtherRemark("");
                        
                    }
                    if (null != request.getParameter("itDept") && request.getParameter("itDept").equals("checked")) {
                        
                    } else {
                        noDueMaster.setCompanyMobile("");
                        noDueMaster.setCompanyMobileRemark("");
                        noDueMaster.setComputerChecked("");
                        noDueMaster.setComputerCheckedRemark("");
                        noDueMaster.setEmail("");
                        noDueMaster.setEmailRemark("");
                        noDueMaster.setComputerTransfered("");
                        noDueMaster.setComputerTransferedRemark("");
                        noDueMaster.setItOtherText("");
                        noDueMaster.setItOtherRemark("");
                        noDueMaster.setItOther("");
                        
                    }
                    if (null != request.getParameter("fDept") && request.getParameter("fDept").equals("checked")) {
                        
                    } else {
                        noDueMaster.setAdvanceCleared("");
                        noDueMaster.setAdvanceClearedRemark("");
                        noDueMaster.setPendingBills("");
                        noDueMaster.setPendingBillsRemark("");
                        noDueMaster.setSalaryAdvanceOrLoan("");
                        noDueMaster.setSalaryAdvanceOrLoanRemark("");
                        noDueMaster.setFinanceOther("");
                        noDueMaster.setFinanceOtherRemark("");
                        noDueMaster.setFinanceOtherText("");
                        
                    }
                    
                }
                noDueMasterService.create(noDueMaster);
                
            }
            session.setAttribute("isExistingNoDueDataExist", existingNoDueDataToggle);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.getModelMap().put("noDueMaster", noDueMaster);
            mv.setViewName("forward:userMaster.htm?act=goToDashboard");//method name changed from userDashboard.
            //    Email Sent to NoDueRightsHR
            List<?> NoDueHRList = userRightMasterService.readNoDueRightsList();
            for (Object o : NoDueHRList) {
                Object[] o1 = (Object[]) o;
                int AdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(AdminId);
//                    String EmpStr = request.getParameter("empid");

                    List list = employeeMasterService.readByEmployeeNo(empid);
                    if (!list.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list.get(0);
                    }
                    // id 90 is for status No Due Apply (Email to HR)
                    emailTemplate = emailTemplateService.readById(90);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{emp_name\\}", employeeMaster.getEmployeeName());
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {
                    
                }
            }
        }
        return mv;
    }

    // emp result
    public ModelAndView EmpResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
        List<?> list = employeeMasterService.getEmployeeDetatilByEmp_Id(employeeMaster.getId());
//        List<?> list = noDueMasterService.readforemp(noDueMaster);
        request.setAttribute("list", list);
        mv.getModelMap().put("noDueMaster", noDueMaster);
        mv.setViewName("NoDues/EmpResult");
        return mv;
    }
    
    public ModelAndView createNoDueApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        int tabId = Integer.parseInt(request.getParameter("id"));
        int empId = Integer.parseInt(request.getParameter("empID"));
        employeeMaster = employeeMasterService.readById(empId);
        noDueMaster = noDueMasterService.readById(tabId);
        setStatus(request);
        
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("noDueMaster", noDueMaster);
        request.setAttribute("id", tabId);
        request.setAttribute("empId", empId);
        mv.setViewName("NoDues/NoDuesFormApprovalCreate");
        return mv;
    }
    
    public ModelAndView createNoDueReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        NoDueMaster noDueMasterModel = new NoDueMaster();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        int tabId = Integer.parseInt(request.getParameter("id"));
//        int empId = Integer.parseInt(request.getParameter("empID"));
//        employeeMaster = employeeMasterService.readById(empId);
//        noDueMasterModel = noDueMasterService.readById(tabId);
//        setStatus(request);
//
//        request.setAttribute("employeeMaster", employeeMaster);
//        mv.getModelMap().put("noDueMaster", noDueMasterModel);
//        mv.setViewName("NoDues/createNoDueReturn");
//        return mv;
        ModelAndView mv = new ModelAndView();
        String employeeNoString = request.getParameter("employeeNo");
        String employeeId = request.getParameter("employeeId");
//        String reportingManager = request.getParameter("reportingManager");
        NoDueMaster noDueMaster = new NoDueMaster();
        NoDueMaster noDueMasterByEmployeeId = null;
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        user.getId();
//        employeeMaster.setUserMaster(user);try
        try {
            int employeeNo = Integer.parseInt(employeeNoString);
            List<?> noDueByEmployeeIdList = noDueMasterService.getNoDueByEmpId(Integer.parseInt(employeeId));
            List<?> empList = employeeMasterService.readByEmployeeNo(employeeNo);
            request.setAttribute("list", empList);
            if (!noDueByEmployeeIdList.isEmpty()) {
                request.setAttribute("noDueByEmployeeIdList", noDueByEmployeeIdList.get(0));
                noDueMasterByEmployeeId = (NoDueMaster) noDueByEmployeeIdList.get(0);
            }
        } catch (NumberFormatException nfe) {
        }
        setStatus(request);
        if (noDueMasterByEmployeeId != null) {
            mv.getModelMap().put("noDueMaster", noDueMasterByEmployeeId);
        } else {
            mv.getModelMap().put("noDueMaster", noDueMaster);
        }
//        request.setAttribute("reportingManager", reportingManager);
        mv.setViewName("NoDues/createNoDueReturn");
        return mv;
        
    }
    
    public ModelAndView submitNoDueReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        NoDueMaster noDueMaster1 = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        bind(request, noDueMaster);
        int empid = Integer.parseInt(request.getParameter("empId"));
        int tabid = Integer.parseInt(request.getParameter("id"));
        noDueMaster.setId(tabid);
        employeeMaster.setId(empid);
        noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
        if (null == noDueMaster.getEmployeeMasterByApproverId()) {
            noDueMaster1 = noDueMasterService.readById(tabid);
            employeeMaster1 = noDueMaster1.getEmployeeMasterByApproverId();
            noDueMaster.setEmployeeMasterByApproverId(employeeMaster1);
        }
        String btn = (String) request.getParameter("btnType");
        if (btn.equals("Submit")) {
            noDueMaster.setStatus(3);
            noDueMasterService.update(noDueMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Submitted Successfully.");
            //    Email Sent to NoDueRightsHR
            List<?> NoDueHRList = userRightMasterService.readNoDueRightsList();
            for (Object o : NoDueHRList) {
                Object[] o1 = (Object[]) o;
                int AdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(AdminId);
                    // id 93 is for status No Due Rework Submitted (Email to HR)
                    emailTemplate = emailTemplateService.readById(93);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {
                    
                }
            }
        }
        if (btn.equals("Withdraw")) {
            noDueMaster.setStatus(4);
        }
        if (btn.equals("WithdrawSubmit")) {
            noDueMaster.setStatus(7);
        }
        mv.setViewName("forward:userMaster.htm?act=goToDashboard");//method name changed from userDashboard.
        return mv;
    }
    
    public ModelAndView submitNoDueApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        bind(request, noDueMaster);
        int empid = Integer.parseInt(request.getParameter("empId"));
        int tabid = Integer.parseInt(request.getParameter("id"));
        noDueMaster.setId(tabid);
        employeeMaster.setId(empid);
        noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
        
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        user.getId();
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster1 = (EmployeeMaster) empList.get(0);
            employeeMaster1.getId();
        }
        noDueMaster.setEmployeeMasterByApproverId(employeeMaster1);
        String btn = (String) request.getParameter("btnType");
        if (btn.equals("Approve")) {
            noDueMaster.setStatus(2);
            noDueMasterService.update(noDueMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Approved Successfully.");
            mv = createNoDueApproveList(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = noDueMasterService.readEmpIdFromTabId(tabid);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 91 is for status No Due Approve(Email to Employee)
                emailTemplate = emailTemplateService.readById(91);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
                
                String name = "No Due";
                EmailAddMaster emailAddMaster = new EmailAddMaster();
                emailAddMaster.setModuleName(name);
                emailAddMaster.setDepartmentMaster(employeeRequestee.getDepartmentMaster());
                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                if (!emailSendList.isEmpty()) {
                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
                    String emailId = emailAddMaster1.getEmailId();
                    for (String emailId1 : emailId.split(",")) {
                        if (!emailId1.equals("")) {
                            String To1 = emailId1;
                            String from1 = employeeMasterModel.getOfficeEmailId();
                            String subject1 = emailTemplate.getSubject();
                            subject1 = subject1.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg1 = emailTemplate.getBodytext();
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from1, To1, subject1, msg1);

                        }
                    }
                }
                
            } catch (Exception e) {
                
            }
        }
        if (btn.equals("Return")) {
            noDueMaster.setStatus(1);
            noDueMasterService.update(noDueMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Return Successfully.");
            mv = createNoDueApproveList(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = noDueMasterService.readEmpIdFromTabId(tabid);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 92 is for status No Due Rejected(Email to Employee)
                emailTemplate = emailTemplateService.readById(92);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {
                
            }
        }
        if (btn.equals("WithdrawApprove")) {
            noDueMaster.setStatus(6);
            noDueMasterService.update(noDueMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Submitted Successfully.");
            mv = createNoDueApproveList(request, response);
        }
        if (btn.equals("WithdrawReturn")) {
            noDueMaster.setStatus(5);
            noDueMasterService.update(noDueMaster);
            request.setAttribute("successMessage",
                    "Information : The Information is Submitted Successfully.");
            mv = createNoDueApproveList(request, response);
        }
        return mv;
    }
    
    public ModelAndView createNoDueApproveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List<?> list = noDueMasterService.read();
        for (Object o : list) {
            noDueMaster = (NoDueMaster) o;
            employeeMaster = employeeMasterService.readById(noDueMaster.getEmployeeMasterByEmpId().getId());
            noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
        }
        Collections.reverse(list);
        request.setAttribute("list", list);
        mv.setViewName("NoDues/NoDuesFormApprovalList");
        return mv;
    }
    
    public ModelAndView createEmployeeWiseSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("NoDues/EmployeeWiseExitSearch");
        return mv;
    }
    
    public ModelAndView submitEmployeeWiseSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        ResignationMaster resignationMaster = new ResignationMaster();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, employeeMaster);
        int empId = Integer.parseInt(employeeMaster.getEmployeeName());
        List<?> list = employeeMasterService.readEmployeeAjax(empId);
        
        List<?> resgList = resignationMasterService.readApprovedList(empId);
        List<?> exitList = exitInterviewMasterService.readApprovedList(empId);
        List<?> noDueList = noDueMasterService.readApprovedList(empId);
        
        request.setAttribute("list", list);
        request.setAttribute("resgList", resgList);
        request.setAttribute("exitList", exitList);
        request.setAttribute("noDueList", noDueList);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("NoDues/EmployeeWiseExitResult");
        return mv;
    }
    
    public ModelAndView searchresult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        noDueMaster.setEmployeeMasterByEmpId(employeeMaster);
        if (!departmentId.equals("")) {
            noDueMaster.setAdvanceAmount(departmentId);
        }
        if (!designationId.equals("")) {
            noDueMaster.setAdvanceAmountRemark(designationId);
        }
        List<?> list = noDueMasterService.readSearchRequest(noDueMaster);
        mv.getModelMap().put("list", list);
        mv.setViewName("NoDues/EmployeeWiseExitSearchResult");
        return mv;
    }
    
    public ModelAndView getNoDueRequests(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        HttpSession session = request.getSession();
        List<?> resignedEmployeesList = resignationMasterService.getFinallyResignedEmployees();
        List<List<?>> employeeList = new ArrayList<List<?>>();
        if (!resignedEmployeesList.isEmpty()) {
            for (Object o : resignedEmployeesList) {
                ResignationMaster rm = (ResignationMaster) o;
                int empId = rm.getEmployeeMaster().getId();
                employeeList.add(employeeMasterService.getEmployeeDetatilByEmp_Id(empId));
            }
        }
        mv.addObject("employeesListOfList", employeeList);
        session.setAttribute("employeeList", employeeList);
        mv.setViewName("NoDues/NoDuesRequestsListView");

//        resignedEmployeesList.stream().filter(resignationMaster.);
        return mv;
    }
    
    public ModelAndView viewNoDueRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String employeeNoString = request.getParameter("employeeNo");
        String employeeId = request.getParameter("employeeId");
        String reportingManager = request.getParameter("reportingManager");
        NoDueMaster noDueMaster = new NoDueMaster();
        NoDueMaster noDueMasterByEmployeeId = null;
        EmployeeMaster employeeMaster = new EmployeeMaster();
//        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
//        user.getId();
//        employeeMaster.setUserMaster(user);try
        try {
            int employeeNo = Integer.parseInt(employeeNoString);
            List<?> noDueByEmployeeIdList = noDueMasterService.getNoDueByEmpId(Integer.parseInt(employeeId));
            List<?> empList = employeeMasterService.readByEmployeeNo(employeeNo);
            request.setAttribute("list", empList);
            if (!noDueByEmployeeIdList.isEmpty()) {
                request.setAttribute("noDueByEmployeeIdList", noDueByEmployeeIdList.get(0));
                noDueMasterByEmployeeId = (NoDueMaster) noDueByEmployeeIdList.get(0);
            }
        } catch (NumberFormatException nfe) {
        }
        setStatus(request);
        if (noDueMasterByEmployeeId != null) {
            mv.getModelMap().put("noDueMaster", noDueMasterByEmployeeId);
        } else {
            mv.getModelMap().put("noDueMaster", noDueMaster);
        }
        request.setAttribute("reportingManager", reportingManager);
        mv.setViewName("NoDues/NoDuesFormCreate");
        return mv;
        
    }
    
    public ModelAndView userDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        this is method which shows  pending requests for noDue Form FillUp on user Dashbord
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        EmployeeMaster employeeInfo = (EmployeeMaster) session.getAttribute("employeeInfo");
        UserRightMaster userRight = (UserRightMaster) session.getAttribute("userRight");
        String employeeId = "" + employeeInfo.getId();
        List<?> resignedEmployeesList1 = resignationMasterService.getFinallyResignedEmployeesForDashBoard(employeeId, userRight.isEmployeeExit(), userRight.isItAdmin(), userRight.isTravelExpenseAdmin());
        
        request.setAttribute("pendingNoDuerequests", resignedEmployeesList1.get(0));
       
        mv.setViewName("forward:exitInterviewMaster.htm?act=userDashboard");
        return mv;
        
    }
    
    public ModelAndView printClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        int tabId = Integer.parseInt(request.getParameter("id"));
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster = employeeMasterService.readById(empId);
        noDueMaster = noDueMasterService.readById(tabId);
        setStatus(request);
        
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("noDueMaster", noDueMaster);
        mv.setViewName("NoDues/NoDuePrint");
        return mv;
    }
    
    public ModelAndView exportToExcelResignation(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> employeeList = (List<?>) request.getSession().getAttribute("employeeList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ExpenseRequestData.xls");
        request.setAttribute("employeesListOfList", employeeList);
        mv.setViewName("NoDues/NoDuesRequestsListViewExport");
        return mv;
    }
}
