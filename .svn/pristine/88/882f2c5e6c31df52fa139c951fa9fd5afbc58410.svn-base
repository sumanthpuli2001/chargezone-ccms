/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.leave;

import com.bul.zydex.model.COffLeaveMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Patel <dhaval217@gmail.com>
 */
public class CoffMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return COffLeaveMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
      COffLeaveMaster cOffLeaveMaster=(COffLeaveMaster)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hoursNo",
                "field.error1", "None");

    }
}
