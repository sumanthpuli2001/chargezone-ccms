/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.support.ForgotPwd;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class ForgotPwdValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ForgotPwd.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ForgotPwd forgotPwd = (ForgotPwd) o;
        int level = forgotPwd.getLevel();
        String email1 = forgotPwd.getEmailL1();
        String email2 = forgotPwd.getEmailL2();
        String email3 = forgotPwd.getEmailL3();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailL1",
                "field.error1", "None");
        if (null != email1 && !email1.isEmpty()) {
            if (!new NumberValidator().validate(email1)) {
                errors.rejectValue("emailL1", "field.error33", "None");
            }
        }

//        if (1 == level) {
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailL1",
//                    "field.error1", "None");
//            if (null != email1 && !email1.isEmpty()) {
//                if (!new EmailValidator().validate(email1)) {
//                    errors.rejectValue("emailL1", "field.error7", "None");
//                }
//            }
//        } else if (2 == level) {
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailL2",
//                    "field.error1", "None");
//            if (null != email2 && !email2.isEmpty()) {
//                if (!new EmailValidator().validate(email2)) {
//                    errors.rejectValue("emailL2", "field.error7", "None");
//                }
//            }
//        } else if (3 == level) {
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailL3",
//                    "field.error1", "None");
//            if (null != email3 && !email3.isEmpty()) {
//                if (!new EmailValidator().validate(email3)) {
//                    errors.rejectValue("emailL3", "field.error7", "None");
//                }
//            }
//        }
    }
}
