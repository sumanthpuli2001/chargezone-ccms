/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hussain
 */
public class TaxDeductionDecarationSubmit implements java.io.Serializable {

    private Integer id;
    private TaxSavingSubmit taxSavingSubmit;
    private PayrollTaxDeductionMaster payrollTaxDeductionMaster;
    private PayrollTaxDeductionComponent payrollTaxDeductionComponent;
    private Double amountTaxDecaration;
    private Integer status;
    private Integer createdBy;
    private Integer updatedBy;
    private String updatedDate;
    private String createdDate;
    private String attachment;

    public TaxDeductionDecarationSubmit() {
    }

    public TaxDeductionDecarationSubmit(Integer id, TaxSavingSubmit taxSavingSubmit, PayrollTaxDeductionMaster payrollTaxDeductionMaster, PayrollTaxDeductionComponent payrollTaxDeductionComponent, Double amountTaxDecaration, Integer status, Integer createdBy, Integer updatedBy, String updatedDate, String createdDate, String attachment) {
        this.id = id;
        this.taxSavingSubmit = taxSavingSubmit;
        this.payrollTaxDeductionMaster = payrollTaxDeductionMaster;
        this.payrollTaxDeductionComponent = payrollTaxDeductionComponent;
        this.amountTaxDecaration = amountTaxDecaration;
        this.status = status;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.createdDate = createdDate;
        this.attachment = attachment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TaxSavingSubmit getTaxSavingSubmit() {
        return taxSavingSubmit;
    }

    public void setTaxSavingSubmit(TaxSavingSubmit taxSavingSubmit) {
        this.taxSavingSubmit = taxSavingSubmit;
    }

    public PayrollTaxDeductionMaster getPayrollTaxDeductionMaster() {
        return payrollTaxDeductionMaster;
    }

    public void setPayrollTaxDeductionMaster(PayrollTaxDeductionMaster payrollTaxDeductionMaster) {
        this.payrollTaxDeductionMaster = payrollTaxDeductionMaster;
    }

    public PayrollTaxDeductionComponent getPayrollTaxDeductionComponent() {
        return payrollTaxDeductionComponent;
    }

    public void setPayrollTaxDeductionComponent(PayrollTaxDeductionComponent payrollTaxDeductionComponent) {
        this.payrollTaxDeductionComponent = payrollTaxDeductionComponent;
    }

    public Double getAmountTaxDecaration() {
        return amountTaxDecaration;
    }

    public void setAmountTaxDecaration(Double amountTaxDecaration) {
        this.amountTaxDecaration = amountTaxDecaration;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

   

}
