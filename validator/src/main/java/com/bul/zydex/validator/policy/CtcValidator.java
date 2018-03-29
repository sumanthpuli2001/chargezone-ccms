/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.policy;

import com.bul.zydex.model.CtcAllowance;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class CtcValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return CtcAllowance.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CtcAllowance ctcAllowance = (CtcAllowance) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ctcName", "field.error1", "None");
    }
    

    
    
}
