/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.emp;

import com.bul.zydex.model.DesignationMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class DesignationMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return DesignationMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DesignationMaster designationMaster = (DesignationMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationName", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "levelMaster.id", "field.error27", "None");
    }
}
