package com.bul.zydex.validator.Classified;


import com.bul.zydex.model.ClassifiedBox;
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
 * @author Hussain
 */
public class ClassifiedBoxValidator implements Validator  {

    @Override
    public boolean supports(Class<?> type) {
      return  ClassifiedBox.class.equals(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
     ClassifiedBox classifiedBox = (ClassifiedBox) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "advertisementName",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
                "field.error1", "None");
       
    }
    
}
