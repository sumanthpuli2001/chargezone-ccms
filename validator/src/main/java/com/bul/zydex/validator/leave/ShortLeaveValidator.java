/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.leave;

import com.bul.zydex.model.ShortLeave;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <Khokharkhurshid123@gmail.com>
 */
public class ShortLeaveValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ShortLeave.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         ShortLeave shortLeave = (ShortLeave) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hoursNo",
                "field.error1", "None");

    }
}
