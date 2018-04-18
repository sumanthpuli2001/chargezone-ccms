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
public class PayrollTaxDeclarationPeriodMaster implements java.io.Serializable
{
    private Integer id;
    private PayrollFinancialYear payrollFinancialYear;
    private String declarationThresholdDate;
    private String proofThresholdDate;
    private Integer tdpStatus;
    private Integer createdBy;
    private String createdDate;
    private Integer updatedBy;
    private String updatedDate;

    public PayrollTaxDeclarationPeriodMaster() {
    }

    public PayrollTaxDeclarationPeriodMaster(Integer id, PayrollFinancialYear payrollFinancialYear, String declarationThresholdDate, String proofThresholdDate, Integer tdpStatus, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
        this.id = id;
        this.payrollFinancialYear = payrollFinancialYear;
        this.declarationThresholdDate = declarationThresholdDate;
        this.proofThresholdDate = proofThresholdDate;
        this.tdpStatus = tdpStatus;
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

    public PayrollFinancialYear getPayrollFinancialYear() {
        return payrollFinancialYear;
    }

    public void setPayrollFinancialYear(PayrollFinancialYear payrollFinancialYear) {
        this.payrollFinancialYear = payrollFinancialYear;
    }

    public String getDeclarationThresholdDate() {
        return declarationThresholdDate;
    }

    public void setDeclarationThresholdDate(String declarationThresholdDate) {
        this.declarationThresholdDate = declarationThresholdDate;
    }

    public String getProofThresholdDate() {
        return proofThresholdDate;
    }

    public void setProofThresholdDate(String proofThresholdDate) {
        this.proofThresholdDate = proofThresholdDate;
    }

    public Integer getTdpStatus() {
        return tdpStatus;
    }

    public void setTdpStatus(Integer tdpStatus) {
        this.tdpStatus = tdpStatus;
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
