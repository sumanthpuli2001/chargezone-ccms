/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollTaxRateMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author DELL3
 */
public class PayrollTaxRateMasterValidator implements Validator
{

    @Override
    public boolean supports(Class<?> type) {
        return PayrollTaxRateMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        PayrollTaxRateMaster payrollTaxRateMaster = (PayrollTaxRateMaster) o;
                
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taxRate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "incomeFrom",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "incomeTo",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ageFrom",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ageTo",
                "field.error1", "None");
        
    }
    
}
