/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.appraisalPerformance;


import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationTextmasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return CompetencyEvaluationTextmaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "infoText", "field.error1", "None");
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster = (CompetencyEvaluationTextmaster) o;
    }
    
}
