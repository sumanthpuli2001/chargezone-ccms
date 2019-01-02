/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingQuestionAnswerSubmitDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingQuestionAnswerSubmitServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingQuestionAnswerSubmitService<T> {

    private TrainingQuestionAnswerSubmitDAO<T> trainingQuestionAnswerSubmitDAO;

    public TrainingQuestionAnswerSubmitDAO<T> getTrainingQuestionAnswerSubmitDAO() {
        return trainingQuestionAnswerSubmitDAO;
    }

    public void setTrainingQuestionAnswerSubmitDAO(TrainingQuestionAnswerSubmitDAO<T> trainingQuestionAnswerSubmitDAO) {
        this.trainingQuestionAnswerSubmitDAO = trainingQuestionAnswerSubmitDAO;
        setGenericsDAO(trainingQuestionAnswerSubmitDAO);
    }

    @Override
    public List<?> readByTrainigAssessmentId(int assessmentId) {
        return trainingQuestionAnswerSubmitDAO.readByTrainigAssessmentId(assessmentId);
    }

    @Override
    public List<?> readByTrainigAssessmentREsultViewId(int assessmentId) {
        return trainingQuestionAnswerSubmitDAO.readByTrainigAssessmentREsultViewId(assessmentId);
    }

}
