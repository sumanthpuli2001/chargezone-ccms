/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payment;

import com.bul.zydex.model.PaymentTypeMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class PaymentTypeMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PaymentTypeMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PaymentTypeMaster paymentTypeMaster = (PaymentTypeMaster) o;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partyCode", "partyCode.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameOfParty", "nameOfParty.required", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gstNo", "gstNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "phoneNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "mobileNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "panNo", "panNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "paymentAmount", "paymentAmount.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "additionalRemarks", "additionalRemarks.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "location.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeOfPayment", "typeOfPayment.required", "None");

    }
}
