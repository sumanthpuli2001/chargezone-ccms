/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProvidentFundValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollProvidentFund.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        PayrollProvidentFund payrollProvidentFund = (PayrollProvidentFund) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pfPercentage",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maximumBasicAmount",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "epfPercentage",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apfPercentage",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id",
                "field.error13", "None");

        if (!new NumberValidator().validate(payrollProvidentFund.getPfPercentage())) {
            errors.rejectValue("pfPercentage", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollProvidentFund.getMaximumBasicAmount())) {
            errors.rejectValue("maximumBasicAmount", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollProvidentFund.getEpfPercentage())) {
            errors.rejectValue("epfPercentage", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollProvidentFund.getApfPercentage())) {
            errors.rejectValue("apfPercentage", "field.error3", "None");
        }
    }
}
