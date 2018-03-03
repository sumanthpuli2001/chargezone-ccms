/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Recruitment;

import com.bul.zydex.model.RecruitmentMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class RecruitmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return RecruitmentMaster.class.equals(type);
    }
//
    @Override
    public void validate(Object o, Errors errors) {
        RecruitmentMaster recruitmentMaster = (RecruitmentMaster) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobtypeMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfPosition",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "budget",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationMaster.id",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experiance",
                "field.error1", "None");
       
       
    }

}
