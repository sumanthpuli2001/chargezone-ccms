/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.support.UserActivityLog;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class UserLogValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return UserActivityLog.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserActivityLog userActivityLog = (UserActivityLog) o;

        if (null != userActivityLog.getIpAddress()
                && !userActivityLog.getIpAddress().isEmpty()) {
            if (!new IPAddressValidator().validate(userActivityLog
                    .getIpAddress())) {
                errors.rejectValue("ipAddress", "field.error8", "None");
            }
        }
    }

}
