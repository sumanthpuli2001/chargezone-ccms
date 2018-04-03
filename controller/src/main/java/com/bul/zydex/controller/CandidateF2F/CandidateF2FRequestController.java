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
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.model.VacancyMaster;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        return mv;
    }

    public ModelAndView submitFtoF(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

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
        mprApprovalHistory.setStatusMessage("Face To Face Interview");
        mprApprovalHistory.setMprMaster(candidateJobApplication.getVacancyMaster().getMprMaster());
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

        cja.setStatus(2);
        candidateJobApplicationService.update(cja);

        mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
        mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
        mprApprovalHistory.setMprMaster(cja.getVacancyMaster().getMprMaster());
        mprApprovalHistory.setStatus(2);
        mprApprovalHistory.setStatusMessage("ShortListed");
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        mprApprovalHistoryService.create(mprApprovalHistory);

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
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

        cja.setStatus(3);
        candidateJobApplicationService.update(cja);

        mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
        mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
        mprApprovalHistory.setMprMaster(cja.getVacancyMaster().getMprMaster());
        mprApprovalHistory.setStatus(3);
        mprApprovalHistory.setStatusMessage("Rejected");
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        mprApprovalHistoryService.create(mprApprovalHistory);

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        return mv;
    }

    public ModelAndView offerLater(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        MprApprovalHistory mprApprovalHistory = new MprApprovalHistory();
        EmployeeMaster employeeMaster = (EmployeeMaster) request.getSession().getAttribute("employeeInfo");
        CandidateApplyJob candidateApplyJob = new CandidateApplyJob();
        OnlineAssessment onlineAssessment = new OnlineAssessment();
        String applicationId = request.getParameter("id");
        String candidateId = request.getParameter("candidateId");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cDate = new Date();
        CandidateJobApplication cja = candidateJobApplicationService.readById(Integer.parseInt(applicationId));
        candidateApplyJob = candidateJobApplyService.readById(Integer.parseInt(candidateId));

        try {
            CertificateTemplate certificateTemplate = new CertificateTemplate();
            certificateTemplate = certificateTemplateService.readById(1);
            String from = employeeMaster.getOfficeEmailId();
            String To = candidateApplyJob.getEmailId();
            String Subject = certificateTemplate.getCertificateType();
            String msg = certificateTemplate.getCertificateBody();
            msg = msg.replaceAll("\\{to_user\\}", candidateApplyJob.getName());
            msg = msg.replaceAll("\\{from_user\\}", employeeMaster.getEmployeeName());
            sendMail.sendMail(from, To, Subject, msg);
        } catch (Exception e) {
        }

        cja.setStatus(14);
        candidateJobApplicationService.update(cja);

        mprApprovalHistory.setApprovalUserId(employeeMaster.getId());
        mprApprovalHistory.setApprovalUserName(employeeMaster.getEmployeeName());
        mprApprovalHistory.setMprMaster(cja.getVacancyMaster().getMprMaster());
        mprApprovalHistory.setStatus(14);
        mprApprovalHistory.setStatusMessage("Send Offer Laters");
        mprApprovalHistory.setCreateDate(sdf.format(cDate));
        mprApprovalHistory.setCreatedBy(employeeMaster.getId());
        mprApprovalHistoryService.create(mprApprovalHistory);

        List<?> candidateJobList = candidateJobApplicationService.readCandidateApplyForJob();

        mv.getModelMap().put("list", candidateJobList);
        questionList(request);
        mv.getModelMap().put("onlineAssessment", onlineAssessment);
        mv.getModelMap().put("candidateApplyJob", candidateApplyJob);
        mv.setViewName("Recruitment/CandidateRequestList");
        return mv;
    }

}
