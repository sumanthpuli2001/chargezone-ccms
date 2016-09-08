/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.CafeteriaRequest;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
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
public class CafeteriaRequestController extends CafeteriaRequestAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = employeeMaster.getId().toString();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            cafeteriaRequest.setAdminRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            cafeteriaRequest.setApproverDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            cafeteriaRequest.setRequestDate(endDate);
        }
        List<?> cafeRequestList = cafeteriaRequestService.readByEmpId(cafeteriaRequest);
        mv.getModelMap().put("cafeRequestList", cafeRequestList);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv.setViewName("CafeteriaRequest/CafeteriaRequestResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
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
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv.setViewName("CafeteriaRequest/CafeteriaRequestCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        BindException errors = new BindException(cafeteriaRequest, "cafeteriaRequest");
        bind(request, cafeteriaRequest);
        Integer empid = cafeteriaRequest.getEmployeeMasterByEmployeeMasterId().getId();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(empid);
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        cafeteriaRequestValidator.validate(cafeteriaRequest, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("CafeteriaRequest/CafeteriaRequestCreate");
        } else {
            String requestdate = sdf.format(new Date());
            cafeteriaRequest.setRequestDate(requestdate);
            cafeteriaRequest.setStatus(1);
            cafeteriaRequestService.create(cafeteriaRequest);
            request.setAttribute("successMessage",
                    "Information : Request Sent Successfully.");
            //    Email Sent to Cafeteria Admin
            List<?> CafeAdminList = userRightMasterService.readCafeAdminList();
            for (Object o : CafeAdminList) {
                Object[] o1 = (Object[]) o;
                int CafeAdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(CafeAdminId);
                    // id 43 is for status Cafeteria Request Apply
                    emailTemplate = emailTemplateService.readById(43);
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
            request.setAttribute("cafeteriaRequest", cafeteriaRequest);
            mv = searchSubmit(request, response);
        }
        return mv;
    }

    //    <---------Admin Approver---------->
    public ModelAndView adminApproveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        HttpSession session = request.getSession();
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
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
        if (!"".equals(departmentId) && null != departmentId) {
            cafeteriaRequest.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            cafeteriaRequest.setRejectRemark(designationId);
        }
        if (!"".equals(status) && null != status) {
            cafeteriaRequest.setAdminRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            cafeteriaRequest.setApproverDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            cafeteriaRequest.setRequestDate(endDate);
        }
        String id = request.getParameter("id");
        List<?> cafeRequestList = cafeteriaRequestService.readByapproverId(cafeteriaRequest);
        mv.getModelMap().put("ApproverList", cafeRequestList);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        session.setAttribute("cafeRequestList", cafeRequestList);
        mv.setViewName("CafeteriaRequest/CafeAdminResult");
        return mv;
    }

    public ModelAndView adminViewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
//         if(!"".equals(employeeMaster.getReportingManagerLevel1())){
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, cafeteriaRequest);
        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("CafeteriaRequest/viewAdminCafeRequest");
        return mv;
    }

    public ModelAndView adminAprroveClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, cafeteriaRequest);
        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
        String approvedate = sdf.format(new Date());
        cafeteriaRequest.setApproverDate(approvedate);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        cafeteriaRequest.setEmployeeMasterByAdminApproverId(employeeMaster);
        if (null != statusType) {
            if (statusType.equals("3")) {
                cafeteriaRequest.setStatus(3);
                cafeteriaRequest.setAdminRemark(remark);
                cafeteriaRequestService.createOrUpdate(cafeteriaRequest);
                request.setAttribute("successMessage",
                        "Information : Request Rejected Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = cafeteriaRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 46 is for status Cafeteria Request Rejected
                    emailTemplate = emailTemplateService.readById(46);
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
            } else if (statusType.equals("4")) {
                cafeteriaRequest.setStatus(4);
                cafeteriaRequest.setAdminRemark(remark);
                cafeteriaRequestService.createOrUpdate(cafeteriaRequest);
                request.setAttribute("successMessage",
                        "Information : Request Returned Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = cafeteriaRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 45 is for status Cafeteria Request Returned
                    emailTemplate = emailTemplateService.readById(45);
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
            cafeteriaRequest.setStatus(2);
            cafeteriaRequestService.createOrUpdate(cafeteriaRequest);
            request.setAttribute("successMessage",
                    "Information : Request Approved Successfully.");
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = cafeteriaRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 44 is for status Cafeteria Request Approved
                emailTemplate = emailTemplateService.readById(44);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

                String name = "Cafeteria";
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
        request.setAttribute("employeeMaster", employeeMaster);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv = adminApproveSubmit(request, response);
        return mv;
    }

    //    <---------Return Cycle---------->
    public ModelAndView EmpviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        EmployeeMaster employee = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster = employeeMasterService.readById(employee.getId());
        employeeMaster.getReportingManagerLevel1();
        if (!"".equals(employeeMaster.getReportingManagerLevel1())) {

            List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
            if (!list.isEmpty()) {
                request.setAttribute("reportingLevel1", list.get(0));
            }
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        bind(request, cafeteriaRequest);
        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("CafeteriaRequest/EmpCafeView");
        return mv;
    }

    public ModelAndView returnCreateSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        CafeteriaRequest cafeteriaRequest1 = new CafeteriaRequest();
        BindException errors = new BindException(cafeteriaRequest, "cafeteriaRequest");
        bind(request, cafeteriaRequest1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String id = request.getParameter("id");
        if (cafeteriaRequest1.getId() == null) {
            cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
        }
        String btn = (String) request.getParameter("btnType");
        if (btn.equals("Submit")) {
            if (cafeteriaRequest.getStatus() == 4) {

                String requestdate = sdf.format(new Date());
                cafeteriaRequest.setRequestDate(requestdate);
                cafeteriaRequest.setStatus(5);
                cafeteriaRequest.setRequestType(cafeteriaRequest1.getRequestType());
                cafeteriaRequest.setRequestFor(cafeteriaRequest1.getRequestFor());
                cafeteriaRequest.setReason(cafeteriaRequest1.getReason());
                cafeteriaRequest.setVenue(cafeteriaRequest1.getVenue());
                cafeteriaRequest.setOrderDateTime(cafeteriaRequest1.getOrderDateTime());
                if ("SpecialMeal".equals(cafeteriaRequest1.getRequestType())) {
                    cafeteriaRequest.setSpecialMeal(cafeteriaRequest1.getSpecialMeal());
                }
                cafeteriaRequestService.update(cafeteriaRequest);
                request.setAttribute("successMessage",
                        "Information : Request Sent Successfully.");
                //    Email Sent to Cafeteria Admin
                List<?> CafeAdminList = userRightMasterService.readCafeAdminList();
                for (Object o : CafeAdminList) {
                    Object[] o1 = (Object[]) o;
                    int CafeAdminId = (int) o1[0];
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(CafeAdminId);
                        // id 56 is for status Cafeteria Rework Submitted
                        emailTemplate = emailTemplateService.readById(56);
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
                mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
                mv = searchSubmit(request, response);
            }
        }

//               empwithdraw Method
        if (btn.equals("Withdraw")) {
            if (cafeteriaRequest.getStatus() == 1 || cafeteriaRequest.getStatus() == 2
                    || cafeteriaRequest.getStatus() == 4 || cafeteriaRequest.getStatus() == 5) {
                if (cafeteriaRequest.getStatus() == 1) {
                    cafeteriaRequestService.delete(Integer.parseInt(id));
                    request.setAttribute("successMessage",
                            "Information : Request Withdrawed Successfully.");
                    mv = searchSubmit(request, response);
                } else if (cafeteriaRequest.getStatus() == 2 || cafeteriaRequest.getStatus() == 4 || cafeteriaRequest.getStatus() == 5) {
                    cafeteriaRequest.setStatus(8);
                    cafeteriaRequest.setReason(cafeteriaRequest1.getReason());
                    cafeteriaRequestService.update(cafeteriaRequest);
                    request.setAttribute("successMessage",
                            "Information : Withdraw Request Sent Successfully.");
                    mv = searchSubmit(request, response);
                }
            }
            //    Email Sent to Cafeteria Admin
            List<?> CafeAdminList = userRightMasterService.readCafeAdminList();
            for (Object o : CafeAdminList) {
                Object[] o1 = (Object[]) o;
                int CafeAdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(CafeAdminId);
                    // id 47 is for status Cafeteria Withdarw
                    emailTemplate = emailTemplateService.readById(47);
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
//            withdrawreturnSubmit Method

//        if (cafeteriaRequest.getStatus() == 9) {
//            cafeteriaRequest.setStatus(10);
//            cafeteriaRequest.setReason(cafeteriaRequest1.getReason());
//
//            cafeteriaRequestService.update(cafeteriaRequest);
//            request.setAttribute("successMessage",
//                    "Information :Withdraw Return Request Sent Successfully.");
//            mv = searchSubmit(request, response);
//        }
        return mv;
    }

    //    <---------Withdraw Cycle---------->
    public ModelAndView adminAprrovewithdrawClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, cafeteriaRequest);
        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("7")) {
                cafeteriaRequest.setStatus(7);
                cafeteriaRequest.setAdminRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("9")) {
                cafeteriaRequest.setStatus(9);
                cafeteriaRequest.setAdminRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Returned Successfully.");

            }
        } else {
            cafeteriaRequest.setStatus(8);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Approved Successfully.");
        }
        cafeteriaRequestService.update(cafeteriaRequest);
        mv = adminApproveSubmit(request, response);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        return mv;
    }

    //    <---------Search---------->
    public ModelAndView searchEmpClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv.setViewName("CafeteriaRequest/CafeEmpSearch");
        return mv;
    }

    public ModelAndView searchEmpResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster.getId().toString();
        if (!empId.equals("")) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!status.equals("")) {
            cafeteriaRequest.setAdminRemark(status);
        }
        if (!startDate.equals("")) {
            cafeteriaRequest.setApproverDate(startDate);
        }
        if (!endDate.equals("")) {
            cafeteriaRequest.setRequestDate(endDate);
        }
        List list = cafeteriaRequestService.readSearchEmpRequest(cafeteriaRequest);

        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv.getModelMap().put("list", list);
        mv.setViewName("CafeteriaRequest/CafeEmpSearchResult");
        return mv;
    }

    public ModelAndView searchAdminClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv.setViewName("CafeteriaRequest/CafeAdminSearch");
        return mv;
    }

    public ModelAndView searchAdminResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(departmentId) && null != departmentId) {
            cafeteriaRequest.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            cafeteriaRequest.setRejectRemark(designationId);
        }
        if (!"".equals(status) && null != status) {
            cafeteriaRequest.setAdminRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            cafeteriaRequest.setApproverDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            cafeteriaRequest.setRequestDate(endDate);
        }
        List<?> list = cafeteriaRequestService.readSearchRequest(cafeteriaRequest);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        request.setAttribute("flag", 1);
        request.setAttribute("cafeteriaRequest", cafeteriaRequest);
//        mv.setViewName("CafeteriaRequest/CafeAdminSearchResult");
        mv = adminApproveSubmit(request, response);
        return mv;
    }

    public ModelAndView userDashboardCafeTeriaPendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = cafeteriaRequestService.readByCafeTeriaPendingRequest(cafeteriaRequest);
        int cafeTeriaPending = list.size();
        request.setAttribute("cafeTeriaPending", cafeTeriaPending);
        List<?> list1 = cafeteriaRequestService.readByCafeTeriaApproverPendingRequest(cafeteriaRequest);
        int cafeTeriaApproverPending = list1.size();
        request.setAttribute("cafeTeriaApproverPending", cafeTeriaApproverPending);
        mv.setViewName("forward:itServiceRequest.htm?act=userDashboardItServicePendingRequest");
        return mv;
    }

    public ModelAndView searchCafeteriaPendingRequestSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        cafeteriaRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> cafeRequestList = cafeteriaRequestService.readByCafeTeriaPendingRequest(cafeteriaRequest);
        mv.getModelMap().put("cafeRequestList", cafeRequestList);
        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
        mv.setViewName("CafeteriaRequest/CafeteriaRequestDashboard");
        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
        List<?> cafeRequestList = (List<?>) request.getSession().getAttribute("cafeRequestList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=CafeteriaDetails.xls");
        mv.addObject("cafeRequestList", cafeRequestList);
        mv.setViewName("CafeteriaRequest/ExportCafeAdminResult");
        return mv;
    }
}

 //    <--------- Approver---------->
//
//    public ModelAndView searchApproverSubmit(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        cafeteriaRequest.setEmployeeMasterByApproverId(employeeMaster);
//        List<?> cafeRequestList = cafeteriaRequestService.readByrequesteeId(cafeteriaRequest);
//        mv.getModelMap().put("cafeRequestList", cafeRequestList);
//        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
//        mv.setViewName("CafeteriaRequest/CafeApproverResult");
//        return mv;
//    }
//
//    public ModelAndView viewClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        String id = request.getParameter("id");
//        String empId = request.getParameter("empId");
//        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
//        employeeMaster.getReportingManagerLevel1();
//        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
//        if (!list.isEmpty()) {
//            request.setAttribute("reportingLevel1", list.get(0));
//        }
//        bind(request, cafeteriaRequest);
//        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
//        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
//        request.setAttribute("employeeMaster", employeeMaster);
//        mv.setViewName("CafeteriaRequest/ViewCafeRequest");
//        return mv;
//    }
//
//    public ModelAndView aprroveClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String id = request.getParameter("id");
//        String statusType = request.getParameter("statusType");
//        String remark = request.getParameter("rejectRemark");
//        bind(request, cafeteriaRequest);
//        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
//        String approvedate = sdf.format(new Date());
//        cafeteriaRequest.setApproverDate(approvedate);
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
//        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
//        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
//        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
//        cafeteriaRequest.setEmployeeMasterByApproverId(employeeMaster);
//        if (null != statusType) {
//            if (statusType.equals("3")) {
//                cafeteriaRequest.setStatus(3);
//                cafeteriaRequest.setRejectRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information : Request Rejected Successfully.");
//            } else if (statusType.equals("6")) {
//                cafeteriaRequest.setStatus(6);
//                cafeteriaRequest.setRejectRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information : Request Returned Successfully.");
//            }
//        } else {
//            cafeteriaRequest.setStatus(2);
//            request.setAttribute("successMessage",
//                    "Information : Request Approved Successfully.");
//        }
//        cafeteriaRequestService.createOrUpdate(cafeteriaRequest);
//        request.setAttribute("employeeMaster", employeeMaster);
//        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
//        mv = searchApproverSubmit(request, response);
//        return mv;
//
//    }
//  <--------- ApproverReturnCycle---------->
//
//public ModelAndView aprroveReturnClick(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
//        String id = request.getParameter("id");
//        bind(request, cafeteriaRequest);
//        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        String approvedate = sdf.format(new Date());
//        cafeteriaRequest.setApproverDate(approvedate);
//        cafeteriaRequest.setStatus(9);
//        cafeteriaRequestService.update(cafeteriaRequest);
//        request.setAttribute("successMessage",
//                "Information : Request Sent Successfully.");
//        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
////        mv = searchApproverSubmit(request, response);
//        return mv;
//    }
//<--------- ApproverWithdrawCycle---------->
// public ModelAndView approverwithdraw(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
//        String id = request.getParameter("id");
//        String statusType = request.getParameter("statusType");
//        String remark = request.getParameter("rejectRemark");
//        bind(request, cafeteriaRequest);
//        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
//        if (null != statusType) {
//            if (statusType.equals("13")) {
//                cafeteriaRequest.setStatus(13);
//                cafeteriaRequest.setRejectRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information :Withdraw Request Rejected Successfully.");
//            } else if (statusType.equals("16")) {
//                cafeteriaRequest.setStatus(16);
//                cafeteriaRequest.setRejectRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information :Withdraw Request Returned Successfully.");
//
//            }
//        } else {
//            cafeteriaRequest.setStatus(12);
//            request.setAttribute("successMessage",
//                    "Information :Withdraw Request Approved Successfully.");
//        }
//        cafeteriaRequestService.update(cafeteriaRequest);
//        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
////        mv = searchApproverSubmit(request, response);
//        return mv;
//    }
//<--------- ApproverWithdrawReturnCycle---------->
// public ModelAndView withdrawapprovereturn(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        CafeteriaRequest cafeteriaRequest = new CafeteriaRequest();
//        String id = request.getParameter("id");
//        bind(request, cafeteriaRequest);
//        cafeteriaRequest = cafeteriaRequestService.readById(Integer.parseInt(id));
//        cafeteriaRequest.setStatus(19);
//        request.setAttribute("successMessage",
//                "Information :Withdraw Request Approved Successfully.");
//        cafeteriaRequestService.update(cafeteriaRequest);
//        mv.getModelMap().put("cafeteriaRequest", cafeteriaRequest);
////        mv = searchApproverSubmit(request, response);
//        return mv;
//    }

//
