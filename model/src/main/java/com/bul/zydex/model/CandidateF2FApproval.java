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
public class CandidateF2FApproval {

    private Integer id;
    private CandidateF2FRequest candidateF2FRequest;
    private EmployeeMaster employeeMaster;
    private String Comment;
    private Integer status;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;

    public CandidateF2FApproval() {

    }

    public CandidateF2FApproval(Integer id, CandidateF2FRequest candidateF2FRequest, EmployeeMaster employeeMaster, String Comment, Integer status, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
        this.id = id;
        this.candidateF2FRequest = candidateF2FRequest;
        this.employeeMaster = employeeMaster;
        this.Comment = Comment;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidateF2FRequest getCandidateF2FRequest() {
        return candidateF2FRequest;
    }

    public void setCandidateF2FRequest(CandidateF2FRequest candidateF2FRequest) {
        this.candidateF2FRequest = candidateF2FRequest;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    
    

}
