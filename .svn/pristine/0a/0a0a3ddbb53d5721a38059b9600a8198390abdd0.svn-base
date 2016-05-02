/*
 * 
 * Author Vinita
 */

package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.ItRequestType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class ItRequestTypeValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
             return ItRequestType.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
          ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text","field.error1", "None"); 
          ItRequestType itRequestType = (ItRequestType) o;
    }

}
