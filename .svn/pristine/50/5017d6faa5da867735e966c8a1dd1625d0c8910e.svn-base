package com.bul.zydex.validator.travel;

import com.bul.zydex.model.TravelRequestMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AJAY
 */
public class TravelRequestMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return TravelRequestMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "travelType",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "travelRequestNo",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDateTime",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDateTime",
//                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "purpose",
                "field.error1", "None");
        TravelRequestMaster travelRequestMaster = (TravelRequestMaster) o;
    }

}
