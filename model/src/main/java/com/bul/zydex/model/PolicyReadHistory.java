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
public class PolicyReadHistory {

    private Integer id;
    private Integer policyId;
    private String readerDate;
    private String readerBy;
    private Integer policyAcept;
    private String policyAceptTime;
    private Integer policyReadStatus;

    public PolicyReadHistory() {
    }

    public PolicyReadHistory(Integer id, Integer policyId, String readerDate, String readerBy, Integer policyAcept, String policyAceptTime, Integer policyReadStatus) {
        this.id = id;
        this.policyId = policyId;
        this.readerDate = readerDate;
        this.readerBy = readerBy;
        this.policyAcept = policyAcept;
        this.policyAceptTime = policyAceptTime;
        this.policyReadStatus = policyReadStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getReaderDate() {
        return readerDate;
    }

    public void setReaderDate(String readerDate) {
        this.readerDate = readerDate;
    }

    public String getReaderBy() {
        return readerBy;
    }

    public void setReaderBy(String readerBy) {
        this.readerBy = readerBy;
    }

    public Integer getPolicyAcept() {
        return policyAcept;
    }

    public void setPolicyAcept(Integer policyAcept) {
        this.policyAcept = policyAcept;
    }

    public String getPolicyAceptTime() {
        return policyAceptTime;
    }

    public void setPolicyAceptTime(String policyAceptTime) {
        this.policyAceptTime = policyAceptTime;
    }

    public Integer getPolicyReadStatus() {
        return policyReadStatus;
    }

    public void setPolicyReadStatus(Integer policyReadStatus) {
        this.policyReadStatus = policyReadStatus;
    }
    
    

}
