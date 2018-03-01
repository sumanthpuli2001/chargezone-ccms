/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Recruitment;

import com.bul.zydex.model.MprMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class MprValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return MprMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MprMaster mprMaster = (MprMaster) o;
        
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobtypeMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfPosition",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "budget",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experience",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationMaster",
                "field.error1", "None");
    }
    
}
