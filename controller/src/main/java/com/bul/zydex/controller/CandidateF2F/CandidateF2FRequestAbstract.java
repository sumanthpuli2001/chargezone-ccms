/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CandidateF2F;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateF2FApproval;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CertificateTemplate;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.CandidateF2FApproval.CandidateF2FApprovalService;
import com.bul.zydex.service.CandidateF2FRequest.CandidateF2FRequestService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.Payroll.CertificateTemplateService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.RecruitmentApprovalHistory.MprApprovalHistoryService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;
import com.bul.zydex.service.emp.DesignationMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.questionlibrary.QuestionPaperService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Vikas
 */
public class CandidateF2FRequestAbstract extends CustomAbstract{
    
    protected CandidateF2FRequestService<CandidateF2FRequest> candidateF2FRequestService;
    protected CandidateF2FApprovalService<CandidateF2FApproval> candidateF2FApprovalService;
    protected CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService;
    protected QuestionPaperService<QuestionPaper> questionPaperService;
    protected CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService;
    protected VacancyMasterService<VacancyMaster> vacancyMasterService;
    protected CertificateTemplateService<CertificateTemplate> certificateTemplateService;
    protected MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService;
     protected DesignationMasterService<DesignationMaster> designationMasterService;
     protected LocationMasterService<LocationMaster> locationMasterService;

    public CandidateF2FRequestService<CandidateF2FRequest> getCandidateF2FRequestService() {
        return candidateF2FRequestService;
    }

    public void setCandidateF2FRequestService(CandidateF2FRequestService<CandidateF2FRequest> candidateF2FRequestService) {
        this.candidateF2FRequestService = candidateF2FRequestService;
    }

    public CandidateF2FApprovalService<CandidateF2FApproval> getCandidateF2FApprovalService() {
        return candidateF2FApprovalService;
    }

    public void setCandidateF2FApprovalService(CandidateF2FApprovalService<CandidateF2FApproval> candidateF2FApprovalService) {
        this.candidateF2FApprovalService = candidateF2FApprovalService;
    }

    public CandidateJobApplicationService<CandidateJobApplication> getCandidateJobApplicationService() {
        return candidateJobApplicationService;
    }

    public void setCandidateJobApplicationService(CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService) {
        this.candidateJobApplicationService = candidateJobApplicationService;
    }

    public QuestionPaperService<QuestionPaper> getQuestionPaperService() {
        return questionPaperService;
    }

    public void setQuestionPaperService(QuestionPaperService<QuestionPaper> questionPaperService) {
        this.questionPaperService = questionPaperService;
    }

    public CandidateJobApplyService<CandidateApplyJob> getCandidateJobApplyService() {
        return candidateJobApplyService;
    }

    public void setCandidateJobApplyService(CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService) {
        this.candidateJobApplyService = candidateJobApplyService;
    }

    public VacancyMasterService<VacancyMaster> getVacancyMasterService() {
        return vacancyMasterService;
    }

    public void setVacancyMasterService(VacancyMasterService<VacancyMaster> vacancyMasterService) {
        this.vacancyMasterService = vacancyMasterService;
    }

    public CertificateTemplateService<CertificateTemplate> getCertificateTemplateService() {
        return certificateTemplateService;
    }

    public void setCertificateTemplateService(CertificateTemplateService<CertificateTemplate> certificateTemplateService) {
        this.certificateTemplateService = certificateTemplateService;
    }

    public MprApprovalHistoryService<MprApprovalHistory> getMprApprovalHistoryService() {
        return mprApprovalHistoryService;
    }

    public void setMprApprovalHistoryService(MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService) {
        this.mprApprovalHistoryService = mprApprovalHistoryService;
    }
    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }
    
    
    
    
    
    
        protected void questionList(HttpServletRequest request) {
        QuestionPaper questionPaper = new QuestionPaper();
        List<?> depttList = questionPaperService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : depttList) {
            questionPaper = (QuestionPaper) o;
            dm.put(questionPaper.getId(), questionPaper.getPaperName());
        }

        request.setAttribute("questions", dm);
    }
    
    
    
}
