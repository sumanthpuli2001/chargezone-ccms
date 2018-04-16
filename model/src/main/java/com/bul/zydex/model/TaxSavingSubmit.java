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
public class TaxSavingSubmit implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private PayrollFinancialYear payrollFinancialYear;
    private Integer status;
    private Integer createdBy;
    private Integer updatedBy;
    private String updatedDate;
    private String createdDate;

    public TaxSavingSubmit() {
    }

    public TaxSavingSubmit(Integer id, EmployeeMaster employeeMaster, PayrollFinancialYear payrollFinancialYear, Integer status, Integer createdBy, Integer updatedBy, String updatedDate, String createdDate) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.payrollFinancialYear = payrollFinancialYear;
        this.status = status;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public PayrollFinancialYear getPayrollFinancialYear() {
        return payrollFinancialYear;
    }

    public void setPayrollFinancialYear(PayrollFinancialYear payrollFinancialYear) {
        this.payrollFinancialYear = payrollFinancialYear;
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
    

}
