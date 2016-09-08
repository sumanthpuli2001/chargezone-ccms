/*
 * 
 * Author Vinita
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ItRequestType;
import com.bul.zydex.model.ItServiceRequest;
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
public class ItServiceRequestController extends ItServiceRequestAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        List<?> list = itServiceRequestService.readByEmpId(itServiceRequest);
//        mv.getModelMap().put("list", list);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = "" + employeeMaster.getId();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            itServiceRequest.setRejectRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            itServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            itServiceRequest.setItApproverDate(endDate);
        }
        List<?> list = itServiceRequestService.readSearchEmpRequest(itServiceRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.addObject("list", list);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.setViewName("ItService/ItServiceRequestResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
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
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        readrequesttype(request, response);
        ItRequestType itRequestType = new ItRequestType();
        itServiceRequest.setItRequestType(itRequestType);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.setViewName("ItService/CreateITService");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        BindException errors = new BindException(itServiceRequest, "itServiceRequest");
        bind(request, itServiceRequest);
        Integer empid = itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(empid);
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        boolean flag = false;
        itServiceValidator.validate(itServiceRequest, errors);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        readrequesttype(request, response);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.getModelMap().put("itServiceRequest", itServiceRequest);
            mv.setViewName("ItService/CreateITService");
        } else {
            String requestdate = sdf.format(new Date());
            itServiceRequest.setRequestDate(requestdate);
            itServiceRequest.setStatus(1);
            ItRequestType itRequestType = new ItRequestType();
            String requestType = request.getParameter("itRequestType.id");
            if (itRequestType.getId() == null && requestType == "") {
                request.setAttribute("failureMessage", "Error :Select Request Type");
                mv.getModelMap().put("itServiceRequest", itServiceRequest);
                mv.setViewName("ItService/CreateITService");
            } else {
                itRequestType = itRequestTypeService.readById(Integer.parseInt(requestType));
                itServiceRequest.setItRequestType(itRequestType);
                if (!itServiceRequestService.isExist(itServiceRequest)) {
                    itServiceRequestService.create(itServiceRequest);
                    request.setAttribute("successMessage", "Information : Request Sent Successfully.");
                    request.setAttribute("itServiceRequest", itServiceRequest);
                    //    Email Sent to IT Admin
                    List<?> ITAdminList = userRightMasterService.readITAdminList();
                    for (Object o : ITAdminList) {
                        Object[] o1 = (Object[]) o;
                        int ItAdminId = (int) o1[0];
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(ItAdminId);
                            // id 48 is for status IT Service Request Apply
                            emailTemplate = emailTemplateService.readById(48);
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
                } else {
                    flag = true;
                    request.setAttribute("failureMessage", "Error : Request Already Exists");
                }
                mv = searchSubmit(request, response);
            }
        }
        return mv;
    }

    public ModelAndView approverClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!"".equals(departmentId) && null != departmentId) {
            itServiceRequest.setProblemDetail(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            itServiceRequest.setItApproverDate(designationId);
        }
        if (!"".equals(status) && null != status) {
            itServiceRequest.setRejectRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            itServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            employeeMaster.setAdharCard(endDate);
        }
        HttpSession session = request.getSession();
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = itServiceRequestService.readByrequesteeId(itServiceRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.addObject("readByrequesteeIdList", list);
        mv.getModelMap().put("readByrequesteeIdList", list);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        session.setAttribute("ITApproverList", list);
        mv.setViewName("ItService/ITApproverResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        ItRequestType itRequestType = new ItRequestType();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, itServiceRequest);
        itServiceRequest = itServiceRequestService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        itServiceRequest.setItRequestType(itRequestTypeService.readById(itServiceRequest.getItRequestType().getId()));
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("ItService/ITRequestView");
        return mv;
    }

    public ModelAndView approveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, itServiceRequest);
        itServiceRequest = itServiceRequestService.readById(Integer.parseInt(id));
        String approvedate = sdf.format(new Date());
        itServiceRequest.setItApproverDate(approvedate);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        itServiceRequest.setEmployeeMasterByItApproverId(employeeMaster);
        itServiceRequest.setStatus(2);
        itServiceRequestService.update(itServiceRequest);
        
        EmailTemplate emailTemplate = new EmailTemplate();
        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        DesignationMaster designationMaster = new DesignationMaster();
        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
        EmployeeMaster employeeMaster1 = new EmployeeMaster();
        employeeMaster1 = employeeMasterService.readById(itServiceRequest.getEmployeeMasterByEmployeeMasterId().getId());
        // id 48 is for status IT Service Request Apply
        emailTemplate = emailTemplateService.readById(127);
        String To = employeeMaster1.getOfficeEmailId();
        String from = employeeMasterModel.getOfficeEmailId();
        String Subject = emailTemplate.getSubject();
        Subject = Subject.replaceAll("\\{user\\}",employeeMaster1.getEmployeeName());
        String msg = emailTemplate.getBodytext();
        msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
        msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
        msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
        sendMail.sendMail(from, To, Subject, msg);
        request.setAttribute("successMessage",
                "Information : Request Closed Successfully.");
        
        
                String name = "IT Service";
                EmailAddMaster emailAddMaster = new EmailAddMaster();
                emailAddMaster.setModuleName(name);
                emailAddMaster.setDepartmentMaster(employeeMaster1.getDepartmentMaster());
                List<?> emailSendList = emailAddMasterService.readByName(emailAddMaster);
                if (!emailSendList.isEmpty()) {
                    EmailAddMaster emailAddMaster1 = (EmailAddMaster) emailSendList.get(0);
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
//        if (null != statusType) {
//            if (statusType.equals("3")) {
//                itServiceRequest.setStatus(3);
//                itServiceRequest.setRejectRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information : Request Rejected Successfully.");
//            } else if (statusType.equals("4")) {
//                itServiceRequest.setStatus(4);
//                itServiceRequest.setRejectRemark(remark);
//                request.setAttribute("successMessage",
//                        "Information : Request Returned Successfully.");
//
//            }
//        } else {
//        }

        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv = approverClick(request, response);
        return mv;
    }

    //    <---------Return Cycle---------->
    public ModelAndView EmpviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        readrequesttype(request, response);
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
        request.setAttribute("employeeMaster", employeeMaster);
        itServiceRequest = itServiceRequestService.readById(Integer.parseInt(id));
        itServiceRequest.setItRequestType(itRequestTypeService.readById(itServiceRequest.getItRequestType().getId()));
//        bind(request, itServiceRequest);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.setViewName("ItService/EmpView");
        return mv;
    }

    public ModelAndView returnCreateSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        ItServiceRequest itServiceRequest1 = new ItServiceRequest();
        String id = request.getParameter("id");
        BindException errors = new BindException(itServiceRequest, "itServiceRequest");
        bind(request, itServiceRequest1);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("ItService/EmpView");
        } else {
            if (itServiceRequest1.getId() == null) {
                itServiceRequest = itServiceRequestService.readById(Integer.parseInt(id));
            }
            if (itServiceRequest.getStatus() == 4) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String requestdate = sdf.format(new Date());
                readrequesttype(request, response);
                itServiceRequest.setRequestDate(requestdate);
                itServiceRequest.setStatus(5);
                itServiceRequest.setRejectRemark(itServiceRequest1.getRejectRemark());
                itServiceRequest.setProblemDetail(itServiceRequest1.getProblemDetail());
                ItRequestType itRequestType = new ItRequestType();
                String requestType = request.getParameter("itRequestType");
                itRequestType = itRequestTypeService.readById(Integer.parseInt(requestType));
                itServiceRequest.setItRequestType(itRequestType);
                itServiceRequestService.update(itServiceRequest);
                request.setAttribute("successMessage",
                        "Information : Request Sent Successfully.");
                mv.getModelMap().put("itServiceRequest", itServiceRequest);
                mv = searchSubmit(request, response);
            }
//    empwithdraw
            if (itServiceRequest.getStatus() == 1 || itServiceRequest.getStatus() == 2) {
                if (itServiceRequest.getStatus() == 1) {
                    itServiceRequestService.delete(Integer.parseInt(id));
                    request.setAttribute("successMessage",
                            "Information : Request Withdrawed Successfully.");
                    mv = searchSubmit(request, response);
                } else if (itServiceRequest.getStatus() == 2) {
                    itServiceRequest.setStatus(6);
                    itServiceRequest.setProblemDetail(itServiceRequest1.getProblemDetail());
                    itServiceRequestService.update(itServiceRequest);
                    request.setAttribute("successMessage",
                            "Information : Withdraw Request Sent Successfully.");
                    mv = searchSubmit(request, response);
                }
            }
//    withdrawreturnSubmit 
            if (itServiceRequest.getStatus() == 9) {
                itServiceRequest.setStatus(10);
                itServiceRequest.setProblemDetail(itServiceRequest1.getProblemDetail());
                itServiceRequestService.update(itServiceRequest);
                request.setAttribute("successMessage",
                        "Information : Request Sent Successfully.");
                mv.getModelMap().put("itServiceRequest", itServiceRequest);
                mv = approverClick(request, response);
            }
        }
        return mv;
    }

//    <---------Withdraw Cycle---------->
    public ModelAndView approverwithdraw(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, itServiceRequest);
        itServiceRequest = itServiceRequestService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("7")) {
                itServiceRequest.setStatus(7);
                itServiceRequest.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("9")) {
                itServiceRequest.setStatus(9);
                itServiceRequest.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Returned Successfully.");
            }
        } else {
            itServiceRequest.setStatus(8);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Approved Successfully.");
        }
        itServiceRequestService.update(itServiceRequest);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv = approverClick(request, response);
        return mv;
    }

    //    <---------Search---------->
    public ModelAndView searchEmpClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        ItServiceRequest itServiceRequest = new ItServiceRequest();
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        mv.getModelMap().put("itServiceRequest", itServiceRequest);
//        request.setAttribute("empName", employeeMaster.getEmployeeName());
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.getModelMap().put("itServiceRequest", itServiceRequest);
//        mv.setViewName("ItService/EmpSearch");
//        return mv;
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        List<?> list = itServiceRequestService.readByEmpId(itServiceRequest);
//        mv.getModelMap().put("list", list);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = "" + employeeMaster.getId();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            itServiceRequest.setRejectRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            itServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            itServiceRequest.setItApproverDate(endDate);
        }
        List<?> list = itServiceRequestService.readSearchEmpRequest(itServiceRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.addObject("list", list);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.setViewName("ItService/ItServiceRequestResult");
        return mv;
    }

    public ModelAndView searchEmpResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        ItServiceRequest itServiceRequest = new ItServiceRequest();
//        String startDate = request.getParameter("startDate");
//        String endDate = request.getParameter("endDate");
//        String status = request.getParameter("status");
//
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        String empId = employeeMaster.getId().toString();
//        if (!"".equals(empId) && null != empId) {
//            employeeMaster.setId(Integer.parseInt(empId));
//        }
//        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        if (!"".equals(status) && null != status) {
//            itServiceRequest.setRejectRemark(status);
//        }
//        if (!"".equals(startDate) && null != startDate) {
//            itServiceRequest.setRequestDate(startDate);
//        }
//        if (!"".equals(endDate) && null != endDate) {
//            itServiceRequest.setItApproverDate(endDate);
//        }
//        List<?> list = itServiceRequestService.readSearchEmpRequest(itServiceRequest);
//        mv.getModelMap().put("itServiceRequest", itServiceRequest);
//        mv.getModelMap().put("list", list);
//        mv.setViewName("ItService/EmpSearchResult");
//        return mv;
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        List<?> list = itServiceRequestService.readByEmpId(itServiceRequest);
//        mv.getModelMap().put("list", list);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = "" + employeeMaster.getId();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            itServiceRequest.setRejectRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            itServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            itServiceRequest.setItApproverDate(endDate);
        }
        List<?> list = itServiceRequestService.readSearchEmpRequest(itServiceRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.addObject("list", list);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
        mv.setViewName("ItService/ItServiceRequestResult");
        return mv;
    }

    public ModelAndView searchITClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        ItServiceRequest itServiceRequest = new ItServiceRequest();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        selectEmployee(request, response);
//        departmentList(request);
//        designationList(request);
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.getModelMap().put("itServiceRequest", itServiceRequest);
//        mv.setViewName("ItService/ItApproverSearch");
//        return mv;
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!"".equals(departmentId) && null != departmentId) {
            itServiceRequest.setProblemDetail(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            itServiceRequest.setItApproverDate(designationId);
        }
        if (!"".equals(status) && null != status) {
            itServiceRequest.setRejectRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            itServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            employeeMaster.setAdharCard(endDate);
        }
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = itServiceRequestService.readByrequesteeId(itServiceRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.addObject("readByrequesteeIdList", list);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.setViewName("ItService/ITApproverResult");
        return mv;
    }

    public ModelAndView searchITResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        ItServiceRequest itServiceRequest = new ItServiceRequest();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
//        String empId = request.getParameter("employeeName");
//        String departmentId = request.getParameter("departmentMaster");
//        String designationId = request.getParameter("designationMaster");
//        String startDate = request.getParameter("startDate");
//        String endDate = request.getParameter("endDate");
//        String status = request.getParameter("status");
//
//        if (!"".equals(empId) && null != empId) {
//            employeeMaster.setId(Integer.parseInt(empId));
//        }
//        if (!"".equals(departmentId) && null != departmentId) {
//            itServiceRequest.setProblemDetail(departmentId);
//        }
//        if (!"".equals(designationId) && null != designationId) {
//            itServiceRequest.setItApproverDate(designationId);
//        }
//        if (!"".equals(status) && null != status) {
//            itServiceRequest.setRejectRemark(status);
//        }
//        if (!"".equals(startDate) && null != startDate) {
//            itServiceRequest.setRequestDate(startDate);
//        }
//        if (!"".equals(endDate) && null != endDate) {
//            employeeMaster.setAdharCard(endDate);
//        }
//        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        List<?> list = itServiceRequestService.readSearchRequest(itServiceRequest);
//        mv.getModelMap().put("itServiceRequest", itServiceRequest);
//        mv.getModelMap().put("list", list);
//        mv.setViewName("ItService/ItApproverSearchResult");
//        return mv;
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        String empId = request.getParameter("employeeName");
        String departmentId = request.getParameter("departmentMaster");
        String designationId = request.getParameter("designationMaster");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");

        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        if (!"".equals(departmentId) && null != departmentId) {
            itServiceRequest.setProblemDetail(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            itServiceRequest.setItApproverDate(designationId);
        }
        if (!"".equals(status) && null != status) {
            itServiceRequest.setRejectRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            itServiceRequest.setRequestDate(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            employeeMaster.setAdharCard(endDate);
        }
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = itServiceRequestService.readByrequesteeId(itServiceRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.addObject("readByrequesteeIdList", list);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.setViewName("ItService/ITApproverResult");
        return mv;
    }

    public ModelAndView userDashboardItServicePendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = itServiceRequestService.readByItServicePendingRequest(itServiceRequest);
        int itServicePending = list.size();
        request.setAttribute("itServicePending", itServicePending);
        List<?> list1 = itServiceRequestService.readByItServiceApproverPendingRequest(itServiceRequest);
        int itServiceApproverPending = list1.size();
        request.setAttribute("itServiceApproverPending", itServiceApproverPending);
        mv.setViewName("forward:hrServiceRequest.htm?act=userDashboardHrServicePendingRequest");
        return mv;
    }

    public ModelAndView searchItServicePendingRequestSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        itServiceRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = itServiceRequestService.readByItServicePendingRequest(itServiceRequest);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("itServiceRequest", itServiceRequest);
        mv.setViewName("ItService/ItServiceRequestResult");
        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ItServiceRequest itServiceRequest = new ItServiceRequest();
        List<?> ITApproverList = (List<?>) request.getSession().getAttribute("ITApproverList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ITService.xls");
        mv.addObject("ITApproverList", ITApproverList);
        mv.setViewName("ItService/ExportITServiceResult");
        return mv;
    }

}
