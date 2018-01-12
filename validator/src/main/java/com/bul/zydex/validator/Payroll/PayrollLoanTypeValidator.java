/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollLoanType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public class PayrollLoanTypeValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return PayrollLoanType.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
      PayrollLoanType payrollLoanType = (PayrollLoanType)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "field.error1", "none");
    }
}
