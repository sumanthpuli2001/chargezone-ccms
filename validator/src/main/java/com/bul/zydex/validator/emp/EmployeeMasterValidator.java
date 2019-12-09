/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator.emp;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.validator.AadharValidator;
import com.bul.zydex.validator.DateValidator;
import com.bul.zydex.validator.EmailValidator;
import com.bul.zydex.validator.NumberValidator;
import com.bul.zydex.validator.PanValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public class EmployeeMasterValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return EmployeeMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        EmployeeMaster employeeMaster = (EmployeeMaster) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "employeeId.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName", "employeeName.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfJoining", "dateOfJoining.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirth.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "departmentMaster.id", "departmentMaster.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeSubType.id", "subTypeId.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designationMaster.id", "designationMaster.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maritalStatus", "maritalStatus.required", "None");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "panCard", "panCard.required", "None");
 //       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", "nationality.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adharCard", "adharCard.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "emailAddress.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNo1", "contactNo1.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodGroups", "bloodGroups.required", "None");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherName", "fatherName.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motherName", "motherName.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentAddress", "presentAddress.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "permanentAddress", "permanentAddress.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "levelMaster.id", "levelMasterId.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationMaster.id", "locationMaster.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeType", "employeeType.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shiftType", "shiftType.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "basicSalary", "basicSalary.required", "None");
        
        //if (employeeMaster.getId() == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "jobDescription.required", "None");
        //}
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "paymentType", "paymentType.required", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reportingManagerLevel1", "reportingManagerLevel1.required", "None");
        if (employeeMaster.getId() == null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userMaster.password", "field.error1", "None");
        }
        
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userMaster.password", "userMasterPassword.required", "None");
        
        
        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "field.error1", "None");
        //        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emergencyContactPerson", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emergencyContactNo", "field.error1", "None");

        
                
        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "officeEmailId", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "highestEducationDetails", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experienceYearOnDoj", "field.error27", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "experienceMonthOnDoj", "field.error27", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "field.error27", "None");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zydexLocationMaster.id", "zydexLocationMaster.required", "None");
        //        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeLocation", "field.error1", "None");

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankName", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankAccountNo", "field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bankIfscCode", "field.error1", "None");

        
        

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "child1","field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "child2","field.error1", "None");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reasonForLeaving", "field.error1", "None");
        EmailValidator emailValidator = new EmailValidator();
        NumberValidator numberValidator = new NumberValidator();
        DateValidator dateValidator = new DateValidator();

//        if (!dateValidator.validate(employeeMaster.getDateOfBirth()) && !employeeMaster.getDateOfBirth().isEmpty()) {
//            errors.rejectValue("dateOfBirth", "field.error5", "Value Is Not Valid");
//        }

//        if (!emailValidator.validate(employeeMaster.getEmailAddress()) && !employeeMaster.getEmailAddress().isEmpty()) {
//            errors.rejectValue("emailAddress", "field.error7", "none");
//        }
        
        if (!emailValidator.validate(employeeMaster.getEmailAddress()) && !employeeMaster.getEmailAddress().isEmpty()) {
            errors.rejectValue("emailAddress", "emailAddress.error", "none");
        }

        if (!numberValidator.validate(employeeMaster.getContactNo1()) && !employeeMaster.getContactNo1().isEmpty()) {
            errors.rejectValue("contactNo1", "contactNo1.error", "none");
        }
//
//        if (!numberValidator.validate(employeeMaster.getEmergencyContactNo()) && !employeeMaster.getEmergencyContactNo().isEmpty()) {
//            errors.rejectValue("emergencyContactNo", "field.error0", "none");
//        }
//
        if (!new PanValidator().validate(employeeMaster.getPanCard().toUpperCase()) && !employeeMaster.getPanCard().isEmpty()) {
            errors.rejectValue("panCard", "pan.error10", "none");
        }

        if (!new AadharValidator().validate(employeeMaster.getAdharCard()) && !employeeMaster.getAdharCard().isEmpty()) {
            errors.rejectValue("adharCard", "aadhar.error31", "none");
        }

//        if (!emailValidator.validate(employeeMaster.getOfficeEmailId()) && !employeeMaster.getOfficeEmailId().isEmpty()) {
//            errors.rejectValue("officeEmailId", "field.error7", "none");
//        }
//
//        if (!dateValidator.validate(employeeMaster.getDateOfJoining()) && !employeeMaster.getDateOfJoining().isEmpty()) {
//            errors.rejectValue("dateOfJoining", "field.error5", "none");
//        }

//        if (!numberValidator.validate(employeeMaster.getBankAccountNo()) && !employeeMaster.getBankAccountNo().isEmpty()) {
//            errors.rejectValue("bankAccountNo", "field.error0", "It Is Not Valid BankAcountNo.");
//        }

//        if (!new IFSCValidator().isValidIFSC(employeeMaster.getBankIfscCode()) && !employeeMaster.getBankIfscCode().isEmpty()) {
//            errors.rejectValue("bankIfscCode", "field.error32", "It Is Not Valid.");
//        }
    }

}
