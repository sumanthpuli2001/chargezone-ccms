/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Aman
 */
public class CandidateApplyJob  implements java.io.Serializable{
    
    
    private Integer id;
    private String name;
    private String fatherName;
    private String motherName;
    private String fatherDob;
    private String motherDob;
    private String sex;
    private String martialStatus;
    private String dob;
    private String photograph;
    private String presentAddress;
    private String permanentAddress;
    private String city;
    private String bloodGroup;
    private String emailId;
    private String contactNo;
    private String emergencyContactPerson;
    private String emergencyContactNo;
    private String highestEducationQualification;
    private String experianceDateJoiningYear;
    private String experianceDateJoiningMonth;
    private String certificateAttach;
    private VacancyMaster vacancyId;
    private ApplayJobUserMaster applayJobUserMaster;
   
    
    public CandidateApplyJob(){
        
    }

    public CandidateApplyJob(Integer id, String name, String fatherName, String motherName, String fatherDob, String motherDob, String sex, String martialStatus, String dob, String photograph, String presentAddress, String permanentAddress, String city, String bloodGroup, String emailId, String contactNo, String emergencyContactPerson, String emergencyContactNo, String highestEducationQualification, String experianceDateJoiningYear, String experianceDateJoiningMonth, String certificateAttach, VacancyMaster vacancyId,ApplayJobUserMaster applayJobUserMaster) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherDob = fatherDob;
        this.motherDob = motherDob;
        this.sex = sex;
        this.martialStatus = martialStatus;
        this.dob = dob;
        this.photograph = photograph;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.city = city;
        this.bloodGroup = bloodGroup;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactNo = emergencyContactNo;
        this.highestEducationQualification = highestEducationQualification;
        this.experianceDateJoiningYear = experianceDateJoiningYear;
        this.experianceDateJoiningMonth = experianceDateJoiningMonth;
        this.certificateAttach = certificateAttach;
        this.vacancyId = vacancyId;
        this.applayJobUserMaster = applayJobUserMaster;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherDob() {
        return fatherDob;
    }

    public void setFatherDob(String fatherDob) {
        this.fatherDob = fatherDob;
    }

    public String getMotherDob() {
        return motherDob;
    }

    public void setMotherDob(String motherDob) {
        this.motherDob = motherDob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public String getHighestEducationQualification() {
        return highestEducationQualification;
    }

    public void setHighestEducationQualification(String highestEducationQualification) {
        this.highestEducationQualification = highestEducationQualification;
    }

    public String getExperianceDateJoiningYear() {
        return experianceDateJoiningYear;
    }

    public void setExperianceDateJoiningYear(String experianceDateJoiningYear) {
        this.experianceDateJoiningYear = experianceDateJoiningYear;
    }

    public String getExperianceDateJoiningMonth() {
        return experianceDateJoiningMonth;
    }

    public void setExperianceDateJoiningMonth(String experianceDateJoiningMonth) {
        this.experianceDateJoiningMonth = experianceDateJoiningMonth;
    }

    public String getCertificateAttach() {
        return certificateAttach;
    }

    public void setCertificateAttach(String certificateAttach) {
        this.certificateAttach = certificateAttach;
    }

    public VacancyMaster getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(VacancyMaster vacancyId) {
        this.vacancyId = vacancyId;
    }

    public ApplayJobUserMaster getApplayJobUserMaster() {
        return applayJobUserMaster;
    }

    public void setApplayJobUserMaster(ApplayJobUserMaster applayJobUserMaster) {
        this.applayJobUserMaster = applayJobUserMaster;
    }

    
    
    

   
    
    
    
}
