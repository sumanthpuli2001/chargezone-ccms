/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emprequest;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeDatetimeData;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeShiftData;
import com.bul.zydex.model.PoolCarRequest;
import com.bul.zydex.model.ShiftGenerateMonthlySchedule;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
public class PoolCarRequestController extends PoolCarRequestAbstract {

    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByAdminApproverId(employeeMaster);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = employeeMaster.getId().toString();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            poolCarRequest.setAdminRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            poolCarRequest.setStartDateTime(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            poolCarRequest.setEndDateTime(endDate);
        }
//        List<?> readSearchEmpRequestList = poolCarRequestService.readSearchEmpRequest(poolCarRequest);
        List<?> poolCarRequestList = poolCarRequestService.readByEmpId(poolCarRequest);
        mv.getModelMap().put("poolCarRequestList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
//        mv.addObject("readSearchEmpRequestList", readSearchEmpRequestList);
        mv.setViewName("PoolCar/PoolCarResult");
        return mv;
    }

    public ModelAndView createClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String manager = employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("PoolCar/PoolCarRequestCreate");
        return mv;
    }

    public ModelAndView createSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        BindException errors = new BindException(poolCarRequest, "poolCarRequest");
        bind(request, poolCarRequest);
        Integer empid = poolCarRequest.getEmployeeMasterByEmployeeMasterId().getId();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(empid);
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        boolean flag = false;
        poolCarRequestValidator.validate(poolCarRequest, errors);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("PoolCar/PoolCarRequestCreate");
        } else {
            String startDate = request.getParameter("startDateTime");
            String endDate = request.getParameter("endDateTime");
            Date sDate = sdf.parse(startDate);
            Date eDate = sdf.parse(endDate);
            if (sDate.after(eDate)) {
                request.setAttribute("failureMessage",
                        "Error : Enter EndDate after StartDate");
                request.setAttribute("poolCarRequest", poolCarRequest);
                mv.setViewName("PoolCar/PoolCarRequestCreate");
            } else {
                String requestdate = sdf.format(new Date());
                poolCarRequest.setRequestDate(requestdate);
                poolCarRequest.setStatus(1);
                if (!poolCarRequestService.isExist(poolCarRequest)) {
                    poolCarRequestService.create(poolCarRequest);
//       Email Sent to ReportingManager1
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                        // id 29 is for poolcar apply status
                        emailTemplate = emailTemplateService.readById(29);
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

                    request.setAttribute("poolCarRequest", poolCarRequest);
                } else {
                    flag = true;
                    request.setAttribute("failureMessage",
                            "Error : Request Already Exists");
                }
                mv = searchSubmit(request, response);
            }
        }
        return mv;
    }
    //    <--------- Approver---------->

    public ModelAndView searchApproverSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByApproverId(employeeMaster);
        List<?> poolCarRequestList = poolCarRequestService.readByrequesteeId(poolCarRequest);
        mv.getModelMap().put("poolCarRequestList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv.setViewName("PoolCar/PoolCarApproverResult");
        return mv;
    }

    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        if (poolCarRequest.isRequestFor()) {
            request.setAttribute("requestFor", "Self");
        } else {
            request.setAttribute("requestFor", "Other");

        }
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("PoolCar/ViewPoolCarRequest");
        return mv;
    }

    public ModelAndView aprroveClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));

        String approvedate = sdf.format(new Date());
        poolCarRequest.setApproveDate(approvedate);

        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        poolCarRequest.setEmployeeMasterByApproverId(employeeMaster);
        if (null != statusType) {
            if (statusType.equals("3")) {
                poolCarRequest.setStatus(3);
                poolCarRequest.setRejectRemark(remark);
                poolCarRequestService.createOrUpdate(poolCarRequest);
                request.setAttribute("successMessage",
                        "Information : Request Rejected Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 32 is for status poolcar Reject
                    emailTemplate = emailTemplateService.readById(32);
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
                poolCarRequest.setStatus(6);
                poolCarRequest.setRejectRemark(remark);
                poolCarRequestService.createOrUpdate(poolCarRequest);
                request.setAttribute("successMessage",
                        "Information : Request Returned Successfully.");
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 31 is for status poolcar Rework
                    emailTemplate = emailTemplateService.readById(31);
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
            poolCarRequest.setStatus(2);
            poolCarRequestService.createOrUpdate(poolCarRequest);
            request.setAttribute("successMessage",
                    "Information : Request Approved Successfully.");
            //    Email Sent to poolcarAdmin
            List<?> poolCarAdminList = userRightMasterService.readpoolcarAdminList();
            for (Object o : poolCarAdminList) {
                Object[] o1 = (Object[]) o;
                int AdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(AdminId);
                    List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 30 is for status poolcar approve admin
                    emailTemplate = emailTemplateService.readById(30);
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
                List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 50 is for status poolcar approve (Employee)
                emailTemplate = emailTemplateService.readById(50);
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
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    //    <---------Admin Approver---------->
    public ModelAndView adminApproveSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        selectEmployee(request, response);
        departmentList(request);
        designationList(request);
        List<?> Approverlist;
        List<?> poolCarRequestList = null;

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
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(departmentId) && null != departmentId) {
            poolCarRequest.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            poolCarRequest.setRejectRemark(designationId);
        }
        if (!"".equals(startDate) && null != startDate) {
            poolCarRequest.setStartDateTime(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            poolCarRequest.setEndDateTime(endDate);
        }
        if (!"".equals(status) && null != status) {
            poolCarRequest.setAdminRemark(status);
        }
        Object object = (Object) request.getAttribute("flag");
        if (object == null) {

            poolCarRequestList = poolCarRequestService.readByapproverId(poolCarRequest);
        } else {
            poolCarRequestList = (List<?>) request.getAttribute("Approverlist");
        }
//        List<?> list = poolCarRequestService.readByapproverId(poolCarRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.addObject("ApproverList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        session.setAttribute("Approverlist", poolCarRequestList);
        mv.setViewName("PoolCar/PoolCarAdminResult");
        return mv;
    }

    public ModelAndView viewAdminClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        String id = request.getParameter("id");
        String empId = request.getParameter("empId");
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        if (poolCarRequest.isRequestFor()) {
            request.setAttribute("requestFor", "Self");
        } else {
            request.setAttribute("requestFor", "Other");

        }
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("PoolCar/AdminViewPoolCarRequest");
        return mv;
    }

    public ModelAndView adminAprroveClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("adminRemark");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByAdminApproverId(employeeMaster);
        if (null != statusType) {
            if (statusType.equals("5")) {
                poolCarRequest.setStatus(5);
                poolCarRequest.setAdminRemark(remark);
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 120 is for status poolcar Admin Rejected
                    emailTemplate = emailTemplateService.readById(120);
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
                request.setAttribute("successMessage",
                        "Information : Request Rejected Successfully.");
            } else if (statusType.equals("7")) {
                poolCarRequest.setStatus(7);
                poolCarRequest.setAdminRemark(remark);
                //    Email Sent to Employee
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                    EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                    // id 121 is for status poolcar Admin Returned
                    emailTemplate = emailTemplateService.readById(121);
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
//                //       Email Sent to ReportingManager1
//                      try {
//                            EmailTemplate emailTemplate = new EmailTemplate();
//                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                            DesignationMaster designationMaster = new DesignationMaster();
//                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
//                            employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
//                               // id 31 is for status poolcar Rework
//                            emailTemplate = emailTemplateService.readById(31);
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
                request.setAttribute("successMessage",
                        "Information : Request Returned Successfully.");

            }
        } else {

            if (poolCarRequest.isRequestFor() == true) {
                String startDate = poolCarRequest.getStartDateTime().trim();
                String endDate = poolCarRequest.getEndDateTime().trim();
                poolCarRequest.getEmployeeMasterByEmployeeMasterId();
                EmployeeDatetimeData employeeDatetimeData = new EmployeeDatetimeData();
                EmployeeDatetimeData employeeDatetimeData1 = new EmployeeDatetimeData();
                employeeDatetimeData.setDateTime(startDate);
                employeeDatetimeData.setEmployeeMaster(poolCarRequest.getEmployeeMasterByEmployeeMasterId());
                employeeDatetimeData1.setDateTime(endDate);
                employeeDatetimeData1.setEmployeeMaster(poolCarRequest.getEmployeeMasterByEmployeeMasterId());
                employeeDatetimeDataService.create(employeeDatetimeData);
                employeeDatetimeDataService.create(employeeDatetimeData1);
                EmployeeShiftData employeeShiftData = new EmployeeShiftData();
                EmployeeShiftData employeeShiftData1 = new EmployeeShiftData();
                employeeShiftData.setEmployeeMaster(poolCarRequest.getEmployeeMasterByEmployeeMasterId());
                employeeShiftData.setInDateTime(startDate);
                employeeShiftData.setOutDateTime(endDate);
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date date1 = sdf1.parse(startDate);

                LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate1.getYear();
                int month = localDate1.getMonthValue();
                int day = localDate1.getDayOfMonth();
                String month1 = "" + month;
                String year1 = "" + year;
                ShiftGenerateMonthlySchedule shiftGenerateMonthlySchedule = new ShiftGenerateMonthlySchedule();
                shiftGenerateMonthlySchedule.setEmployeeMaster(poolCarRequest.getEmployeeMasterByEmployeeMasterId());
                shiftGenerateMonthlySchedule.setShiftMonth(month1);
                shiftGenerateMonthlySchedule.setShiftYear(year1);
                List empShiftList = shiftGenerateMonthlyScheduleService.readByDayWiseEmployeeShiftData(shiftGenerateMonthlySchedule, day);
                employeeShiftData1.setInDateTime(startDate);
                employeeShiftData1.setOutDateTime(endDate);
                try {
                    if (!empShiftList.isEmpty()) {
                        String shiftId = "" + empShiftList.get(0);
                        employeeShiftData1.setShiftMaster(shiftMasterService.readById(Integer.parseInt(shiftId)));
                        employeeShiftData1.setEmployeeMaster(poolCarRequest.getEmployeeMasterByEmployeeMasterId());
                        employeeShiftData1.setShiftMaster(employeeShiftData1.getShiftMaster());
                        employeeShiftDataService.create(employeeShiftData1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            poolCarRequest.setStatus(4);
            request.setAttribute("successMessage",
                    "Information : Request Approved Successfully.");
            //    Email Sent to Employee
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
                EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
                // id 119 is for status poolcar Admin approve (Employee)
                emailTemplate = emailTemplateService.readById(119);
                String To = employeeRequestee.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);

                String name = "Pool Car";
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
        poolCarRequestService.createOrUpdate(poolCarRequest);

        mv.getModelMap().put("employeeMaster", employeeMaster);

        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv = adminApproveSubmit(request, response);
        return mv;
    }

//    <---------Return Cycle---------->
    public ModelAndView EmpviewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
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
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        if (poolCarRequest.isRequestFor()) {
            request.setAttribute("requestFor", "Self");
        } else {
            request.setAttribute("requestFor", "Other");
        }
        poolCarRequest.setRejectRemark(poolCarRequest.getRejectRemark());
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("employeeMaster", employeeMaster);
        mv.setViewName("PoolCar/EmpView");
        return mv;
    }

    public ModelAndView returnCreateSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        PoolCarRequest poolCarRequest1 = new PoolCarRequest();
        BindException errors = new BindException(poolCarRequest, "poolCarRequest");
        bind(request, poolCarRequest1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String startDate = poolCarRequest1.getStartDateTime();
        String endDate = poolCarRequest1.getEndDateTime();
        Date sDate = sdf.parse(startDate);
        Date eDate = sdf.parse(endDate);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            mv.addAllObjects(errors.getModel());
            mv.setViewName("PoolCar/EmpView");
        } else if (sDate.after(eDate)) {
            request.setAttribute("failureMessage",
                    "Error : Enter EndDate after StartDate");
            request.setAttribute("poolCarRequest", poolCarRequest);
            mv = EmpviewClick(request, response);
        } else {
            String id = request.getParameter("id");
            if (poolCarRequest1.getRequestDate() == null) {
                poolCarRequest = poolCarRequestService.readById(poolCarRequest1.getId());
            }
            String btn = (String) request.getParameter("btnType");
            if (btn.equals("Submit")) {
                if (poolCarRequest.getStatus() == 6 || poolCarRequest.getStatus() == 7) {
                    String requestdate = sdf.format(new Date());
                    poolCarRequest.setRequestDate(requestdate);
                    poolCarRequest.setStatus(8);
                    poolCarRequest.setReason(poolCarRequest1.getReason());
                    poolCarRequest.setStartDateTime(poolCarRequest1.getStartDateTime());
                    poolCarRequest.setEndDateTime(poolCarRequest1.getEndDateTime());
                    if (poolCarRequest1.isRequestFor()) {
                        poolCarRequest.setRequestFor(true);
                    } else {
                        poolCarRequest.setRequestFor(false);
                    }

                    poolCarRequestService.update(poolCarRequest);
                    //       Email Sent to ReportingManager1
                    try {
                        EmailTemplate emailTemplate = new EmailTemplate();
                        EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                        EmployeeMaster employeeMasterHr = new EmployeeMaster();
                        employeeMasterHr = employeeMasterService.readById(Integer.parseInt(employeeMasterModel.getReportingManagerLevel1()));
                        // id 51 is for poolcar rework Submitted
                        emailTemplate = emailTemplateService.readById(51);
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
                    mv.getModelMap().put("poolCarRequest", poolCarRequest);
                    mv = searchSubmit(request, response);
                }
            }
            //               empwithdraw Method
            if (btn.equals("Withdraw")) {
               
                //               empwithdraw Method
                if (btn.equals("Withdraw")) {
                    if (poolCarRequest.getStatus() == 1 || poolCarRequest.getStatus() == 2 || poolCarRequest.getStatus() == 4
                            || poolCarRequest.getStatus() == 8 || poolCarRequest.getStatus() == 9
                            || poolCarRequest.getStatus() == 6 || poolCarRequest.getStatus() == 7) {
                        if (poolCarRequest.getStatus() == 1) {
                            poolCarRequestService.delete(Integer.parseInt(id));
                            request.setAttribute("successMessage",
                                    "Information : Request Withdrawed Successfully.");
                            mv = searchSubmit(request, response);
                        } else if (poolCarRequest.getStatus() == 2 || poolCarRequest.getStatus() == 4
                                || poolCarRequest.getStatus() == 8 || poolCarRequest.getStatus() == 9
                                || poolCarRequest.getStatus() == 6 || poolCarRequest.getStatus() == 7) {
                            poolCarRequest.setStatus(14);
                            poolCarRequest.setReason(poolCarRequest1.getReason());
                            poolCarRequestService.update(poolCarRequest);

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
                        // id 33 is for poolcar Withdraw
                        emailTemplate = emailTemplateService.readById(33);
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
                    //    Email Sent to poolcarAdmin
                    List<?> poolCarAdminList = userRightMasterService.readpoolcarAdminList();
                    for (Object o : poolCarAdminList) {
                        Object[] o1 = (Object[]) o;
                        int AdminId = (int) o1[0];
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                            DesignationMaster designationMaster = new DesignationMaster();
                            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                            EmployeeMaster employeeMasterHr = new EmployeeMaster();
                            employeeMasterHr = employeeMasterService.readById(AdminId);
                            // id 33 is for poolcar Withdraw
                            emailTemplate = emailTemplateService.readById(33);
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
//                        }
                        request.setAttribute("successMessage",
                                "Information : Withdraw Request Sent Successfully.");
                        mv.getModelMap().put("poolCarRequest", poolCarRequest);
                        mv = searchSubmit(request, response);
//                }
                    }
                }
                //            withdrawreturnSubmit Method
//            if (poolCarRequest.getStatus() == 16) {
//                poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
//                poolCarRequest.setStatus(18);
//                poolCarRequest.setReason(poolCarRequest1.getReason());
//                poolCarRequestService.update(poolCarRequest);
//                request.setAttribute("successMessage",
//                        "Information : Request Sent Successfully.");
//                mv.getModelMap().put("poolCarRequest", poolCarRequest);
//                mv = searchSubmit(request, response);
//            }
            }
        }
        return mv;
    }

    public ModelAndView aprroveReturnClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        String approvedate = sdf.format(new Date());
        poolCarRequest.setApproveDate(approvedate);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        poolCarRequest.setEmployeeMasterByApproverId(employeeMaster);
        poolCarRequest.setStatus(9);
        request.setAttribute("successMessage",
                "Information : Request Approved Successfully.");
        poolCarRequestService.update(poolCarRequest);
        //    Email Sent to Employee
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            List l1 = poolCarRequestService.readEmpIdFromTabId(Integer.parseInt(id));
            EmployeeMaster employeeRequestee = (EmployeeMaster) l1.get(0);
            // id 50 is for status poolcar approve (Employee)
            emailTemplate = emailTemplateService.readById(50);
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
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    //    <---------Withdraw Cycle---------->
    public ModelAndView approverwithdraw(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("13")) {
                poolCarRequest.setStatus(13);
                poolCarRequest.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("16")) {
                poolCarRequest.setStatus(16);
                poolCarRequest.setRejectRemark(remark);
                request.setAttribute("successMessage",
                        "Information :Withdraw Request Returned Successfully.");
            }
        } else {
            poolCarRequest.setStatus(12);
            request.setAttribute("successMessage",
                    "Information :Withdraw Request Approved Successfully.");
        }
        poolCarRequestService.createOrUpdate(poolCarRequest);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    public ModelAndView adminAprrovewithdrawClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        String statusType = request.getParameter("statusType");
        String remark = request.getParameter("rejectRemark");
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        if (null != statusType) {
            if (statusType.equals("15")) {
                poolCarRequest.setStatus(15);
                poolCarRequest.setAdminRemark(remark);
                request.setAttribute("successMessage",
                        "Information : Withdraw Request Rejected Successfully.");
            } else if (statusType.equals("17")) {
                poolCarRequest.setStatus(17);
                poolCarRequest.setAdminRemark(remark);
                request.setAttribute("successMessage",
                        "Information : Withdraw Request Returned Successfully.");
            }
        } else {
            poolCarRequest.setStatus(14);
            request.setAttribute("successMessage",
                    "Information : Withdraw Request Approved Successfully.");
        }
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        poolCarRequest.setEmployeeMasterByAdminApproverId(employeeMaster);
        poolCarRequestService.update(poolCarRequest);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv = adminApproveSubmit(request, response);
        return mv;
    }

    public ModelAndView withdrawapprovereturn(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        String id = request.getParameter("id");
        bind(request, poolCarRequest);
        poolCarRequest = poolCarRequestService.readById(Integer.parseInt(id));
        poolCarRequest.setStatus(19);
        request.setAttribute("successMessage",
                "Information :Withdraw Request Approved Successfully.");
        poolCarRequestService.update(poolCarRequest);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv = searchApproverSubmit(request, response);
        return mv;
    }

    //    <---------Search---------->
    public ModelAndView searchEmpClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        PoolCarRequest poolCarRequest = new PoolCarRequest();
//        HttpSession session = request.getSession();
//        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
//        String startDate = request.getParameter("startDate");
//        String endDate = request.getParameter("endDate");
//        String status = request.getParameter("status");
//        String empId = employeeMaster.getId().toString();
//        if (!"".equals(empId) && null != empId) {
//            employeeMaster.setId(Integer.parseInt(empId));
//        }
//        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        if (!"".equals(status) && null != status) {
//            poolCarRequest.setAdminRemark(status);
//        }
//        if (!"".equals(startDate) && null != startDate) {
//            poolCarRequest.setStartDateTime(startDate);
//        }
//        if (!"".equals(endDate) && null != endDate) {
//            poolCarRequest.setEndDateTime(endDate);
//        }
//        List<?> list = poolCarRequestService.readSearchEmpRequest(poolCarRequest);
//        mv.getModelMap().put("poolCarRequest", poolCarRequest);
//        request.setAttribute("empName", employeeMaster.getEmployeeName());
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.addObject("list", list);
//        mv.setViewName("PoolCar/PoolCarRequestEmpSearch");
//        return mv;
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByAdminApproverId(employeeMaster);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = employeeMaster.getId().toString();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            poolCarRequest.setAdminRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            poolCarRequest.setStartDateTime(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            poolCarRequest.setEndDateTime(endDate);
        }
//        List<?> readSearchEmpRequestList = poolCarRequestService.readSearchEmpRequest(poolCarRequest);
        List<?> poolCarRequestList = poolCarRequestService.readByEmpId(poolCarRequest);
        mv.getModelMap().put("poolCarRequestList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
//        mv.addObject("readSearchEmpRequestList", readSearchEmpRequestList);
        mv.setViewName("PoolCar/PoolCarResult");
        return mv;
    }

    public ModelAndView searchEmpResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        PoolCarRequest poolCarRequest = new PoolCarRequest();
//
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
//        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
//        if (!"".equals(status) && null != status) {
//            poolCarRequest.setAdminRemark(status);
//        }
//        if (!"".equals(startDate) && null != startDate) {
//            poolCarRequest.setStartDateTime(startDate);
//        }
//        if (!"".equals(endDate) && null != endDate) {
//            poolCarRequest.setEndDateTime(endDate);
//        }
//        List<?> list = poolCarRequestService.readSearchEmpRequest(poolCarRequest);
//        request.setAttribute("empName", employeeMaster.getEmployeeName());
//        mv.getModelMap().put("employeeMaster", employeeMaster);
//        mv.getModelMap().put("poolCarRequest", poolCarRequest);
//        mv.addObject("readSearchEmpRequestList", list);
//        mv.setViewName("PoolCar/PoolCarRequestEmpSearch");
////        mv.setViewName("PoolCar/PoolCarRequestEmpSearchResult");
//        return mv;
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByAdminApproverId(employeeMaster);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        String empId = employeeMaster.getId().toString();
        if (!"".equals(empId) && null != empId) {
            employeeMaster.setId(Integer.parseInt(empId));
        }
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(status) && null != status) {
            poolCarRequest.setAdminRemark(status);
        }
        if (!"".equals(startDate) && null != startDate) {
            poolCarRequest.setStartDateTime(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            poolCarRequest.setEndDateTime(endDate);
        }
//        List<?> readSearchEmpRequestList = poolCarRequestService.readSearchEmpRequest(poolCarRequest);
        List<?> poolCarRequestList = poolCarRequestService.readByEmpId(poolCarRequest);
        mv.getModelMap().put("poolCarRequestList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("empName", employeeMaster.getEmployeeName());
//        mv.addObject("readSearchEmpRequestList", readSearchEmpRequestList);
        mv.setViewName("PoolCar/PoolCarResult");
        return mv;
    }

    public ModelAndView searchAdminClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
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
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(departmentId) && null != departmentId) {
            poolCarRequest.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            poolCarRequest.setRejectRemark(designationId);
        }
        if (!"".equals(startDate) && null != startDate) {
            poolCarRequest.setStartDateTime(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            poolCarRequest.setEndDateTime(endDate);
        }
        if (!"".equals(status) && null != status) {
            poolCarRequest.setAdminRemark(status);
        }
//        List<?> list = poolCarRequestService.readByapproverId(poolCarRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        List<?> poolCarRequestList = poolCarRequestService.readByapproverId(poolCarRequest);
        mv.getModelMap().put("ApproverList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv.setViewName("PoolCar/PoolCarAdminResult");
        return mv;
    }

    public ModelAndView searchAdminResult(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
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
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        if (!"".equals(departmentId) && null != departmentId) {
            poolCarRequest.setReason(departmentId);
        }
        if (!"".equals(designationId) && null != designationId) {
            poolCarRequest.setRejectRemark(designationId);
        }
        if (!"".equals(startDate) && null != startDate) {
            poolCarRequest.setStartDateTime(startDate);
        }
        if (!"".equals(endDate) && null != endDate) {
            poolCarRequest.setEndDateTime(endDate);
        }
        if (!"".equals(status) && null != status) {
            poolCarRequest.setAdminRemark(status);
        }
//        List<?> list = poolCarRequestService.readByapproverId(poolCarRequest);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        List<?> poolCarRequestList = poolCarRequestService.readByapproverId(poolCarRequest);
        mv.getModelMap().put("ApproverList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        request.setAttribute("flag", 1);
        request.setAttribute("Approverlist", poolCarRequestList);
        mv = adminApproveSubmit(request, response);
//        mv.setViewName("PoolCar/PoolCarAdminResult");
        return mv;
    }

    public ModelAndView userDashboardPoolCarPendingRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> list = poolCarRequestService.readByPoolCarPendingRequest(poolCarRequest);
        int poolCarPending = list.size();
        request.setAttribute("poolCarPending", poolCarPending);
        List<?> list1 = poolCarRequestService.readByApproverWisePoolCarPendingRequest(poolCarRequest);
        int poolCarApproverPending = list1.size();
        request.setAttribute("poolCarApproverPending", poolCarApproverPending);
        mv.setViewName("forward:attendanceRegularizationMaster.htm?act=userDashboardAttendanceRegularizationPendingRequest");
        return mv;
    }

    public ModelAndView searchPendingCarRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        PoolCarRequest poolCarRequest = new PoolCarRequest();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        poolCarRequest.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> poolCarRequestList = poolCarRequestService.readByPoolCarPendingRequest(poolCarRequest);
        mv.getModelMap().put("poolCarRequestList", poolCarRequestList);
        mv.getModelMap().put("poolCarRequest", poolCarRequest);
        mv.setViewName("PoolCar/PoolcarpendingDashboard");
        return mv;
    }

    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> Approverlist = (List<?>) request.getSession().getAttribute("Approverlist");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=PoolcarDetail.xls");
        response.setContentType("application/vnd.ms-excel");
        mv.addObject("approverlist", Approverlist);
        mv.setViewName("PoolCar/ExportPoolCarAdminResult");
        return mv;
    }

}
