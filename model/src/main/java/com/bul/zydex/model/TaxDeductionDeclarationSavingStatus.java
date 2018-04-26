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
public class TaxDeductionDeclarationSavingStatus implements java.io.Serializable
{
    private Integer id;
    private Integer status;
    private TaxDeductionDecarationSubmit taxDeductionDecarationSubmit;
 //   private TaxSavingSubmit taxSavingSubmit;
    private Integer statusUpdatedBy;
    private String statusUpdatedDate;

    public TaxDeductionDeclarationSavingStatus() {
    }

    public TaxDeductionDeclarationSavingStatus(Integer id, Integer status, TaxDeductionDecarationSubmit taxDeductionDecarationSubmit, Integer statusUpdatedBy, String statusUpdatedDate) {
        this.id = id;
        this.status = status;
        this.taxDeductionDecarationSubmit = taxDeductionDecarationSubmit;
        this.statusUpdatedBy = statusUpdatedBy;
        this.statusUpdatedDate = statusUpdatedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TaxDeductionDecarationSubmit getTaxDeductionDecarationSubmit() {
        return taxDeductionDecarationSubmit;
    }

    public void setTaxDeductionDecarationSubmit(TaxDeductionDecarationSubmit taxDeductionDecarationSubmit) {
        this.taxDeductionDecarationSubmit = taxDeductionDecarationSubmit;
    }

    public String getStatusUpdatedDate() {
        return statusUpdatedDate;
    }

    public void setStatusUpdatedDate(String statusUpdatedDate) {
        this.statusUpdatedDate = statusUpdatedDate;
    }
    
    public Integer getStatusUpdatedBy() {
        return statusUpdatedBy;
    }

    public void setStatusUpdatedBy(Integer statusUpdatedBy) {
        this.statusUpdatedBy = statusUpdatedBy;
    }
    
}
