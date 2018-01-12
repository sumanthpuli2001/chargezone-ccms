/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollFinancialYear;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFinancialYearValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return PayrollFinancialYear.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
      PayrollFinancialYear payrollFinancialYear = (PayrollFinancialYear)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "field.error5", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.error1", "none");
    }
    
}
