/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.leave;

import com.bul.zydex.model.COffLeaveRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class COffLeaveRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return COffLeaveRequest.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        COffLeaveRequest cOffLeaveRequest = (COffLeaveRequest) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOf",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noOfHoursWork",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leaveFor",
                "field.error1", "None");
        String str=cOffLeaveRequest.getNoOfHoursWork().replace(":", ".").trim();
        if(!str.equals("") || !str.equals(null)){
         if(Float.parseFloat(str) < 4){
          errors.rejectValue("noOfHoursWork", "field.error0", "None");
        }
        }

    }

}
