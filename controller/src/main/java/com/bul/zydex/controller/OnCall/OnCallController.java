/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OnCall;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.OnCall;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class OnCallController extends OnCallAbstract {

    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
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
        mv.getModelMap().put("onCall", onCall);
        mv.setViewName("OnCall/OnCallSupportForm");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, OnCall onCall) throws Exception {
        ModelAndView mv = new ModelAndView();

        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        int reportingId = 0;
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int userMasterId = user.getId();
        employeeMaster.setUserMaster(user);
        BindException errors = new BindException(onCall, "onCall");
        bind(request, onCall);
        onCallValidator.validate(onCall, errors);
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

            mv.getModelMap().put("onCall", onCall);
            mv.setViewName("OnCall/OnCallSupportForm");
        } else {
            onCall.setUserMasterId(userMasterId);
            onCall.setStatus(0);

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String currentDate = dateFormat1.format(new Date());
            onCall.setDateOfSubmit(currentDate);
            onCallService.create(onCall);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            try {
                mailSendOnCallApply(request);
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                // id 163 is for On Call apply....
                emailTemplate = emailTemplateService.readById(163);
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
        mv.getModelMap().put("onCall", onCall);
        mv = view(request, response);
        return mv;
    }

    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        int id = user.getId();
        List<?> list = onCallService.userWiseOnCallList(id);
        List<?> list1 = onCallService.userReportingManager(id);
        EmployeeMaster employeeMaster = new EmployeeMaster();

        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        if (!list1.isEmpty()) {
            employeeMaster = (EmployeeMaster) list1.get(0);
            employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
        }
        mv.getModelMap().put("managerName", employeeMaster1.getEmployeeName());
        mv.getModelMap().put("list", list);

        mv.getModelMap().put("onCall", onCall);
        mv.setViewName("OnCall/OnCallViewList");
        return mv;
    }

    public ModelAndView editClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
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

        onCall = onCallService.readById(Integer.parseInt(id));
        int status1 = onCall.getStatus();
        String status = Integer.toString(status1);
        String remark = onCall.getManagerRemark();
        request.setAttribute("remark", remark);
        request.setAttribute("status", status);
        mv.getModelMap().put("onCall", onCall);
        mv.setViewName("OnCall/OnCallViewEdit");
        return mv;
    }

    public ModelAndView approvalSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        int id = employeeMaster.getId();
        List<?> list = onCallService.approvalmanagerWiseOnCallList(id);
        List<?> list1 = onCallService.userReportingManager(id);
        String managerName = "";
        if (!list1.isEmpty()) {
            employeeMaster = (EmployeeMaster) list1.get(0);
            if (!employeeMaster.getReportingManagerLevel1().equals("")) {
                List<?> reportingmanagerNameList = employeeMasterService.readByEmployeeLevel1Id(employeeMaster);
                if (!reportingmanagerNameList.isEmpty()) {
                    Object[] o = (Object[]) reportingmanagerNameList.get(0);
                    managerName = (String) o[2];
                }
            }
        }
        mv.getModelMap().put("managerName", managerName);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("onCall", onCall);
        mv.setViewName("OnCall/OnCallApprovalResult");
        return mv;
    }

    public ModelAndView editClickByManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String id = request.getParameter("id");
        onCall = onCallService.readById(Integer.parseInt(id));
        int status1 = onCall.getStatus();
        String status = Integer.toString(status1);
        request.setAttribute("status", status);
        String remarkNmame = onCall.getManagerRemark();
        request.setAttribute("remarkNmame", remarkNmame);
        int userId = onCall.getUserMasterId();
        UserMaster user = new UserMaster();
        user.setId(userId);
        employeeMaster.setUserMaster(user);
        List<?> empDetailList = employeeMasterService.readEmployeeDetailUserIdWise(employeeMaster);
        if (!empDetailList.isEmpty()) {
            request.setAttribute("employeeMaster", empDetailList.get(0));
            Object[] arrayOfObject = (Object[]) empDetailList.get(0);
            String reportmanager = (String) arrayOfObject[6];
        }

        mv.getModelMap().put("onCall", onCall);
        mv.setViewName("OnCall/OnCallApprovaledit");
        return mv;
    }

    public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
        OnCall onCall1 = new OnCall();
        bind(request, onCall);
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        String id = request.getParameter("id");
        String btnSubmit = request.getParameter("btnSubmit");
        onCall1 = onCallService.readById(onCall.getId());
        if (btnSubmit.equals("Submit")) {

            if (onCall1.getStatus() == 2) {
                onCall.setStatus(0);
                onCall.setManagerRemark(onCall1.getManagerRemark());
                onCall.setUserMasterId(onCall1.getUserMasterId());
            } else {
                onCall.setStatus(0);
                onCall.setUserMasterId(onCall1.getUserMasterId());
                
            }
            try {

                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
                    EmployeeMaster EmployeeHR = new EmployeeMaster();
                    EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    //id=14 is for attandence regularization Apply...
                    emailTemplate = emailTemplateService.readById(163);
                    String EmpStr = request.getParameter("empid");
                    if (null != EmpStr && !"".equals(EmpStr)) {
                        int Empid = Integer.parseInt(EmpStr);
                        List list = employeeMasterService.readByEmployeeNo(Empid);
                        if (!list.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list.get(0);
                            String To = EmployeeHR.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                            String name = "OnCall";
                            EmailAddMaster emailAddMaster = new EmailAddMaster();
                            emailAddMaster.setModuleName(name);
                            emailAddMaster.setDepartmentMaster(employeeMasterModel.getDepartmentMaster());
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
                                        msg1 = msg1.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from1, To1, subject1, msg1);

                                    }

                                }
                            }
                            List<?> allDeptmailList = emailAddMasterService.readAllDept(name);
                            if (!allDeptmailList.isEmpty()) {
                                EmailAddMaster emailAddMaster1 = (EmailAddMaster) allDeptmailList.get(0);
                                String emailId = emailAddMaster1.getEmailId();
                                for (String emailId1 : emailId.split(",")) {
                                    if (!emailId1.equals("")) {
                                        String To1 = emailId1;
                                        String from1 = employeeMasterModel.getOfficeEmailId();
                                        String subject1 = emailTemplate.getSubject();
                                        subject1 = subject1.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                                        String msg1 = emailTemplate.getBodytext();
                                        msg1 = msg1.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                        msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                        sendMail.sendMail(from1, To1, subject1, msg1);
                                    }
                                }
                            }

                        }

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");

        } else if (btnSubmit.equals("Withdraw")) {
            onCall.setStatus(4);
            onCall.setManagerRemark(onCall1.getManagerRemark());
            onCall.setUserMasterId(onCall1.getUserMasterId());

            try {

                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                EmployeeMaster EmployeeHR = new EmployeeMaster();
                EmployeeHR = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                //id=18 is for On call withdrow...
                emailTemplate = emailTemplateService.readById(167);
                String EmpStr = request.getParameter("empid");
                if (null != EmpStr && !"".equals(EmpStr)) {
                    int Empid = Integer.parseInt(EmpStr);
                    List list = employeeMasterService.readByEmployeeNo(Empid);
                    if (!list.isEmpty()) {
                        employeeMaster1 = (EmployeeMaster) list.get(0);
                        String To = EmployeeHR.getOfficeEmailId();
                        String from = employeeMasterModel.getOfficeEmailId();
                        String Subject = emailTemplate.getSubject();
                        Subject = Subject.replaceAll("\\{user\\}", employeeMasterModel.getEmployeeName());
                        String msg = emailTemplate.getBodytext();
                        msg = msg.replaceAll("\\{to_user\\}", EmployeeHR.getEmployeeName());
                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                        sendMail.sendMail(from, To, Subject, msg);

                    }

                }

            } catch (Exception e) {
            }
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String currentDate = dateFormat1.format(new Date());
        onCall.setDateOfSubmit(currentDate);
        onCallService.createOrUpdate(onCall);
        mv.getModelMap().put("onCall", onCall);
        mv = view(request, response);
        return mv;
    }

    public ModelAndView approvalbyManagerSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        OnCall onCall = new OnCall();
        String id = request.getParameter("id");

        onCall.setId(Integer.parseInt(id));
        String btnSubmit = request.getParameter("btnSubmit");
        onCall = onCallService.readById(Integer.parseInt(id));
        int status = onCall.getStatus();
        if (btnSubmit.equals("APPROVE")) {
            if (status == 0) {
                onCall.setStatus(3);
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();

                    List<?> allhrlist = userRightMasterService.readallHRList();

                    if (!allhrlist.isEmpty()) {

                        for (Object obj : allhrlist) {
                            UserRightMaster userRightMaster = new UserRightMaster();
                            EmployeeMaster employeeMaster2 = new EmployeeMaster();
                            userRightMaster = (UserRightMaster) obj;
                            List list = employeeMasterService.readByUserId(userRightMaster.getUserMaster().getId());
                            if (!list.isEmpty()) {

                                for (Object obj1 : list) {
                                    employeeMaster2 = (EmployeeMaster) obj1;
                                    emailTemplate = emailTemplateService.readById(164);

                                    String To = employeeMaster2.getOfficeEmailId();
                                    String from = employeeMasterModel.getOfficeEmailId();
                                    String Subject = emailTemplate.getSubject();
                                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                    String msg = emailTemplate.getBodytext();
                                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from, To, Subject, msg);
                                }

                            }

                        }
                    }
                    //id=69 is for attandence regularization approve to employee...
                    emailTemplate = emailTemplateService.readById(164);
                    String EmpStr = request.getParameter("empid");
                    if (null != EmpStr && !"".equals(EmpStr)) {
                        int Empid = Integer.parseInt(EmpStr);
                        List list = employeeMasterService.readByEmployeeNo(Empid);
                        if (!list.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster1.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                        }

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (status == 4) {
                onCall.setStatus(5);
                 try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();

                    List<?> allhrlist = userRightMasterService.readallHRList();

                    if (!allhrlist.isEmpty()) {

                        for (Object obj : allhrlist) {
                            UserRightMaster userRightMaster = new UserRightMaster();
                            EmployeeMaster employeeMaster2 = new EmployeeMaster();
                            userRightMaster = (UserRightMaster) obj;
                            List list = employeeMasterService.readByUserId(userRightMaster.getUserMaster().getId());
                            if (!list.isEmpty()) {

                                for (Object obj1 : list) {
                                    employeeMaster2 = (EmployeeMaster) obj1;
                                    emailTemplate = emailTemplateService.readById(167);

                                    String To = employeeMaster2.getOfficeEmailId();
                                    String from = employeeMasterModel.getOfficeEmailId();
                                    String Subject = emailTemplate.getSubject();
                                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster2.getEmployeeName());
                                    String msg = emailTemplate.getBodytext();
                                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster2.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                    sendMail.sendMail(from, To, Subject, msg);
                                }

                            }

                        }
                    }
                    //id=69 is for attandence regularization approve to employee...
                    emailTemplate = emailTemplateService.readById(167);
                    String EmpStr = request.getParameter("empid");
                    if (null != EmpStr && !"".equals(EmpStr)) {
                        int Empid = Integer.parseInt(EmpStr);
                        List list = employeeMasterService.readByEmployeeNo(Empid);
                        if (!list.isEmpty()) {
                            employeeMaster1 = (EmployeeMaster) list.get(0);
                            String To = employeeMaster1.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);

                        }

                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
                
                
                
            }
        } else if (btnSubmit.equals("REJECT")) {
            onCall.setStatus(1);
            try {

                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                UserMaster userMaster = new UserMaster();
                userMaster.setId(onCall.getUserMasterId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                employeeMaster1.setUserMaster(userMaster);
                List list = employeeMasterService.readByUserName(employeeMaster1);
                //id=17 is for attandence regularization reject...
                emailTemplate = emailTemplateService.readById(166);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
                if (!list.isEmpty()) {
                    employeeMaster1 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster1.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);

//                }
                }

            } catch (Exception e) {
            }
        } else if (btnSubmit.equals("REWORK")) {
            if (status == 0) {
                onCall.setStatus(2);

            } else if (status == 4) {
                onCall.setStatus(2);
            }
            try {

                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                //id=16 is for attandence regularization rework...
                emailTemplate = emailTemplateService.readById(165);
                UserMaster userMaster = new UserMaster();
                userMaster.setId(onCall.getUserMasterId());
                employeeMaster1.setUserMaster(userMaster);
                List<?> list = employeeMasterService.readByUserName(employeeMaster1);
//            String EmpStr = request.getParameter("empid");
//            if (null != EmpStr && !"".equals(EmpStr)) {
//                int Empid = Integer.parseInt(EmpStr);
//                List list = employeeMasterService.readByEmployeeNo(Empid);
                if (!list.isEmpty()) {
                    employeeMaster1 = (EmployeeMaster) list.get(0);
                    String To = employeeMaster1.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeMaster1.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);

                }

            } catch (Exception e) {

            }
        }
        bind(request, onCall);
        EmployeeMaster approverName = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String currentDate = dateFormat1.format(new Date());
        onCall.setApprovedDate(currentDate);
        onCall.setEmployeeMaster(approverName);
        onCallService.update(onCall);
        mv.getModelMap().put("onCall", onCall);
        mv = approvalSubmit(request, response);
        return mv;
    }

}
