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
public class FullAndFinalSettlement {

    private Integer id;
    private Integer resignationEmpId;
    private Integer noticePeriod;
    private Integer givenNotice;
    private String createdDate;
    private Integer createdBy;
    private String updateDate;
    private Integer updatedBy;
    private Integer status;

    public FullAndFinalSettlement(){
        
    }
    
    public FullAndFinalSettlement(Integer id, Integer resignationEmpId, Integer noticePeriod, Integer givenNotice, String createdDate, Integer createdBy, String updateDate, Integer updatedBy, Integer status) {
        this.id = id;
        this.resignationEmpId = resignationEmpId;
        this.noticePeriod = noticePeriod;
        this.givenNotice = givenNotice;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updateDate = updateDate;
        this.updatedBy = updatedBy;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResignationEmpId() {
        return resignationEmpId;
    }

    public void setResignationEmpId(Integer resignationEmpId) {
        this.resignationEmpId = resignationEmpId;
    }

    public Integer getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(Integer noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public Integer getGivenNotice() {
        return givenNotice;
    }

    public void setGivenNotice(Integer givenNotice) {
        this.givenNotice = givenNotice;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

}
