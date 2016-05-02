/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.resignation;

import com.bul.zydex.model.ResignationMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public class ResignationMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return ResignationMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason","field.error1", "None"); 
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "effectiveDatetime","field.error13", "None"); 
        ResignationMaster resignationMaster=(ResignationMaster) o;
//        if ("".equals(resignationMaster.getRelievingDate()) || null == resignationMaster.getRelievingDate()) {
//                        errors.rejectValue("relievingDate", "field.error13", "none");
//
//        }
    }
    
}
