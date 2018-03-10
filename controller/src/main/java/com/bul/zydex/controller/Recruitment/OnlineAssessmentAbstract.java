/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Recruitment;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.OnlineAssessment;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.service.Recruitment.OnlineAssessmentService;
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
