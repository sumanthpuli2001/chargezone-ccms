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
    private Integer currentApproverCount;
    private Integer totalApproverCount;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;
    private String message;
    private String location;
    private String dateOfInterview;

    public CandidateF2FRequest() {

    }

    public CandidateF2FRequest(Integer id, CandidateJobApplication candidateJobApplication, Integer status, Integer currentApproverCount, Integer totalApproverCount, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate, String message, String location, String dateOfInterview) {
        this.id = id;
        this.candidateJobApplication = candidateJobApplication;
        this.status = status;
        this.currentApproverCount = currentApproverCount;
        this.totalApproverCount = totalApproverCount;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.message = message;
        this.location = location;
        this.dateOfInterview = dateOfInterview;
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

    public Integer getCurrentApproverCount() {
        return currentApproverCount;
    }

    public void setCurrentApproverCount(Integer currentApproverCount) {
        this.currentApproverCount = currentApproverCount;
    }

    public Integer getTotalApproverCount() {
        return totalApproverCount;
    }

    public void setTotalApproverCount(Integer totalApproverCount) {
        this.totalApproverCount = totalApproverCount;
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
    
    

}
