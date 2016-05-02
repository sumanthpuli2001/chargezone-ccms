/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.emp;

import com.bul.zydex.model.DepartmentMaster;
import org.apache.commons.validator.util.ValidatorUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class DepartmentMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return DepartmentMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentName", "field.error1", "None");
        DepartmentMaster departmentMaster = (DepartmentMaster) o;
    }
}
