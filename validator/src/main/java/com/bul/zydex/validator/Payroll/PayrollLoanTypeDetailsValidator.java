/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollLoanDetail;
import com.bul.zydex.validator.NumberValidator;
import static jdk.nashorn.internal.objects.NativeJava.type;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class PayrollLoanTypeDetailsValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PayrollLoanDetail.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PayrollLoanDetail payrollLoanDetail = (PayrollLoanDetail) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loanAmount",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "monltyEmi",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instRate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payrollLoanType.id",
                "field.error13", "None");

//        if (!new NumberValidator().validate(payrollProvidentFund.getPfPercentage())) {
//            errors.rejectValue("pfPercentage", "field.error3", "None");
//        }
//        if (!new NumberValidator().validate(payrollProvidentFund.getMaximumBasicAmount())) {
//            errors.rejectValue("maximumBasicAmount", "field.error3", "None");
//        }
//        if (!new NumberValidator().validate(payrollProvidentFund.getEpfPercentage())) {
//            errors.rejectValue("epfPercentage", "field.error3", "None");
//        }
//        if (!new NumberValidator().validate(payrollProvidentFund.getApfPercentage())) {
//            errors.rejectValue("apfPercentage", "field.error3", "None");
//        }
    }

}
