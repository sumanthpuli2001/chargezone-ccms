/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.shift;

import com.bul.zydex.model.CoffRegularization;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class CoffRegularizationValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
           return CoffRegularization.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CoffRegularization shiftRegularization = (CoffRegularization) o;
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "approvalComment",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDateCoff",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDateCoff",
                "field.error1", "None");
    }
    
}
