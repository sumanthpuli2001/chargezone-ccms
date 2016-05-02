/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.empreferral;

import com.bul.zydex.model.EmployeeReferral;
import com.bul.zydex.validator.NumberValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan
 */
public class EmployeeReferralValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeReferral.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeReferral employeeReferral = (EmployeeReferral) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "candidateName", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "candidateContactNo", "field.error11", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "candidatePositionReferredFor", "field.error27", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "candidateRelation", "field.error1", "none");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "candidateReferingReason", "field.error1", "none");
//        if (employeeReferral.getId() != null && employeeReferral.getStatus() != 2) {
////not 0 means it is just created
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinerName", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinerDateOfJoining", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinerEmployeeNo", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinerDepartment", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinersPosition", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joinersLocation", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "referralAward", "field.error1", "none");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hrRemark", "field.error1", "none");
//        }
        //this is for validate contact no as digits allow.
        if (!(employeeReferral.getCandidateContactNo().isEmpty()) && !(new NumberValidator().validate(employeeReferral.getCandidateContactNo()))) {
            errors.rejectValue("candidateContactNo", "field.error11", "Please Valid Contact No.");
        }
    }
}
