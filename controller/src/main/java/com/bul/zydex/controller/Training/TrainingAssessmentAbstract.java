/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DesignationMaster;
import com.bul.zydex.model.QuestionAns;
import com.bul.zydex.model.QuestionDetails;
import com.bul.zydex.model.QuestionLibrary;
import com.bul.zydex.model.QuestionPaper;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingQuestionAnswerSubmit;
import com.bul.zydex.model.TrainingResultStatus;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.service.Training.TrainerService;
import com.bul.zydex.service.Training.TrainingAssessmentService;
import com.bul.zydex.service.Training.TrainingAttendanceService;
import com.bul.zydex.service.Training.TrainingIdentificationService;
import com.bul.zydex.service.Training.TrainingMasterService;
import com.bul.zydex.service.Training.TrainingQuestionAnswerSubmitService;
import com.bul.zydex.service.Training.TrainingResultStatusService;
import com.bul.zydex.service.Training.TrainingSubTypeService;
import com.bul.zydex.service.Training.TrainingTypeService;
import com.bul.zydex.service.emp.DesignationMasterService;
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
    protected TrainingResultStatusService<TrainingResultStatus> trainingResultStatusService;
    protected TrainingMasterService<TrainingMaster> trainingMasterService;
    protected TrainingAttendanceService<TrainingAttendance> trainingAttendanceService;
    protected TrainingIdentificationService<TrainingIdentification> trainingIdentificationService;
    protected TrainingTypeService<TrainingType> trainingTypeService;
    protected TrainingSubTypeService<TrainingSubType> trainingSubTypeService;
    protected TrainerService<Trainer> trainerService;
    protected DesignationMasterService<DesignationMaster> designationMasterService;

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

    public TrainingResultStatusService<TrainingResultStatus> getTrainingResultStatusService() {
        return trainingResultStatusService;
    }

    public void setTrainingResultStatusService(TrainingResultStatusService<TrainingResultStatus> trainingResultStatusService) {
        this.trainingResultStatusService = trainingResultStatusService;
    }

    public TrainingMasterService<TrainingMaster> getTrainingMasterService() {
        return trainingMasterService;
    }

    public void setTrainingMasterService(TrainingMasterService<TrainingMaster> trainingMasterService) {
        this.trainingMasterService = trainingMasterService;
    }

    public TrainingAttendanceService<TrainingAttendance> getTrainingAttendanceService() {
        return trainingAttendanceService;
    }

    public void setTrainingAttendanceService(TrainingAttendanceService<TrainingAttendance> trainingAttendanceService) {
        this.trainingAttendanceService = trainingAttendanceService;
    }

    public TrainingIdentificationService<TrainingIdentification> getTrainingIdentificationService() {
        return trainingIdentificationService;
    }

    public void setTrainingIdentificationService(TrainingIdentificationService<TrainingIdentification> trainingIdentificationService) {
        this.trainingIdentificationService = trainingIdentificationService;
    }

    public TrainingTypeService<TrainingType> getTrainingTypeService() {
        return trainingTypeService;
    }

    public void setTrainingTypeService(TrainingTypeService<TrainingType> trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }

    public TrainingSubTypeService<TrainingSubType> getTrainingSubTypeService() {
        return trainingSubTypeService;
    }

    public void setTrainingSubTypeService(TrainingSubTypeService<TrainingSubType> trainingSubTypeService) {
        this.trainingSubTypeService = trainingSubTypeService;
    }

    public TrainerService<Trainer> getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService<Trainer> trainerService) {
        this.trainerService = trainerService;
    }
    public void setDesignationMasterService(DesignationMasterService<DesignationMaster> designationMasterService) {
        this.designationMasterService = designationMasterService;
    }

    public DesignationMasterService<DesignationMaster> getDesignationMasterService() {
        return designationMasterService;
    }

    
}
