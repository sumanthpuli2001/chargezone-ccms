/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Training;

import com.bul.zydex.model.Trainer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Aman
 */
public class TrainerValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Trainer.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Trainer trainer = new Trainer();
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainerName",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
                "field.error1","None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status",
                "field.error1","None");
        
    }
    
}
