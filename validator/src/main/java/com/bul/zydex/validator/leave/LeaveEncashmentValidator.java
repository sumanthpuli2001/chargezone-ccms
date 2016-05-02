/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.leave;

import com.bul.zydex.model.LeaveEncashment;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class LeaveEncashmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return LeaveEncashment.class.equals(type);

    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leaveTypeMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalLeave",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noOfLeaveEncashment",
                "field.error1", "None");

    }
}
