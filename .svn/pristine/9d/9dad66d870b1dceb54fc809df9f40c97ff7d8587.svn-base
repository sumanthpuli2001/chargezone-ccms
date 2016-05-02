/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.shift;

import com.bul.zydex.model.ShiftRotationMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class ShiftRotationMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ShiftRotationMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duration",
                "field.error13", "None");
        ShiftRotationMaster shiftRotationMaster = (ShiftRotationMaster) o;
    }

}
