/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.nodue;

import com.bul.zydex.model.NoDueMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public class NoDueMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return NoDueMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NoDueMaster noDueMaster = (NoDueMaster) o;
    }

}
