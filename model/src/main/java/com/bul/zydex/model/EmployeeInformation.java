/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;

/**
 *
 * @author DELL3
 */
public class EmployeeInformation implements Serializable{
    private Boolean employeeId;
    private Boolean employeeName;
    private Boolean dateOfJoining;
    private Boolean role;
    private Boolean company;
    private Boolean emailAddress;
    private Boolean contactNo1;
    private Boolean contactNo2;
    private Boolean fatherName;
    private Boolean motherName;
    private Boolean dateOfBirth;
    private Boolean gender;
    private Boolean bloodGroups;
    private Boolean maritalStatus;
    private Boolean spouseName;
    private Boolean emergencyContactPerson;
    private Boolean emergencyContactNo;
    private Boolean panCard;
    private Boolean adharCard;
    private Boolean passportNo;
    private Boolean passportIssueDate;
    private Boolean passportExpiryDate;
    private Boolean employeeType;
    private Boolean officeEmailId;
    private Boolean experienceYearOnDoj;
    private Boolean experienceMonthOnDoj;
    private Boolean permanentAddress;
    private Boolean presentAddress;
    private Boolean maritalStatusOthers;
    private Boolean bankName;
    private Boolean bankAccountNo;
    private Boolean bankIfscCode;
    private Boolean zydexLocation;
    private Boolean workLocation;
    private Boolean level;
    private Boolean department;
    private Boolean designation;
    private Boolean workType;
    private Boolean reportingManager;
    private Boolean highestEducationDetails;
    private Boolean cityOfEmployee;
    private Boolean child1;
    private Boolean child2;
    private Boolean dateOfBirthOfEmpFather;
    private Boolean dateOfBirthOfEmpMother;
    private Boolean dateOfBirthOfEmpSpous;
    private Boolean dateOfBirthOfEmpChilld1;
    private Boolean dateOfBirthOfEmpChild2;
    private Boolean dateOfTransferOfEntity;
    private Boolean dateOfLeaving;
    private String id;
    private String employeeCode;
    private String employeeMasterName;
    private String zydexLocationId;
    private String workLocationId;
    private String levelID;
    private String departmentId;
    private String designationId;
    private String dojStartDate;
    private String dojEndDate;
    private String dolStartDate;
    private String dolEndDate;


    public EmployeeInformation() {
    }

    public EmployeeInformation(Boolean employeeId, Boolean employeeName, Boolean dateOfJoining, Boolean role, Boolean company, Boolean emailAddress, Boolean contactNo1, Boolean contactNo2, Boolean fatherName, Boolean motherName, Boolean dateOfBirth, Boolean gender, Boolean bloodGroups, Boolean maritalStatus, Boolean spouseName, Boolean emergencyContactPerson, Boolean emergencyContactNo, Boolean panCard, Boolean adharCard, Boolean passportNo, Boolean passportIssueDate, Boolean passportExpiryDate, Boolean employeeType, Boolean officeEmailId, Boolean experienceYearOnDoj, Boolean experienceMonthOnDoj, Boolean permanentAddress, Boolean presentAddress, Boolean maritalStatusOthers, Boolean bankName, Boolean bankAccountNo, Boolean bankIfscCode, Boolean zydexLocation, Boolean workLocation, Boolean level, Boolean department, Boolean designation, Boolean workType, Boolean reportingManager, Boolean highestEducationDetails, Boolean cityOfEmployee, Boolean child1, Boolean child2, Boolean dateOfBirthOfEmpFather, Boolean dateOfBirthOfEmpMother, Boolean dateOfBirthOfEmpSpous, Boolean dateOfBirthOfEmpChilld1, Boolean dateOfBirthOfEmpChild2, Boolean dateOfTransferOfEntity, Boolean dateOfLeaving, String id, String employeeCode, String employeeMasterName, String zydexLocationId, String workLocationId, String levelID, String departmentId, String designationId, String dojStartDate, String dojEndDate, String dolStartDate, String dolEndDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dateOfJoining = dateOfJoining;
        this.role = role;
        this.company = company;
        this.emailAddress = emailAddress;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodGroups = bloodGroups;
        this.maritalStatus = maritalStatus;
        this.spouseName = spouseName;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactNo = emergencyContactNo;
        this.panCard = panCard;
        this.adharCard = adharCard;
        this.passportNo = passportNo;
        this.passportIssueDate = passportIssueDate;
        this.passportExpiryDate = passportExpiryDate;
        this.employeeType = employeeType;
        this.officeEmailId = officeEmailId;
        this.experienceYearOnDoj = experienceYearOnDoj;
        this.experienceMonthOnDoj = experienceMonthOnDoj;
        this.permanentAddress = permanentAddress;
        this.presentAddress = presentAddress;
        this.maritalStatusOthers = maritalStatusOthers;
        this.bankName = bankName;
        this.bankAccountNo = bankAccountNo;
        this.bankIfscCode = bankIfscCode;
        this.zydexLocation = zydexLocation;
        this.workLocation = workLocation;
        this.level = level;
        this.department = department;
        this.designation = designation;
        this.workType = workType;
        this.reportingManager = reportingManager;
        this.highestEducationDetails = highestEducationDetails;
        this.cityOfEmployee = cityOfEmployee;
        this.child1 = child1;
        this.child2 = child2;
        this.dateOfBirthOfEmpFather = dateOfBirthOfEmpFather;
        this.dateOfBirthOfEmpMother = dateOfBirthOfEmpMother;
        this.dateOfBirthOfEmpSpous = dateOfBirthOfEmpSpous;
        this.dateOfBirthOfEmpChilld1 = dateOfBirthOfEmpChilld1;
        this.dateOfBirthOfEmpChild2 = dateOfBirthOfEmpChild2;
        this.dateOfTransferOfEntity = dateOfTransferOfEntity;
        this.dateOfLeaving = dateOfLeaving;
        this.id = id;
        this.employeeCode = employeeCode;
        this.employeeMasterName = employeeMasterName;
        this.zydexLocationId = zydexLocationId;
        this.workLocationId = workLocationId;
        this.levelID = levelID;
        this.departmentId = departmentId;
        this.designationId = designationId;
        this.dojStartDate = dojStartDate;
        this.dojEndDate = dojEndDate;
        this.dolStartDate = dolStartDate;
        this.dolEndDate = dolEndDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeMasterName() {
        return employeeMasterName;
    }

    public void setEmployeeMasterName(String employeeMasterName) {
        this.employeeMasterName = employeeMasterName;
    }

    public Boolean getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Boolean employeeId) {
        this.employeeId = employeeId;
    }

    public Boolean getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(Boolean employeeName) {
        this.employeeName = employeeName;
    }

    public Boolean getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Boolean dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public Boolean getCompany() {
        return company;
    }

    public void setCompany(Boolean company) {
        this.company = company;
    }

    public Boolean getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Boolean emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(Boolean contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public Boolean getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(Boolean contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public Boolean getFatherName() {
        return fatherName;
    }

    public void setFatherName(Boolean fatherName) {
        this.fatherName = fatherName;
    }

    public Boolean getMotherName() {
        return motherName;
    }

    public void setMotherName(Boolean motherName) {
        this.motherName = motherName;
    }

    public Boolean getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Boolean dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(Boolean spouseName) {
        this.spouseName = spouseName;
    }

    public Boolean getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(Boolean emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public Boolean getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(Boolean emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public Boolean getPanCard() {
        return panCard;
    }

    public void setPanCard(Boolean panCard) {
        this.panCard = panCard;
    }

    public Boolean getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(Boolean passportNo) {
        this.passportNo = passportNo;
    }

    public Boolean getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(Boolean passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public Boolean getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(Boolean passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }

    public Boolean getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Boolean employeeType) {
        this.employeeType = employeeType;
    }

    public Boolean getOfficeEmailId() {
        return officeEmailId;
    }

    public void setOfficeEmailId(Boolean officeEmailId) {
        this.officeEmailId = officeEmailId;
    }

    public Boolean getExperienceYearOnDoj() {
        return experienceYearOnDoj;
    }

    public void setExperienceYearOnDoj(Boolean experienceYearOnDoj) {
        this.experienceYearOnDoj = experienceYearOnDoj;
    }

    public Boolean getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Boolean permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Boolean getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(Boolean presentAddress) {
        this.presentAddress = presentAddress;
    }

    public Boolean getAdharCard() {
        return adharCard;
    }

    public void setAdharCard(Boolean adharCard) {
        this.adharCard = adharCard;
    }

    public Boolean getBloodGroups() {
        return bloodGroups;
    }

    public void setBloodGroups(Boolean bloodGroups) {
        this.bloodGroups = bloodGroups;
    }

    public Boolean getMaritalStatusOthers() {
        return maritalStatusOthers;
    }

    public void setMaritalStatusOthers(Boolean maritalStatusOthers) {
        this.maritalStatusOthers = maritalStatusOthers;
    }

    public Boolean getExperienceMonthOnDoj() {
        return experienceMonthOnDoj;
    }

    public void setExperienceMonthOnDoj(Boolean experienceMonthOnDoj) {
        this.experienceMonthOnDoj = experienceMonthOnDoj;
    }

    public Boolean getBankName() {
        return bankName;
    }

    public void setBankName(Boolean bankName) {
        this.bankName = bankName;
    }

    public Boolean getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(Boolean bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public Boolean getBankIfscCode() {
        return bankIfscCode;
    }

    public void setBankIfscCode(Boolean bankIfscCode) {
        this.bankIfscCode = bankIfscCode;
    }

    public Boolean getZydexLocation() {
        return zydexLocation;
    }

    public void setZydexLocation(Boolean zydexLocation) {
        this.zydexLocation = zydexLocation;
    }

    public Boolean getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(Boolean workLocation) {
        this.workLocation = workLocation;
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }

    public Boolean getDepartment() {
        return department;
    }

    public void setDepartment(Boolean department) {
        this.department = department;
    }

    public Boolean getDesignation() {
        return designation;
    }

    public void setDesignation(Boolean designation) {
        this.designation = designation;
    }

    public Boolean getWorkType() {
        return workType;
    }

    public void setWorkType(Boolean workType) {
        this.workType = workType;
    }

    public Boolean getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(Boolean reportingManager) {
        this.reportingManager = reportingManager;
    }

    public Boolean getHighestEducationDetails() {
        return highestEducationDetails;
    }

    public void setHighestEducationDetails(Boolean highestEducationDetails) {
        this.highestEducationDetails = highestEducationDetails;
    }

    public String getZydexLocationId() {
        return zydexLocationId;
    }

    public void setZydexLocationId(String zydexLocationId) {
        this.zydexLocationId = zydexLocationId;
    }

    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDesignationId() {
        return designationId;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public Boolean getCityOfEmployee() {
        return cityOfEmployee;
    }

    public void setCityOfEmployee(Boolean cityOfEmployee) {
        this.cityOfEmployee = cityOfEmployee;
    }

    public Boolean getChild1() {
        return child1;
    }

    public void setChild1(Boolean child1) {
        this.child1 = child1;
    }

    public Boolean getChild2() {
        return child2;
    }

    public void setChild2(Boolean child2) {
        this.child2 = child2;
    }

    public Boolean getDateOfBirthOfEmpFather() {
        return dateOfBirthOfEmpFather;
    }

    public void setDateOfBirthOfEmpFather(Boolean dateOfBirthOfEmpFather) {
        this.dateOfBirthOfEmpFather = dateOfBirthOfEmpFather;
    }

    public Boolean getDateOfBirthOfEmpMother() {
        return dateOfBirthOfEmpMother;
    }

    public void setDateOfBirthOfEmpMother(Boolean dateOfBirthOfEmpMother) {
        this.dateOfBirthOfEmpMother = dateOfBirthOfEmpMother;
    }

    public Boolean getDateOfBirthOfEmpSpous() {
        return dateOfBirthOfEmpSpous;
    }

    public void setDateOfBirthOfEmpSpous(Boolean dateOfBirthOfEmpSpous) {
        this.dateOfBirthOfEmpSpous = dateOfBirthOfEmpSpous;
    }

    public Boolean getDateOfBirthOfEmpChilld1() {
        return dateOfBirthOfEmpChilld1;
    }

    public void setDateOfBirthOfEmpChilld1(Boolean dateOfBirthOfEmpChilld1) {
        this.dateOfBirthOfEmpChilld1 = dateOfBirthOfEmpChilld1;
    }

    public Boolean getDateOfBirthOfEmpChild2() {
        return dateOfBirthOfEmpChild2;
    }

    public void setDateOfBirthOfEmpChild2(Boolean dateOfBirthOfEmpChild2) {
        this.dateOfBirthOfEmpChild2 = dateOfBirthOfEmpChild2;
    }

    public Boolean getDateOfTransferOfEntity() {
        return dateOfTransferOfEntity;
    }

    public void setDateOfTransferOfEntity(Boolean dateOfTransferOfEntity) {
        this.dateOfTransferOfEntity = dateOfTransferOfEntity;
    }

    public String getDojStartDate() {
        return dojStartDate;
    }

    public void setDojStartDate(String dojStartDate) {
        this.dojStartDate = dojStartDate;
    }

    public String getDojEndDate() {
        return dojEndDate;
    }

    public void setDojEndDate(String dojEndDate) {
        this.dojEndDate = dojEndDate;
    }

    public String getDolStartDate() {
        return dolStartDate;
    }

    public void setDolStartDate(String dolStartDate) {
        this.dolStartDate = dolStartDate;
    }

    public String getDolEndDate() {
        return dolEndDate;
    }

    public void setDolEndDate(String dolEndDate) {
        this.dolEndDate = dolEndDate;
    }

    public String getWorkLocationId() {
        return workLocationId;
    }

    public void setWorkLocationId(String workLocationId) {
        this.workLocationId = workLocationId;
    }

    public Boolean getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(Boolean dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }
    
}
