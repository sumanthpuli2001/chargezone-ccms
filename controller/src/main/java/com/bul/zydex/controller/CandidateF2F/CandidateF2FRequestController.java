/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CandidateF2F;

import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateF2FApproval;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CertificateTemplate;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.VacancyMaster;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeFunction.bind;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vikas
 */
public class CandidateF2FRequestController extends CandidateF2FRequestAbstract {

    public ModelAndView createCandidateF2FInvitation(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CandidateApplyJob candidateApplyJob1 = new CandidateApplyJob();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        String applicationId = request.getParameter("id");
        String candidateId = request.getParameter("candidateId");
        EmployeeMaster employeeMaster = new EmployeeMaster();
        selectEmployee(request, response);

        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());

        candidateF2FRequest.setCandidateApplyJob(candidateApplyJob);
        candidateF2FRequest.setVacancyMaster(vm);

        selectedEmployeeFor360Feedback(request, employeeMaster);
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("candidateF2FRequest", candidateF2FRequest);
        mv.getModelMap().put("applicationId", applicationId);
        mv.getModelMap().put("vacancyMaster", vm);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.getModelMap().put("candidateApplyJob1", candidateApplyJob1);
        mv.setViewName("CandidateFtoF/candidateF2FInvitation");
//        request.setAttribute("successMessage",
//                "Information : The Candidate Face To Face Invitation successfully.");

//        try {
//            EmailTemplate emailTemplate = new EmailTemplate();
//            EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
//            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
//            // id ( Not created id 138) is for Face To Face Invitation User....
//            emailTemplate = emailTemplateService.readById(17);
//            String To = cja.getCandidateApplyJob().getEmailId();
//            String from = "";
//            String Subject = "Interview Call Letter for the position of "+vm.getName();
//            String msg = emailTemplate.getBodytext();
//            Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
//            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
//            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//            sendMail.sendMail(from, To, Subject, msg);
//        } catch (Exception e) {
//        }
        return mv;
    }

    public ModelAndView submitFtoF(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        CandidateF2FRequest candidateF2FRequest = new CandidateF2FRequest();
        CandidateF2FApproval candidateF2FApproval = new CandidateF2FApproval();
        CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
//        EmployeeMaster employeeMaster = new EmployeeMaster();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        BindException errors = new BindException(candidateF2FRequest, "candidateF2FRequest");
        bind(request, candidateF2FRequest);
        String applicationId = request.getParameter("applicationId");
        int otherDetailCount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        candidateJobApplication = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        VacancyMaster vm = vacancyMasterService.readById(candidateJobApplication.getVacancyMaster().getId());
        candidateApplyJob.setId(candidateJobApplication.getCandidateApplyJob().getId());
        CandidateApplyJob candidateApplyJob1 = candidateJobApplyService.readById(candidateApplyJob.getId());
        candidateF2FRequest.setCandidateJobApplication(candidateJobApplication);
        candidateF2FRequest.setCandidateApplyJob(candidateJobApplication.getCandidateApplyJob());
        candidateF2FRequest.setVacancyMaster(candidateJobApplication.getVacancyMaster());
        candidateF2FRequest.setCreatedBy(employeeMaster.getId());
        candidateF2FRequest.setCreatedDate(sdf.format(cDate));
        candidateF2FRequest.setStatus(0);
        candidateF2FRequest.setHrStatus(0);
        candidateF2FRequest.setUserStatus(0);
        candidateF2FRequestService.create(candidateF2FRequest);

        candidateJobApplication.setStatus(8);
        candidateJobApplicationService.update(candidateJobApplication);

        mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
        mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        mprApprovalHistory.setStatus(8);
        mprApprovalHistory.setComment("Face To Face Interview");
        mprApprovalHistory.setStatusMessage("Face To Face Interview");
        mprApprovalHistory.setMprMaster(vm.getMprMaster());
        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
        mprApprovalHistoryService.create(mprApprovalHistory);

        otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 0; i <= otherDetailCount; i++) {
            if (null != request.getParameter("policyId" + i)) {
                if (!request.getParameter("policyId" + i).equals("")) {
                    int policyId = Integer.parseInt(request.getParameter("policyId" + i));
                    employeeMaster = employeeMasterService.readById(policyId);

                    candidateF2FApproval.setEmployeeMaster(employeeMaster);
                    candidateF2FApproval.setCandidateF2FRequest(candidateF2FRequest);
                    candidateF2FApproval.setCreatedBy(employeeMaster.getId());
                    candidateF2FApproval.setCreatedDate(sdf.format(cDate));
                    candidateF2FApproval.setStatus(0);
                    candidateF2FApprovalService.create(candidateF2FApproval);

                }
            }
        }

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        request.setAttribute("successMessage",
                "Information : The Candidate Face To Face Invitation Sent successfully.");
        try {
//            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            // id ( Not created id 138) is for Face To Face Invitation User....
//            emailTemplate = emailTemplateService.readById(17);
            CertificateTemplate certificateTemplate = new CertificateTemplate();
            certificateTemplate = certificateTemplateService.readById(17);
            String To = candidateApplyJob1.getEmailId();
            String from = "";
            String Subject = "Interview Call Letter for the position of " + vm.getName();
            String msg = certificateTemplate.getCertificateBody();
            EmployeeMaster employee = (EmployeeMaster) session.getAttribute("employeeInfo");
            Integer dep = employee.getDesignationMaster().getId();
            DesignationMaster designationMaster1 = new DesignationMaster();
            designationMaster1 = designationMasterService.readById(dep);
//            Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
            msg = msg.replaceAll("\\{name\\}", candidateApplyJob1.getName());
            msg = msg.replaceAll("\\{name_position\\}", vm.getName());
            msg = msg.replaceAll("\\{date_of_birth\\}", sdf.format(cDate));
            msg = msg.replaceAll("\\{date_of_joining\\}", candidateF2FRequest.getDateOfInterview());
            msg = msg.replaceAll("\\{passport_no\\}", candidateF2FRequest.getLocation());

            msg = msg.replaceAll("\\{employee_name\\}", employee.getEmployeeName());
            msg = msg.replaceAll("\\{contact_no1\\}", employee.getContactNo1());
            msg = msg.replaceAll("\\{department_name\\}", designationMaster1.getDesignationName());
//            msg = msg.replaceAll("\\{payment_type\\}", candidateF2FRequest.getLocation());
//            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
//            msg = msg.replaceAll("\\{from_location\\}", candidateF2FRequest.getLocation());
//            msg = msg.replaceAll("\\{from_dateOfInterview\\}", candidateF2FRequest.getDateOfInterview());
//            msg = msg.replaceAll("\\{from_position\\}", vm.getName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }
//        mv = createCandidateF2FInvitation(request, response);
        return mv;
    }

    public ModelAndView CandidateShortlisted(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
        String applicationId = request.getParameter("id");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());

        cja.setStatus(2);
        candidateJobApplicationService.update(cja);

        if (employeeMaster != null) {
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        }
        mprApprovalHistory.setMprMaster(vm.getMprMaster());
        mprApprovalHistory.setStatus(2);
        mprApprovalHistory.setComment("ShortListed");
        mprApprovalHistory.setStatusMessage("ShortListed");
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
        mprApprovalHistoryService.create(mprApprovalHistory);

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        request.setAttribute("successMessage",
                "Information : The Candidate Shortlisted successfully.");

        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            // id ( Not created id 138) is for Shortlisted User....
            emailTemplate = emailTemplateService.readById(153);
            String To = cja.getCandidateApplyJob().getEmailId();
            String from = "";
            String Subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

        return mv;
    }

    public ModelAndView reject(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        CandidateJobApplication candidateJobApplication = new CandidateJobApplication();
        String applicationId = request.getParameter("id");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
        cja.setStatus(3);
        candidateJobApplicationService.update(cja);

        if (employeeMaster != null) {
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        }
        mprApprovalHistory.setMprMaster(vm.getMprMaster());
        mprApprovalHistory.setStatus(3);
        mprApprovalHistory.setComment("Candidate Rejected");
        mprApprovalHistory.setStatusMessage("Candidate Rejected");
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
        mprApprovalHistoryService.create(mprApprovalHistory);

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);

        try {
            EmailTemplate emailTemplate = new EmailTemplate();
            EmployeeMaster employeeMaster1 = employeeMasterService.readById(Integer.parseInt(employeeMaster.getReportingManagerLevel1()));
            DesignationMaster designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
            // id ( Not created id 138) is for Shortlisted User....
            emailTemplate = emailTemplateService.readById(154);
            String To = cja.getCandidateApplyJob().getEmailId();
            String from = "";
            String Subject = emailTemplate.getSubject();
            String msg = emailTemplate.getBodytext();
            Subject = Subject.replaceAll("\\{user\\}", employeeMaster.getEmployeeName());
            msg = msg.replaceAll("\\{to_user\\}", employeeMaster1.getEmployeeName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
            msg = msg.replaceAll("\\{from_designation\\}", designationMaster.getDesignationName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }
        mv.setViewName("Recruitment/CandidateRequestList");
        return mv;
    }

    public ModelAndView offerLater(HttpServletRequest request,
            HttpServletResponse response, CertificateTemplate certificateTemplate) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        String applicationId = request.getParameter("applicationId");
        String candidateId = request.getParameter("candidateId");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));

        try {
            String certificationName = request.getParameter("certificateName");
            String candidateBody = request.getParameter("certificateBody");
//            CertificateTemplate certificateTemplate = new CertificateTemplate();
            BindException errors = new BindException(certificateTemplate, "certificateTemplate");
            bind(request, certificateTemplate);

//            certificateTemplate.setCertificateBody(certificateTemplate.getCertificateBody().replaceAll("&Acirc;", ""));
//            certificateTemplate = certificateTemplateService.readById(10);
            String from = employeeMaster.getOfficeEmailId();
            String To = candidateApplyJob.getEmailId();
            String Subject = certificateTemplate.getCertificateName();
            String msg = certificateTemplate.getCertificateBody().replaceAll("&Acirc;", "");
//            Subject = Subject.replaceAll("\\{name\\}", employeeMaster.getEmployeeName());
//            msg = msg.replaceAll("\\{name\\}", candidateApplyJob.getName());
//            msg = msg.replaceAll("\\{email_id\\}", candidateApplyJob.getEmailId());
//            msg = msg.replaceAll("\\{present_address\\}", candidateApplyJob.getPresentAddress());
//            msg = msg.replaceAll("\\{name_position\\}", vm.getName());
//            msg = msg.replaceAll("\\{date_of_birth\\}", sdf.format(cDate));

//            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

        cja.setStatus(14);
        candidateJobApplicationService.update(cja);

        if (employeeMaster != null) {
            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        }
        mprApprovalHistory.setMprMaster(vm.getMprMaster());
        mprApprovalHistory.setStatus(14);
        mprApprovalHistory.setComment("Send Offer Letter");
        mprApprovalHistory.setStatusMessage("Send Offer Letter");
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
        mprApprovalHistoryService.create(mprApprovalHistory);

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        request.setAttribute("successMessage",
                "Information : The Offer Letter Sent successfully.");
        return mv;
    }

//    public ModelAndView appoitmentofferLater(HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        HttpSession session = request.getSession();
//        ModelAndView mv = new ModelAndView();
//        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
//        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
//        OnlineAssessment onlineAssessment = new OnlineAssessment();
//        String applicationId = request.getParameter("id");
//        String candidateId = request.getParameter("candidateId");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date cDate = new Date();
//        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
//        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
//        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));
//
//        try {
//            CertificateTemplate certificateTemplate = new CertificateTemplate();
//            certificateTemplate = certificateTemplateService.readById(10);
//            String from = employeeMaster.getOfficeEmailId();
//            String To = candidateApplyJob.getEmailId();
//            String Subject = "Offer Letter for the position of " + vm.getName();
//            String msg = certificateTemplate.getCertificateBody();
////            Subject = Subject.replaceAll("\\{name\\}", employeeMaster.getEmployeeName());
//            msg = msg.replaceAll("\\{name\\}", candidateApplyJob.getName());
//            msg = msg.replaceAll("\\{email_id\\}", candidateApplyJob.getEmailId());
//            msg = msg.replaceAll("\\{present_address\\}", candidateApplyJob.getPresentAddress());
//            msg = msg.replaceAll("\\{name_position\\}", vm.getName());
//            msg = msg.replaceAll("\\{date_of_birth\\}", sdf.format(cDate));
//
////            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
//            sendMail.sendMail(from, To, Subject, msg);
//        } catch (Exception e) {
//        }
//
//        cja.setStatus(14);
//        candidateJobApplicationService.update(cja);
//
//        if (employeeMaster != null) {
//            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
//            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
//            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
//        }
//        mprApprovalHistory.setMprMaster(vm.getMprMaster());
//        mprApprovalHistory.setStatus(30);
//        mprApprovalHistory.setComment("Send Appointment Letter");
//        mprApprovalHistory.setStatusMessage("Send Appointment Letter");
//        mprApprovalHistory.setCreateDate(sdf.format(cDate));
//        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
//        mprApprovalHistoryService.create(mprApprovalHistory);
//
//        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();
//
//        mv.getModelMap().put("list", candidateJobList);
//        questionList(request);
//        mv.getModelMap().put("onlineAssessment", onlineAssessment);
//        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
//        mv.setViewName("Recruitment/CandidateRequestList");
//        request.setAttribute("successMessage",
//                "Information : The Offer Letter Sent successfully.");
//        return mv;
//    }
    public ModelAndView offerLaterEditable(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();
        certificateTemplate = certificateTemplateService.readById(10);
//        EmployeeMaster employeeMaster = new EmployeeMaster();

        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        String applicationId = request.getParameter("id");
        String candidateId = request.getParameter("candidateId");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));
        String Subject = "Offer Letter for the position of " + vm.getName();
        String msg = certificateTemplate.getCertificateBody();
//            Subject = Subject.replaceAll("\\{name\\}", employeeMaster.getEmployeeName());
        msg = msg.replaceAll("\\{name\\}", candidateApplyJob.getName());
        msg = msg.replaceAll("\\{email_id\\}", candidateApplyJob.getEmailId());
        msg = msg.replaceAll("\\{present_address\\}", candidateApplyJob.getPresentAddress());
        msg = msg.replaceAll("\\{name_position\\}", vm.getName());
        msg = msg.replaceAll("\\{date_of_birth\\}", sdf.format(cDate));
        certificateTemplate.setCertificateBody(msg);
        certificateTemplate.setCertificateName(Subject);

//        String id = request.getParameter("id");
//        formateFullNdFinalLetter = formateFullNdFinalLetterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("certificateTemplate", certificateTemplate);
        request.setAttribute("applicationId",
                applicationId);
        request.setAttribute("candidateId",
                candidateId);
        mv.setViewName("Vacancy/OfferletterEidtable");
        return mv;
    }

    public ModelAndView appoitmentLaterEditable(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        CertificateTemplate certificateTemplate = new CertificateTemplate();

        String userId = request.getParameter("id");

        certificateTemplate = certificateTemplateService.readById(18);
        EmployeeMaster employeeMaster = new EmployeeMaster();
        UserMaster userMaster = new UserMaster();
        userMaster.setId(Integer.parseInt(userId));
        employeeMaster.setUserMaster(userMaster);
        int id = 0;
        List<?> empId = employeeMasterService.readByUserName(employeeMaster);
        if (!empId.isEmpty()) {
            employeeMaster = (EmployeeMaster) empId.get(0);
            id = employeeMaster.getId();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();

        DesignationMaster designationMaster = new DesignationMaster();
        designationMaster = designationMasterService.readById(employeeMaster.getDesignationMaster().getId());
        LocationMaster locationMaster = new LocationMaster();
        locationMaster = locationMasterService.readById(employeeMaster.getLocationMaster().getId());

        String Subject = "Appointment Letter ";
        String msg = certificateTemplate.getCertificateBody();
//            Subject = Subject.replaceAll("\\{name\\}", employeeMaster.getEmployeeName());
        msg = msg.replaceAll("\\{employee_name\\}", employeeMaster.getEmployeeName());
        msg = msg.replaceAll("\\{present_address\\}", employeeMaster.getPresentAddress());
        msg = msg.replaceAll("\\{designation_name\\}", designationMaster.getDesignationName());
        msg = msg.replaceAll("\\{work_location\\}", locationMaster.getLocation());
        msg = msg.replaceAll("\\{date_of_joining\\}", employeeMaster.getDateOfJoining());
        msg = msg.replaceAll("\\{date_of_leaving\\}", sdf.format(cDate));
        certificateTemplate.setCertificateBody(msg);
        certificateTemplate.setCertificateName(Subject);

//        String id = request.getParameter("id");
//        formateFullNdFinalLetter = formateFullNdFinalLetterService.readById(Integer.parseInt(id));
        mv.getModelMap().put("employeeMaster", employeeMaster);
        mv.getModelMap().put("certificateTemplate", certificateTemplate);
//        request.setAttribute("applicationId",
//                applicationId);
//        request.setAttribute("candidateId",
//                candidateId);
        mv.setViewName("Vacancy/appoitmentLaterEditable");
        return mv;
    }

    public ModelAndView appointmentLater(HttpServletRequest request,
            HttpServletResponse response, CertificateTemplate certificateTemplate) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
//        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
//        OnlineAssessment onlineAssessment = new OnlineAssessment();
        String emplid = request.getParameter("emplid");
//        String candidateId = request.getParameter("candidateId");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        EmployeeMaster employeeMaster2 = new EmployeeMaster();
        employeeMaster2 = employeeMasterService.readById(Integer.parseInt(emplid));
//        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
//        VacancyMaster vm = vacancyMasterService.readById(cja.getVacancyMaster().getId());
//        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));

        try {
            String certificationName = request.getParameter("certificateName");
            String candidateBody = request.getParameter("certificateBody");
//            CertificateTemplate certificateTemplate = new CertificateTemplate();
            BindException errors = new BindException(certificateTemplate, "certificateTemplate");
            bind(request, certificateTemplate);

//            certificateTemplate.setCertificateBody(certificateTemplate.getCertificateBody().replaceAll("&Acirc;", ""));
//            certificateTemplate = certificateTemplateService.readById(10);
            String from = employeeMaster.getOfficeEmailId();
            String To = employeeMaster2.getOfficeEmailId();
            String Subject = certificateTemplate.getCertificateName();
              String msg = certificateTemplate.getCertificateBody().replaceAll("&Acirc;", "");
//            Subject = Subject.replaceAll("\\{name\\}", employeeMaster.getEmployeeName());
//            msg = msg.replaceAll("\\{name\\}", candidateApplyJob.getName());
//            msg = msg.replaceAll("\\{email_id\\}", candidateApplyJob.getEmailId());
//            msg = msg.replaceAll("\\{present_address\\}", candidateApplyJob.getPresentAddress());
//            msg = msg.replaceAll("\\{name_position\\}", vm.getName());
//            msg = msg.replaceAll("\\{date_of_birth\\}", sdf.format(cDate));

//            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

//        cja.setStatus(14);
//        candidateJobApplicationService.update(cja);
//
//        if (employeeMaster != null) {
//            mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
//            mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
//            mprApprovalHistory.setCreatedBy(employeeMaster.getId());
//        }
//        mprApprovalHistory.setMprMaster(vm.getMprMaster());
//        mprApprovalHistory.setStatus(14);
//        mprApprovalHistory.setComment("Send Offer Letter");
//        mprApprovalHistory.setStatusMessage("Send Offer Letter");
//        mprApprovalHistory.setCreateDate(sdf.format(cDate));
//        mprApprovalHistory.setApplicationId(Integer.parseInt(applicationId));
//        mprApprovalHistoryService.create(mprApprovalHistory);
        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
//        mv.getModelMap().put("onlineAssessment", onlineAssessment);
//        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        request.setAttribute("successMessage",
                "Information : The Appointment Letter Sent successfully.");
        return mv;
    }

}
