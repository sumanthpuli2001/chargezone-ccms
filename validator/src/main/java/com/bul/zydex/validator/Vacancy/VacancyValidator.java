/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Vacancy;

import com.bul.zydex.model.VacancyMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class VacancyValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return VacancyMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        VacancyMaster vacancyMaster = (VacancyMaster) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromDate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "toDate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryRange",
                "field.error1", "None");
        
    }

}
