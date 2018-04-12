/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.CandidateResultStatus;
import com.bul.zydex.model.JobtypeMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.MprApprovalHistory;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionAnswerSubmit;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.RecruitmentMaster;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.QuestionAnswerSubmit.CandidateResultStatusService;
import com.bul.zydex.service.QuestionAnswerSubmit.QuestionAnswerSubmitService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.Recruitment.JobtypeMasterService;
import com.bul.zydex.service.Recruitment.MprMasterService;
import com.bul.zydex.service.Recruitment.OnlineAssessmentService;
import com.bul.zydex.service.Recruitment.RecruitmentService;
import com.bul.zydex.service.RecruitmentApprovalHistory.MprApprovalHistoryService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.questionlibrary.QuestionAnsService;
import com.bul.zydex.service.questionlibrary.QuestionDetailsService;
import com.bul.zydex.service.questionlibrary.QuestionLibraryService;
import com.bul.zydex.service.questionlibrary.QuestionPaperService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Admin
 */
public class OnlineAssessmentAbstract extends CustomAbstract {

    protected OnlineAssessmentService<OnlineAssessment> onlineAssessmentService;

    protected QuestionPaperService<QuestionPaper> questionPaperService;

    protected QuestionDetailsService<QuestionDetails> questionDetailsService;

    protected CandidateJobApplicationService<CandidateJobApplication> candidateJobApplicationService;

    protected CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService;

    protected QuestionAnswerSubmitService<QuestionAnswerSubmit> questionAnswerSubmitService;

    protected QuestionLibraryService<QuestionLibrary> questionLibraryService;

    protected QuestionAnsService<QuestionAns> questionAnsService;

    protected CandidateResultStatusService<CandidateResultStatus> candidateResultStatusService;

    protected MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService;
    protected VacancyMasterService<VacancyMaster> vacancyMasterService;

    protected MprMasterService<MprMaster> mprMasterService;
    protected RecruitmentService<RecruitmentMaster> recruitmentService;
    protected JobtypeMasterService<JobtypeMaster> jobtypeMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;

    public OnlineAssessmentService<OnlineAssessment> getOnlineAssessmentService() {
        return onlineAssessmentService;
    }

    public void setOnlineAssessmentService(OnlineAssessmentService<OnlineAssessment> onlineAssessmentService) {
        this.onlineAssessmentService = onlineAssessmentService;
    }

    public QuestionPaperService<QuestionPaper> getQuestionPaperService() {
        return questionPaperService;
    }

    public void setQuestionPaperService(QuestionPaperService<QuestionPaper> questionPaperService) {
        this.questionPaperService = questionPaperService;
    }

    public QuestionDetailsService<QuestionDetails> getQuestionDetailsService() {
        return questionDetailsService;
    }

    public void setQuestionDetailsService(QuestionDetailsService<QuestionDetails> questionDetailsService) {
        this.questionDetailsService = questionDetailsService;
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

    public QuestionAnswerSubmitService<QuestionAnswerSubmit> getQuestionAnswerSubmitService() {
        return questionAnswerSubmitService;
    }

    public void setQuestionAnswerSubmitService(QuestionAnswerSubmitService<QuestionAnswerSubmit> questionAnswerSubmitService) {
        this.questionAnswerSubmitService = questionAnswerSubmitService;
    }

    public QuestionLibraryService<QuestionLibrary> getQuestionLibraryService() {
        return questionLibraryService;
    }

    public void setQuestionLibraryService(QuestionLibraryService<QuestionLibrary> questionLibraryService) {
        this.questionLibraryService = questionLibraryService;
    }

    public QuestionAnsService<QuestionAns> getQuestionAnsService() {
        return questionAnsService;
    }

    public void setQuestionAnsService(QuestionAnsService<QuestionAns> questionAnsService) {
        this.questionAnsService = questionAnsService;
    }

    public CandidateResultStatusService<CandidateResultStatus> getCandidateResultStatusService() {
        return candidateResultStatusService;
    }

    public void setCandidateResultStatusService(CandidateResultStatusService<CandidateResultStatus> candidateResultStatusService) {
        this.candidateResultStatusService = candidateResultStatusService;
    }

    public MprApprovalHistoryService<MprApprovalHistory> getMprApprovalHistoryService() {
        return mprApprovalHistoryService;
    }

    public void setMprApprovalHistoryService(MprApprovalHistoryService<MprApprovalHistory> mprApprovalHistoryService) {
        this.mprApprovalHistoryService = mprApprovalHistoryService;
    }

    public VacancyMasterService<VacancyMaster> getVacancyMasterService() {
        return vacancyMasterService;
    }

    public void setVacancyMasterService(VacancyMasterService<VacancyMaster> vacancyMasterService) {
        this.vacancyMasterService = vacancyMasterService;
    }

    public MprMasterService<MprMaster> getMprMasterService() {
        return mprMasterService;
    }

    public void setMprMasterService(MprMasterService<MprMaster> mprMasterService) {
        this.mprMasterService = mprMasterService;
    }

    public RecruitmentService<RecruitmentMaster> getRecruitmentService() {
        return recruitmentService;
    }

    public void setRecruitmentService(RecruitmentService<RecruitmentMaster> recruitmentService) {
        this.recruitmentService = recruitmentService;
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
