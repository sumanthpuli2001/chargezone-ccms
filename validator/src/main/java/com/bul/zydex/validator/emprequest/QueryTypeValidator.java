/*
 * 
 * Author Vinita
 */

package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.QueryType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class QueryTypeValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
         return QueryType.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
               ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text","field.error1", "None"); 
               QueryType queryType = (QueryType) o;
    }

}
