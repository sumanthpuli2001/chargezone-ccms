/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Recruitment;

import com.bul.zydex.model.FullAndFinalSettlement;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Rishi
 */
public class fullAndFinalSettlementValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return FullAndFinalSettlement.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FullAndFinalSettlement fullAndFinalSettlement = (FullAndFinalSettlement) o;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMaster",
//                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "noticePeriod",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "givenNotice",
                "field.error13", "None");
    }

}
