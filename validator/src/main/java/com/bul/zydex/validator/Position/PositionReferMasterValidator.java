/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Position;

import com.bul.zydex.model.PositionReferMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class PositionReferMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PositionReferMaster.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PositionReferMaster positionReferMaster = (PositionReferMaster) o;
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "positionName",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "positionCode",
                "field.error1", "None");
    }

}
