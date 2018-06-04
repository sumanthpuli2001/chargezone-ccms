/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.CertificateTemplate;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class certificateTemplateValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return CertificateTemplate.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         CertificateTemplate certificateTemplate = (CertificateTemplate) o;
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "certificateTitle",
                "field.error1", "None");
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modules.id",
                "field.error13", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "certificateType",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "certificateName",
//                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "certificateBody",
                "field.error1", "None");
    }
    
}
