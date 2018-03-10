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
public class CandidateJobApplication implements java.io.Serializable {

    private Integer id;
    private CandidateApplyJob candidateApplyJob;
    private ApplayJobUserMaster applayJobUserMaster;
    private VacancyMaster vacancyMaster;
    private Integer status;
    private Integer createdBy;
    private String createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidateApplyJob getCandidateApplyJob() {
        return candidateApplyJob;
    }

    public void setCandidateApplyJob(CandidateApplyJob candidateApplyJob) {
        this.candidateApplyJob = candidateApplyJob;
    }

    public VacancyMaster getVacancyMaster() {
        return vacancyMaster;
    }

    public void setVacancyMaster(VacancyMaster vacancyMaster) {
        this.vacancyMaster = vacancyMaster;
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

    public ApplayJobUserMaster getApplayJobUserMaster() {
        return applayJobUserMaster;
    }

    public void setApplayJobUserMaster(ApplayJobUserMaster applayJobUserMaster) {
        this.applayJobUserMaster = applayJobUserMaster;
    }
    
     
    
    

}
