/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.emp;

import com.bul.zydex.model.EmployeeType;
import com.bul.zydex.model.EmployeeTypeMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public class EmployeeTypeValidator implements Validator {

    public boolean supports(Class<?> type) {
        return EmployeeTypeMaster.class.equals(type);
    }

    public void validate(Object o, Errors errors) {
        EmployeeTypeMaster employeeTypeMaster = (EmployeeTypeMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeOfEmployee", "field.error1", "none");

    }

}
