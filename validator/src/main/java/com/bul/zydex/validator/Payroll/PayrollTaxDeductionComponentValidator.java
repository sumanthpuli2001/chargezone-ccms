/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollTaxDeductionComponent;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionComponentValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollTaxDeductionComponent.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        PayrollTaxDeductionComponent payrollTaxDeductionComponentCreate = (PayrollTaxDeductionComponent) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payrollTaxDeductionMaster.id", "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "component", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ageLimit", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taxSavingLimit", "field.error1", "none");
    }
}
