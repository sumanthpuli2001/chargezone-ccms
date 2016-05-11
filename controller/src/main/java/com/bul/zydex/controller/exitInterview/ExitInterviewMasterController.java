/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.exitInterview;

import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExitInterviewMaster;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.model.ZydexLocationMaster;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ExitInterviewMasterController extends ExitInterviewMasterAbstract {

    public ModelAndView createClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        UserMaster user = (UserMaster) request.getSession().getAttribute("user");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        String manager = employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        int locationId = employeeMaster.getLocationMaster().getId();
        int zydexlocationId = employeeMaster.getZydexLocationMaster().getId();
        LocationMaster locationmaster = new LocationMaster();
        locationmaster = locationMasterService.readById(locationId);
        ZydexLocationMaster zydexLocationMaster = new ZydexLocationMaster();
        zydexLocationMaster = zydexLocationMasterService.readById(zydexlocationId);
        levelMaster = levelMasterService.readById(levelId);
        designationMaster = designationMasterService.readById(desigId);
        departmentMaster = departmentMasterService.readById(deptId);
        employeeMaster.setZydexLocationMaster(zydexLocationMaster);
        employeeMaster.setLocationMaster(locationmaster);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);
        setStatus(request);
        setStatus1(request);
        setStatus2(request);
        setStatus3(request);
        request.setAttribute("list", empList);
        mv.getModelMap().put("exitInterviewMaster", exitInterviewMaster);
        mv.setViewName("ExitInterview/ExitInterviewCreate");

        return mv;
    }
//createsubmit

    public ModelAndView submitExitInterviewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final Boolean existingExitDataToggle = true;
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        //this is toggle of isExistingExitDataExist setted on dashboard page @ first time login.
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        bind(request, exitInterviewMaster);
        BindException errors = new BindException(exitInterviewMaster, "exitInterviewMaster");
        int empid = Integer.parseInt(request.getParameter("empId"));
        int approverid = Integer.parseInt(request.getParameter("approverId"));
        int approverid2 = 0;
        if (request.getParameter("approverId2").equals("")) {
            approverid2 = 1;
        } else {
            approverid2 = Integer.parseInt(request.getParameter("approverId2"));
        }
        employeeMaster.setId(empid);
        employeeMaster1.setId(approverid);
        employeeMaster2.setId(approverid2);
        exitInterviewMaster.setEmployeeMasterByEmpId(employeeMaster);
//        exitInterviewMaster.setEmployeeMasterByApproverId(employeeMaster1);
//        exitInterviewMaster.setEmployeeMasterByApproverId2(employeeMaster2);
        exitInterviewMasterValidator.validate(exitInterviewMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
            mv = createClick(request, response);
        } else {
            exitInterviewMaster.setStatus(1);
            exitInterviewMasterService.create(exitInterviewMaster);
            session.setAttribute("isExistingExitDataExist", existingExitDataToggle);
            request.setAttribute("successMessage",
                    "Information : The Information is saved Successfully.");
            mv.setViewName("forward:userMaster.htm?act=goToDashboard");//method name changed from userDashboard.
            //    Email Sent to ReportingManager1
//                      try {
//                            EmailTemplate emailTemplate = new EmailTemplate();
//                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                            DesignationMaster designationMaster = new DesignationMaster();
//                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//            // id 81 is for status Exit Interview Submitted
//                            emailTemplate = emailTemplateService.readById(81);
//                            String To = employeeMasterHr.getOfficeEmailId();
//                            String from = employeeMasterModel.getOfficeEmailId();
//                            String Subject = emailTemplate.getSubject();
//                            String msg = emailTemplate.getBodytext();
//                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                            sendMail.sendMail(from, To, Subject, msg);
//                        } catch (Exception e) {
//
//                        }
//            Email Sent to ExitInterviewHR
            List<?> ExitInterviewHRList = userRightMasterService.readExitInterviewRightsList();
            for (Object o : ExitInterviewHRList) {
                Object[] o1 = (Object[]) o;
                int AdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(AdminId);
                    // id 81 is for status Exit Interview Accepted by Manager (Email to HR)
                    emailTemplate = emailTemplateService.readById(81);
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
        return mv;
    }

    //Approverresult
    public ModelAndView ExitApproveresult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        exitInterviewMaster.setEmployeeMasterByApproverId(employeeMaster);
        int empid = employeeMaster.getId();
        int exitcount = 0;
        List<?> finalList = new ArrayList<Object>();
//        List<List<?>> finalList = new ArrayList<>();
        List<?> list1 = exitInterviewMasterService.readByEmployeeId(empid);
        if (!list1.isEmpty()) {
            String dateOfSubmit = "";
            for (Object o : list1) {
                Object[] o1 = (Object[]) o;
                String abc = "" + o1[0];
                String abc1 = "" + o1[1];
                String abc2 = "" + o1[2];
                dateOfSubmit = "" + o1[3];
                int tabId = Integer.parseInt("" + o1[4]);
                finalList = exitInterviewMasterService.readExitApprovalList(empid, tabId);
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                Date date = sdf.parse(dateOfSubmit);
//                Date today = Calendar.getInstance().getTime();
//                Calendar c = Calendar.getInstance();
//                c.setTime(date); // Now use today date.
//                c.add(Calendar.DATE, 15);
//                Date output = c.getTime();

//                if (output.after(today)) {
//                    System.out.println("Date1 is after Date2");
//                    exitList = exitInterviewMasterService.readExitApprovalList(empid, tabId);
//                }
//
//                if (output.before(today)) {
//                    System.out.println("Date1 is before Date2");
//                    exitList = exitInterviewMasterService.readExitApproval2List(empid, tabId);
//                }
//
//                if (output.equals(today)) {
//                    System.out.println("Date1 is equal Date2");
//                    exitList = exitInterviewMasterService.readExitApprovalList(empid, tabId);
//                }
//                if (exitList.size() > 0) {
//                    finalList.add(exitList);
//                }
            }
        }

        request.setAttribute("finalList", finalList);
        mv.setViewName("ExitInterview/exitApproverResult");
        return mv;
    }

//appview
    public ModelAndView createApproveOrReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster;
        EmployeeMaster employeeMaster = new EmployeeMaster();
        int empid = Integer.parseInt(request.getParameter("empID"));
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        employeeMaster = employeeMasterService.readById(empid);
//         HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        String manager = employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
//        if (!list.isEmpty()) {
        request.setAttribute("reportingLevel1", list.get(0));
//        }
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        levelMaster = levelMasterService.readById(levelId);
        designationMaster = designationMasterService.readById(desigId);
        departmentMaster = departmentMasterService.readById(deptId);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);
        int locationId = employeeMaster.getLocationMaster().getId();
        LocationMaster locationmaster = new LocationMaster();
        locationmaster = locationMasterService.readById(locationId);
        employeeMaster.setLocationMaster(locationmaster);
        int id = Integer.parseInt(request.getParameter("id"));
        setStatus(request);
        setStatus1(request);
        setStatus2(request);
        exitInterviewMaster = exitInterviewMasterService.readById(id);

        request.setAttribute("id", id);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("exitInterviewMaster", exitInterviewMaster);
        request.setAttribute("empid", empid);
        mv.setViewName("ExitInterview/createExitInterviewApproveOrReturn");
        return mv;
    }

//approver
    public ModelAndView submitApproveOrReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        bind(request, exitInterviewMaster);
        BindException errors = new BindException(exitInterviewMaster, "exitInterviewMaster");
        int tabId = Integer.parseInt(request.getParameter("tabId"));
        exitInterviewMaster = exitInterviewMasterService.readById(tabId);
        String btn = (String) request.getParameter("btnType");
        String empid = request.getParameter("empid");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String manager = employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        exitInterviewMasterValidator.validate(exitInterviewMaster, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : The Entered Information is not valid.");
            mv.addAllObjects(errors.getModel());
        } else {
            if (btn.equals("Approve")) {
                exitInterviewMaster.setStatus(1);
                exitInterviewMaster.setEmployeeMasterByApproverId(employeeMaster);
                exitInterviewMasterService.update(exitInterviewMaster);
                request.setAttribute("successMessage",
                        "Information : Exit Interview Accepted Successfully.");
                mv = ExitApproveresult(request, response);
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = exitInterviewMasterService.readEmpIdFromTabId(tabId);
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 86 is for status Exit Interview Accepted by Manager (Email to Employee)
                    emailTemplate = emailTemplateService.readById(86);
                    String To = employeeRequestee.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
//                Send to Concerned Department
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());

                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(empid));
                    EmployeeMaster empReportingManager = employeeMasterService.readById(Integer.parseInt(employeeRequestee.getReportingManagerLevel1()));
                    // id 86 is for status Exit Interview Accepted by Manager (Email to Employee)
                    emailTemplate = emailTemplateService.readById(129);
                    String To = empReportingManager.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", empReportingManager.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {

                }
//                Send to IT Dept
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());

                    List itAdminList = userRightMasterService.readITAdminList();
                    Iterator itr = itAdminList.iterator();
                    while (itr.hasNext()) {
                        try {

                            Object[] next = (Object[]) itr.next();
                            String itEmpId = "" + next[0];
                            EmployeeMaster employeeItAdmin = employeeMasterService.readById(Integer.parseInt(itEmpId));
// id 86 is for status Exit Interview Accepted by Manager (Email to Employee)
                            emailTemplate = emailTemplateService.readById(129);
                            String To = employeeItAdmin.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeItAdmin.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }
//                Send to Hr Dept
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());

                    List hrAdminList = userRightMasterService.readEmployeeExitRightsList();
                    Iterator itr = hrAdminList.iterator();
                    while (itr.hasNext()) {
                        try {

                            Object[] next = (Object[]) itr.next();
                            String itEmpId = "" + next[0];
                            EmployeeMaster employeeItAdmin = employeeMasterService.readById(Integer.parseInt(itEmpId));
// id 86 is for status Exit Interview Accepted by Manager (Email to Employee)
                            emailTemplate = emailTemplateService.readById(129);
                            String To = employeeItAdmin.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeItAdmin.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }
//                Send to Finance Dept
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());

                    List expenseAdminList = userRightMasterService.readExpenseAdmin();
                    Iterator itr = expenseAdminList.iterator();
                    while (itr.hasNext()) {
                        try {

                            Object[] next = (Object[]) itr.next();
                            String itEmpId = "" + next[1];
                            EmployeeMaster expenseAdmin = employeeMasterService.readById(Integer.parseInt(itEmpId));
                            emailTemplate = emailTemplateService.readById(129);
                            String To = expenseAdmin.getOfficeEmailId();
                            String from = employeeMasterModel.getOfficeEmailId();
                            String Subject = emailTemplate.getSubject();
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", expenseAdmin.getEmployeeName());
                            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from, To, Subject, msg);
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }
                //    Email Sent to ExitInterviewHR
//                List<?> ExitInterviewHRList = userRightMasterService.readExitInterviewRightsList();
//                for (Object o : ExitInterviewHRList) {
//                    Object[] o1 = (Object[]) o;
//                    int AdminId = (int) o1[0];
//                    try {
//                        EmailTemplate emailTemplate = new EmailTemplate();
//                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                        DesignationMaster designationMaster = new DesignationMaster();
//                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                        employeeMasterHr = employeeMasterService.readById(AdminId);
//                        // id 87 is for status Exit Interview Accepted by Manager (Email to HR)
//                        emailTemplate = emailTemplateService.readById(87);
//                        String To = employeeMasterHr.getOfficeEmailId();
//                        String from = employeeMasterModel.getOfficeEmailId();
//                        String Subject = emailTemplate.getSubject();
//                        String msg = emailTemplate.getBodytext();
//                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                        sendMail.sendMail(from, To, Subject, msg);
//                    } catch (Exception e) {
//
//                    }
//                }

            }
//            if (btn.equals("Return")) {
//                exitInterviewMaster.setStatus(1);
//                exitInterviewMaster.setEmployeeMasterByApproverId(employeeMaster);
//                exitInterviewMasterService.update(exitInterviewMaster);
//                request.setAttribute("successMessage",
//                        "Information : The Information is Return Successfully.");
//                mv.setViewName("forward:userMaster.htm?act=goToDashboard");//method name changed from userDashboard.
//            }
//            if (btn.equals("WithdrawApprove")) {
//                exitInterviewMaster.setStatus(6);
////                exitInterviewMaster.setEmployeeMasterByApproverId(employeeMaster);
//                exitInterviewMasterService.update(exitInterviewMaster);
//                request.setAttribute("successMessage",
//                        "Information : Withdraw Approved Successfully.");
//                mv.setViewName("forward:userMaster.htm?act=goToDashboard");//method name changed from userDashboard.
//            }
            mv.getModelMap().put("exitInterviewMaster", exitInterviewMaster);
        }
        return mv;
    }

//resultpage(all in one)
    public ModelAndView createExitApproveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        List<?> list = exitInterviewMasterService.read();
        for (Object o : list) {
            exitInterviewMaster = (ExitInterviewMaster) o;
            employeeMaster = employeeMasterService.readById(exitInterviewMaster.getEmployeeMasterByEmpId().getId());
            exitInterviewMaster.setEmployeeMasterByEmpId(employeeMaster);
        }
        request.setAttribute("list", list);
        mv.setViewName("ExitInterview/createExitInterviewApproveList");
        return mv;
    }

// emp result
    public ModelAndView EmpResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        exitInterviewMaster.setEmployeeMasterByEmpId(employeeMaster);
        List<?> list = exitInterviewMasterService.reademp(exitInterviewMaster);
        request.setAttribute("list", list);
        mv.getModelMap().put("exitInterviewMaster", exitInterviewMaster);
        mv.setViewName("ExitInterview/EmpResult");
        return mv;
    }

//emp returnview
    public ModelAndView createExitReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster;
        EmployeeMaster employeeMaster = new EmployeeMaster();
        int empid = Integer.parseInt(request.getParameter("empID"));
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        employeeMaster = employeeMasterService.readById(empid);
        String manager = employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        int locationId = employeeMaster.getLocationMaster().getId();
        LocationMaster locationmaster = new LocationMaster();
        locationmaster = locationMasterService.readById(locationId);
        employeeMaster.setLocationMaster(locationmaster);
        levelMaster = levelMasterService.readById(levelId);
        designationMaster = designationMasterService.readById(desigId);
        departmentMaster = departmentMasterService.readById(deptId);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);

        int id = Integer.parseInt(request.getParameter("id"));
        setStatus(request);
        setStatus1(request);
        setStatus2(request);
        exitInterviewMaster = exitInterviewMasterService.readById(id);

        request.setAttribute("id", id);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("exitInterviewMaster", exitInterviewMaster);
        mv.setViewName("ExitInterview/createExitReturn");
        return mv;
    }

//emp return submit
    public ModelAndView submitExitReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        bind(request, exitInterviewMaster);
        int tabId = Integer.parseInt(request.getParameter("tabId"));
        exitInterviewMaster = exitInterviewMasterService.readById(tabId);

        bind(request, exitInterviewMaster);
        exitInterviewMaster.setStatus(3);
        exitInterviewMasterService.update(exitInterviewMaster);
        request.setAttribute("successMessage",
                "Information : The Information is Submitted Successfully.");
        mv = EmpResult(request, response);
        return mv;
    }

    public ModelAndView withdraw(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        bind(request, exitInterviewMaster);
        int tabId = Integer.parseInt(request.getParameter("id"));
        exitInterviewMaster = exitInterviewMasterService.readById(tabId);
        bind(request, exitInterviewMaster);
        exitInterviewMaster.setStatus(5);
        exitInterviewMasterService.update(exitInterviewMaster);
        request.setAttribute("successMessage",
                "Information : The Information is withdrawed Successfully.");
        mv = EmpResult(request, response);
        return mv;
    }

    public ModelAndView withdrawapprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        bind(request, exitInterviewMaster);
        int tabId = Integer.parseInt(request.getParameter("id"));
        exitInterviewMaster = exitInterviewMasterService.readById(tabId);
        bind(request, exitInterviewMaster);
        exitInterviewMaster.setStatus(6);
        exitInterviewMasterService.update(exitInterviewMaster);
        request.setAttribute("successMessage",
                "Information :Withdrawed Approved Successfully.");
        mv = ExitApproveresult(request, response);
        return mv;
    }

//    hr
    public ModelAndView HRResult(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        List<?> list = exitInterviewMasterService.readforHR(exitInterviewMaster);
        request.setAttribute("list", list);
        mv.setViewName("ExitInterview/HrResult");
        return mv;
    }

    public ModelAndView HrApprove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster = new ExitInterviewMaster();
        String id = request.getParameter("id");
        exitInterviewMaster = exitInterviewMasterService.readById(Integer.parseInt(id));
//        if (exitInterviewMaster.getStatus() == 6) {
//            exitInterviewMaster.setStatus(7);
//            HttpSession session = request.getSession();
//            EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//            exitInterviewMaster.setEmployeeMasterByApproverId2(employeeMaster);
//        }
        if (exitInterviewMaster.getStatus() == 1) {
            exitInterviewMaster.setStatus(2);
            HttpSession session = request.getSession();
            EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
            exitInterviewMaster.setEmployeeMasterByApproverId2(employeeMaster);
        }
        exitInterviewMasterService.update(exitInterviewMaster);
        request.setAttribute("successMessage",
                "Information : Exit Interview Accepted Successfully.");
        mv = HRResult(request, response);
        //    Email Sent to Employee
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            List l1 = exitInterviewMasterService.readEmpIdFromTabId(Integer.parseInt(id));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            // id 88 is for status Exit Interview Accepted by HR (Email to Employee)
            emailTemplate = emailTemplateService.readById(88);
            String To = employeeRequestee.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
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
            List l1 = exitInterviewMasterService.readEmpIdFromTabId(Integer.parseInt(id));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeRequestee.getReportingManagerLevel1()));
            // id 89 is for status Exit Interview Accepted by HR
            emailTemplate = emailTemplateService.readById(89);
            String To = employeeMasterHr.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {

        }
//        mv.setViewName("forward:userMaster.htm?act=goToDashboard");//method name changed from userDashboard.
        return mv;
    }

    public ModelAndView userDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        UserRightMaster userRight = (UserRightMaster) session.getAttribute("userRight");
        int exitcount = 0;
        if ((userRight.isExitInterview())) {
            List<?> list = exitInterviewMasterService.readlist();
            exitcount = list.size();
        }
        request.setAttribute("exitcount", exitcount);
        mv.setViewName("forward:userMaster.htm?act=userDashboardShow");
        return mv;
    }
    
    public ModelAndView printClick(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ExitInterviewMaster exitInterviewMaster;
        EmployeeMaster employeeMaster = new EmployeeMaster();
        int empid = Integer.parseInt(request.getParameter("empId"));
        DesignationMaster designationMaster;
        LevelMaster levelMaster;
        DepartmentMaster departmentMaster;
        employeeMaster = employeeMasterService.readById(empid);
//         HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        String manager = employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
//        if (!list.isEmpty()) {
        request.setAttribute("reportingLevel1", list.get(0));
//        }
        int levelId = employeeMaster.getLevelMaster().getId();
        int deptId = employeeMaster.getDepartmentMaster().getId();
        int desigId = employeeMaster.getDesignationMaster().getId();
        levelMaster = levelMasterService.readById(levelId);
        designationMaster = designationMasterService.readById(desigId);
        departmentMaster = departmentMasterService.readById(deptId);
        employeeMaster.setLevelMaster(levelMaster);
        employeeMaster.setDepartmentMaster(departmentMaster);
        employeeMaster.setDesignationMaster(designationMaster);
        int locationId = employeeMaster.getLocationMaster().getId();
        LocationMaster locationmaster = new LocationMaster();
        locationmaster = locationMasterService.readById(locationId);
        employeeMaster.setLocationMaster(locationmaster);
        int id = Integer.parseInt(request.getParameter("id"));
        setStatus(request);
        setStatus1(request);
        setStatus2(request);
        exitInterviewMaster = exitInterviewMasterService.readById(id);

        request.setAttribute("id", id);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("exitInterviewMaster", exitInterviewMaster);
        request.setAttribute("empid", empid);
        mv.setViewName("ExitInterview/ExitInterviewPrint");
        return mv;
    }
}
