/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.Vacancy;

import com.bul.zydex.model.CandidateApplyJob;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vikas
 */
public class CandidateJobApplyValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return CandidateApplyJob.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CandidateApplyJob candidateApplyJob = (CandidateApplyJob) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherName",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motherName",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherDob",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motherDob",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photograph",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodGroup",
//                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentAddress",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "permanentAddress",
//                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNo",
                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emergencyContactPerson",
//                "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emergencyContactNo",
//                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "highestEducationQualification",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experianceDateJoiningYear",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experianceDateJoiningMonth",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "certificateAttach",
                "field.error1", "None");
    }

}
