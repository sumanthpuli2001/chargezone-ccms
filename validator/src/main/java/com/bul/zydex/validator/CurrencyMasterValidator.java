/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import com.bul.zydex.model.CurrencyMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY  
 */
public class CurrencyMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return CurrencyMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currencyName",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currencyCode",
                "field.error1", "None");

    }

}
