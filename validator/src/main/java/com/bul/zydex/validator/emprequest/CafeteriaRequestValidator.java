/*
 * 
 * Author Vinita
 */

package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.CafeteriaRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class CafeteriaRequestValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return CafeteriaRequest.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestType","field.error13", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestFor","field.error1", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "venue","field.error1", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderDateTime","field.error13", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason","field.error1", "None"); 
         CafeteriaRequest cafeteriaRequest = (CafeteriaRequest) o;
    }

}
