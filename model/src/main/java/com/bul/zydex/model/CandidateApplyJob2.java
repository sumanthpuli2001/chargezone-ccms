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
public class CandidateApplyJob2 implements Serializable {

    private Integer id;
    private String lastName;
    private String postAppliedFor;
    private String residentPhoneNumber;
    private String religion;
    private String height;
    private String weight;
    private String physicalDamageOrDiseases;
    private String criminalCaseBackground;
    private String insurancePolicyNumber;
    private String drivingLicenceNumber;
    private String anyRelativeInSPCL;
    private Integer readEnglish;
    private Integer writeEnglish;
    private Integer speakEnglish;
    private Integer readHindi;
    private Integer writeHindi;
    private Integer speakHindi;
    private Integer readGujarati;
    private Integer writeGujarati;
    private Integer speakGujarati;
    private Integer smokingHabit;
    private Integer chewingHabit;
    private Integer tobaccoHabit;
    private Integer otherHabit;
    private String salaryExpected;
    private String noticePeriod;
    private Integer esicStatus;
    private Integer pfStatus;
    private String esicNumber;
    private String pfNumber;
    private String salaryBreakupBasic;
    private String salaryBreakupDaVdaSdAll;
    private String salaryBreakupHRA;
    private String salaryBreakupConveyanceAll;
    private String salaryBreakupLTA;
    private String salaryBreakupMED;
    private String salaryBreakupBonus;
    private String salaryBreakupOther;
    private String salaryBreakupTotal;
    private String salarySlipAttachment;
    private String createdDate;
    private CandidateApplyJob candidateApplyJob;

    public CandidateApplyJob2() {
    }

    public CandidateApplyJob2(String lastName, String postAppliedFor, String residentPhoneNumber, String religion, String height, String weight, String physicalDamageOrDiseases, String criminalCaseBackground, String insurancePolicyNumber, String drivingLicenceNumber, String anyRelativeInSPCL, Integer readEnglish, Integer writeEnglish, Integer speakEnglish, Integer readHindi, Integer writeHindi, Integer speakHindi, Integer readGujarati, Integer writeGujarati, Integer speakGujarati, Integer smokingHabit, Integer chewingHabit, Integer tobaccoHabit, Integer otherHabit, String salaryExpected, String noticePeriod, Integer esicStatus, Integer pfStatus, String esicNumber, String pfNumber, String salaryBreakupBasic, String salaryBreakupDaVdaSdAll, String salaryBreakupHRA, String salaryBreakupConveyanceAll, String salaryBreakupLTA, String salaryBreakupMED, String salaryBreakupBonus, String salaryBreakupOther, String salaryBreakupTotal, String salarySlipAttachment, String createdDate, CandidateApplyJob candidateApplyJob) {
        this.lastName = lastName;
        this.postAppliedFor = postAppliedFor;
        this.residentPhoneNumber = residentPhoneNumber;
        this.religion = religion;
        this.height = height;
        this.weight = weight;
        this.physicalDamageOrDiseases = physicalDamageOrDiseases;
        this.criminalCaseBackground = criminalCaseBackground;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.drivingLicenceNumber = drivingLicenceNumber;
        this.anyRelativeInSPCL = anyRelativeInSPCL;
        this.readEnglish = readEnglish;
        this.writeEnglish = writeEnglish;
        this.speakEnglish = speakEnglish;
        this.readHindi = readHindi;
        this.writeHindi = writeHindi;
        this.speakHindi = speakHindi;
        this.readGujarati = readGujarati;
        this.writeGujarati = writeGujarati;
        this.speakGujarati = speakGujarati;
        this.smokingHabit = smokingHabit;
        this.chewingHabit = chewingHabit;
        this.tobaccoHabit = tobaccoHabit;
        this.otherHabit = otherHabit;
        this.salaryExpected = salaryExpected;
        this.noticePeriod = noticePeriod;
        this.esicStatus = esicStatus;
        this.pfStatus = pfStatus;
        this.esicNumber = esicNumber;
        this.pfNumber = pfNumber;
        this.salaryBreakupBasic = salaryBreakupBasic;
        this.salaryBreakupDaVdaSdAll = salaryBreakupDaVdaSdAll;
        this.salaryBreakupHRA = salaryBreakupHRA;
        this.salaryBreakupConveyanceAll = salaryBreakupConveyanceAll;
        this.salaryBreakupLTA = salaryBreakupLTA;
        this.salaryBreakupMED = salaryBreakupMED;
        this.salaryBreakupBonus = salaryBreakupBonus;
        this.salaryBreakupOther = salaryBreakupOther;
        this.salaryBreakupTotal = salaryBreakupTotal;
        this.salarySlipAttachment = salarySlipAttachment;
        this.createdDate = createdDate;
        this.candidateApplyJob = candidateApplyJob;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostAppliedFor() {
        return postAppliedFor;
    }

    public void setPostAppliedFor(String postAppliedFor) {
        this.postAppliedFor = postAppliedFor;
    }

    
    public String getResidentPhoneNumber() {
        return residentPhoneNumber;
    }

    public void setResidentPhoneNumber(String residentPhoneNumber) {
        this.residentPhoneNumber = residentPhoneNumber;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getReadEnglish() {
        return readEnglish;
    }

    public void setReadEnglish(Integer readEnglish) {
        this.readEnglish = readEnglish;
    }

    public Integer getWriteEnglish() {
        return writeEnglish;
    }

    public void setWriteEnglish(Integer writeEnglish) {
        this.writeEnglish = writeEnglish;
    }

    public Integer getSpeakEnglish() {
        return speakEnglish;
    }

    public void setSpeakEnglish(Integer speakEnglish) {
        this.speakEnglish = speakEnglish;
    }

    public Integer getReadHindi() {
        return readHindi;
    }

    public void setReadHindi(Integer readHindi) {
        this.readHindi = readHindi;
    }

    public Integer getWriteHindi() {
        return writeHindi;
    }

    public void setWriteHindi(Integer writeHindi) {
        this.writeHindi = writeHindi;
    }

    public Integer getSpeakHindi() {
        return speakHindi;
    }

    public void setSpeakHindi(Integer speakHindi) {
        this.speakHindi = speakHindi;
    }

    public Integer getReadGujarati() {
        return readGujarati;
    }

    public void setReadGujarati(Integer readGujarati) {
        this.readGujarati = readGujarati;
    }

    public Integer getWriteGujarati() {
        return writeGujarati;
    }

    public void setWriteGujarati(Integer writeGujarati) {
        this.writeGujarati = writeGujarati;
    }

    public Integer getSpeakGujarati() {
        return speakGujarati;
    }

    public void setSpeakGujarati(Integer speakGujarati) {
        this.speakGujarati = speakGujarati;
    }

    
    public String getPhysicalDamageOrDiseases() {
        return physicalDamageOrDiseases;
    }

    public void setPhysicalDamageOrDiseases(String physicalDamageOrDiseases) {
        this.physicalDamageOrDiseases = physicalDamageOrDiseases;
    }

    public String getCriminalCaseBackground() {
        return criminalCaseBackground;
    }

    public void setCriminalCaseBackground(String criminalCaseBackground) {
        this.criminalCaseBackground = criminalCaseBackground;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    public String getAnyRelativeInSPCL() {
        return anyRelativeInSPCL;
    }

    public void setAnyRelativeInSPCL(String anyRelativeInSPCL) {
        this.anyRelativeInSPCL = anyRelativeInSPCL;
    }

    public Integer getSmokingHabit() {
        return smokingHabit;
    }

    public void setSmokingHabit(Integer smokingHabit) {
        this.smokingHabit = smokingHabit;
    }

    public Integer getChewingHabit() {
        return chewingHabit;
    }

    public void setChewingHabit(Integer chewingHabit) {
        this.chewingHabit = chewingHabit;
    }

    public Integer getTobaccoHabit() {
        return tobaccoHabit;
    }

    public void setTobaccoHabit(Integer tobaccoHabit) {
        this.tobaccoHabit = tobaccoHabit;
    }

    public Integer getOtherHabit() {
        return otherHabit;
    }

    public void setOtherHabit(Integer otherHabit) {
        this.otherHabit = otherHabit;
    }

    public Integer getEsicStatus() {
        return esicStatus;
    }

    public void setEsicStatus(Integer esicStatus) {
        this.esicStatus = esicStatus;
    }

    public Integer getPfStatus() {
        return pfStatus;
    }

    public void setPfStatus(Integer pfStatus) {
        this.pfStatus = pfStatus;
    } 

    public String getSalaryExpected() {
        return salaryExpected;
    }

    public void setSalaryExpected(String salaryExpected) {
        this.salaryExpected = salaryExpected;
    }

    public String getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    

    public String getEsicNumber() {
        return esicNumber;
    }

    public void setEsicNumber(String esicNumber) {
        this.esicNumber = esicNumber;
    }

    public String getPfNumber() {
        return pfNumber;
    }

    public void setPfNumber(String pfNumber) {
        this.pfNumber = pfNumber;
    }

    public String getSalaryBreakupBasic() {
        return salaryBreakupBasic;
    }

    public void setSalaryBreakupBasic(String salaryBreakupBasic) {
        this.salaryBreakupBasic = salaryBreakupBasic;
    }

    public String getSalaryBreakupDaVdaSdAll() {
        return salaryBreakupDaVdaSdAll;
    }

    public void setSalaryBreakupDaVdaSdAll(String salaryBreakupDaVdaSdAll) {
        this.salaryBreakupDaVdaSdAll = salaryBreakupDaVdaSdAll;
    }

    public String getSalaryBreakupHRA() {
        return salaryBreakupHRA;
    }

    public void setSalaryBreakupHRA(String salaryBreakupHRA) {
        this.salaryBreakupHRA = salaryBreakupHRA;
    }

    public String getSalaryBreakupConveyanceAll() {
        return salaryBreakupConveyanceAll;
    }

    public void setSalaryBreakupConveyanceAll(String salaryBreakupConveyanceAll) {
        this.salaryBreakupConveyanceAll = salaryBreakupConveyanceAll;
    }

    public String getSalaryBreakupLTA() {
        return salaryBreakupLTA;
    }

    public void setSalaryBreakupLTA(String salaryBreakupLTA) {
        this.salaryBreakupLTA = salaryBreakupLTA;
    }

    public String getSalaryBreakupMED() {
        return salaryBreakupMED;
    }

    public void setSalaryBreakupMED(String salaryBreakupMED) {
        this.salaryBreakupMED = salaryBreakupMED;
    }

    public String getSalaryBreakupBonus() {
        return salaryBreakupBonus;
    }

    public void setSalaryBreakupBonus(String salaryBreakupBonus) {
        this.salaryBreakupBonus = salaryBreakupBonus;
    }

    public String getSalaryBreakupOther() {
        return salaryBreakupOther;
    }

    public void setSalaryBreakupOther(String salaryBreakupOther) {
        this.salaryBreakupOther = salaryBreakupOther;
    }

    public String getSalaryBreakupTotal() {
        return salaryBreakupTotal;
    }

    public void setSalaryBreakupTotal(String salaryBreakupTotal) {
        this.salaryBreakupTotal = salaryBreakupTotal;
    }

    public String getSalarySlipAttachment() {
        return salarySlipAttachment;
    }

    public void setSalarySlipAttachment(String salarySlipAttachment) {
        this.salarySlipAttachment = salarySlipAttachment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public CandidateApplyJob getCandidateApplyJob() {
        return candidateApplyJob;
    }

    public void setCandidateApplyJob(CandidateApplyJob candidateApplyJob) {
        this.candidateApplyJob = candidateApplyJob;
    }

    
    
}
