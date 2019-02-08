/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.OnCall;

import com.bul.zydex.model.OnCall;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class OnCallValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return OnCall.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"fromDate","field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"toDate","field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description","field.error1", "None");
    }
    
}
