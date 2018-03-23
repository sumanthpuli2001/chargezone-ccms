/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TrainingQuestionAnswerSubmit;
import com.bul.zydex.service.Training.TrainingQuestionAnswerSubmitService;

/**
 *
 * @author Aman
 */
public class TrainingQuestionAnswerSubmitAbstract extends CustomAbstract{
    protected TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit>trainingQuestionAnswerSubmitService;

    public TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> getTrainingQuestionAnswerSubmitService() {
        return trainingQuestionAnswerSubmitService;
    }

    public void setTrainingQuestionAnswerSubmitService(TrainingQuestionAnswerSubmitService<TrainingQuestionAnswerSubmit> trainingQuestionAnswerSubmitService) {
        this.trainingQuestionAnswerSubmitService = trainingQuestionAnswerSubmitService;
    }
    
    
}
