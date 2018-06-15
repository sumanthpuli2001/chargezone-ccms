/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.resignation;

import com.bul.zydex.model.ApprovalMaster;
import com.bul.zydex.model.ApprovalUser;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeCtcDetailSalary;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.FormateFullNdFinalLetter;
import com.bul.zydex.model.FullAndFinalSettlement;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserMaster;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
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
public class ResignationMasterController extends ResignationMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        user.getId();
        employeeMaster2.setUserMaster(user);
        List<?> empId = employeeMasterService.readByUserName(employeeMaster2);
        if (!empId.isEmpty()) {
            employeeMaster2 = (EmployeeMaster) empId.get(0);
        }
        int id = employeeMaster2.getId();
        List<?> list = employeeMasterService.readEmployeeAjax(id);
        if (employeeMaster2.getReportingManagerLevel1().equals("")) {
            employeeMaster2.setReportingManagerLevel1("1");
        }
        employeeMaster = employeeMasterService.readById(Integer.parseInt(employeeMaster2.getReportingManagerLevel1()));
        Date cdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        String currentDate = sdf.format(cdate);
        request.setAttribute("employeeMaster", employeeMaster);
        request.setAttribute("list", list);
        request.setAttribute("currentDate", currentDate);
        mv.getModelMap().put("resignationMaster", resignationMaster);
        mv.setViewName("Resignation/ResignationCreate");

        return mv;
    }

    public void employeeAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int empId = Integer.parseInt(request.getParameter("empId"));
        List<?> list = employeeMasterService.readEmployeeAjax(empId);
        String listString = "";

        String tempStr = "";
        Object[] arrayOfObject;

        boolean flag = false;
        for (Iterator<? extends Object> it = list.iterator(); it.hasNext();) {
            arrayOfObject = (Object[]) it.next();

            if (flag) {
                tempStr += ", ";
            }
            flag = true;
            tempStr += "" + arrayOfObject[0]
                    + "/" + arrayOfObject[1]
                    + "/" + arrayOfObject[2]
                    + "/" + arrayOfObject[3]
                    + "/" + arrayOfObject[4]
                    + "/" + arrayOfObject[5]
                    + "/" + arrayOfObject[6] + "";
        }

        PrintWriter out = response.getWriter();
        out.write(tempStr);

    }

    public ModelAndView submitResignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final Boolean RESIGNATION_GENERATED_FLAG = true;
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        List<?> list = employeeMasterService.readEmployeeAjax(id);
        bind(request, resignationMaster);
        BindException errors = new BindException(resignationMaster, "resignationMaster");
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster.setId(empId);
        resignationMaster.setEmployeeMaster(employeeMaster);
        employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        resignationMasterValidator.validate(resignationMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Resignation/ResignationCreate");
        } else {
//            if (resignationMaster.getManagerComment() == null) {
//                resignationMaster.setManagerComment(" ");
//            }

            List<?> resList = resignationMasterService.readExistingList(id);
            if (resList.isEmpty()) {
                resignationMasterService.create(resignationMaster);
                if (session != null) {
                    session.setAttribute("isExistingResignationDataExist", RESIGNATION_GENERATED_FLAG);
                    //this is for showing resignation result link on navbar without terminating session.
                }
                //    Email Sent to ReportingManager1
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    // id 59 is status for Resignnation apply
                    emailTemplate = emailTemplateService.readById(59);
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
                request.setAttribute("successMessage",
                        "Information : The Information is saved Successfully.");
                mv.setViewName("forward:userMaster.htm?act=goToDashboard");
            } else {
                request.setAttribute("failureMessage",
                        "Error :You Have Already Submit Your Resignation...");
                mv.setViewName("forward:userMaster.htm?act=goToDashboard");
            }
        }
        request.setAttribute("list", list);
        request.setAttribute("employeeMaster", employeeMaster1);
        return mv;
    }
//emp result

    public ModelAndView EmpResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        resignationMaster.setEmployeeMaster(employeeMaster);
        List<?> list = resignationMasterService.readByResignationPendingRequest(resignationMaster);
        request.setAttribute("list", list);
        mv.getModelMap().put("resignationMaster", resignationMaster);
        mv.setViewName("Resignation/EmpResult");
        return mv;
    }
//emp view

    public ModelAndView viewClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int id = Integer.parseInt(request.getParameter("id"));
        int empid = Integer.parseInt(request.getParameter("EmpId"));

        List<?> list = employeeMasterService.readEmployeeAjax(empid);
        resignationMaster = resignationMasterService.readById(id);
        employeeMaster = employeeMasterService.readById(empid);
        employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        request.setAttribute("employeeMaster", employeeMaster1);
        request.setAttribute("list", list);
        mv.getModelMap().put("resignationMaster", resignationMaster);
        mv.setViewName("Resignation/ResignationView");
        return mv;
    }

    //emp withdraw n return submit
    public ModelAndView empsubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        ResignationMaster resignationMaster1 = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, resignationMaster);
        String ButtonType = request.getParameter("btnType");
        int id = Integer.parseInt(request.getParameter("id"));
        resignationMaster.setId(id);
        resignationMaster1 = resignationMasterService.readById(id);
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster.setId(empId);
        resignationMaster.setEmployeeMaster(employeeMaster);
        if (resignationMaster1.getHrId() != null) {
            resignationMaster.setHrId(resignationMaster1.getHrId());
            resignationMaster.setHrApproveDate(resignationMaster1.getHrApproveDate());
            resignationMaster.setHrComment(resignationMaster1.getHrComment());
        }
        if ("WITHDRAW".equals(ButtonType)) {
            if (resignationMaster1.getStatus() == 0) {
                resignationMasterService.delete(id);
                request.setAttribute("successMessage",
                        "Information : Resignation Withdrawed Successfully.");
            } else {
                resignationMaster.setStatus(5);
                resignationMaster.setEffectiveDatetime(resignationMaster1.getEffectiveDatetime());
                resignationMaster.setReason(resignationMaster1.getReason());
                if (resignationMaster1.getRelievingDate() != null || resignationMaster1.getRelievingDate() != "") {
                    resignationMaster.setRelievingDate(resignationMaster1.getRelievingDate());
                }
                resignationMasterService.update(resignationMaster);
                request.setAttribute("successMessage",
                        "Information : The Withdraw Request Sent Successfully.");
            }
            mv.getModelMap().put("resignationMaster", resignationMaster);
            mv = EmpResult(request, response);
            //    Email Sent to ReportingManager1
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                // id 68 is status for Withdraw Resignnation
                emailTemplate = emailTemplateService.readById(68);
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
        if ("SUBMIT".equals(ButtonType)) {
            resignationMaster.setStatus(3);
            resignationMasterService.update(resignationMaster);
            request.setAttribute("successMessage",
                    "Information : The Returned Request Sent Successfully.");
            mv.getModelMap().put("resignationMaster", resignationMaster);
            mv = EmpResult(request, response);
            //    Email Sent to ReportingManager1
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                // id 67 is status for Resignnation Rework Submitted
                emailTemplate = emailTemplateService.readById(67);
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
//        if ("WITHDRAWSUBMIT".equals(ButtonType)) {
//            resignationMaster.setStatus(8);
//            resignationMasterService.update(resignationMaster);
//            request.setAttribute("successMessage",
//                    "Information : The Returned Request Sent Successfully.");
//            mv.getModelMap().put("resignationMaster", resignationMaster);
//            mv = EmpResult(request, response);
//        }
        return mv;
    }
//approver result

    public ModelAndView createResignationResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        resignationMaster.setEmployeeMaster(employeeMaster);
        List<?> list = resignationMasterService.readforapprover(resignationMaster);
        request.setAttribute("list", list);
        mv.setViewName("Resignation/ResignationResult");
        return mv;
    }
//approver view

    public ModelAndView createApproveOrRejectResignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int id = Integer.parseInt(request.getParameter("id"));
        int empid = Integer.parseInt(request.getParameter("EmpId"));

        List<?> list = employeeMasterService.readEmployeeAjax(empid);
        resignationMaster = resignationMasterService.readById(id);
        employeeMaster = employeeMasterService.readById(empid);
        employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        request.setAttribute("employeeMaster", employeeMaster1);
        request.setAttribute("list", list);
        mv.getModelMap().put("resignationMaster", resignationMaster);
        mv.setViewName("Resignation/Approverview");
        return mv;
    }
//approve reject

    public ModelAndView submitApproveOrRejectResignation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        ResignationMaster resignationMaster1 = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        bind(request, resignationMaster);
        String ButtonType = request.getParameter("btnType");
        int id = Integer.parseInt(request.getParameter("id"));
        resignationMaster.setId(id);
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster.setId(empId);
        resignationMaster.setEmployeeMaster(employeeMaster);
        resignationMaster1 = resignationMasterService.readById(id);
        if (resignationMaster1.getHrId() != null) {
            resignationMaster.setHrId(resignationMaster1.getHrId());
            resignationMaster.setHrApproveDate(resignationMaster1.getHrApproveDate());
            resignationMaster.setHrComment(resignationMaster1.getHrComment());
        }
        if ("APPROVE".equals(ButtonType)) {
            resignationMaster.setStatus(2);
            resignationMasterService.update(resignationMaster);
//            employeeMaster = employeeMasterService.readById(empId);
//            employeeMaster.setDateOfLeaving(resignationMaster.getEffectiveDatetime());
//            employeeMasterService.update(employeeMaster);
            request.setAttribute("successMessage",
                    "Information : Resignation Accepted Successfully.");
            mv = createResignationResult(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 60 is status for Resignation Approve(Email for Employee)
                emailTemplate = emailTemplateService.readById(60);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();

                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

                String name = "Resignation";
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
                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                            String msg1 = emailTemplate.getBodytext();
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from1, To1, subject1, msg1);

                            List<?> gmOrStateHeadMailSend = employeeMasterService.readForSendMailToAll(employeeRequestee);
                            if (!gmOrStateHeadMailSend.isEmpty()) {
                                Object[] emaillist = (Object[]) gmOrStateHeadMailSend.get(0);
                                for (int i = 0; i <= emaillist.length; i++) {
                                    if (null != emaillist[i] && "" != emaillist[i]) {
                                        String emailid = emaillist[i].toString();

                                        String To3 = emailid;
                                        String from3 = employeeMasterModel.getOfficeEmailId();
                                        String subject3 = emailTemplate.getSubject();

                                        subject3 = subject3.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                        String msg3 = emailTemplate.getBodytext();
                                        msg3 = msg3.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                        msg3 = msg3.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg3 = msg3.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from3, To3, subject3, msg3);
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {

            }
            //    Email Sent to HR(Having EmployeeExit Rights)
            List<?> ListforEmployeeExitRights = userRightMasterService.readEmployeeExitRightsList();
            for (Object o : ListforEmployeeExitRights) {
                Object[] o1 = (Object[]) o;
                int AdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(AdminId);
                    List l1 = resignationMasterService.readEmpIdFromTabId(id);
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 61 is status for Resignation Approve(Email for HR)
                    emailTemplate = emailTemplateService.readById(61);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
            }
        }
        if ("RETURN".equals(ButtonType)) {
            resignationMaster.setStatus(1);
            resignationMasterService.update(resignationMaster);
            request.setAttribute("successMessage",
                    "Information : Resignation Returned Successfully.");
            mv = createResignationResult(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 62 is status for Resignation Returned(Email for Employee)
                emailTemplate = emailTemplateService.readById(62);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
        }
        if ("APPROVEWITHDRAW".equals(ButtonType)) {
            if (resignationMaster.getHrId() == null) {
                resignationMaster.setStatus(9);
                resignationMasterService.update(resignationMaster);
                request.setAttribute("successMessage",
                        "Information : Withdraw Approved Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = resignationMasterService.readEmpIdFromTabId(id);
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 72 is status for Resignation Withdarw Final Approved(Cycle Ends as Hr has yet not Approved) (Email for Employee)
                    emailTemplate = emailTemplateService.readById(72);
                    String To = employeeRequestee.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
            } else {
                resignationMaster.setStatus(7);
                resignationMasterService.update(resignationMaster);
                request.setAttribute("successMessage",
                        "Information : Withdraw Approved Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = resignationMasterService.readEmpIdFromTabId(id);
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 70 is status for Resignation Withdarw Rejected by manager (Email for Employee)
                    emailTemplate = emailTemplateService.readById(70);
                    String To = employeeRequestee.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
                //    Email Sent to HR(Having EmployeeExit Rights)
                List<?> ListforEmployeeExitRights = userRightMasterService.readEmployeeExitRightsList();
                for (Object o : ListforEmployeeExitRights) {
                    Object[] o1 = (Object[]) o;
                    int AdminId = (int) o1[0];
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(AdminId);
                        List l1 = resignationMasterService.readEmpIdFromTabId(id);
                        EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                        // id 71` is status for Resignation Withdarw Approved by manager and Withdraw Request is pending For Hr to approve(Email for HRs)
                        emailTemplate = emailTemplateService.readById(71);
                        String To = employeeMasterHr.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);
                    } catch (Exception e) {

                    }
                }
            }
            mv = createResignationResult(request, response);
        }
        if ("REJECTWITHDRAW".equals(ButtonType)) {
            if (resignationMaster.getHrId() == null) {
                resignationMaster.setStatus(2);
                resignationMasterService.update(resignationMaster);
                request.setAttribute("successMessage",
                        "Information : Withdraw Rejected and Resignation Accepted Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = resignationMasterService.readEmpIdFromTabId(id);
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 75 is status for Resignation Withdarw Rejected by manager and Resignation Request is pending For Hr(Email for Employee)
                    emailTemplate = emailTemplateService.readById(75);
                    String To = employeeRequestee.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
                //    Email Sent to HR(Having EmployeeExit Rights)
                List<?> ListforEmployeeExitRights = userRightMasterService.readEmployeeExitRightsList();
                for (Object o : ListforEmployeeExitRights) {
                    Object[] o1 = (Object[]) o;
                    int AdminId = (int) o1[0];
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(AdminId);
                        List l1 = resignationMasterService.readEmpIdFromTabId(id);
                        EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                        // id 76 is status for Resignation Withdraw Rejected by manager and Resignation Request is pending For Hr(Email for HR)
                        emailTemplate = emailTemplateService.readById(76);
                        String To = employeeMasterHr.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);
                    } catch (Exception e) {

                    }
                }
            } else {
                resignationMaster.setStatus(10);
                resignationMasterService.update(resignationMaster);
                request.setAttribute("successMessage",
                        "Information : Withdraw Rejected Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = resignationMasterService.readEmpIdFromTabId(id);
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 73 is status for Resignation Withdarw Rejected by manager and Withdraw Request is pending For Hr(Email for Employee)
                    emailTemplate = emailTemplateService.readById(73);
                    String To = employeeRequestee.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
                //    Email Sent to HR(Having EmployeeExit Rights)
                List<?> ListforEmployeeExitRights = userRightMasterService.readEmployeeExitRightsList();
                for (Object o : ListforEmployeeExitRights) {
                    Object[] o1 = (Object[]) o;
                    int AdminId = (int) o1[0];
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(AdminId);
                        List l1 = resignationMasterService.readEmpIdFromTabId(id);
                        EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                        // id 74 is status for Resignation Withdraw Rejected by manager and Withdraw Request is pending For Hr(Email for HR)
                        emailTemplate = emailTemplateService.readById(74);
                        String To = employeeMasterHr.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);
                    } catch (Exception e) {

                    }
                }
            }
            mv = createResignationResult(request, response);
        }
        return mv;
    }
//    hr

    public ModelAndView HRResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        ResignationMaster resignationMaster = new ResignationMaster();
        List<?> list = resignationMasterService.readforHR(resignationMaster);
        request.setAttribute("list", list);
        session.setAttribute("resignationResultSessionList", list);
        mv.setViewName("Resignation/HrResult");
        return mv;
    }

    public ModelAndView Hrview(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int id = Integer.parseInt(request.getParameter("id"));
        int empid = Integer.parseInt(request.getParameter("EmpId"));

        List<?> list = employeeMasterService.readEmployeeAjax(empid);
        resignationMaster = resignationMasterService.readById(id);
        employeeMaster = employeeMasterService.readById(empid);
        employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        request.setAttribute("employeeMaster", employeeMaster1);
        request.setAttribute("list", list);
        mv.getModelMap().put("resignationMaster", resignationMaster);
        request.setAttribute("id", id);
        request.setAttribute("empid", empid);
        mv.setViewName("Resignation/Hrview");
        return mv;
    }

    public ModelAndView HRApprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        BindException errors = new BindException(resignationMaster, "resignationMaster");
        bind(request, resignationMaster);
        String ButtonType = request.getParameter("btnType");
        int id = Integer.parseInt(request.getParameter("id"));
        resignationMaster.setId(id);
        int empId = Integer.parseInt(request.getParameter("empId"));
        employeeMaster.setId(empId);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        int loginid = employeeMaster1.getId();
        resignationMaster.setHrId(loginid);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String date = sdf.format(new Date());
        resignationMaster.setHrApproveDate(date);
        resignationMaster.setEmployeeMaster(employeeMaster);
        if ("APPROVE".equals(ButtonType)) {
//            resignationMasterValidator.validate(resignationMaster, errors);
//        if (errors.hasErrors()) {
//            request.setAttribute("failureMessage",
//                      "Error : Mandatory Fields should not be blank.");
//            mv.addAllObjects(errors.getModel());
//            mv = Hrview(request, response);
//        }else{
            resignationMaster.setStatus(4);

            resignationMasterService.update(resignationMaster);
            employeeMaster = employeeMasterService.readById(empId);
            employeeMaster.setDateOfLeaving(resignationMaster.getRelievingDate());
            employeeMaster.setReasonForLeaving(resignationMaster.getReason());
            employeeMasterService.update(employeeMaster);
            request.setAttribute("successMessage",
                    "Information : Resignation Accepted Successfully.");
            mv = HRResult(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 63 is status for Resignation Approved by HR(Email for Employee)
                emailTemplate = emailTemplateService.readById(63);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

                String name = "Resignation";
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
                            subject1 = subject1.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                            String msg1 = emailTemplate.getBodytext();
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from1, To1, subject1, msg1);

                            List<?> gmOrStateHeadMailSend = employeeMasterService.readForSendMailToAll(employeeRequestee);
                            if (!gmOrStateHeadMailSend.isEmpty()) {
                                Object[] emaillist = (Object[]) gmOrStateHeadMailSend.get(0);
                                for (int i = 0; i <= emaillist.length; i++) {
                                    if (null != emaillist[i] && "" != emaillist[i]) {
                                        String emailid = emaillist[i].toString();

                                        String To3 = emailid;
                                        String from3 = employeeMasterModel.getOfficeEmailId();
                                        String subject3 = emailTemplate.getSubject();

                                        subject3 = subject3.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                                        String msg3 = emailTemplate.getBodytext();
                                        msg3 = msg3.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                                        msg3 = msg3.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg3 = msg3.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from3, To3, subject3, msg3);
                                    }
                                }
                            }

                        }
                    }
                }
            } catch (Exception e) {

            }
            //    Email Sent to ReportingManager1
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeRequestee.getReportingManagerLevel1()));
                // id 64 is status for Resignation Approved by HR(Email for Manager)
                emailTemplate = emailTemplateService.readById(64);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }

//        }
        }
        if ("RETURN".equals(ButtonType)) {
            resignationMaster.setStatus(6);

            resignationMasterService.update(resignationMaster);

            request.setAttribute("successMessage",
                    "Information : Resignation Returned Successfully.");
            mv = HRResult(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 65 is status for Resignation Returned by HR(Email for Employee)
                emailTemplate = emailTemplateService.readById(65);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
            //    Email Sent to ReportingManager1
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeRequestee.getReportingManagerLevel1()));
                // id 66 is status for Resignation Returned by HR(Email for Manager)
                emailTemplate = emailTemplateService.readById(66);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
        }
        if ("WITHDRAWAPPROVE".equals(ButtonType)) {
            resignationMaster.setStatus(9);
            resignationMasterService.update(resignationMaster);
            employeeMaster = employeeMasterService.readById(empId);
            employeeMaster.setDateOfLeaving("");
            employeeMaster.setReasonForLeaving("");
            employeeMasterService.update(employeeMaster);
// Delete Exit interview and No Dues Data as resignation is cancelled
            List<?> exitinterviewfilled = exitInterviewMasterService.readExistingEmp(empId);
            if (exitinterviewfilled.size() > 0) {
                int exitinterviewtableid = (Integer) exitinterviewfilled.get(0);
                exitInterviewMasterService.delete(exitinterviewtableid);
            }
            List<?> noDuesfilled = noDueMasterService.readExistingemployee(empId);
            if (noDuesfilled.size() > 0) {
                int noduesTableID = (Integer) noDuesfilled.get(0);
                noDueMasterService.delete(noduesTableID);
            }
            request.setAttribute("successMessage",
                    "Information : Resignation Approved Successfully.");
            mv = HRResult(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 77 is status for Resignation Withdraw Final Approved(Email for Employee)
                emailTemplate = emailTemplateService.readById(77);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
            //    Email Sent to ReportingManager1
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeRequestee.getReportingManagerLevel1()));
                // id 78 is status for Resignation Withdraw Final Approved(Email for Manager)
                emailTemplate = emailTemplateService.readById(78);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }

        }
        if ("WITHDRAWREJECT".equals(ButtonType)) {
            resignationMaster.setStatus(11);
            resignationMasterService.update(resignationMaster);
            employeeMaster = employeeMasterService.readById(empId);
            employeeMaster.setDateOfLeaving(resignationMaster.getRelievingDate());
            employeeMaster.setReasonForLeaving(resignationMaster.getReason());
            employeeMasterService.update(employeeMaster);
            request.setAttribute("successMessage",
                    "Information : Resignation Rejected Successfully.");
            mv = HRResult(request, response);
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 79 is status for Withdraw Rejected Resignation Accepted(Email for Employee)
                emailTemplate = emailTemplateService.readById(79);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
            //    Email Sent to ReportingManager1
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                List l1 = resignationMasterService.readEmpIdFromTabId(id);
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeRequestee.getReportingManagerLevel1()));
                // id 80 is status for Withdraw Rejected Resignation Accepted(Email for HR)
                emailTemplate = emailTemplateService.readById(80);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
            } catch (Exception e) {

            }
        }
        return mv;
    }

    public ModelAndView userDashboardResignationPendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        resignationMaster.setEmployeeMaster(employeeMaster);
        List<?> list = resignationMasterService.readforapprover(resignationMaster);
        request.setAttribute("resignationPending", list);
        int resigncount = list.size();
        request.setAttribute("resigncount", resigncount);
        mv.setViewName("forward:expenseMaster.htm?act=userDashboardExpensePendingRequest");
        return mv;
    }

    public ModelAndView submitEmployeeWiseSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectResignedEmployee(request, response);
        departmentList(request);
        designationList(request);
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        resignationMaster.setEmployeeMaster(employeeMaster);
        if (!"".equals(departmentId) && null != departmentId) {
            resignationMaster.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            resignationMaster.setManagerComment(designationId);
        }
        List<?> SearchRequestResultList = resignationMasterService.readSearchRequest(resignationMaster);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.addObject("SearchRequestResultList", SearchRequestResultList);
//        mv.setViewName("NoDues/EmployeeWiseExitSearch");
        mv.setViewName("Resignation/hrSearch");
        return mv;
    }

    public ModelAndView searchresult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        NoDueMaster noDueMaster = new NoDueMaster();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectResignedEmployee(request, response);
        departmentList(request);
        designationList(request);
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        if (!"".equals(empId)) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        resignationMaster.setEmployeeMaster(employeeMaster);
        if (!"".equals(departmentId)) {
            resignationMaster.setReason(departmentId);
        }
        if (!"".equals(designationId)) {
            resignationMaster.setManagerComment(designationId);
        }
        List<?> SearchRequestResultList = resignationMasterService.readSearchRequest(resignationMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.addObject("SearchRequestResultList", SearchRequestResultList);
        mv.setViewName("Resignation/hrSearch");
        return mv;
    }

    public ModelAndView managerSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("NoDues/EmployeeWiseExitSearch");
        mv.setViewName("Resignation/managerSearch");
        return mv;
    }

    public ModelAndView managerSearchResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        resignationMaster.setEmployeeMaster(employeeMaster);
        List<?> list = resignationMasterService.readmanagerSearchRequest(resignationMaster);
        mv.getModelMap().put("list", list);
        mv.setViewName("Resignation/managerSearchResult");
        return mv;
    }

    public ModelAndView printClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ResignationMaster resignationMaster = new ResignationMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int id = Integer.parseInt(request.getParameter("id"));
        int empid = Integer.parseInt(request.getParameter("empId"));

        List<?> list = employeeMasterService.readEmployeeAjax(empid);
        resignationMaster = resignationMasterService.readById(id);
        employeeMaster = employeeMasterService.readById(empid);
        employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        request.setAttribute("employeeMaster", employeeMaster1);
        request.setAttribute("list", list);
        mv.getModelMap().put("resignationMaster", resignationMaster);
        request.setAttribute("id", id);
        request.setAttribute("empid", empid);
        mv.setViewName("Resignation/PrintView");
        return mv;
    }

    public ModelAndView exportToExcelResignation(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> resignationResultSessionList = (List<?>) request.getSession().getAttribute("resignationResultSessionList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ExpenseRequestData.xls");
        request.setAttribute("resignationResultSessionList", resignationResultSessionList);
        mv.setViewName("Resignation/ResignationHrResultExcel");
        return mv;
    }

    private synchronized void reportingManagerChangeCheck() throws Exception {

        List<?> list = resignationMasterService.read();
        for (Object o : list) {
            ResignationMaster resignationMaster = (ResignationMaster) o;
            String relevingDate = resignationMaster.getRelievingDate();
            if (null != relevingDate && !relevingDate.equals("")) {
                SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                Date relevingDate1 = sdf3.parse(relevingDate);
                Date date = new Date();
                if (relevingDate1.before(date)) {
                    int empId = resignationMaster.getEmployeeMaster().getId();
                    List<?> list1 = employeeMasterService.readForAprove(empId);
                    for (Object o1 : list1) {
                        EmployeeMaster employeeMaster = (EmployeeMaster) o1;
                        employeeMaster.setReportingManagerLevel1(employeeMaster.getReportingManagerLevel2());
                        employeeMasterService.update(employeeMaster);
                    }
                }
            }

        }

    }

    public ModelAndView fullAndfinal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        FullAndFinalSettlement fullAndFinalSettlement = new FullAndFinalSettlement();

        List<?> fullAndFinalSettlementList = fullAndFinalSettlementService.readFAndFData();

        mv.getModelMap().put("list", fullAndFinalSettlementList);
        mv.getModelMap().put("fullAndFinalSettlement", fullAndFinalSettlement);
        mv.setViewName("Resignation/ListFullAndFinal");
        return mv;
    }

    public ModelAndView fullAndfinalSettlement(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        FullAndFinalSettlement fullAndFinalSettlement = new FullAndFinalSettlement();
        bind(request, fullAndFinalSettlement);

        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectResignedEmployee(request, response);
        selectedEmployeeFor360Feedback(request, employeeMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("fullAndFinalSettlement", fullAndFinalSettlement);
        mv.setViewName("Resignation/FullAdFinaSettlementl");
        return mv;
    }

    public ModelAndView fullAndFinalSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        FullAndFinalSettlement fullAndFinalSettlement = new FullAndFinalSettlement();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();
        if ("" != request.getParameter("employeeMaster")) {
            String empid = request.getParameter("employeeMaster");
            employeeMaster1 = employeeMasterService.readById(Integer.parseInt(empid));
            BindException errors = new BindException(fullAndFinalSettlement, "fullAndFinalSettlement");
            bind(request, fullAndFinalSettlement);
            departmentList(request);

            fullAndFinalSettlementValidator.validate(fullAndFinalSettlement, errors);
            if (errors.hasErrors()) {
                request.setAttribute("failureMessage",
                        " field are Required.Please Enter Valid data");
                mv = fullAndfinalSettlement(request, response);

            } else {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date cDate = new Date();
                fullAndFinalSettlement.setEmployeeMaster(employeeMaster1);
                fullAndFinalSettlement.setCreatedDate(sdf.format(cDate));
                fullAndFinalSettlement.setCreatedBy(employeeMaster.getId());
                fullAndFinalSettlement.setStatus(0);

                fullAndFinalSettlementService.create(fullAndFinalSettlement);
                request.setAttribute("successMessage",
                        "Information : The Information is Updated Successfully.");

                mv = fullAndfinal(request, response);
                return mv;
            }
        }
        request.setAttribute("failureMessage",
                " field are Required.Please Enter Valid data");
        mv = fullAndfinalSettlement(request, response);
        return mv;
    }

    public ModelAndView ViewfullAndfinalSettlement(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        FullAndFinalSettlement fullAndFinalSettlement = new FullAndFinalSettlement();
        DesignationMaster designationMaster = new DesignationMaster();
        DepartmentMaster departmentMaster = new DepartmentMaster();

        String id = request.getParameter("id");
        fullAndFinalSettlement = fullAndFinalSettlementService.readById(Integer.parseInt(id));

        employeeMaster = employeeMasterService.readById(fullAndFinalSettlement.getEmployeeMaster().getId());
        ResignationMaster rm = resignationMasterService.readByEmpId(fullAndFinalSettlement.getEmployeeMaster().getId());
        List<?> ListBW = resignationMasterService.fetchBWdate(rm.getEmployeeMaster().getId(), rm.getEffectiveDatetime(), rm.getRelievingDate());
        List<?> esp = employeeSalaryProcessService.readEmpId(rm.getEmployeeMaster().getId());
        List<?> ctcDetail = employeeCtcDetailService.empid(fullAndFinalSettlement.getEmployeeMaster().getId());
        List<?> Gratuiety = employeeCtcDetailService.GratuietyFiveYrFetch(fullAndFinalSettlement.getEmployeeMaster().getId());
        List<?> daysfetch = employeeSalaryProcessService.monthDaysFetch(rm.getEmployeeMaster().getId());
        List<?> bonusFetchdata = employeeCtcDetailService.bonusFetch(rm.getEmployeeMaster().getId());
//        List<?> ctcDetail1 = employeeCtcDetailService.CtcDetailempid(fullAndFinalSettlement.getEmployeeMaster().getId());
        List<?> fNfList = formateFullNdFinalLetterService.fetchFnFDate();
//        EmployeeCtcDetail ecd = (EmployeeCtcDetail) ctcDetail1.get(0);
//        EmployeeSalaryProcess em = (EmployeeSalaryProcess) esp.get(0);
        List<?> list = employeeDeductionAmountService.readByedaId(rm.getEmployeeMaster().getId(), rm.getEffectiveDatetime(), rm.getRelievingDate());
        List<?> salary = employeeDeductionAmountService.fetchsalary(rm.getEmployeeMaster().getId(), rm.getEffectiveDatetime(), rm.getRelievingDate());
        Double netPayable = 0.00;
        Double totalMonthlyAmount2 = 0.00;
        Double totalMonthlyAmount3 = 0.00;
        Double totalMonthlyAmount4 = 0.00;
        Double totalMonthlyAmount5 = 0.00;
        Double totalMonthlyAmount6 = 0.00;
        Double deductionAmount = 0.00;
        Double mmmm = 0.00;
        Double salaryamount = 0.00;
        Double Gratuietycal = 0.00;
        Double bounsdata = 0.0;
        Float leavedaysfetch = 0.0F;
        Float workingDays = 0.0F;

        for (int i = 0; i < ctcDetail.size(); i++) {
            Object[] o = (Object[]) ctcDetail.get(i);
            if ((Integer.parseInt(o[1].toString()) == 2)) {
                Double amount1 = (Double) o[3];
                totalMonthlyAmount2 += Double.valueOf(amount1);
            }
            if ((Integer.parseInt(o[1].toString()) == 3)) {
                Double amount1 = (Double) o[3];
                totalMonthlyAmount3 += Double.valueOf(amount1);
            }
            if ((Integer.parseInt(o[1].toString()) == 4)) {
                Double amount1 = (Double) o[3];
                totalMonthlyAmount4 += Double.valueOf(amount1);
            }
            if ((Integer.parseInt(o[1].toString()) == 5)) {
                Double amount1 = (Double) o[3];
                totalMonthlyAmount5 += Double.valueOf(amount1);
            }
            if ((Integer.parseInt(o[1].toString()) == 6)) {
                Double amount1 = (Double) o[3];
                totalMonthlyAmount6 += Double.valueOf(amount1);
            }
        }

        for (int i = 0; i < ListBW.size(); i++) {
            Object[] o = (Object[]) ListBW.get(i);
            Double reafmowise = (Double) o[1];
            mmmm += Double.valueOf(reafmowise);
        }

        for (int i = 0; i < Gratuiety.size(); i++) {
            Object[] o = (Object[]) Gratuiety.get(i);
            Double reafmowise1 = (Double) o[2];
            Gratuietycal += Double.valueOf(reafmowise1);
        }
        for (int i = 0; i < bonusFetchdata.size(); i++) {
            Object[] o = (Object[]) bonusFetchdata.get(i);
            Double bonusfm = (Double) o[1];
            bounsdata += Double.valueOf(bonusfm);
        }
        
//        ////  leaves count /////////////////
        for (int i = 0; i < daysfetch.size(); i++) {
            Object[] o = (Object[]) daysfetch.get(i);
            Float leavecount = (Float) o[1];
            leavedaysfetch += Float.valueOf(leavecount);
        }
        for (int i = 0; i < daysfetch.size(); i++) {
            Object[] o = (Object[]) daysfetch.get(i);
            Float workingdy = (Float) o[4];
            workingDays += Float.valueOf(workingdy);
        }
        
        /////////  leaves pays amount count //////////
        
        for (int i = 0; i < salary.size(); i++) {
            Object[] o = (Object[]) salary.get(i);
            Double workingdy = (Double) o[7];
            salaryamount += Double.valueOf(workingdy);
        }
        
        Double amountCount = salaryamount / 30;
        
        Float leavedayscount = workingDays - leavedaysfetch;
        
        Double totalLyamountCount = amountCount * leavedayscount;

//       ///// --------   For Salary For The Month of -------//////
//        for (int i = 0; i < esp.size(); i++) {
//            EmployeeSalaryProcess em1 = (EmployeeSalaryProcess) esp.get(i);
//            netPayable += em1.getGrossTotal();
//        }
//        //////  ------ ctc_allowance for monthvise ------------ //////
        Double monthAmountTotal = totalMonthlyAmount2 + Gratuietycal + totalMonthlyAmount4 + totalMonthlyAmount5 + totalMonthlyAmount6;
//        /////// -------- DEDUCTIONS -----------------//////
        for (int i = 0; i < list.size(); i++) {
            Object[] o = (Object[]) list.get(i);
            Double aaam = (Double) o[4];
            deductionAmount += aaam.valueOf(aaam);
        }

//        --------  (B) TOTAL PAYABLES ------------   //////
        Double totalpayable = mmmm + monthAmountTotal;
//        ------  TOTAL NET PAYABLE ( A - B ) -----  ///////
        Double finaltotalBD = totalpayable - deductionAmount;
        
//        ------------  Deduction Amount ------------
        Integer shoesDeduction =  fullAndFinalSettlement.getShoesDeduction();
        Integer uniformDeduction =  fullAndFinalSettlement.getUniformDeduction();
        Integer otherDeduction =  fullAndFinalSettlement.getOtherDeduction();
        Integer noticePeriodRecovery =  fullAndFinalSettlement.getNoticePeriodRecovery();
        
        Integer totaldeduction = noticePeriodRecovery + shoesDeduction + uniformDeduction + otherDeduction;

        int designation = employeeMaster.getDesignationMaster().getId();
        designationMaster = designationMasterService.readById(designation);
        String designationName = designationMaster.getDesignationName();

        int department = employeeMaster.getDepartmentMaster().getId();
        departmentMaster = departmentMasterService.readById(department);
        String departmentName = departmentMaster.getDepartmentName();

        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("rm", rm);
//        mv.getModelMap().put("esp", esp);
        mv.getModelMap().put("ListBW", ListBW);
        mv.getModelMap().put("ctcDetail", ctcDetail);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("daysfetch", daysfetch);
        mv.getModelMap().put("bonusFetch", bonusFetchdata);
        mv.getModelMap().put("salary", salary);
        mv.getModelMap().put("totalpayable", totalpayable);
        mv.getModelMap().put("deductionAmount", deductionAmount);
        mv.getModelMap().put("finaltotalBD", finaltotalBD);
        mv.getModelMap().put("fNfList", fNfList);
        mv.getModelMap().put("Gratuiety", Gratuiety);
        mv.getModelMap().put("esp", esp);
        mv.getModelMap().put("bounsdata", bounsdata);
        mv.getModelMap().put("leavedaysfetch", leavedaysfetch);
        mv.getModelMap().put("leavedayscount", leavedayscount);
        mv.getModelMap().put("totaldeduction", totaldeduction);
        mv.getModelMap().put("totalLyamountCount", totalLyamountCount);
        mv.getModelMap().put("totalMonthlyAmount2", totalMonthlyAmount2);
        mv.getModelMap().put("totalMonthlyAmount3", totalMonthlyAmount3);
        mv.getModelMap().put("totalMonthlyAmount4", totalMonthlyAmount4);
        mv.getModelMap().put("designationName", designationName);
        mv.getModelMap().put("departmentName", departmentName);
        mv.getModelMap().put("fullAndFinalSettlement", fullAndFinalSettlement);
        mv.setViewName("Resignation/FullAndFinaSettlementReportShow");

        return mv;
    }

    public ModelAndView fullandfcreateClick(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        FormateFullNdFinalLetter formateFullNdFinalLetter = new FormateFullNdFinalLetter();
        List<?> list = formateFullNdFinalLetterService.fetchFnFDate();
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("formateFullNdFinalLetter", formateFullNdFinalLetter);
        mv.setViewName("FullAndFinal/FullAndFinalFetchList");
        return mv;
    }

    public ModelAndView newFormatCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        FormateFullNdFinalLetter formateFullNdFinalLetter = new FormateFullNdFinalLetter();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
//          EmployeeMaster employeeMaster= new EmployeeMaster();
        selectedEmployeeFor360Feedback(request, employeeMaster);
//        selectEmployeeForParticularManager(request, response);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("formateFullNdFinalLetter", formateFullNdFinalLetter);
        mv.setViewName("FullAndFinal/NewFormatCraeteFndF");
        return mv;
    }

    public ModelAndView submitCraeteFormat(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        FormateFullNdFinalLetter formateFullNdFinalLetter = new FormateFullNdFinalLetter();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(formateFullNdFinalLetter, "formateFullNdFinalLetter");
        bind(request, formateFullNdFinalLetter);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        formateFullNdFinalLetter.setCreateDate(sdf.format(cDate));
        formateFullNdFinalLetter.setCreatedBy(employeeMaster.getId());
        formateFullNdFinalLetter.setStatus(0);
        formateFullNdFinalLetterService.create(formateFullNdFinalLetter);

        request.setAttribute("successMessage",
                "Information: The Format Full And Final Settlement Create successfully");

        mv = fullandfcreateClick(request, response);

        return mv;
    }

    public ModelAndView resignationDeleteList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String empId[] = request.getParameterValues("checkId");
        for (String z : empId) {
            try {
                fullAndFinalSettlementService.delete(Integer.parseInt(z));
                request.setAttribute("successMessage",
                        "Info : One or more records are deleted successfully.");
            } catch (Exception e) {

            }
        }
        mv = fullAndfinal(request, response);
        return mv;
    }
}
