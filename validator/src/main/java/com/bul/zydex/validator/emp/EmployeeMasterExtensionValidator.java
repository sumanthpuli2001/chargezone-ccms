/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.emp;

import com.bul.zydex.model.EmployeeMasterExtension;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class EmployeeMasterExtensionValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return EmployeeMasterExtension.class.equals(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        EmployeeMasterExtension employeeMasterExtension = (EmployeeMasterExtension) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "Nationality is required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "FirstName is required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middleName", "MiddleName is required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "LastName is required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentAddress2", "Present Address is required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "permanentAddress2", "Permanent Address is required", "None");
        
    }
    
}
