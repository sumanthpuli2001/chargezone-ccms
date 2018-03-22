/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.service.Training.TrainingAssessmentService;

/**
 *
 * @author Aman
 */
public class TrainingAssessmentAbstract extends CustomAbstract{
    
    protected TrainingAssessmentService<TrainingAssessment> trainingAssessmentService;

    public TrainingAssessmentService<TrainingAssessment> getTrainingAssessmentService() {
        return trainingAssessmentService;
    }

    public void setTrainingAssessmentService(TrainingAssessmentService<TrainingAssessment> trainingAssessmentService) {
        this.trainingAssessmentService = trainingAssessmentService;
    }
    
    
}
