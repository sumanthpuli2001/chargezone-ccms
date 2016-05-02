/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.EmailTemplate;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailTemplateValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return EmailTemplate.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        EmailTemplate emailTemplate = (EmailTemplate) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bodytext",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestType",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestStatus",
                "field.error1", "None");
    }
}
