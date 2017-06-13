/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.DeviceMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class DeviceMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return DeviceMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) { 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ipAddress",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portNo",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seqNumber",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countConnectionOut",
                "field.error1", "None");
        DeviceMaster deviceMaster = (DeviceMaster) o; 
    } 

}
