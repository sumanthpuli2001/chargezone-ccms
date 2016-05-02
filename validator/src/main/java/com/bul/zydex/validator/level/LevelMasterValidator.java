/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.level;

import com.bul.zydex.model.LevelMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author admin
 */
public class LevelMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return LevelMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LevelMaster levelMaster = (LevelMaster) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "level", "field.error1", "None");
    }

}
