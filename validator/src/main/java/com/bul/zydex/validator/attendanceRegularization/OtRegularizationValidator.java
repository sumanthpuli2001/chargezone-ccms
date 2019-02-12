/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.attendanceRegularization;

import com.bul.zydex.model.OTRegularization;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Success
 */
public class OtRegularizationValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return OTRegularization.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       OTRegularization otRegularization = (OTRegularization) o;
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDateTime",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDateTime",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "arType",
                "field.error1", "None");
        if (otRegularization.getClientDetailsMaster() == null){
            ValidationUtils.rejectIfEmpty(errors, "clientDetailsMaster", "field.error27", "None");
        }
        
    }
    
}
