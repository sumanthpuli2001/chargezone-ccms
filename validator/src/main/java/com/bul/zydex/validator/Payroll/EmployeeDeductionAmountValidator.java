/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.EmployeeDeductionAmount;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeDeductionAmountValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
         return EmployeeDeductionAmount.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         EmployeeDeductionAmount employeeDeductionAmount = (EmployeeDeductionAmount) o;
    }
    
}
