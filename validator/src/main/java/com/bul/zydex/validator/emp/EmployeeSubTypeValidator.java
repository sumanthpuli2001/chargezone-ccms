/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.emp;

import com.bul.zydex.model.EmployeeSubType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public class EmployeeSubTypeValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return EmployeeSubType.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EmployeeSubType employeeSubType = (EmployeeSubType) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeTypeMaster.id", "field.error13", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subType", "field.error1", "none");
    }

}
