/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.UserMaster;
import com.bul.zydex.util.CheckString;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return UserMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "field.error1", "None");

        UserMaster u = (UserMaster) o;
        String password = u.getPassword();
        if (null != u.getUserName() && !u.getUserName().isEmpty()) {
            if (!new CheckString().allowAll(u.getUserName(), true)) {
                errors.rejectValue("userName", "field.error3", "None");
            }
        }
//        if (null != password && !password.isEmpty()) {
////            if (!new PasswordValidator().validate(password)) {
//                errors.rejectValue("password",
//                        "loginPage.field.password.error1", "None");
////            }
//        }
    }

}
