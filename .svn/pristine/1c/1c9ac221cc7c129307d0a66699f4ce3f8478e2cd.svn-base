/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.shift;

import com.bul.zydex.model.ShiftMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class ShiftMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ShiftMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ShiftMaster shiftMaster = (ShiftMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shiftName",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startTime",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endTime",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lateHours",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "earlyHours",
//                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "halfStartTime1",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "halfEndTime1",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "halfStartTime2",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "halfEndTime2",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weekof",
                "field.error1", "None");

    }

}
