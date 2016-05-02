/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.leave;

import com.bul.zydex.model.EmployeeLeaveBalance;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class EmployeeLeaveBalanceValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return EmployeeLeaveBalance.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noOfLeaveRemain",
                "field.error1", "None");
        EmployeeLeaveBalance employeeLeaveBalance = (EmployeeLeaveBalance) o;

    }

}
