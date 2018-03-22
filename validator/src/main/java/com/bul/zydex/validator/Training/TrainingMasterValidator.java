/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Training;

import com.bul.zydex.model.TrainingMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Aman
 */
public class TrainingMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return TrainingMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TrainingMaster trainingMaster = new TrainingMaster();
//        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingTitle",
                "field.error1","None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainer",
//                "field.error27","None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingType",
//                "field.error27","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "venue",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingTimeForm",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingTimeTo",
                "field.error1","None");
        
        
        
    }
    
}
