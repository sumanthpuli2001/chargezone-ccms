/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollMaximumSavingTaxAmount;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollMaximumSavingTaxAmountValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollMaximumSavingTaxAmount.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount = (PayrollMaximumSavingTaxAmount) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maximumAmount",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id",
                "field.error13", "None");

        if (!new NumberValidator().validate(payrollMaximumSavingTaxAmount.getMaximumAmount())) {
            errors.rejectValue("maximumAmount", "field.error3", "None");
        }
    }

}
