/*
 * 
 * Author Vinita
 */
package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.VisitorManagement;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class VisitorManagementValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return VisitorManagement.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitorName", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitorOrganization", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "incomingDateTime", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitorComingFrom", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitorContactDetail", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitorVisitedLocation.id", "field.error27", "None");
        VisitorManagement visitorManagement = (VisitorManagement) o;
        if (visitorManagement.getVisitorVisitedLocation().getId() != null) {
            if (visitorManagement.getVisitorVisitedLocation().getId() == 0) {
                errors.rejectValue("visitorVisitedLocation.id", "field.error27", "none");
            } else {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitorVisitedLocation.id", "field.error1", "None");
            }
        }
    }

}
