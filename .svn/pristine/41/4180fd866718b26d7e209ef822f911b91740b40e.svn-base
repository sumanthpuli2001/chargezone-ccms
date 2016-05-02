/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.location;

import com.bul.zydex.model.LocationMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class LocationMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return LocationMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LocationMaster locationMaster = (LocationMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "field.error1", "none");

    }

}
