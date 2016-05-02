/*
 * 
 * Author Vinita
 */

package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.ItServiceRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class ItServiceValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ItServiceRequest.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itRequestType.id","field.error13", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "problemDetail","field.error1", "None"); 
         ItServiceRequest itServiceRequest = (ItServiceRequest) o;
    }

}
