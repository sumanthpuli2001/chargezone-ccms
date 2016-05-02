/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.probationtoconfirmation;

import com.bul.zydex.model.ProbationPeriod;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class ProbationPeriodValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ProbationPeriod.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationMaster.id", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "period", "field.error1", "None");
    }

}
