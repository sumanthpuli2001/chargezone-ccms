/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.exitInterview;

import com.bul.zydex.model.ExitInterviewMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public class ExitInterviewMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ExitInterviewMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reasonLeaving", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reasonForSustain", "field.error1", "None");
        ExitInterviewMaster exitInterviewMaster = (ExitInterviewMaster) o;
    }

}
