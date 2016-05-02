/*
 * 
 * Author Vinita
 */

package com.bul.zydex.validator.probationtoconfirmation;

import com.bul.zydex.model.ProbationToConfirmation;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class ProbationtoConfirmationValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return ProbationToConfirmation.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobHandled","field.error1", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "performanceRating","field.error13", "None"); 
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recommendationSelect","field.error13", "None"); 
        ProbationToConfirmation probationToConfirmation = (ProbationToConfirmation) o;
    }

}
