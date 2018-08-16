/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class VacancyApprovalHistory implements java.io.Serializable {

    private Integer id;
    private VacancyMaster vacancyMaster;
    private String comment;
    private Integer status;
    private String statusMessage;
    private String createdDate;
    private String createdBy;

    public VacancyApprovalHistory() {
    }

    public VacancyApprovalHistory(Integer id, VacancyMaster vacancyMaster, String comment, Integer status, String statusMessage, String createdDate, String createdBy) {
        this.id = id;
        this.vacancyMaster = vacancyMaster;
        this.comment = comment;
        this.status = status;
        this.statusMessage = statusMessage;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VacancyMaster getVacancyMaster() {
        return vacancyMaster;
    }

    public void setVacancyMaster(VacancyMaster vacancyMaster) {
        this.vacancyMaster = vacancyMaster;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    

}
