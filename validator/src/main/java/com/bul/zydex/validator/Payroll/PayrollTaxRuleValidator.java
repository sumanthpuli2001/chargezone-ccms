/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollTaxRule;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollTaxRuleValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollTaxRule.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PayrollTaxRule payrollTaxRule = (PayrollTaxRule) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taxPercentage",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryFrom",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryTo",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id",
                "field.error13", "None");

        if (!new NumberValidator().validate(payrollTaxRule.getTaxPercentage())) {
            errors.rejectValue("taxPercentage", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollTaxRule.getSalaryFrom())) {
            errors.rejectValue("salaryFrom", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollTaxRule.getSalaryTo())) {
            errors.rejectValue("salaryTo", "field.error3", "None");
        }
        
       

    }

}
