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
    private PolicyCreate policyCreate;
    private String readerDate;
    private String readerBy;
    private Integer policyAcept;
    private String policyAceptTime;

    public PolicyReadHistory() {
    }

    public PolicyReadHistory(Integer id, PolicyCreate policyCreate, String readerDate, String readerBy, Integer policyAcept, String policyAceptTime) {
        this.id = id;
        this.policyCreate = policyCreate;
        this.readerDate = readerDate;
        this.readerBy = readerBy;
        this.policyAcept = policyAcept;
        this.policyAceptTime = policyAceptTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PolicyCreate getPolicyCreate() {
        return policyCreate;
    }

    public void setPolicyCreate(PolicyCreate policyCreate) {
        this.policyCreate = policyCreate;
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
    
    

}
