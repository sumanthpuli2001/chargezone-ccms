/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.CandidateF2F;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CandidateAcademicQualification;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateApplyJob2;
import com.bul.zydex.model.CandidateExperienceDetail;
import com.bul.zydex.model.CandidateF2FApproval;
import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.model.CandidateFamilyBackground;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CandidateOtherReferences;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.VacancyApprovalHistory;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.CandidateF2FApproval.CandidateF2FApprovalService;
import com.bul.zydex.service.CandidateF2FRequest.CandidateF2FRequestService;
import com.bul.zydex.service.CandidateJobApply.CandidateAcademicQualificationService;
import com.bul.zydex.service.CandidateJobApply.CandidateApplyJob2Service;
import com.bul.zydex.service.CandidateJobApply.CandidateExperienceDetailService;
import com.bul.zydex.service.CandidateJobApply.CandidateFamilyBackgroundService;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.CandidateJobApply.CandidateOtherReferencesService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.Recruitment.JobtypeMasterService;
import com.bul.zydex.service.Recruitment.MprMasterService;
import com.bul.zydex.service.Recruitment.RecruitmentService;
import com.bul.zydex.service.RecruitmentApprovalHistory.MprApprovalHistoryService;
import com.bul.zydex.service.Vacancy.VacancyApprovalHistoryService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;
import com.bul.zydex.service.location.LocationMasterService;

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
    protected JobtypeMasterService<JobtypeMaster> jobtypeMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected MprMasterService<MprMaster> mprMasterService;
    protected RecruitmentService<RecruitmentMaster> recruitmentService;
    protected MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService;
    protected CandidateApplyJob2Service<CandidateApplyJob2> candidateApplyJob2Service;
    protected VacancyApprovalHistoryService<VacancyApprovalHistory> vacancyApprovalHistoryService;
    protected CandidateAcademicQualificationService<CandidateAcademicQualification> candidateAcademicQualificationService;
    protected CandidateFamilyBackgroundService<CandidateFamilyBackground> candidateFamilyBackgroundService;
    protected CandidateExperienceDetailService<CandidateExperienceDetail> candidateExperienceDetailService;
    protected CandidateOtherReferencesService<CandidateOtherReferences> candidateOtherReferencesService;

    public RecruitmentService<RecruitmentMaster> getRecruitmentService() {
        return recruitmentService;
    }

    public void setRecruitmentService(RecruitmentService<RecruitmentMaster> recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

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

    public JobtypeMasterService<JobtypeMaster> getJobtypeMasterService() {
        return jobtypeMasterService;
    }

    public void setJobtypeMasterService(JobtypeMasterService<JobtypeMaster> jobtypeMasterService) {
        this.jobtypeMasterService = jobtypeMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public MprMasterService<MprMaster> getMprMasterService() {
        return mprMasterService;
    }

    public void setMprMasterService(MprMasterService<MprMaster> mprMasterService) {
        this.mprMasterService = mprMasterService;
    }

    public MprApprovalHistoryService<MprApprovalHistory> getMprApprovalHistoryService() {
        return mprApprovalHistoryService;
    }

    public void setMprApprovalHistoryService(MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService) {
        this.mprApprovalHistoryService = mprApprovalHistoryService;
    }

    public CandidateApplyJob2Service<CandidateApplyJob2> getCandidateApplyJob2Service() {
        return candidateApplyJob2Service;
    }

    public void setCandidateApplyJob2Service(CandidateApplyJob2Service<CandidateApplyJob2> candidateApplyJob2Service) {
        this.candidateApplyJob2Service = candidateApplyJob2Service;
    }

    public VacancyApprovalHistoryService<VacancyApprovalHistory> getVacancyApprovalHistoryService() {
        return vacancyApprovalHistoryService;
    }

    public void setVacancyApprovalHistoryService(VacancyApprovalHistoryService<VacancyApprovalHistory> vacancyApprovalHistoryService) {
        this.vacancyApprovalHistoryService = vacancyApprovalHistoryService;
    }

    public CandidateAcademicQualificationService<CandidateAcademicQualification> getCandidateAcademicQualificationService() {
        return candidateAcademicQualificationService;
    }

    public void setCandidateAcademicQualificationService(CandidateAcademicQualificationService<CandidateAcademicQualification> candidateAcademicQualificationService) {
        this.candidateAcademicQualificationService = candidateAcademicQualificationService;
    }

    public CandidateFamilyBackgroundService<CandidateFamilyBackground> getCandidateFamilyBackgroundService() {
        return candidateFamilyBackgroundService;
    }

    public void setCandidateFamilyBackgroundService(CandidateFamilyBackgroundService<CandidateFamilyBackground> candidateFamilyBackgroundService) {
        this.candidateFamilyBackgroundService = candidateFamilyBackgroundService;
    }

    public CandidateExperienceDetailService<CandidateExperienceDetail> getCandidateExperienceDetailService() {
        return candidateExperienceDetailService;
    }

    public void setCandidateExperienceDetailService(CandidateExperienceDetailService<CandidateExperienceDetail> candidateExperienceDetailService) {
        this.candidateExperienceDetailService = candidateExperienceDetailService;
    }

    public CandidateOtherReferencesService<CandidateOtherReferences> getCandidateOtherReferencesService() {
        return candidateOtherReferencesService;
    }

    public void setCandidateOtherReferencesService(CandidateOtherReferencesService<CandidateOtherReferences> candidateOtherReferencesService) {
        this.candidateOtherReferencesService = candidateOtherReferencesService;
    }
    
    

}
