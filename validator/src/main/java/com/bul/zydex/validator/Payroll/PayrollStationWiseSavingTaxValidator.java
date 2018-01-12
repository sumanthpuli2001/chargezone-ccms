/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollStationWiseSavingTax;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public class PayrollStationWiseSavingTaxValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollStationWiseSavingTax.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PayrollStationWiseSavingTax  payrollStationWiseSavingTax = (PayrollStationWiseSavingTax)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id", "field.error13", "none");    }
    
}
