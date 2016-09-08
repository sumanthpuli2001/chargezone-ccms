/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.shift;

import com.bul.zydex.model.MaxDayLateAllowed;
import com.bul.zydex.model.TempShiftAssignMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class TemporaryShiftAssignValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return TempShiftAssignMaster.class.equals(type);

    }

    @Override
    public void validate(Object o, Errors errors) {
         TempShiftAssignMaster tempShiftAssignMaster = (TempShiftAssignMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMaster",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shiftMaster",
//                "field.error1", "None");
    }

}
