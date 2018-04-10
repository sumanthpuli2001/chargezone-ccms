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
public class PayrollTaxDeductionComponent implements java.io.Serializable{
    
    private Integer componentId;
    private PayrollTaxDeductionMaster payrollTaxDeductionMaster;
    private String component;
    private Integer ageLimit;
    private Integer taxSavingLimit;
    private Integer tdcStatus;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;

    public PayrollTaxDeductionComponent() {

    }

    public PayrollTaxDeductionComponent(Integer componentId, PayrollTaxDeductionMaster payrollTaxDeductionMaster, String component, Integer ageLimit, Integer taxSavingLimit, Integer tdcStatus, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
        this.componentId = componentId;
        this.payrollTaxDeductionMaster = payrollTaxDeductionMaster;
        this.component = component;
        this.ageLimit = ageLimit;
        this.taxSavingLimit = taxSavingLimit;
        this.tdcStatus = tdcStatus;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    
    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public PayrollTaxDeductionMaster getPayrollTaxDeductionMaster() {
        return payrollTaxDeductionMaster;
    }

    public void setPayrollTaxDeductionMaster(PayrollTaxDeductionMaster payrollTaxDeductionMaster) {
        this.payrollTaxDeductionMaster = payrollTaxDeductionMaster;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Integer getTaxSavingLimit() {
        return taxSavingLimit;
    }

    public void setTaxSavingLimit(Integer taxSavingLimit) {
        this.taxSavingLimit = taxSavingLimit;
    }

    public Integer getTdcStatus() {
        return tdcStatus;
    }

    public void setTdcStatus(Integer tdcStatus) {
        this.tdcStatus = tdcStatus;
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
