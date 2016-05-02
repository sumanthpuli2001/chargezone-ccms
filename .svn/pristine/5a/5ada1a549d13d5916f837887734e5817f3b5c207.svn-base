/*
 * 
 * Author Vinita
 */
package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.PoolCarRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PoolCarRequestValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
         return PoolCarRequest.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDateTime","field.error1", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestFor","field.error13", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDateTime","field.error1", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason","field.error1", "None"); 
         PoolCarRequest poolCarRequest = (PoolCarRequest) o;
    }
    
}
