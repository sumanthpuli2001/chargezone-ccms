/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.appraisalPerformance;

import com.bul.zydex.model.AppraisalPerformanceBehaviors;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class AppraisalPerformanceBehaviorsValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return AppraisalPerformanceBehaviorsValidator.class.equals(type);    
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "", "field.error1", "None");
        AppraisalPerformanceBehaviors appraisalPerformanceBehaviors=(AppraisalPerformanceBehaviors)o;
    }  
    
}
