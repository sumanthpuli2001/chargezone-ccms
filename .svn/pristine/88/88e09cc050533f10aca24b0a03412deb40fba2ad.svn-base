/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.zydexLocation;

import com.bul.zydex.model.ZydexLocationMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class ZydexLocationMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ZydexLocationMaster.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ZydexLocationMaster zydexLocationMaster = (ZydexLocationMaster) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocation", "field.error1", "none");
    }

}
