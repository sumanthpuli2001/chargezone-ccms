/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.support.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class UserInitPwdValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
//        return false;
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
                "field.error1", "None");

        User u = (User) o;
        String password = u.getPassword();
        String newPassword = u.getNewPassword();
        String confirmPassword = u.getConfirmPassword();
//        if (null != password && !password.isEmpty()) {
//            if (!new PasswordValidator().validate(password)) {
//                errors.rejectValue("password",
//                        "initPwdChange.field.password.error2", "None");
//            }
//        }
//        if (null != newPassword && !newPassword.isEmpty()) {
//            if (!new PasswordValidator().validate(newPassword)) {
//                errors.rejectValue("newPassword",
//                        "initPwdChange.field.newPassword.error2", "None");
//            }
//        }
//        if (null != confirmPassword && !confirmPassword.isEmpty()) {
//            if (!new PasswordValidator().validate(confirmPassword)) {
//                errors.rejectValue("confirmPassword",
//                        "initPwdChange.field.confirmPassword.error2", "None");
//            }
//        }
        if (null != newPassword && !newPassword.isEmpty()) {
            if (!confirmPassword.equals(newPassword)) {
                errors.rejectValue("confirmPassword",
                        "initPwdChange.field.confirmPassword.error3", "None");
            }
        }
    }
}
