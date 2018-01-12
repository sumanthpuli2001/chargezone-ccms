/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollSalaryLock;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSalaryLockValidator  implements Validator{

    @Override
    public boolean supports(Class<?> type) {
          return PayrollSalaryLock.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       PayrollSalaryLock payrollSalaryLock = (PayrollSalaryLock) o;
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pmonth", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pyear", "field.error13", "none");
    }
    
}
