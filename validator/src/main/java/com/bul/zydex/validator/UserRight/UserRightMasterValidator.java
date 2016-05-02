/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.UserRight;

import com.bul.zydex.model.UserRightMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class UserRightMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return UserRightMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRightMaster userRightMaster=(UserRightMaster) o;
    }
    
}
