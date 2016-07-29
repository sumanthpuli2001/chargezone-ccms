/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.resignation;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.NoDueMaster;
import com.bul.zydex.model.ResignationMaster;
import com.bul.zydex.model.UserMaster;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

}
