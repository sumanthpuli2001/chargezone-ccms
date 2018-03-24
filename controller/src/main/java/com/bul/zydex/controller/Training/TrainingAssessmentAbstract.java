/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.model.TrainingQuestionAnswerSubmit;
import com.bul.zydex.service.Training.TrainingAssessmentService;
import com.bul.zydex.service.Training.TrainingQuestionAnswerSubmitService;
import com.bul.zydex.service.questionlibrary.QuestionAnsService;
import com.bul.zydex.service.questionlibrary.QuestionDetailsService;
import com.bul.zydex.service.questionlibrary.QuestionLibraryService;
import com.bul.zydex.service.questionlibrary.QuestionPaperService;

/**
 *
 * @author Aman
 */
public class TrainingAssessmentAbstract extends CustomAbstract {

    protected TrainingAssessmentService<TrainingAssessment> trainingAssessmentService;
    protected QuestionPaperService<QuestionPaper> questionPaperService;
    protected QuestionDetailsService<QuestionDetails> questionDetailsService;
    protected QuestionLibraryService<QuestionLibrary> questionLibraryService;
    protected QuestionAnsService<QuestionAns> questionAnsService;
    protected TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> trainingQuestionAnswerSubmitService;

    public TrainingAssessmentService<TrainingAssessment> getTrainingAssessmentService() {
        return trainingAssessmentService;
    }

    public void setTrainingAssessmentService(TrainingAssessmentService<TrainingAssessment> trainingAssessmentService) {
        this.trainingAssessmentService = trainingAssessmentService;
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

    public TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> getTrainingQuestionAnswerSubmitService() {
        return trainingQuestionAnswerSubmitService;
    }

    public void setTrainingQuestionAnswerSubmitService(TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> trainingQuestionAnswerSubmitService) {
        this.trainingQuestionAnswerSubmitService = trainingQuestionAnswerSubmitService;
    }

   

}
