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
public class CandidateFamilyBackground implements Serializable {

    private Integer id;
    private String familyMemberName;
    private String relationWithFamilyMember;
    private String familyMemberAge;
    private String familyMemberQualification;
    private String familyMemberDesignationOccupation;
    private String familyMemberMonthlyIncome;
    private String createdDate;
    private CandidateApplyJob candidateApplyJob;

    public CandidateFamilyBackground() {
    }

    public CandidateFamilyBackground(String familyMemberName, String relationWithFamilyMember, String familyMemberAge, String familyMemberQualification, String familyMemberDesignationOccupation, String familyMemberMonthlyIncome, String createdDate, CandidateApplyJob candidateApplyJob) {
        this.familyMemberName = familyMemberName;
        this.relationWithFamilyMember = relationWithFamilyMember;
        this.familyMemberAge = familyMemberAge;
        this.familyMemberQualification = familyMemberQualification;
        this.familyMemberDesignationOccupation = familyMemberDesignationOccupation;
        this.familyMemberMonthlyIncome = familyMemberMonthlyIncome;
        this.createdDate = createdDate;
        this.candidateApplyJob = candidateApplyJob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String familyMemberName) {
        this.familyMemberName = familyMemberName;
    }

    public String getRelationWithFamilyMember() {
        return relationWithFamilyMember;
    }

    public void setRelationWithFamilyMember(String relationWithFamilyMember) {
        this.relationWithFamilyMember = relationWithFamilyMember;
    }

    public String getFamilyMemberAge() {
        return familyMemberAge;
    }

    public void setFamilyMemberAge(String familyMemberAge) {
        this.familyMemberAge = familyMemberAge;
    }

    public String getFamilyMemberQualification() {
        return familyMemberQualification;
    }

    public void setFamilyMemberQualification(String familyMemberQualification) {
        this.familyMemberQualification = familyMemberQualification;
    }

    public String getFamilyMemberDesignationOccupation() {
        return familyMemberDesignationOccupation;
    }

    public void setFamilyMemberDesignationOccupation(String familyMemberDesignationOccupation) {
        this.familyMemberDesignationOccupation = familyMemberDesignationOccupation;
    }

    public String getFamilyMemberMonthlyIncome() {
        return familyMemberMonthlyIncome;
    }

    public void setFamilyMemberMonthlyIncome(String familyMemberMonthlyIncome) {
        this.familyMemberMonthlyIncome = familyMemberMonthlyIncome;
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
