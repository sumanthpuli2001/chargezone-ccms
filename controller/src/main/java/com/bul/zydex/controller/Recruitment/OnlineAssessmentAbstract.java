/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.CandidateJobApplication;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.Recruitment.CandidateJobApplicationService;
import com.bul.zydex.service.Recruitment.OnlineAssessmentService;
import com.bul.zydex.service.questionlibrary.QuestionDetailsService;
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
