/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.appraisalPerformance;

import com.bul.zydex.model.AppraisalPerformanceKra;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceKraValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return AppraisalPerformanceKra.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "field.error1", "None");
        AppraisalPerformanceKra appraisalPerformanceKra = new AppraisalPerformanceKra(); 
    }
   
}
