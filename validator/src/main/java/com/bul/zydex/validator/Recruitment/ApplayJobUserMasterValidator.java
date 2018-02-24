/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Recruitment;

import com.bul.zydex.model.ApplayJobUserMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class ApplayJobUserMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return ApplayJobUserMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ApplayJobUserMaster applayJobUserMaster = (ApplayJobUserMaster) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "field.error1", "None");
    }
    
}
