/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.holiday;

import com.bul.zydex.model.HolidayMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class HolidayMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return HolidayMaster.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HolidayMaster holidayMaster = (HolidayMaster) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "holidayFromDate", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "holidayToDate", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationMaster.id", "field.error0", "none");
//       if("0".equals(holidayMaster.getLocationMaster().getLocation())){
//       errors.rejectValue("locationMaster", "field.error0");
//       }
    }

}
