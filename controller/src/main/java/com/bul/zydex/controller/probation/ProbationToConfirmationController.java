/*
 *
 * Author Vinita
 */
package com.bul.zydex.controller.probation;

import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailAddMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSubType;
import com.bul.zydex.model.ProbationToConfirmation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vinita
 */
public class ProbationToConfirmationController extends ProbationToConfirmationAbstract {

//Request Submited by manager:-
    public ModelAndView searchSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        Integer LoginempId = employeeMaster.getId();
        List<?> probationtypeList = employeeMasterService.readForEmployeeType(LoginempId);
        List<Object> finalprobationList1 = new ArrayList<>();
        
        if (!probationtypeList.isEmpty()) {
            for (Object o : probationtypeList) {
                EmployeeMaster employeeMaster1 = new EmployeeMaster();
                employeeMaster1 = (EmployeeMaster) o;
                String employeeId = employeeMaster1.getId().toString();
                ProbationToConfirmation ptc1 = new ProbationToConfirmation();
                ptc1.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                List<?> listrepeat = probationToConfirmationService.readForRepeatedId(ptc1);
                if (!listrepeat.isEmpty()) {
                    ProbationToConfirmation ptc2 = new ProbationToConfirmation();
                    ptc2 = (ProbationToConfirmation) listrepeat.get(0);
                    Integer status = ptc2.getStatus();
                    if (status == 1 || status == 2) {
                        
                    } else if (status == 4 || status == 0 || status == 10) {
                        String assessmentToDatestring = ptc2.getAssessmentToDate();
                        String today = sdf.format(new Date());
                        Date tDate = sdf.parse(today);
                        Date assessmentToDate = sdf.parse(assessmentToDatestring);
                        
                        Calendar c = Calendar.getInstance();
                        c.setTime(assessmentToDate);
//                        c.add(Calendar.DATE, -15);
                        c.add(Calendar.MONTH, -1);
                        Date datebefore1 = c.getTime();
                        c.setTime(datebefore1);
                        c.add(Calendar.MONTH, 1);
                        Date level1Date = c.getTime();
                        
                        c.setTime(level1Date);
                        c.add(Calendar.DATE, 15);
                        Date level2Date = c.getTime();
                        c.setTime(level2Date);
                        c.add(Calendar.DATE, 15);
                        Date level3Date = c.getTime();
                        
                        c.setTime(level3Date);
                        c.add(Calendar.DATE, 15);
                        Date level4Date = c.getTime();

//                        if ((DateUtils.isSameDay(tDate, datebefore1) || tDate.after(datebefore1))) {
                        List<?> probationList = employeeMasterService.readForProbationForManager(LoginempId.toString(), employeeId);
                        if (!probationList.isEmpty() || probationList.size() > 0) {
                            finalprobationList1.add(probationList);
                        }
//                        } else if ((DateUtils.isSameDay(tDate, level2Date) || tDate.after(level1Date)) && tDate.before(level2Date)) {
//                            List<?> probationList = employeeMasterService.readForProbationlevel2(LoginempId.toString(), employeeId);
//
//                            if (!probationList.isEmpty() || probationList.size() > 0) {
//                                finalprobationList1.add(probationList);
//                            }
//                        } else if ((DateUtils.isSameDay(tDate, level3Date) || tDate.after(level2Date)) && tDate.before(level3Date)) {
//                            List<?> probationList = employeeMasterService.readForProbationlevel3(LoginempId.toString(), employeeId);
//
//                            if (!probationList.isEmpty() || probationList.size() > 0) {
//                                finalprobationList1.add(probationList);
//                            }
//                        } else if ((DateUtils.isSameDay(tDate, level4Date) || tDate.after(level3Date)) && tDate.before(level4Date)) {
//                            List<?> probationList = employeeMasterService.readForProbationlevel3(LoginempId.toString(), employeeId);
//
//                            if (!probationList.isEmpty() || probationList.size() > 0) {
//                                finalprobationList1.add(probationList);
//                            }
//                        }
                    }
//                      else if (status == 0) {
//
//                    String dateOfJoining = employeeMaster1.getDateOfJoining();
//                    DesignationMaster designationMaster = new DesignationMaster();
//                     designationMaster = designationMasterService.readById(employeeMaster1.getDesignationMaster().getId());
//                     Integer desgnId = designationMaster.getId();
//                     List list = probationPeriodService.readbyDesignation(desgnId);
//                     int probationPeriod = 6;
//                    if (!list.isEmpty()) {
//                        probationPeriod = (int) list.get(0);
//                    }
//                    int pp = probationPeriod - 1;
//                    String today = sdf.format(new Date());
//                    Date tDate = sdf.parse(today);
//                    Date dojdate = sdf.parse(dateOfJoining);
//
//                    Calendar c = Calendar.getInstance();
//                    c.setTime(dojdate);
////                    c.add(Calendar.DATE, 165);
//                    c.add(Calendar.MONTH, pp);
//                    Date datebefore15 = c.getTime();
//                    c.setTime(datebefore15);
//                    c.add(Calendar.DATE, 30);
//
//                    Date level1Date = c.getTime();
//                    c.setTime(level1Date);
//                    c.add(Calendar.DATE, 15);
//                    Date level2Date = c.getTime();
//
//                    c.setTime(level2Date);
//                    c.add(Calendar.DATE, 15);
//                    Date level3Date = c.getTime();
//
//                    c.setTime(level3Date);
//                    c.add(Calendar.DATE, 15);
//                    Date level4Date = c.getTime();
//
//                    if ((DateUtils.isSameDay(tDate, datebefore15) || tDate.after(datebefore15)) && tDate.before(level1Date)) {
//                        List<?> probationList = employeeMasterService.readForProbationForManager(LoginempId.toString(), employeeId);
//
//                        if (!probationList.isEmpty() || probationList.size() > 0) {
//                            finalprobationList1.add(probationList);
//                        }
//                    } else if ((DateUtils.isSameDay(tDate, level2Date) || tDate.after(level1Date)) && tDate.before(level2Date)) {
//                        List<?> probationList = employeeMasterService.readForProbationlevel2(LoginempId.toString(), employeeId);
//
//                        if (!probationList.isEmpty() || probationList.size() > 0) {
//                            finalprobationList1.add(probationList);
//                        }
//                    } else if ((DateUtils.isSameDay(tDate, level3Date) || tDate.after(level2Date)) && tDate.before(level3Date)) {
//                        List<?> probationList = employeeMasterService.readForProbationlevel3(LoginempId.toString(), employeeId);
//
//                        if (!probationList.isEmpty() || probationList.size() > 0) {
//                            finalprobationList1.add(probationList);
//                        }
//                    } else if ((DateUtils.isSameDay(tDate, level4Date) || tDate.after(level3Date)) && tDate.before(level4Date)) {
//                        List<?> probationList = employeeMasterService.readForProbationlevel4(LoginempId.toString(), employeeId);
//
//                        if (!probationList.isEmpty() || probationList.size() > 0) {
//                            finalprobationList1.add(probationList);
//                        }
//                    }
//                }
                }
            }
        }
        List<?> finalprobationList = finalprobationList1;
        request.setAttribute("finalprobationList", finalprobationList);
        mv.getModelMap().put("ptc", ptc);
        mv.setViewName("Probation/ProbationResult");
        return mv;
        
    }
    
    public ModelAndView viewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        ProbationToConfirmation ptc1 = new ProbationToConfirmation();
        String empid = request.getParameter("id");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empid));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        employeeMaster.setEmployeeSubType(employeeSubTypeService.readById(employeeMaster.getEmployeeSubType().getId()));
//        int empSubType = employeeMaster.getEmployeeSubType().getId();
//        List<?> employeeSubType = employeeSubTypeService.readByID(empSubType);
//        if(!employeeSubType.isEmpty()){
//            employeeMaster.setEmployeeSubType((EmployeeSubType) employeeSubType.get(0));
//        }
//        
        ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> l1 = probationToConfirmationService.readForRepeatedId(ptc);
        if (!l1.isEmpty()) {
            ProbationToConfirmation pt;
            pt = (ProbationToConfirmation) l1.get(0);
            String formIssuedate = pt.getFormIssueDate();
            ptc.setFormIssueDate(formIssuedate);
            if (pt.getStatus().equals(4)) {
                ptc.setAssessmentFromDate(pt.getAssessmentFromDate());
                ptc.setAssessmentToDate(pt.getAssessmentToDate());
            } else if (pt.getStatus().equals(0)) {
                String dateOfJoining = employeeMaster.getDateOfJoining();
                ptc.setAssessmentFromDate(dateOfJoining);
                ptc.setAssessmentToDate(pt.getAssessmentToDate());
//                Integer desgnId =employeeMaster.getDesignationMaster().getId();
//                     List list1 = probationPeriodService.readbyDesignation(desgnId);
//                     int probationPeriod = 6;
//                    if (!list1.isEmpty()) {
//                        probationPeriod = (int) list1.get(0);
//                    }
//
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date dojdate = sdf.parse(dateOfJoining);
//            Calendar c = Calendar.getInstance();
//            c.setTime(dojdate);
//            c.add(Calendar.MONTH, probationPeriod);
//            Date newDate = c.getTime();
//            String dateafter6month = sdf.format(newDate);
//            ptc.setAssessmentToDate(dateafter6month);
            } else if (pt.getStatus().equals(10)) {
                ptc = (ProbationToConfirmation) pt;
                ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
                
            }
        } else {
            
        }
        request.setAttribute("empid", empid);
        mv.getModelMap().put("ptc", ptc);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/Probationlevel1");
        return mv;
    }
    
    public ModelAndView level1Submit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        ProbationToConfirmation ptc1 = new ProbationToConfirmation();
        ProbationToConfirmation ptc2 = new ProbationToConfirmation();
        BindException errors = new BindException(ptc, "ptc");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        bind(request, ptc);
        String empId=request.getParameter("empId");
        String ptcId = probationToConfirmationService.getPtcId(empId);
        Integer ptcId1 = Integer.parseInt(ptcId);
                ptc2 = probationToConfirmationService.readById(ptcId1);
        probationtoConfirmationValidator.validate(ptc, errors);
        if (errors.hasErrors()) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            request.setAttribute("ptc", ptc2);
            request.setAttribute("empid", empId);
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Probation/Probationlevel1");
        } else if (ptc.getManagerJustification().equals("")) {
            request.setAttribute("failureMessage",
                    "Error : Mandatory Fields should not be blank.");
            request.setAttribute("ptc", ptc2);
            request.setAttribute("empId", empId);
            mv.addAllObjects(errors.getModel());
            mv.setViewName("Probation/Probationlevel1");
        } else {
            List<?> listrepeat = probationToConfirmationService.readForRepeatedId(ptc);
            if (!listrepeat.isEmpty()) {
                List<?> list = probationToConfirmationService.readForId(ptc);
                Integer id = (Integer) list.get(0);
                ptc1 = probationToConfirmationService.readById(id);
                if (ptc1.getStatus() == 4) {
                    ptc1.setStatus(8);
                    probationToConfirmationService.update(ptc1);
                    request.setAttribute("successMessage",
                            "Information : Successfully Submited to Functional head for Confirmation.");
                    ptc.setStatus(1);
                    String requestdate = sdf.format(new Date());
                    ptc.setReportingManagerSubmitDate(requestdate);
                    HttpSession session = request.getSession();
                    EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
                    String employeeId = employeeMaster.getId().toString();
                    ptc.setReportingManagerId(employeeId);
                    probationToConfirmationService.create(ptc);
                    request.setAttribute("successMessage",
                            "Information : Successfully Submited to Functional head for Confirmation.");
                    mv = searchSubmit(request, response);
                } else if (ptc1.getStatus() == 0 || ptc1.getStatus() == 10) {
                    ptc1.setStatus(1);
                    String requestdate = sdf.format(new Date());
                    ptc.setReportingManagerSubmitDate(requestdate);
                    HttpSession session = request.getSession();
                    EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
                    String employeeId = employeeMaster.getId().toString();
                    ptc1.setReportingManagerId(employeeId);
                    ptc1.setEmployeeMasterByEmployeeMasterId(ptc.getEmployeeMasterByEmployeeMasterId());
                    ptc1.setAssessmentFromDate(ptc.getAssessmentFromDate());
                    ptc1.setAssessmentToDate(ptc.getAssessmentToDate());
                    ptc1.setJobHandled(ptc.getJobHandled());
                    ptc1.setPerformanceRating(ptc.getPerformanceRating());
                    ptc1.setRecommendationSelect(ptc.getRecommendationSelect());
                    ptc1.setJobKnowledge1(ptc.getJobKnowledge1());
                    ptc1.setJobKnowledge2(ptc.getJobKnowledge2());
                    ptc1.setJobKnowledge3(ptc.getJobKnowledge3());
                    ptc1.setJobKnowledge4(ptc.getJobKnowledge4());
                    ptc1.setJobKnowledge5(ptc.getJobKnowledge5());
                    ptc1.setQuality1(ptc.getQuality1());
                    ptc1.setQuality2(ptc.getQuality2());
                    ptc1.setQuality3(ptc.getQuality3());
                    ptc1.setQuality4(ptc.getQuality4());
                    ptc1.setQuality5(ptc.getQuality5());
                    ptc1.setLearning1(ptc.getLearning1());
                    ptc1.setLearning2(ptc.getLearning2());
                    ptc1.setLearning3(ptc.getLearning3());
                    ptc1.setLearning4(ptc.getLearning4());
                    ptc1.setLearning5(ptc.getLearning5());
                    ptc1.setGeneral1(ptc.getGeneral1());
                    ptc1.setGeneral2(ptc.getGeneral2());
                    ptc1.setGeneral3(ptc.getGeneral3());
                    ptc1.setGeneral4(ptc.getGeneral4());
                    ptc1.setGeneral5(ptc.getGeneral5());
                    ptc1.setEmployeeFullfill(ptc.getEmployeeFullfill());
                    ptc1.setEmployeeStrengths(ptc.getEmployeeStrengths());
                    ptc1.setEmployeeImprove(ptc.getEmployeeImprove());
                    ptc1.setEmployeeTrainingAttend(ptc.getEmployeeTrainingAttend());
                    ptc1.setOverallPerformance(ptc.getOverallPerformance());
                    String today = sdf.format(new Date());
                    ptc1.setReportingManagerSubmitDate(today);
                    if (ptc.getRecommendationSelect().equals("No")) {
                        ptc1.setRecommendationRemark(ptc.getRecommendationRemark());
                    } else if (ptc.getRecommendationSelect().equals("Extend")) {
                        ptc1.setRecommendationExtendPeriod(ptc.getRecommendationExtendPeriod());
                        ptc1.setRecommendationRemark(ptc.getRecommendationRemark());
                    }
                    ptc1.setManagerJustification(ptc.getManagerJustification());
                    probationToConfirmationService.createOrUpdate(ptc1);
                    request.setAttribute("successMessage",
                            "Information : Successfully Submited to Functional head for Confirmation.");
                    mv = searchSubmit(request, response);
                    
                }
            } else {
                
            }
            String eId = request.getParameter("employeeMasterByEmployeeMasterId.id");
            //    Email Sent to Employee
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                DesignationMaster designationMaster = new DesignationMaster();
//                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(eId));
//                // id 96 is status for Probation to confirmation Submitted by Manager(Email for Employee)
//                emailTemplate = emailTemplateService.readById(96);
//                String To = employeeRequestee.getOfficeEmailId();
//                String from = employeeMasterModel.getOfficeEmailId();
//                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//                String msg = emailTemplate.getBodytext();
//                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//
//            }
            //    Email Sent to FH
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(eId));
                String FHID = employeeRequestee.getReportingManagerLevel5();
                EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(FHID));
                EmployeeMaster employee = employeeMasterService.readById(Integer.parseInt(eId));
                // id 97 is status for Probation to confirmation Submitted by Manager(Email for FH)
                emailTemplate = emailTemplateService.readById(97);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employee.getEmployeeName());
                String msg = emailTemplate.getBodytext();
                msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                sendMail.sendMail(from, To, Subject, msg);
                
                String name = "Probation To Conformation";
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
                            msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                            msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                            sendMail.sendMail(from1, To1, subject1, msg1);
                            
                        }
                    }
                }
            } catch (Exception e) {
                
            }
            //    Email Sent to HR having Probation to confirmation Rights
            List<?> ptcAdminList = userRightMasterService.readProbationToConfirmationAdminList();
            for (Object o : ptcAdminList) {
                Object[] o1 = (Object[]) o;
                int AdminId = (int) o1[0];
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeMasterHr = new EmployeeMaster();
                    employeeMasterHr = employeeMasterService.readById(AdminId);
                    EmployeeMaster employee = employeeMasterService.readById(Integer.parseInt(eId));
                    // id 98 is status for Probation to confirmation Submitted by Manager(Email for HR)
                    emailTemplate = emailTemplateService.readById(98);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                } catch (Exception e) {
                    
                }
            }
            mv = searchSubmit(request, response);
        }
        request.setAttribute("empId", empId);
        return mv;
    }

//Manager Level4 Approval:-
    public ModelAndView functionalheadResultClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        String employeeId = employeeMaster.getId().toString();
        ptc.setFunctionalHeadId(employeeId);
        List headlist = probationToConfirmationService.readForFunctionalHead(ptc);
        mv.getModelMap().put("ptc", ptc);
        mv.getModelMap().put("headlist", headlist);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/Probationlevel2Result");
        return mv;
    }
    
    public ModelAndView functionalheadview(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        String id = request.getParameter("id");
        String Empid = request.getParameter("empId");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(Empid));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        mv.getModelMap().put("ptc", ptc);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/Probationlevel2");
        return mv;
    }
    
    public ModelAndView functionalheadSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        ProbationToConfirmation ptc1 = new ProbationToConfirmation();
        BindException errors = new BindException(ptc, "ptc");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String id = request.getParameter("id");
        String Emid = request.getParameter("Emid");
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        bind(request, ptc1);
        String today = sdf.format(new Date());
        Date tDate = sdf.parse(today);
        ptc.setFunctionalHeadSubmitDate(today);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster1.getId().toString();
        ptc.setFunctionalHeadId(empId);
        ptc.setImprovementComment(ptc1.getImprovementComment());
        ptc.setApprovalSelect(ptc1.getApprovalSelect());
        if (ptc.getApprovalSelect().equals("No")) {
            ptc.setApprovalRemark(ptc1.getApprovalRemark());
        } else if (ptc.getApprovalSelect().equals("Extend")) {
            ptc.setApprovalExtendPeriod(ptc1.getApprovalExtendPeriod());
            ptc.setApprovalRemark(ptc1.getApprovalRemark());
        }
        ptc.setStatus(2);
        ptc.setManagerJustification(ptc1.getManagerJustification());
        ptc.setHrAdditionalRemark(ptc1.getHrAdditionalRemark());
        String performanceRating = request.getParameter("performanceRating");
        ptc.setPerformanceRating(performanceRating);
        probationToConfirmationService.update(ptc);
        request.setAttribute("successMessage",
                "Information : Submitted Sucessfully");
        mv.getModelMap().put("ptc", ptc);
        mv = functionalheadResultClick(request, response);
        //    Email Sent to Employee
//        try {
//            EmailTemplate emailTemplate = new EmailTemplate();
//            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//            DesignationMaster designationMaster = new DesignationMaster();
//            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//            EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
//            // id 99 is status for Probation to confirmation Submitted by FH(Email for Employee)
//            emailTemplate = emailTemplateService.readById(99);
//            String To = employeeRequestee.getOfficeEmailId();
//            String from = employeeMasterModel.getOfficeEmailId();
//            String Subject = emailTemplate.getSubject();
//            Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//            String msg = emailTemplate.getBodytext();
//            msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//            sendMail.sendMail(from, To, Subject, msg);
//        } catch (Exception e) {
//
//        }
        //      Email Sent to ReportingManager1
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
            String rmId = employeeRequestee.getReportingManagerLevel1();
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
            EmployeeMaster employee = employeeMasterService.readById(Integer.parseInt(Emid));
            // id 100 is status for Probation to confirmation Submitted by FH(Email for Manager)
            emailTemplate = emailTemplateService.readById(100);
            String To = employeeMasterHr.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employee.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
            
        }
        //    Email Sent to HR having Probation to confirmation Rights
        List<?> ptcAdminList = userRightMasterService.readProbationToConfirmationAdminList();
        for (Object o : ptcAdminList) {
            Object[] o1 = (Object[]) o;
            int AdminId = (int) o1[0];
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeMasterHr = new EmployeeMaster();
                employeeMasterHr = employeeMasterService.readById(AdminId);
                EmployeeMaster employee = employeeMasterService.readById(Integer.parseInt(Emid));
                // id 100 is status for Probation to confirmation Submitted by FH(Email for HR)
                emailTemplate = emailTemplateService.readById(101);
                String To = employeeMasterHr.getOfficeEmailId();
                String from = employeeMasterModel.getOfficeEmailId();
                String Subject = emailTemplate.getSubject();
                Subject = Subject.replaceAll("\\{user\\}", employee.getEmployeeName());
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
    
    public ModelAndView functionalheadSubmitOLD(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        ProbationToConfirmation ptc1 = new ProbationToConfirmation();
        BindException errors = new BindException(ptc, "ptc");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String id = request.getParameter("id");
        String Emid = request.getParameter("Emid");
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        bind(request, ptc1);
        String today = sdf.format(new Date());
        Date tDate = sdf.parse(today);
        ptc.setFunctionalHeadSubmitDate(today);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster1 = (EmployeeMaster) session.getAttribute("employeeInfo");
        String empId = employeeMaster1.getId().toString();
        ptc.setFunctionalHeadId(empId);
        ptc.setImprovementComment(ptc1.getImprovementComment());
        ptc.setApprovalSelect(ptc1.getApprovalSelect());
        
        if (ptc.getApprovalSelect().equals("Yes")) {
            ptc.setStatus(2);
// employee type confirm
            EmployeeMaster employeeMaster = new EmployeeMaster();
            employeeMaster = employeeMasterService.readById(Integer.parseInt(Emid));
            employeeMaster.setEmployeeType("Confirmation");
            employeeMasterService.update(employeeMaster);
            request.setAttribute("successMessage",
                    "Information : Employee Type changed to 'confirmation' ");
        } else if (ptc.getApprovalSelect().equals("No")) {
            ptc.setStatus(3);
            ptc.setApprovalRemark(ptc1.getApprovalRemark());
            request.setAttribute("successMessage",
                    "Information : Submited Sucessfully");
        } else if (ptc.getApprovalSelect().equals("Extend")) {
            ptc.setStatus(4);
            ptc.setApprovalRemark(ptc1.getApprovalRemark());
            ptc.setApprovalExtendPeriod(ptc1.getApprovalExtendPeriod());
            String doj = ptc1.getAssessmentFromDate();
            String date6aftermonthString = ptc1.getAssessmentToDate();
            Date date6aftermonth = sdf.parse(date6aftermonthString);
            if (ptc.getApprovalExtendPeriod().equals("1Month")) {
                Calendar c = Calendar.getInstance();
                c.setTime(date6aftermonth);
                c.add(Calendar.MONTH, 1);
                Date Date1 = c.getTime();
                String Date1String = sdf.format(Date1);
                ptc.setAssessmentFromDate(doj);
                ptc.setAssessmentToDate(Date1String);
            } else if (ptc.getApprovalExtendPeriod().equals("2Month")) {
                Calendar c = Calendar.getInstance();
                c.setTime(date6aftermonth);
                c.add(Calendar.MONTH, 2);
                Date Date1 = c.getTime();
                String Date1String = sdf.format(Date1);
                ptc.setAssessmentFromDate(doj);
                ptc.setAssessmentToDate(Date1String);
            } else if (ptc.getApprovalExtendPeriod().equals("3Month")) {
                Calendar c = Calendar.getInstance();
                c.setTime(date6aftermonth);
                c.add(Calendar.MONTH, 3);
                Date Date1 = c.getTime();
                String Date1String = sdf.format(Date1);
                ptc.setAssessmentFromDate(doj);
                ptc.setAssessmentToDate(Date1String);
            } else if (ptc.getApprovalExtendPeriod().equals("4Month")) {
                Calendar c = Calendar.getInstance();
                c.setTime(date6aftermonth);
                c.add(Calendar.MONTH, 4);
                Date Date1 = c.getTime();
                String Date1String = sdf.format(Date1);
                ptc.setAssessmentFromDate(doj);
                ptc.setAssessmentToDate(Date1String);
            } else if (ptc.getApprovalExtendPeriod().equals("5Month")) {
                Calendar c = Calendar.getInstance();
                c.setTime(date6aftermonth);
                c.add(Calendar.MONTH, 5);
                Date Date1 = c.getTime();
                String Date1String = sdf.format(Date1);
                ptc.setAssessmentFromDate(doj);
                ptc.setAssessmentToDate(Date1String);
            } else if (ptc.getApprovalExtendPeriod().equals("6Month")) {
                Calendar c = Calendar.getInstance();
                c.setTime(date6aftermonth);
                c.add(Calendar.MONTH, 6);
                Date Date1 = c.getTime();
                String Date1String = sdf.format(Date1);
                ptc.setAssessmentFromDate(doj);
                ptc.setAssessmentToDate(Date1String);
            }
            request.setAttribute("successMessage",
                    "Information : Probation Period Extended Sucessfully.");
        }
        probationToConfirmationService.update(ptc);
        mv.getModelMap().put("ptc", ptc);
        mv = functionalheadResultClick(request, response);
        return mv;
    }

//HR Approval:-
    public ModelAndView hrResultClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        
        List<?> pendingProbationList = employeeMasterService.readProbationByAdmin();
        Map<Integer, String> map = new HashMap<Integer, String>();
        if (!pendingProbationList.isEmpty()) {
            for (Object o : pendingProbationList) {
                Object[] o1 = (Object[]) o;
                Integer emptabid = (Integer) o1[0];
                String empid = "" + o1[1];
                String empname = "" + o1[2];
                
                String ptcid = "" + o1[5];
                String status = "" + o1[6];
                
                if (!"null".equals(ptcid)) {
                    String assesmentdate = "" + o1[7];
                    map.put(emptabid, assesmentdate);
                } else {
                    Integer designationid = (Integer) o1[4];
                    List list = probationPeriodService.readbyDesignation(designationid);
                    int probationPeriod = 3;
                    if (!list.isEmpty()) {
                        probationPeriod = (int) list.get(0);
                    }
                    String date = "" + o1[3];
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date d = sdf.parse(date);
                    c.setTime(d);
                    
                    c.add(Calendar.MONTH, probationPeriod);
//                    c.add(Calendar.MONTH, 6);
                    date = sdf.format(c.getTime());
                    map.put(emptabid, date);
                }
            }
        }

//        List hrlist = probationToConfirmationService.readForHr(ptc);
        mv.getModelMap().put("hrlist", pendingProbationList);
        mv.getModelMap().put("mapVal", map);
        mv.getModelMap().put("ptc", ptc);
        mv.setViewName("Probation/ProbationHrResult");
        return mv;
    }
    
    public ModelAndView hrview(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        String id = request.getParameter("id");
        String Empid = request.getParameter("empId");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(Empid));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        employeeMaster.setEmployeeSubType(employeeSubTypeService.readById(employeeMaster.getEmployeeSubType().getId()));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        mv.getModelMap().put("ptc", ptc);
        request.setAttribute("id", id);
        request.setAttribute("empId", Empid);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/ProbationHrView");
        return mv;
    }
    
    public ModelAndView hrSubmit(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        ProbationToConfirmation ptc1 = new ProbationToConfirmation();
        String id = request.getParameter("id");
        String Emid = request.getParameter("Emid");
        String submitType = request.getParameter("submit");
        BindException errors = new BindException(ptc, "ptc");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        bind(request, ptc1);
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        if (submitType.equals("approve")) {
            
            ptc.setRecomendationByHr(ptc1.getRecomendationByHr());
            ptc.setImprovementComment(ptc1.getImprovementComment());
            
            ptc.setHrSelect(ptc1.getHrSelect());
            if (ptc.getHrSelect().equals("Yes")) {
                ptc.setStatus(5);

//// employee type confirm
                String ConfirmDate = ptc.getAssessmentToDate();
                Date todayDate = new Date();
                Date ConfirmDate1 = sdf.parse(ConfirmDate);
                if (ConfirmDate1.before(todayDate)) {
                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster = employeeMasterService.readById(Integer.parseInt(Emid));
                    employeeMaster.setEmployeeType("Confirmed");
                    employeeMasterService.update(employeeMaster);
                    
                }
                //    Email Sent to Employee
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                DesignationMaster designationMaster = new DesignationMaster();
//                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
//                // id 102 is status for Probation to confirmation Approved by HR(Email for Employee)
//                emailTemplate = emailTemplateService.readById(102);
//                String To = employeeRequestee.getOfficeEmailId();
//                String from = employeeMasterModel.getOfficeEmailId();
//                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//                String msg = emailTemplate.getBodytext();
//                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//
//            }
                //      Email Sent to ReportingManager1
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                    String rmId = employeeRequestee.getReportingManagerLevel1();
                    EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
                    // id 103 is status for Probation to confirmation Approved by HR(Email for Manager)
                    emailTemplate = emailTemplateService.readById(103);
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
                //    Email Sent to FH
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                    String FHID = employeeRequestee.getReportingManagerLevel5();
                    EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(FHID));
                    // id 104 is status for Probation to confirmation Approved by HR(Email for Manager)
                    emailTemplate = emailTemplateService.readById(104);
                    String To = employeeMasterHr.getOfficeEmailId();
                    String from = employeeMasterModel.getOfficeEmailId();
                    String Subject = emailTemplate.getSubject();
                    Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
                    String msg = emailTemplate.getBodytext();
                    msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                    msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                    msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                    sendMail.sendMail(from, To, Subject, msg);
                    
                    String name = "Probation To Conformation";
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
                                msg1 = msg1.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                msg1 = msg1.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
                                msg1 = msg1.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
                                sendMail.sendMail(from1, To1, subject1, msg1);
                                
                            }
                        }
                    }
                    
                } catch (Exception e) {
                    
                }
            } else if (ptc.getHrSelect().equals("No")) {
                ptc.setStatus(3);
                ptc.setHrApprovalRemark(ptc1.getHrApprovalRemark());
                request.setAttribute("successMessage",
                        "Information : Submited Sucessfully");
                //    Email Sent to Employee
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                DesignationMaster designationMaster = new DesignationMaster();
//                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
//                // id 109 is status for Probation to confirmation Rejected by HR(Email for Employee)
//                emailTemplate = emailTemplateService.readById(109);
//                String To = employeeRequestee.getOfficeEmailId();
//                String from = employeeMasterModel.getOfficeEmailId();
//                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//                String msg = emailTemplate.getBodytext();
//                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//
//            }
                //      Email Sent to ReportingManager1
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                    String rmId = employeeRequestee.getReportingManagerLevel1();
                    EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
                    // id 110 is status for Probation to confirmation Rejected by HR(Email for Manager)
                    emailTemplate = emailTemplateService.readById(110);
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
                //    Email Sent to FH
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                    String FHID = employeeRequestee.getReportingManagerLevel5();
                    EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(FHID));
                    // id 111 is status for Probation to confirmation Rejected by HR(Email for Manager)
                    emailTemplate = emailTemplateService.readById(111);
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
            } else if (ptc.getHrSelect().equals("Extend")) {
                ptc.setStatus(4);
                ptc.setHrApprovalRemark(ptc1.getHrApprovalRemark());
                ptc.setHrExtendPeriod(ptc1.getHrExtendPeriod());
                String doj = ptc1.getAssessmentFromDate();
                String date6aftermonthString = ptc1.getAssessmentToDate();
                Date date6aftermonth = sdf.parse(date6aftermonthString);
                if (ptc.getHrExtendPeriod().equals("1Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 1);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("2Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 2);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("3Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 3);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("4Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 4);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("5Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 5);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("6Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 6);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                    
                } else if (ptc.getHrExtendPeriod().equals("7Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 7);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("8Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 8);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                } else if (ptc.getHrExtendPeriod().equals("9Month")) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(date6aftermonth);
                    c.add(Calendar.MONTH, 9);
                    Date Date1 = c.getTime();
                    String Date1String = sdf.format(Date1);
                    ptc.setAssessmentFromDate(doj);
                    ptc.setAssessmentToDate(Date1String);
                }
                request.setAttribute("successMessage",
                        "Information : Probation Period Extended Sucessfully.");
                //    Email Sent to Employee
//            try {
//                EmailTemplate emailTemplate = new EmailTemplate();
//                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//                DesignationMaster designationMaster = new DesignationMaster();
//                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
//                EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
//                // id 105 is status for Probation to confirmation Extended by HR(Email for Employee)
//                emailTemplate = emailTemplateService.readById(105);
//                String To = employeeRequestee.getOfficeEmailId();
//                String from = employeeMasterModel.getOfficeEmailId();
//                String Subject = emailTemplate.getSubject();
//                Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
//                String msg = emailTemplate.getBodytext();
//                msg = msg.replaceAll("\\{to_user\\}", employeeRequestee.getEmployeeName());
//                msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//                msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//                sendMail.sendMail(from, To, Subject, msg);
//            } catch (Exception e) {
//
//            }
                //      Email Sent to ReportingManager1
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                    String rmId = employeeRequestee.getReportingManagerLevel1();
                    EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
                    // id 106 is status for Probation to confirmation Extended by HR(Email for Manager)
                    emailTemplate = emailTemplateService.readById(106);
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
                //    Email Sent to FH
                try {
                    EmailTemplate emailTemplate = new EmailTemplate();
                    EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                    DesignationMaster designationMaster = new DesignationMaster();
                    designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                    EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                    String FHID = employeeRequestee.getReportingManagerLevel5();
                    EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(FHID));
                    // id 107 is status for Probation to confirmation Extended by HR(Email for Manager)
                    emailTemplate = emailTemplateService.readById(107);
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
//        if (ptc.getStatus().equals(4)) {
//            ptc.setStatus(6);
//        } else {
//            ptc.setStatus(5);
//        }
        } else if (submitType.equals("rework")) {
            ptc.setStatus(10);   // status 10 for Rework
            request.setAttribute("successMessage",
                    "Information : Reworked Sucessfully");
            
            try {
                EmailTemplate emailTemplate = new EmailTemplate();
                EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
                EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(Emid));
                String rmId = employeeRequestee.getReportingManagerLevel1();
                EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
                // id 1390 is status for Probation to confirmation Reworked by HR(Email for Manager)
                emailTemplate = emailTemplateService.readById(139);
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
        String hrdate = sdf.format(new Date());
        ptc.setHrSubmitDate(hrdate);
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        ptc.setEmployeeMasterByHrId(employeeMaster);
        ptc.setPerformanceRating(request.getParameter("performanceRating"));
        probationToConfirmationService.update(ptc);
//        request.setAttribute("successMessage", "Information : Successfully Submited.");
        mv.getModelMap().put("ptc", ptc);
        mv = hrResultClick(request, response);
        return mv;
    }

//    Employee Side
    public ModelAndView empClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List emplist = probationToConfirmationService.readForEmp(ptc);
        if (!emplist.isEmpty()) {
            for (Object o : emplist) {
                Object[] o1 = (Object[]) o;
                int Status = Integer.parseInt("" + o1[5]);
                request.setAttribute("Status", Status);
                if (Status == 0) {
                    int id = Integer.parseInt("" + o1[4]);
                    EmployeeMaster em = new EmployeeMaster();
                    List<?> list = employeeMasterService.readManagerLevel1(em);
                    if (!list.isEmpty()) {
                        request.setAttribute("managerName", list.get(0));
                    }
                } else if (Status == 1) {
                    
                    int id = Integer.parseInt("" + o1[8]);
                    EmployeeMaster em = new EmployeeMaster();
                    em = employeeMasterService.readById(id);
                    request.setAttribute("managerName", em.getEmployeeName());
                } else if (Status == 2) {
                    int FHid = Integer.parseInt("" + o1[9]);
                    EmployeeMaster em1 = new EmployeeMaster();
                    em1 = employeeMasterService.readById(FHid);
                    request.setAttribute("functionalHeadName", em1.getEmployeeName());
                }
            }
        }
        mv.getModelMap().put("emplist", emplist);
        mv.getModelMap().put("ptc", ptc);
        mv.setViewName("Probation/empResult");
        return mv;
    }
    
    public ModelAndView empViewClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        String id = request.getParameter("id");
        String Empid = request.getParameter("empId");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(Empid));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        mv.getModelMap().put("ptc", ptc);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/ProbationHrView");
        return mv;
    }

//this method is for display chart on HrDashboard.
    public ModelAndView hrDashboard(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> probationToConfirmationRequestsList = probationToConfirmationService.readProbationToConfirmationList();
        String pending = "";
        String completed = "";
        
        Object[] probationToConfirmationReportArray;
        if (!probationToConfirmationRequestsList.isEmpty()) {
            probationToConfirmationReportArray = (Object[]) probationToConfirmationRequestsList.get(0);
            pending = "" + probationToConfirmationReportArray[0];
            completed = "" + probationToConfirmationReportArray[1];
        }
        if ("null".equals(pending) || "".equals(pending)) {
            pending = "0";
        }
        if ("null".equals(completed) || "".equals(completed)) {
            completed = "0";
        }
        String probationToCinfirmationReportString = "['Pending', "
                + pending
                + "],['Completed', "
                + completed
                + "]";
        mv.addObject("probationToCinfirmationReportString", probationToCinfirmationReportString);
        
        mv.setViewName("forward:appraisalPerformance.htm?act=hrDashboard");
        return mv;
    }
    
    public ModelAndView viewProbationToConfirmation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        List hrlist = employeeMasterService.readForCommonList();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Object hrlist1 : hrlist) {
            Object[] ob = (Object[]) hrlist1;
            int id = (Integer) ob[0];
            String date = (String) ob[3];
            String assessmentToDateStr = "";
            int probationToConfirmationId = 0;
            try {
                probationToConfirmationId = (Integer) ob[6];
                assessmentToDateStr = (String) ob[7];
            } catch (Exception e) {
            }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(date);
            c.setTime(d);
            c.add(Calendar.MONTH, 6);
            date = sdf.format(c.getTime());
//            if (probationToConfirmationId == 0) {
//                map.put(id, assessmentToDateStr);
//            } else {
//                map.put(id, date);
//            }
            if (!assessmentToDateStr.equals("")) {
                map.put(id, assessmentToDateStr);
            } else {
                map.put(id, date);
            }
        }
        mv.getModelMap().put("hrlist", hrlist);
        mv.getModelMap().put("mapVal", map);
        mv.getModelMap().put("ptc", ptc);
//        mv.setViewName("Probation/ProbationHrResult");
        mv.setViewName("Probation/SearchProbationToConfirmation");
        return mv;
    }
    
    public ModelAndView exportToExcel(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        List hrlist = employeeMasterService.readForCommonList();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Object hrlist1 : hrlist) {
            Object[] ob = (Object[]) hrlist1;
            int id = (Integer) ob[0];
            String date = (String) ob[3];
            String assessmentToDateStr = "";
            int probationToConfirmationId = 0;
            try {
                probationToConfirmationId = (Integer) ob[6];
                assessmentToDateStr = (String) ob[7];
            } catch (Exception e) {
            }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(date);
            c.setTime(d);
            c.add(Calendar.MONTH, 6);
            date = sdf.format(c.getTime());
            if (!assessmentToDateStr.equals("")) {
                map.put(id, assessmentToDateStr);
            } else {
                map.put(id, date);
            }
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ProbationList.xls");
        mv.getModelMap().put("hrlist", hrlist);
        mv.getModelMap().put("mapVal", map);
        mv.getModelMap().put("ptc", ptc);
        mv.setViewName("Probation/probationExcel");
        return mv;
    }
    
    public ModelAndView probationManualTrigger(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        String empId = request.getParameter("empIdVal");
        String endDate = request.getParameter("endDate");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        ptc.setAssessmentFromDate(employeeMaster.getDateOfJoining());
        ptc.setAssessmentToDate(endDate);
        ptc.setStatus(0);
        probationToConfirmationService.create(ptc);
        //      Email Sent to ReportingManager1
        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMasterModel = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
            DesignationMaster designationMaster = new DesignationMaster();
            designationMaster = designationMasterService.readById(employeeMasterModel.getDesignationMaster().getId());
            EmployeeMaster employeeRequestee = employeeMasterService.readById(Integer.parseInt(empId));
            String rmId = employeeRequestee.getReportingManagerLevel1();
            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
            // id 130 is status for Probation to confirmation triggered(Email for Manager)
            emailTemplate = emailTemplateService.readById(130);
            String To = employeeMasterHr.getOfficeEmailId();
            String from = employeeMasterModel.getOfficeEmailId();
            String Subject = emailTemplate.getSubject();
            Subject = Subject.replaceAll("\\{user\\}", employeeRequestee.getEmployeeName());
            String msg = emailTemplate.getBodytext();
            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
//            msg = msg.replaceAll("\\{from_user\\}", employeeMasterModel.getEmployeeName());
//            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
            
        }
        request.setAttribute("successMessage",
                "Information : Triggerred Sucessfully");
        mv = hrResultClick(request, response);
        return mv;
    }
    
    public synchronized void probationToconfirmationAddInEmployeeMaster() {
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String newDate = sdf.format(date);
        ptc.setAssessmentFromDate(newDate);
        List<?> list = probationToConfirmationService.readConfimationDateByTodayDateWise(ptc);
        if (!list.isEmpty()) {
            for (Object o : list) {
                ProbationToConfirmation ptc1 = (ProbationToConfirmation) o;
                int empId = ptc1.getEmployeeMasterByEmployeeMasterId().getId();
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster = employeeMasterService.readById(empId);
                employeeMaster.setEmployeeType("Confirmed");
                employeeMasterService.update(employeeMaster);
            }
        }
        
    }
    
    public synchronized void probationToconfirmationCheck() throws ParseException {
        
        List<?> empList = employeeMasterService.readForProbationToConfirmation();
        List<Object> finalprobationList = new ArrayList<>();
        List<Object> extendedprobationList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
        String today = sdf.format(new Date());
        Date tDate = sdf.parse(today);
        if (!empList.isEmpty()) {
            for (Object o : empList) {
                EmployeeMaster employeeMaster = new EmployeeMaster();
                employeeMaster = (EmployeeMaster) o;
//                if(employeeMaster.getId()==1799){
                DesignationMaster designationMaster = new DesignationMaster();
                designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                Integer desgnId = designationMaster.getId();
                List list = probationPeriodService.readbyDesignation(desgnId);
                int probationPeriod = 3;
                if (!list.isEmpty()) {
                    probationPeriod = (int) list.get(0);
                }
                int pp = probationPeriod - 1;
//                double pp = probationPeriod - 0.5;
                String dojstring = employeeMaster.getDateOfJoining();
                Date dojdate = null;
                try {
                    dojdate = sdf.parse(dojstring);
                } catch (Exception e) {
                    dojdate = sdf1.parse(dojstring);
                }
                Calendar c = Calendar.getInstance();
                c.setTime(dojdate);
//                c.add(Calendar.MONTH, pp);
                c.add(Calendar.MONTH, pp);
                c.add(Calendar.DATE, 14);
                Date dateAfterPP = c.getTime();
                String checkdateString = sdf.format(dateAfterPP);
                if (DateUtils.isSameDay(tDate, dateAfterPP)) {
                    finalprobationList.add(employeeMaster);
                }
                if (tDate.after(dateAfterPP)) {
                    extendedprobationList.add(employeeMaster);
                }
//            }
            }
            System.out.println("---------------------" + finalprobationList);
            if (!finalprobationList.isEmpty()) {
                for (Object o : finalprobationList) {
                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster = (EmployeeMaster) o;
                    Integer empTabId = employeeMaster.getId();
                    ProbationToConfirmation ptc = new ProbationToConfirmation();
                    ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
                    List<?> listrepeat = probationToConfirmationService.readForRepeatedId(ptc);
                    if (listrepeat.isEmpty()) {
                        String doj = employeeMaster.getDateOfJoining();
                        Date dojdate = null;
                        try {
                            dojdate = sdf.parse(doj);
                        } catch (Exception e) {
                            dojdate = sdf1.parse(doj);
                        }
                        DesignationMaster designationMaster = new DesignationMaster();
                        designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
                        Integer desgnId = designationMaster.getId();
                        List list = probationPeriodService.readbyDesignation(desgnId);
                        int probationPeriod = 3;
                        if (!list.isEmpty()) {
                            probationPeriod = (int) list.get(0);
                        }
                        Calendar c = Calendar.getInstance();
                        c.setTime(dojdate);
                        c.add(Calendar.MONTH, probationPeriod);
                        Date dateAdded = c.getTime();
                        String dateAddedstring = sdf.format(dateAdded);

//                        Boolean flag1 = employeeMasterService.checkLevel1AndLevel6FunctionheadByEmployeeMasterId(employeeMaster.getId());
//                        Boolean flag = employeeMasterService.checkLevel1AndLevel5FunctionheadByEmployeeMasterId(Integer.parseInt(employeeMaster.getReportingManagerLevel5()));
                        
//                        if (flag) {
//                            ptc.setStatus(1);
//                            ptc.setManagerJustification("Same person has both the Reporting Manager and Funtional Head permission");
//                        } else {
                            ptc.setStatus(0);
//                        }
                        ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
                        ptc.setAssessmentFromDate(doj);
                        ptc.setAssessmentToDate(dateAddedstring);
                        ptc.setFormIssueDate(today);
                        probationToConfirmationService.create(ptc);
                        //      Email Sent to ReportingManager1
                        try {
                            EmailTemplate emailTemplate = new EmailTemplate();
                            String rmId = employeeMaster.getReportingManagerLevel1();
                            EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
                            // id 130 is status for Probation to confirmation
                            emailTemplate = emailTemplateService.readById(130);
                            String To = employeeMasterHr.getOfficeEmailId();
                            String from = "";
                            String Subject = emailTemplate.getSubject();
                            Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                            String msg = emailTemplate.getBodytext();
                            msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                            sendMail.sendMail(from, To, Subject, msg);
                        } catch (Exception e) {
                            
                        }
                    }
                }
            }
            System.out.println("---------------------" + extendedprobationList);
            if (!extendedprobationList.isEmpty()) {
                for (Object o : extendedprobationList) {
                    EmployeeMaster employeeMaster = new EmployeeMaster();
                    employeeMaster = (EmployeeMaster) o;
                    Integer empTabId = employeeMaster.getId();
                    ProbationToConfirmation ptc = new ProbationToConfirmation();
                    ptc.setEmployeeMasterByEmployeeMasterId(employeeMaster);
                    List<?> listrepeat = probationToConfirmationService.readForRepeatedId(ptc);
                    if (!listrepeat.isEmpty()) {
                        // check assesment to date if sattus 4 i.e extended request
                        for (Object listrepeat1 : listrepeat) {
                            ProbationToConfirmation ptc1 = new ProbationToConfirmation();
                            ptc1 = (ProbationToConfirmation) listrepeat1;
                            int Status = ptc1.getStatus();
                            if (Status == 4) {
                                
                                String assessmentToDatestring = ptc1.getAssessmentToDate();
                                Date assessmentToDate = sdf.parse(assessmentToDatestring);
                                
                                Calendar c = Calendar.getInstance();
                                c.setTime(assessmentToDate);
                                c.add(Calendar.MONTH, -1);
                                Date datebefore1 = c.getTime();
                                
                                if (DateUtils.isSameDay(tDate, datebefore1)) {
                                    //      Email Sent to ReportingManager1
                                    try {
                                        EmailTemplate emailTemplate = new EmailTemplate();
                                        String rmId = employeeMaster.getReportingManagerLevel1();
                                        EmployeeMaster employeeMasterHr = employeeMasterService.readById(Integer.parseInt(rmId));
                                        // id 133 is status for Probation to confirmation
                                        emailTemplate = emailTemplateService.readById(133);
                                        String To = employeeMasterHr.getOfficeEmailId();
                                        String from = "";
                                        String Subject = emailTemplate.getSubject();
                                        Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
                                        String msg = emailTemplate.getBodytext();
                                        msg = msg.replaceAll("\\{to_user\\}", employeeMasterHr.getEmployeeName());
                                        
                                        sendMail.sendMail(from, To, Subject, msg);
                                    } catch (Exception e) {
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public ModelAndView printClick(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        String id = request.getParameter("id");
        String Empid = request.getParameter("empId");
        request.setAttribute("id", id);
        request.setAttribute("empId", Empid);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(Empid));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        employeeMaster.setEmployeeSubType(employeeSubTypeService.readById(employeeMaster.getEmployeeSubType().getId()));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        ptc = probationToConfirmationService.readById(Integer.parseInt(id));
        mv.getModelMap().put("ptc", ptc);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/ProbationPrictView");
        return mv;
    }
    
    public ModelAndView probationconfirmedEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        List probatonConfirmedList = probationToConfirmationService.readConfirmedEmployee();
        
        request.setAttribute("probatonConfirmedList", probatonConfirmedList);
        session.setAttribute("probatonConfirmedSessionList", probatonConfirmedList);
        mv.setViewName("Probation/ProbatonConfirmedEmployeeList");
        return mv;
    }
    
    public ModelAndView viewProbationconfirmedEmployee(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        String probationId = request.getParameter("id");
        String empId = request.getParameter("empId");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster = employeeMasterService.readById(Integer.parseInt(empId));
        employeeMaster.setDepartmentMaster(departmentMasterService.readById(employeeMaster.getDepartmentMaster().getId()));
        employeeMaster.setDesignationMaster(designationMasterService.readById(employeeMaster.getDesignationMaster().getId()));
        employeeMaster.setLevelMaster(levelMasterService.readById(employeeMaster.getLevelMaster().getId()));
        employeeMaster.setLocationMaster(locationMasterService.readById(employeeMaster.getLocationMaster().getId()));
        employeeMaster.setEmployeeSubType(employeeSubTypeService.readById(employeeMaster.getEmployeeSubType().getId()));
        employeeMaster.getReportingManagerLevel1();
        List<?> list = employeeMasterService.readManagerLevel1(employeeMaster);
        if (!list.isEmpty()) {
            request.setAttribute("reportingLevel1", list.get(0));
        }
        ptc = probationToConfirmationService.readById(Integer.parseInt(probationId));
        mv.getModelMap().put("ptc", ptc);
        request.setAttribute("id", probationId);
        request.setAttribute("empId", empId);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.setViewName("Probation/ProbationConfirmedView");
        return mv;
    }
    
    public ModelAndView exportToExcelProbationconfirmedEmployee(HttpServletRequest request, HttpServletResponse response, EmployeeMaster employeeMaster) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<?> probatonConfirmedSessionList = (List<?>) request.getSession().getAttribute("probatonConfirmedSessionList");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=ExpenseRequestData.xls");
        request.setAttribute("probatonConfirmedSessionList", probatonConfirmedSessionList);
        mv.setViewName("Probation/ProbationConfirmedExcel");
        return mv;
    }
    
    public ModelAndView probationDashBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        ProbationToConfirmation ptc = new ProbationToConfirmation();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        HttpSession session = request.getSession();
        EmployeeMaster employeeMaster = (EmployeeMaster) session.getAttribute("employeeInfo");
        Integer LoginempId = employeeMaster.getId();
        List<?> probationtypeList = employeeMasterService.readForEmployeeType(LoginempId);
        List<Object> finalprobationList1 = new ArrayList<>();
        
        if (!probationtypeList.isEmpty()) {
            for (Object o : probationtypeList) {
                try {
                    
                    EmployeeMaster employeeMaster1 = new EmployeeMaster();
                    employeeMaster1 = (EmployeeMaster) o;
                    String employeeId = employeeMaster1.getId().toString();
                    ProbationToConfirmation ptc1 = new ProbationToConfirmation();
                    ptc1.setEmployeeMasterByEmployeeMasterId(employeeMaster1);
                    List<?> listrepeat = probationToConfirmationService.readForRepeatedId(ptc1);
                    if (!listrepeat.isEmpty()) {
                        ProbationToConfirmation ptc2 = new ProbationToConfirmation();
                        ptc2 = (ProbationToConfirmation) listrepeat.get(0);
                        Integer status = ptc2.getStatus();
                        if (status == 1 || status == 2) {
                            
                        } else if (status == 4 || status == 0 || status == 10) {
                            String assessmentToDatestring = ptc2.getAssessmentToDate();
                            String today = sdf.format(new Date());
                            Date tDate = sdf.parse(today);
                            Date assessmentToDate = sdf.parse(assessmentToDatestring);
                            
                            Calendar c = Calendar.getInstance();
                            c.setTime(assessmentToDate);
//                        c.add(Calendar.DATE, -15);
                            c.add(Calendar.MONTH, -1);
                            Date datebefore1 = c.getTime();
                            c.setTime(datebefore1);
                            c.add(Calendar.MONTH, 1);
                            Date level1Date = c.getTime();
                            
                            c.setTime(level1Date);
                            c.add(Calendar.DATE, 15);
                            Date level2Date = c.getTime();
                            c.setTime(level2Date);
                            c.add(Calendar.DATE, 15);
                            Date level3Date = c.getTime();
                            
                            c.setTime(level3Date);
                            c.add(Calendar.DATE, 15);
                            Date level4Date = c.getTime();

//                        if ((DateUtils.isSameDay(tDate, datebefore1) || tDate.after(datebefore1))) {
                            List<?> probationList = employeeMasterService.readForProbationForManager(LoginempId.toString(), employeeId);
                            if (!probationList.isEmpty() || probationList.size() > 0) {
                                finalprobationList1.add(probationList);
                            }
                        }
                    }
                } catch (Exception e) {
                    
                }
            }
        }
        List<?> finalprobationList = finalprobationList1;
        
        request.setAttribute("finalprobationDashboardList", finalprobationList.size());
        List headlist = probationToConfirmationService.readForFunctionalHead(ptc);
        request.setAttribute("fHeadCuonter", headlist.size());
        List<?> pendingProbationList = employeeMasterService.readProbationByAdmin();
        request.setAttribute("hrCuonter", pendingProbationList.size());
        mv.setViewName("forward:userMaster.htm?act=userDashboardShow");
        return mv;
    }
    
    private synchronized void mailSendForProbationToConfirmationLeft() throws Exception {
        
        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster fromEmp = employeeMasterService.readById(1544);
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, 30);
        Date checkDate = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String CheckDate = sdf.format(checkDate);
        ProbationToConfirmation probationToConfirmation = new ProbationToConfirmation();
        List<?> empList = probationToConfirmationService.readByAssessmentToDate(CheckDate);
//        if (!empList.isEmpty()) {
//            for (Object o : empList) {
//                probationToConfirmation = (ProbationToConfirmation) o;
//                int eid1 = probationToConfirmation.getEmployeeMasterByEmployeeMasterId().getId();
//                EmployeeMaster employee = employeeMasterService.readById(eid1);
//                String managerId = employee.getReportingManagerLevel1();
//                EmployeeMaster manager = employeeMasterService.readById(Integer.parseInt(managerId));
//
////             
//                EmailTemplate emailTemplate = emailTemplateService.readById(141); ///////141 template for probation to confirm
//                String emailId = employee.getEmailAddress();
//                String managerMailId = manager.getEmailAddress();
//                for (String emailId1 : emailId.split(",")) {
//                    if (!emailId1.equals("")) {
//                        String To1 = emailId1;
//                        String from1 = fromEmp.getOfficeEmailId();
//                        String subject1 = emailTemplate.getSubject();
////                        subject1 = subject1.replaceAll("\\{user\\}", employee.getEmployeeName());
//                        String msg1 = emailTemplate.getBodytext();
//                        msg1 = msg1.replaceAll("\\{no_days\\}", "30");
//                        sendMail.sendMail(from1, To1, subject1, msg1);
//                    }
//                }
//                for (String managerMailId1 : managerMailId.split(",")) {
//                    if (!managerMailId1.equals("")) {
//                        String To2 = managerMailId1;
//                        String from2 = fromEmp.getOfficeEmailId();
//                        String subject1 = emailTemplate.getSubject();
////                        subject1 = subject1.replaceAll("\\{user\\}", employee.getEmployeeName());
//                        String msg1 = emailTemplate.getBodytext();
//                        msg1 = msg1.replaceAll("\\{no_days\\}", "30");
//                        sendMail.sendMail(from2, To2, subject1, msg1);
//                    }
//                }
////                }
//            }
//        }
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d);
        cal1.add(Calendar.DAY_OF_MONTH, 15);
        Date checkDate1 = cal1.getTime();
        String CheckDate1 = sdf.format(checkDate1);
        List<?> empList1 = probationToConfirmationService.readByAssessmentToDate(CheckDate1);
//        if (!empList1.isEmpty()) {
//            for (Object o : empList1) {
//                probationToConfirmation = (ProbationToConfirmation) o;
//                int eid1 = probationToConfirmation.getEmployeeMasterByEmployeeMasterId().getId();
//                EmployeeMaster employee = employeeMasterService.readById(eid1);
//                String managerId = employee.getReportingManagerLevel1();
//                EmployeeMaster manager = employeeMasterService.readById(Integer.parseInt(managerId));
//
////             
//                EmailTemplate emailTemplate = emailTemplateService.readById(141); ///////141 template for probation to confirm
//                String emailId = employee.getEmailAddress();
//                String managerMailId = manager.getEmailAddress();
//                for (String emailId1 : emailId.split(",")) {
//                    if (!emailId1.equals("")) {
//                        String To1 = emailId1;
//                        String from1 = fromEmp.getOfficeEmailId();
//                        String subject1 = emailTemplate.getSubject();
////                        subject1 = subject1.replaceAll("\\{user\\}", employee.getEmployeeName());
//                        String msg1 = emailTemplate.getBodytext();
//                        msg1 = msg1.replaceAll("\\{no_days\\}", "15");
//                        sendMail.sendMail(from1, To1, subject1, msg1);
//                    }
//                }
//                for (String managerMailId1 : managerMailId.split(",")) {
//                    if (!managerMailId1.equals("")) {
//                        String To2 = managerMailId1;
//                        String from2 = fromEmp.getOfficeEmailId();
//                        String subject1 = emailTemplate.getSubject();
////                        subject1 = subject1.replaceAll("\\{user\\}", employee.getEmployeeName());
//                        String msg1 = emailTemplate.getBodytext();
//                        msg1 = msg1.replaceAll("\\{no_days\\}", "15");
//                        sendMail.sendMail(from2, To2, subject1, msg1);
//                    }
//                }
////                }
//            }
//        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d);
        cal2.add(Calendar.DAY_OF_MONTH, 7);
        Date checkDate2 = cal2.getTime();
        String CheckDate2 = sdf.format(checkDate2);
        List<?> empList2 = probationToConfirmationService.readByAssessmentToDate(CheckDate2);
        if (!empList2.isEmpty()) {
            for (Object o : empList2) {
                probationToConfirmation = (ProbationToConfirmation) o;
                int eid1 = probationToConfirmation.getEmployeeMasterByEmployeeMasterId().getId();
                EmployeeMaster employee = employeeMasterService.readById(eid1);
                String managerId = employee.getReportingManagerLevel1();
                EmployeeMaster manager = employeeMasterService.readById(Integer.parseInt(managerId));
                String hrId = employee.getReportingManagerLevel2();
                EmployeeMaster hr = employeeMasterService.readById(Integer.parseInt(hrId));
                EmailTemplate emailTemplate = emailTemplateService.readById(141); ///////141 template for probation to confirm
                String hrMailId = hr.getEmailAddress();
                String emailId = employee.getEmailAddress();
                String managerMailId = manager.getEmailAddress();
                for (String hrMailId1 : hrMailId.split(",")) {
                    if (!hrMailId1.equals("")) {
                        String To1 = hrMailId1;
                        String from1 = fromEmp.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
//                        subject1 = subject1.replaceAll("\\{user\\}", hr.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{no_days\\}", "7");
                        msg1 = msg1.replaceAll("\\{user\\}", hr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{employee\\}", employee.getEmployeeName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
                for (String managerMailId1 : managerMailId.split(",")) {
                    if (!managerMailId1.equals("")) {
                        String To2 = managerMailId1;
                        String from2 = fromEmp.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
//                        subject1 = subject1.replaceAll("\\{user\\}", manager.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{no_days\\}", "7");
                        msg1 = msg1.replaceAll("\\{user\\}", manager.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{employee\\}", employee.getEmployeeName());
                        sendMail.sendMail(from2, To2, subject1, msg1);
                    }
                }
//                }
            }
        }
        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(d);
        cal3.add(Calendar.DAY_OF_MONTH, 3);
        Date checkDate3 = cal3.getTime();
        String CheckDate3 = sdf.format(checkDate3);
        List<?> empList3 = probationToConfirmationService.readByAssessmentToDate(CheckDate3);
        if (!empList3.isEmpty()) {
            for (Object o : empList3) {
                probationToConfirmation = (ProbationToConfirmation) o;
                int eid1 = probationToConfirmation.getEmployeeMasterByEmployeeMasterId().getId();
                EmployeeMaster employee = employeeMasterService.readById(eid1);
                String managerId = employee.getReportingManagerLevel1();
                EmployeeMaster manager = employeeMasterService.readById(Integer.parseInt(managerId));
                String hrId = employee.getReportingManagerLevel2();
                EmployeeMaster hr = employeeMasterService.readById(Integer.parseInt(hrId));
                String hrMailId = hr.getEmailAddress();
                EmailTemplate emailTemplate = emailTemplateService.readById(141); ///////141 template for probation to confirm
                String emailId = employee.getEmailAddress();
                String managerMailId = manager.getEmailAddress();
                for (String hrMailId1 : hrMailId.split(",")) {
                    if (!hrMailId1.equals("")) {
                        String To1 = hrMailId1;
                        String from1 = fromEmp.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
//                        subject1 = subject1.replaceAll("\\{user\\}", hr.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{no_days\\}", "3");
                        msg1 = msg1.replaceAll("\\{user\\}", hr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{employee\\}", employee.getEmployeeName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
                for (String managerMailId1 : managerMailId.split(",")) {
                    if (!managerMailId1.equals("")) {
                        String To2 = managerMailId1;
                        String from2 = fromEmp.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
//                        subject1 = subject1.replaceAll("\\{user\\}", manager.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{no_days\\}", "3");
                        msg1 = msg1.replaceAll("\\{user\\}", manager.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{employee\\}", employee.getEmployeeName());
                        sendMail.sendMail(from2, To2, subject1, msg1);
                    }
                }
//                }
            }
        }
        Calendar cal4 = Calendar.getInstance();
        cal4.setTime(d);
        cal4.add(Calendar.DAY_OF_MONTH, 1);
        Date checkDate4 = cal4.getTime();
        String CheckDate4 = sdf.format(checkDate4);
        List<?> empList4 = probationToConfirmationService.readByAssessmentToDate(CheckDate4);
        if (!empList4.isEmpty()) {
            for (Object o : empList4) {
                probationToConfirmation = (ProbationToConfirmation) o;
                int eid1 = probationToConfirmation.getEmployeeMasterByEmployeeMasterId().getId();
                EmployeeMaster employee = employeeMasterService.readById(eid1);
                String managerId = employee.getReportingManagerLevel1();
                EmployeeMaster manager = employeeMasterService.readById(Integer.parseInt(managerId));
                String hrId = employee.getReportingManagerLevel2();
                EmployeeMaster hr = employeeMasterService.readById(Integer.parseInt(hrId));
                String hrMailId = hr.getEmailAddress();
//             
                EmailTemplate emailTemplate = emailTemplateService.readById(141); ///////141 template for probation to confirm
                String emailId = employee.getEmailAddress();
                String managerMailId = manager.getEmailAddress();
                for (String hrMailId1 : hrMailId.split(",")) {
                    if (!hrMailId1.equals("")) {
                        String To1 = hrMailId1;
                        String from1 = fromEmp.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
//                        subject1 = subject1.replaceAll("\\{user\\}", hr.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{no_days\\}", "1");
                        msg1 = msg1.replaceAll("\\{user\\}", hr.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{employee\\}", employee.getEmployeeName());
                        sendMail.sendMail(from1, To1, subject1, msg1);
                    }
                }
                for (String managerMailId1 : managerMailId.split(",")) {
                    if (!managerMailId1.equals("")) {
                        String To2 = managerMailId1;
                        String from2 = fromEmp.getOfficeEmailId();
                        String subject1 = emailTemplate.getSubject();
//                        subject1 = subject1.replaceAll("\\{user\\}", manager.getEmployeeName());
                        String msg1 = emailTemplate.getBodytext();
                        msg1 = msg1.replaceAll("\\{no_days\\}", "1");
                        msg1 = msg1.replaceAll("\\{user\\}", manager.getEmployeeName());
                        msg1 = msg1.replaceAll("\\{employee\\}", employee.getEmployeeName());
                        sendMail.sendMail(from2, To2, subject1, msg1);
                    }
                }
//                }
            }
        }
        
    }
    
}
