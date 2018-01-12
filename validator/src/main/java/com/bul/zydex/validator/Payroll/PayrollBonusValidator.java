/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollBonus;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollBonusValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollBonus.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         PayrollBonus payrollBonus = (PayrollBonus) o;
         
           ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount",
                "field.error30", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
                "field.error1", "None");
         
            if (!new NumberValidator().validate(payrollBonus.getAmount())) {
            errors.rejectValue("amount", "field.error3", "None");
         
    }
            
         
    }

}
