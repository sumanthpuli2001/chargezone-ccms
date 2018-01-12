/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollRecurringAdditionalAmountValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollRecurringAdditionalAmount.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        PayrollRecurringAdditionalAmount payrollRecurringAdditionalAmount = (PayrollRecurringAdditionalAmount) o;
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
                "field.error1", "None");

        if (!new NumberValidator().validate(payrollRecurringAdditionalAmount.getAmount())) {
            errors.rejectValue("amount", "field.error3", "None");
        }

    }

}
