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
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.CandidateF2FApproval.CandidateF2FApprovalService;
import com.bul.zydex.service.CandidateF2FRequest.CandidateF2FRequestService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;

/**
 *
 * @author DELL
 */
public class CandidateF2FApprovalAbstract extends CustomAbstract {

    protected CandidateF2FRequestService<CandidateF2FRequest> candidateF2FRequestService;
    protected CandidateF2FApprovalService<CandidateF2FApproval> candidateF2FApprovalService;
    protected CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService;
    protected CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService;
    protected VacancyMasterService<VacancyMaster> vacancyMasterService;

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
    
    

}
