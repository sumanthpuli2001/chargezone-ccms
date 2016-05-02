/*
 * 
 * Author Vinita
 */

package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.HrServiceRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class HrServiceRequestValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
         return HrServiceRequest.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "queryType.id","field.error13", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "details","field.error1", "None"); 
         HrServiceRequest hrServiceRequest = (HrServiceRequest) o;
    }

}
