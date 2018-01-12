/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.EmployeeSalaryProcess;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeSalaryProcessValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return EmployeeSalaryProcess.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       EmployeeSalaryProcess employeeSalaryProcess = (EmployeeSalaryProcess) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeTypeMaster.id", "field.error27", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeSubType.id", "field.error27", "None");
       
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeTypeMasterId", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMasterId", "field.error13", "none");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subTypeId", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "paymentType", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "month", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearselect", "field.error13", "none");
    }
}
