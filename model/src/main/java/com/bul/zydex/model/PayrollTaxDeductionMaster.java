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
public class PayrollTaxDeductionMaster implements java.io.Serializable {
    
    private Integer id;
    private String section;
    private Integer taxSavingLimit;
    private String description;
    private Integer additionalTaxBenefit;
    private Integer tdStatus;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;

    public PayrollTaxDeductionMaster() {
    }

    public PayrollTaxDeductionMaster(Integer id, String section, Integer taxSavingLimit, String description, Integer additionalTaxBenefit, Integer tdStatus, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
        this.id = id;
        this.section = section;
        this.taxSavingLimit = taxSavingLimit;
        this.description = description;
        this.additionalTaxBenefit = additionalTaxBenefit;
        this.tdStatus = tdStatus;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getTaxSavingLimit() {
        return taxSavingLimit;
    }

    public void setTaxSavingLimit(Integer taxSavingLimit) {
        this.taxSavingLimit = taxSavingLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdditionalTaxBenefit() {
        return additionalTaxBenefit;
    }

    public void setAdditionalTaxBenefit(Integer additionalTaxBenefit) {
        this.additionalTaxBenefit = additionalTaxBenefit;
    }

    public Integer getTdStatus() {
        return tdStatus;
    }

    public void setTdStatus(Integer tdStatus) {
        this.tdStatus = tdStatus;
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
