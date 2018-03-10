/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.service.Training.TrainerService;
import org.springframework.validation.Validator;

/**
 *
 * @author Aman
 */
public class TrainerAbstract extends CustomAbstract{
    
    protected TrainerService<Trainer> trainerService;
    protected Validator trainerValidator;

    public TrainerService<Trainer> getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService<Trainer> trainerService) {
        this.trainerService = trainerService;
    }

    public Validator getTrainerValidator() {
        return trainerValidator;
    }

    public void setTrainerValidator(Validator trainerValidator) {
        this.trainerValidator = trainerValidator;
    }
    
    
    
}
