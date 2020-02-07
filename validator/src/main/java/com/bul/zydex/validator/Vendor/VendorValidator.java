/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Vendor;

import com.bul.zydex.model.Vendors;
import com.bul.zydex.validator.EmailValidator;
import com.bul.zydex.validator.PanValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class VendorValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Vendors.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Vendors vendors = (Vendors) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendorId", "vendorId.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendor", "vendor.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gstNo", "gstNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "phoneNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "mobileNo.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "panNo", "panNo.required", "None");
//        EmailValidator emailValidator = new EmailValidator();
//        if (!emailValidator.validate(vendors.getEmailId()) && !vendors.getEmailId().isEmpty()) {
//            errors.rejectValue("emailId", "emailId.error", "none");
//        }
//        if (!new PanValidator().validate(vendors.getPanNo().toUpperCase()) && !vendors.getPanNo().isEmpty()) {
//            errors.rejectValue("panNo", "pan.error10", "none");
//        }

    }
}
