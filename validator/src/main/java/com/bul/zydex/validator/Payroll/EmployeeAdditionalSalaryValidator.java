/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.EmployeeAdditionalSalary;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeAdditionalSalaryValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return EmployeeAdditionalSalary.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EmployeeAdditionalSalary employeeAdditionalSalary = (EmployeeAdditionalSalary) o;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeTypeMaster.id", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryTypeAmount", "field.error1", "none");
    }
    
}
