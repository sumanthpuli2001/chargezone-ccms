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
public class CandidateExperienceDetail implements Serializable {

    private Integer id;
    private Integer experienceYearFrom;
    private Integer experienceYearTo;
    private String experienceOrganization;
    private String experienceDepartment;
    private String experienceDesignation;
    private String experienceJobResponsibilities;
    private String experienceRemunerationOnJoin;
    private String experienceRemunerationOnLeaving;
    private String experienceReasonForLeaving;
    private String createdDate;
    private CandidateApplyJob candidateApplyJob;

    public CandidateExperienceDetail() {
    }

    public CandidateExperienceDetail(Integer experienceYearFrom, Integer experienceYearTo, String experienceOrganization, String experienceDesignation, String experienceDepartment, String experienceJobResponsibilities, String experienceRemunerationOnJoin, String experienceRemunerationOnLeaving, String experienceReasonForLeaving, String createdDate, CandidateApplyJob candidateApplyJob) {
        this.experienceYearFrom = experienceYearFrom;
        this.experienceYearTo = experienceYearTo;
        this.experienceOrganization = experienceOrganization;
        this.experienceDesignation = experienceDesignation;
        this.experienceDepartment = experienceDepartment;
        this.experienceJobResponsibilities = experienceJobResponsibilities;
        this.experienceRemunerationOnJoin = experienceRemunerationOnJoin;
        this.experienceRemunerationOnLeaving = experienceRemunerationOnLeaving;
        this.experienceReasonForLeaving = experienceReasonForLeaving;
        this.createdDate = createdDate;
        this.candidateApplyJob = candidateApplyJob;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExperienceYearFrom() {
        return experienceYearFrom;
    }

    public void setExperienceYearFrom(Integer experienceYearFrom) {
        this.experienceYearFrom = experienceYearFrom;
    }

    public Integer getExperienceYearTo() {
        return experienceYearTo;
    }

    public void setExperienceYearTo(Integer experienceYearTo) {
        this.experienceYearTo = experienceYearTo;
    }

    public String getExperienceOrganization() {
        return experienceOrganization;
    }

    public void setExperienceOrganization(String experienceOrganization) {
        this.experienceOrganization = experienceOrganization;
    }

    public String getExperienceDesignation() {
        return experienceDesignation;
    }

    public void setExperienceDesignation(String experienceDesignation) {
        this.experienceDesignation = experienceDesignation;
    }

    public String getExperienceDepartment() {
        return experienceDepartment;
    }

    public void setExperienceDepartment(String experienceDepartment) {
        this.experienceDepartment = experienceDepartment;
    }

    public String getExperienceJobResponsibilities() {
        return experienceJobResponsibilities;
    }

    public void setExperienceJobResponsibilities(String experienceJobResponsibilities) {
        this.experienceJobResponsibilities = experienceJobResponsibilities;
    }

    public String getExperienceRemunerationOnJoin() {
        return experienceRemunerationOnJoin;
    }

    public void setExperienceRemunerationOnJoin(String experienceRemunerationOnJoin) {
        this.experienceRemunerationOnJoin = experienceRemunerationOnJoin;
    }

    public String getExperienceRemunerationOnLeaving() {
        return experienceRemunerationOnLeaving;
    }

    public void setExperienceRemunerationOnLeaving(String experienceRemunerationOnLeaving) {
        this.experienceRemunerationOnLeaving = experienceRemunerationOnLeaving;
    }

    public String getExperienceReasonForLeaving() {
        return experienceReasonForLeaving;
    }

    public void setExperienceReasonForLeaving(String experienceReasonForLeaving) {
        this.experienceReasonForLeaving = experienceReasonForLeaving;
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
