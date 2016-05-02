/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.attendanceRegularization;

import com.bul.zydex.model.TimeAttandanceFlaxibleMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class TimeAttendanceFlexibleValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return TimeAttandanceFlaxibleMaster.class.equals(type);

    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "earlyFlexibleTime", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lateFlexibleTime", "field.error1", "None");
    }

}
