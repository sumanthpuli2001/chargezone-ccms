/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProfessionalTaxValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollProfessionalTax.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        PayrollProfessionalTax payrollProfessionalTax = (PayrollProfessionalTax) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryFrom",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salaryTo",
                "field.error1", "None");
      

        if (!new NumberValidator().validate(payrollProfessionalTax.getSalaryFrom())) {
            errors.rejectValue("salaryFrom", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollProfessionalTax.getSalaryTo())) {
            errors.rejectValue("salaryTo", "field.error3", "None");
        }
        if (!new NumberValidator().validate(payrollProfessionalTax.getAmount())) {
            errors.rejectValue("amount", "field.error3", "None");
        }

    }
}
