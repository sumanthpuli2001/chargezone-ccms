/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TrainingIdentification;
import com.bul.zydex.service.Training.TrainingIdentificationService;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationAbstract extends CustomAbstract{
    
    protected TrainingIdentificationService<TrainingIdentification> trainingIdentificationService;

    public TrainingIdentificationService<TrainingIdentification> getTrainingIdentificationService() {
        return trainingIdentificationService;
    }

    public void setTrainingIdentificationService(TrainingIdentificationService<TrainingIdentification> trainingIdentificationService) {
        this.trainingIdentificationService = trainingIdentificationService;
    }
    
    
    
}
