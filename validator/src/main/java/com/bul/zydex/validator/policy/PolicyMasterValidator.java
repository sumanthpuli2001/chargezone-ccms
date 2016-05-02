/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.policy;

import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.PolicyMaster;
import static jdk.nashorn.internal.objects.NativeJava.type;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class PolicyMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return PolicyMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PolicyMaster policyMaster = (PolicyMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "policyName", "field.error1", "None");
    }

}
