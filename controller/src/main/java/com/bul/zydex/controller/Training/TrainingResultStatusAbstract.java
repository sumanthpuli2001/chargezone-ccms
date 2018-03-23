/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TrainingResultStatus;
import com.bul.zydex.service.Training.TrainingResultStatusService;

/**
 *
 * @author Aman
 */
public class TrainingResultStatusAbstract extends CustomAbstract{
    protected TrainingResultStatusService<TrainingResultStatus>trainingResultStatusService;

    public TrainingResultStatusService<TrainingResultStatus> getTrainingResultStatusService() {
        return trainingResultStatusService;
    }

    public void setTrainingResultStatusService(TrainingResultStatusService<TrainingResultStatus> trainingResultStatusService) {
        this.trainingResultStatusService = trainingResultStatusService;
    }
    
    
}
