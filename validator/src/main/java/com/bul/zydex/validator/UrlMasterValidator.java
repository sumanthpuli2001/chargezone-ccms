/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.Company;
import com.bul.zydex.model.UrlMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Rishi
 */
public class UrlMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return UrlMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UrlMaster urlMaster = (UrlMaster) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ipAddress",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portNumber",
                "field.error1", "None");

    }

}
