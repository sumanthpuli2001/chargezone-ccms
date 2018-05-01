/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.validator.Company;

import com.bul.zydex.model.RetirementAge;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Rishi
 */
public class companyMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return RetirementAge.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RetirementAge retirementAge = (RetirementAge)o;
        
           ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retireAge",
                "field.error13", "None");
    }

}
