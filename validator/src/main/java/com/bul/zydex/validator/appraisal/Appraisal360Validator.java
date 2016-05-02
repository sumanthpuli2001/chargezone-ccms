package com.bul.zydex.validator.appraisal;

import com.bul.zydex.model.AppraisalFeedback360;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhruv
 */
public class Appraisal360Validator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return AppraisalFeedback360.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMasterByRefForEmpId",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMasterByRefDoneEmpId",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "performedDateStr",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "completeDateStr",
                "field.error1", "None");
    }
    
}
