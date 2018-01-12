/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollFormSixteenMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFormSixteenMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
     return  PayrollFormSixteenMaster.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
     PayrollFormSixteenMaster payrollFormSixteenMaster = (PayrollFormSixteenMaster) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payrollFinancialYear.id",
                "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ename",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberShip",
                "field.error1", "None");
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date",
                "field.error5", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "panNo",
                "field.error10", "None");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tanNo",
                "field.error1", "None");


    }
}
