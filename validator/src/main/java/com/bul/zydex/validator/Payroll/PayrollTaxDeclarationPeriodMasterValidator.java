/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollTaxDeclarationPeriodMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeclarationPeriodMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return PayrollTaxDeclarationPeriodMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        PayrollTaxDeclarationPeriodMaster payrollTaxDeclarationPeriodMaster = (PayrollTaxDeclarationPeriodMaster) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payrollFinancialYear.id", "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "declarationThresholdDate", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "proofThresholdDate", "field.error1", "none");
    }
    
}
