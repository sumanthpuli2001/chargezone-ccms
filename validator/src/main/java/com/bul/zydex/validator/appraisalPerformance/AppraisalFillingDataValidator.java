/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.appraisalPerformance;

import com.bul.zydex.model.AppraisalFillingData;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class AppraisalFillingDataValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return AppraisalFillingData.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "midYearStartDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "midYearEndDate", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearEndStartDate", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearEndEndDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerStartDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerEndDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerMidYearStartDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerMidYearEndDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerYearEndStartDate", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerYearEndEndDate", "field.error1", "None");
        AppraisalFillingData appraisalFillingData = (AppraisalFillingData) o;
    }  

}
