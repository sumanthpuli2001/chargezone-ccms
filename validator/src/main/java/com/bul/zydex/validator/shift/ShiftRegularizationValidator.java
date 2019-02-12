/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.shift;

import com.bul.zydex.model.ShiftRegularization;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class ShiftRegularizationValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
         return ShiftRegularization.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       ShiftRegularization shiftRegularization = (ShiftRegularization) o;
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rotationDate",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shiftMasterCurrent",
//                "field.error1", "None");
    }
    
}
