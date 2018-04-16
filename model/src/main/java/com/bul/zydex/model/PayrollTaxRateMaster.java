/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;
/**
 *
 * @author DELL3
 */
public class PayrollTaxRateMaster implements java.io.Serializable
{
    private Integer id;
    private String incomeFrom;
    private String incomeTo;
    private String taxRate;
    private Integer ageFrom;
    private Integer ageTo;
    private Integer status;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;

    public PayrollTaxRateMaster() 
    {
        
    }
    
    public PayrollTaxRateMaster(Integer id, String incomeFrom, String incomeTo, String taxRate, Integer ageFrom, Integer ageTo, Integer status, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
        this.id = id;
        this.incomeFrom = incomeFrom;
        this.incomeTo = incomeTo;
        this.taxRate = taxRate;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
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

    public String getIncomeFrom() {
        return incomeFrom;
    }

    public void setIncomeFrom(String incomeFrom) {
        this.incomeFrom = incomeFrom;
    }

    public String getIncomeTo() {
        return incomeTo;
    }

    public void setIncomeTo(String incomeTo) {
        this.incomeTo = incomeTo;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
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
