/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Vikas
 */
public class CandidateF2FRequest {

    private Integer id;
    private CandidateJobApplication candidateJobApplication;
    private Integer status;
    private Integer hrStatus;
    private Integer userStatus;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;
    private String message;
    private String location;
    private String dateOfInterview;
    private VacancyMaster vacancyMaster;
    private CandidateApplyJob candidateApplyJob;

    public CandidateF2FRequest() {

    }

    public CandidateF2FRequest(Integer id, CandidateJobApplication candidateJobApplication, Integer status, Integer hrStatus, Integer userStatus, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate, String message, String location, String dateOfInterview, VacancyMaster vacancyMaster, CandidateApplyJob candidateApplyJob) {
        this.id = id;
        this.candidateJobApplication = candidateJobApplication;
        this.status = status;
        this.hrStatus = hrStatus;
        this.userStatus = userStatus;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.message = message;
        this.location = location;
        this.dateOfInterview = dateOfInterview;
        this.vacancyMaster = vacancyMaster;
        this.candidateApplyJob = candidateApplyJob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidateJobApplication getCandidateJobApplication() {
        return candidateJobApplication;
    }

    public void setCandidateJobApplication(CandidateJobApplication candidateJobApplication) {
        this.candidateJobApplication = candidateJobApplication;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getHrStatus() {
        return hrStatus;
    }

    public void setHrStatus(Integer hrStatus) {
        this.hrStatus = hrStatus;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfInterview() {
        return dateOfInterview;
    }

    public void setDateOfInterview(String dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public VacancyMaster getVacancyMaster() {
        return vacancyMaster;
    }

    public void setVacancyMaster(VacancyMaster vacancyMaster) {
        this.vacancyMaster = vacancyMaster;
    }

    public CandidateApplyJob getCandidateApplyJob() {
        return candidateApplyJob;
    }

    public void setCandidateApplyJob(CandidateApplyJob candidateApplyJob) {
        this.candidateApplyJob = candidateApplyJob;
    }
    
    
    
    

}
