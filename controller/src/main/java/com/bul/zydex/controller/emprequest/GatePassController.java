/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.GatePass;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinita
 */
public class GatePassController extends GatePassAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster.getId().toString();
        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            gatePass.setSecurityRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            gatePass.setApproveDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            gatePass.setRequestDate(endDate);
        }
//        List<?> list = gatePassService.readSearchEmpRequest(gatePass);
        List<?> list = gatePassService.readByEmpId(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv.getModelMap().put("list", list);
        mv.setViewName("GatePass/GatePassResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/GatePassCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        BindException errors = new BindException(gatePass, "gatePass");
        bind(request, gatePass);
        Integer empid = gatePass.getEmployeeMasterByEmployeeMasterId().getId();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(empid);
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        boolean flag = false;
        gatePassValidator.validate(gatePass, errors);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("GatePass/GatePassCreate");
        } else {
            String requestdate = sdf.format(new Date());
            gatePass.setRequestDate(requestdate);
            gatePass.setStatus(1);
            if (gatePass.isGatePassType()) {
                gatePass.setReturnFlag(Boolean.FALSE);
            }
            if (!gatePassService.isExist(gatePass)) {
                gatePassService.create(gatePass);
                //       Email Sent to ReportingManager1
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    // id 36 is for GatePass apply status
                    emailTemplate = emailTemplateService.readById(36);
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
                        "Information : Request Sent Successfully.");
                request.setAttribute("gatePass", gatePass);
            } else {
                flag = true;
                request.setAttribute("failureMessage",
                        "Error : Request Already Exists");
            }
            mv = searchSubmit(request, response);
        }
        return mv;
    }

    // <---------Approve Cycle---------->
    public ModelAndView searchApproverSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        gatePass.setEmployeeMasterByApproverId(employeeMaster);
        List<?> list = gatePassService.readByrequesteeId(gatePass);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/GatePassApproverResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/GatePassApproverView");
        return mv;
    }

    public ModelAndView aprroveClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));

        String approvedate = sdf.format(new Date());
        gatePass.setApproveDate(approvedate);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        gatePass.setEmployeeMasterByApproverId(employeeMaster);

        if (null != statusType) {
            if (statusType.equals("3")) {
                gatePass.setStatus(3);
                gatePass.setRejectRemark(remark);
                gatePassService.update(gatePass);
                request.setAttribute("successMessage",
                        "Information : Request Rejected Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = gatePassService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 39 is for status GatePass Reject
                    emailTemplate = emailTemplateService.readById(39);
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
            } else if (statusType.equals("6")) {
                gatePass.setStatus(6);
                gatePass.setRejectRemark(remark);
                gatePassService.update(gatePass);
                request.setAttribute("successMessage",
                        "Information : Request Returned Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = gatePassService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 38 is for status GatePass Rework
                    emailTemplate = emailTemplateService.readById(38);
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
        } else {
            gatePass.setStatus(2);
            gatePassService.update(gatePass);
            request.setAttribute("successMessage",
                    "Information : Request Approved Successfully.");
            //    Email Sent to Security
            List<?> SecurityList = userRightMasterService.readSecurityList();
            for (Object o : SecurityList) {
                Object[] o1 = (Object[]) o;
                int SecurityId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(SecurityId);
                    List l1 = gatePassService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 37 is for status GatePass Approve (Security Notification)
                    emailTemplate = emailTemplateService.readById(37);
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
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = gatePassService.readEmpIdFromTabId(Integer.parseInt(id));
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 52 is for status GatePass Approve (Employee Notification)
                emailTemplate = emailTemplateService.readById(52);
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
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    public ModelAndView securityApproveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        if (!"".equals(empId) && null != empId) {
            employeeMaster1.setId(Integer.parseInt(empId));
        }
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
        if (!"".equals(departmentId) && null != departmentId) {
            gatePass.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            gatePass.setRejectRemark(designationId);
        }
        if (!"".equals(status) && null != status) {
            gatePass.setSecurityRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            gatePass.setApproveDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            gatePass.setRequestDate(endDate);
        }
//        List<?> list = gatePassService.readSearchRequest(gatePass);
        List<?> Securitylist = gatePassService.readByapproverId(gatePass);
        mv.getModelMap().put("Securitylist", Securitylist);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        session.setAttribute("Securitylist11", Securitylist);
        mv.setViewName("GatePass/GatePassSecurityResult");
        return mv;
    }

    public ModelAndView viewSecurityClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/GatePassSecurityView");
        return mv;
    }

    public ModelAndView securityAprroveClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("securityRemark");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        gatePass.setEmployeeMasterBySecurityApproverId(employeeMaster);

        if (null != statusType) {
            if (statusType.equals("5")) {
                gatePass.setStatus(5);
                gatePass.setSecurityRemark(remark);
                gatePassService.update(gatePass);
                request.setAttribute("successMessage",
                        "Information : Request Rejected Successfully.");
            } else if (statusType.equals("7")) {
                gatePass.setStatus(7);
                gatePass.setSecurityRemark(remark);
                gatePassService.update(gatePass);
                request.setAttribute("successMessage",
                        "Information : Request Returned Successfully.");
            }
        } else {
            gatePass.setStatus(4);
            gatePassService.update(gatePass);
            request.setAttribute("successMessage",
                    "Information : Request Approved Successfully.");
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = gatePassService.readEmpIdFromTabId(Integer.parseInt(id));
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 41 is for status GatePass Exit Confirmed
                emailTemplate = emailTemplateService.readById(41);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

                String name = "Gate Pass";
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

                        }
                    }
                }
            } catch (Exception e) {

            }
        }
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv = securityApproveSubmit(request, response);
        return mv;
    }

    // <---------Return Cycle---------->
    public ModelAndView EmpviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        EmployeeMaster employee = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster = employeeMasterService.readById(employee.getId());
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        gatePass.setRejectRemark(gatePass.getRejectRemark());
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/EmpView");
        return mv;
    }

    public ModelAndView returnCreateSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        GatePass gatePass1 = new GatePass();
        String id = request.getParameter("id");
        BindException errors = new BindException(gatePass, "gatePass");
        bind(request, gatePass1);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("GatePass/EmpView");
        } else {
            if (gatePass1.getId() == null) {
                gatePass = gatePassService.readById(Integer.parseInt(id));
            }
            String btn = (String) request.getParameter("btnType");
            if (btn.equals("Submit")) {
                if (gatePass.getStatus() == 6) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String requestdate = sdf.format(new Date());
                    gatePass.setRequestDate(requestdate);
                    gatePass.setStatus(8);
                    gatePass.setReason(gatePass1.getReason());
                    gatePass.setMaterialTakenToPersonName(gatePass1.getMaterialTakenToPersonName());
                    gatePass.setMaterialTakenToPersonMobileNo(gatePass1.getMaterialTakenToPersonMobileNo());
                    gatePass.setMaterialTakenToPersonLandlineNo(gatePass1.getMaterialTakenToPersonLandlineNo());
                    gatePass.setMaterialOutDateTime(gatePass1.getMaterialOutDateTime());
                    gatePass.setMaterialCarryingPersonName(gatePass1.getMaterialCarryingPersonName());
                    gatePass.setMaterialCarryingPersonCntctNo(gatePass1.getMaterialCarryingPersonCntctNo());
                    gatePass.setDestination(gatePass1.getDestination());
                    gatePass.setAssetValue(gatePass1.getAssetValue());
                    gatePass.setAssetIdentityNo(gatePass1.getAssetIdentityNo());
                    gatePass.setAssetDescription(gatePass1.getAssetDescription());
                    if (gatePass1.isGatePassType()) {
                        gatePass.setGatePassType(true);
                        gatePass.setExpectedReturnDateTime(gatePass1.getExpectedReturnDateTime());
                    } else {
                        gatePass.setGatePassType(false);
                    }
                    if (gatePass.isGatePassType()) {
                        gatePass.setReturnFlag(Boolean.FALSE);
                    }
                    gatePassService.update(gatePass);
                    request.setAttribute("successMessage",
                            "Information :Return Request Sent Successfully.");
                    //       Email Sent to ReportingManager1
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                        // id 53 is for GatePass Rework Submitted
                        emailTemplate = emailTemplateService.readById(53);
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
                    mv.getModelMap().put("gatePass", gatePass);
                    mv = searchSubmit(request, response);
                }
            }
//   empwithdraw    
            if (btn.equals("Withdraw")) {
                if (gatePass.getStatus() == 1 || gatePass.getStatus() == 4 || gatePass.getStatus() == 2 || gatePass.getStatus() == 6 || gatePass.getStatus() == 8) {
                    if (gatePass.getStatus() == 1) {
                        gatePassService.delete(Integer.parseInt(id));
                        request.setAttribute("successMessage",
                                "Information : Request Withdrawed Successfully.");
                        mv = searchSubmit(request, response);
                    } else if (gatePass.getStatus() == 4 || gatePass.getStatus() == 2 || gatePass.getStatus() == 6 || gatePass.getStatus() == 8) {
                        gatePass.setStatus(14);
                        gatePass.setReason(gatePass1.getReason());
                        gatePass.setMaterialTakenToPersonName(gatePass1.getMaterialTakenToPersonName());
                        gatePass.setMaterialTakenToPersonMobileNo(gatePass1.getMaterialTakenToPersonMobileNo());
                        gatePass.setMaterialTakenToPersonLandlineNo(gatePass1.getMaterialTakenToPersonLandlineNo());
                        gatePass.setMaterialOutDateTime(gatePass1.getMaterialOutDateTime());
                        gatePass.setMaterialCarryingPersonName(gatePass1.getMaterialCarryingPersonName());
                        gatePass.setMaterialCarryingPersonCntctNo(gatePass1.getMaterialCarryingPersonCntctNo());
                        gatePass.setDestination(gatePass1.getDestination());
                        gatePass.setAssetValue(gatePass1.getAssetValue());
                        gatePass.setAssetIdentityNo(gatePass1.getAssetIdentityNo());
                        gatePass.setAssetDescription(gatePass1.getAssetDescription());
                        if (gatePass1.isGatePassType()) {
                            gatePass.setGatePassType(true);
                            gatePass.setExpectedReturnDateTime(gatePass1.getExpectedReturnDateTime());
                        } else {
                            gatePass.setGatePassType(false);
                        }
                        if (gatePass.isGatePassType()) {
                            gatePass.setReturnFlag(Boolean.FALSE);
                        }
                        gatePassService.update(gatePass);
                        request.setAttribute("successMessage",
                                "Information :Return Request Sent Successfully.");
                        //       Email Sent to ReportingManager1
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                            // id 53 is for GatePass Rework Submitted
                            emailTemplate = emailTemplateService.readById(53);
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
                        mv.getModelMap().put("gatePass", gatePass);
                        mv = searchSubmit(request, response);
                    }
                }
                //       Email Sent to ReportingManager1
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                    // id 40 is for GatePass Withdraw
                    emailTemplate = emailTemplateService.readById(40);
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
                //    Email Sent to Security
                List<?> SecurityList = userRightMasterService.readSecurityList();
                for (Object o : SecurityList) {
                    Object[] o1 = (Object[]) o;
                    int SecurityId = (int) o1[0];
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(SecurityId);
                        // id 40 is for GatePass Withdraw
                        emailTemplate = emailTemplateService.readById(40);
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

//                }
//            }
            }
//    withdrawreturnSubmit        
//            if (gatePass.getStatus() == 16) {
//                gatePass = gatePassService.readById(Integer.parseInt(id));
//                gatePass.setStatus(18);
//                gatePass.setReason(gatePass1.getReason());
//                gatePassService.update(gatePass);
//                request.setAttribute("successMessage",
//                        "Information : Request Sent Successfully.");
//                mv.getModelMap().put("gatePass", gatePass);
//                mv = searchSubmit(request, response);
//            }
        }
        return mv;
    }

    public ModelAndView aprroveReturnClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        String approvedate = sdf.format(new Date());
        gatePass.setApproveDate(approvedate);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        gatePass.setEmployeeMasterByApproverId(employeeMaster);
        gatePass.setStatus(9);
        request.setAttribute("successMessage",
                "Information : Request Approved Successfully.");
        gatePassService.update(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    //    <---------Return Gate Pass (rgp)---------->
    public ModelAndView rgpresult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        List<?> list = gatePassService.readforReturn(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv.getModelMap().put("list", list);
        mv.setViewName("GatePass/RGPResult");
        return mv;
    }

    public ModelAndView rgpview(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/RGPView");
        return mv;
    }

    public ModelAndView rgpsubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        gatePass.setReturnFlag(Boolean.TRUE);
        String returndate = sdf.format(new Date());
        gatePass.setReturnDate(returndate);
        gatePassService.update(gatePass);
        request.setAttribute("successMessage",
                "Information : Returnable Gatepass Inward Confirmed.");
        //    Email Sent to Employee
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            List l1 = gatePassService.readEmpIdFromTabId(Integer.parseInt(id));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            // id 42 is for status GatePass Inward Confirm
            emailTemplate = emailTemplateService.readById(42);
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
        mv.getModelMap().put("gatePass", gatePass);
        mv = rgpresult(request, response);
        return mv;
    }

    //    <---------Withdraw Cycle---------->
    public ModelAndView approverwithdraw(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("13")) {
                gatePass.setStatus(13);
                gatePass.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("16")) {
                gatePass.setStatus(16);
                gatePass.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Returned Successfully.");

            }
        } else {
            gatePass.setStatus(12);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Approved Successfully.");
        }
        gatePassService.createOrUpdate(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    public ModelAndView adminAprrovewithdrawClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("15")) {
                gatePass.setStatus(15);
                gatePass.setSecurityRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("17")) {
                gatePass.setStatus(17);
                gatePass.setSecurityRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Returned Successfully.");
            }
        } else {
            gatePass.setStatus(14);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Approved Successfully.");
        }
        gatePassService.update(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv = securityApproveSubmit(request, response);
        return mv;
    }

    public ModelAndView withdrawapprovereturn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        String id = request.getParameter("id");
        bind(request, gatePass);
        gatePass = gatePassService.readById(Integer.parseInt(id));
        gatePass.setStatus(19);
        request.setAttribute("successMessage",
                "Information :Withdraw Request Approved Successfully.");
        gatePassService.update(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    //    <---------Search ---------->(functionality shifted)
    public ModelAndView searchEmpClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/GatePassSearch");
        return mv;
    }

    public ModelAndView searchEmpResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();

        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster.getId().toString();
        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!status.equals("")) {
            gatePass.setSecurityRemark(status);
        }
        if (!startDate.equals("")) {
            gatePass.setApproveDate(startDate);
        }
        if (!endDate.equals("")) {
            gatePass.setRequestDate(endDate);
        }
        List<?> list = gatePassService.readSearchEmpRequest(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv.getModelMap().put("list", list);
        mv.setViewName("GatePass/GatePassSearchResult");
        return mv;
    }

    public ModelAndView searchSecurityClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        mv.getModelMap().put("gatePass", gatePass);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("GatePass/SecurityGatePassSearch");
        return mv;
    }

    public ModelAndView searchSecurityResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!departmentId.equals("")) {
            gatePass.setReason(departmentId);
        }
        if (!designationId.equals("")) {
            gatePass.setRejectRemark(designationId);
        }
        if (!status.equals("")) {
            gatePass.setSecurityRemark(status);
        }
        if (!startDate.equals("")) {
            gatePass.setApproveDate(startDate);
        }
        if (!endDate.equals("")) {
            gatePass.setRequestDate(endDate);
        }
        List<?> list = gatePassService.readSearchRequest(gatePass);
        mv.getModelMap().put("gatePass", gatePass);
        mv.getModelMap().put("list", list);
        mv.setViewName("GatePass/SecurityGatePassSearchResult");
        return mv;
    }

    public ModelAndView userDashboardGetPassPendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = gatePassService.readByGatePassPendingRequest(gatePass);
        int i = gatePassService.countByGatePassPendingRequest(gatePass);
        int gatePassPending = list.size();
        request.setAttribute("gatePassPending", gatePassPending);
        List<?> list1 = gatePassService.readByGatePassApproverPendingRequest(gatePass);
        int j = gatePassService.countByGatePassApproverPendingRequest(gatePass);
        
        int gatePassApproverPending = list1.size();
        request.setAttribute("gatePassApproverPending", gatePassApproverPending);
        mv.setViewName("forward:cafeteriaRequest.htm?act=userDashboardCafeTeriaPendingRequest");
        return mv;
    }

    public ModelAndView searchPendingGatePassRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        GatePass gatePass = new GatePass();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        gatePass.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> gatePendingList = gatePassService.readByGatePassPendingRequest(gatePass);
        mv.getModelMap().put("list", gatePendingList);
        mv.getModelMap().put("gatePass", gatePass);
        mv.setViewName("GatePass/gatepasspendingDashboard");

        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> Securitylist = (List<?>) request.getSession().getAttribute("Securitylist11");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=GatePassDetail.xls");
        mv.addObject("Securitylist", Securitylist);
        mv.setViewName("GatePass/ExportGatePassSecurityResult");
        return mv;
    }
}
