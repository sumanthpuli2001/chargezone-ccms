/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class EmployeeVisaDetails {
    private Integer id;
    private EmployeeMaster employeeMaster;
    private String visaIssueCountry;
    private String visaIssueDate;
    private String visaValidTillDate;

    public EmployeeVisaDetails() {
    }

    public EmployeeVisaDetails(Integer id, EmployeeMaster employeeMaster, String visaIssueCountry, String visaIssueDate, String visaValidTillDate) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.visaIssueCountry = visaIssueCountry;
        this.visaIssueDate = visaIssueDate;
        this.visaValidTillDate = visaValidTillDate;
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

    public String getVisaIssueCountry() {
        return visaIssueCountry;
    }

    public void setVisaIssueCountry(String visaIssueCountry) {
        this.visaIssueCountry = visaIssueCountry;
    }

    public String getVisaIssueDate() {
        return visaIssueDate;
    }

    public void setVisaIssueDate(String visaIssueDate) {
        this.visaIssueDate = visaIssueDate;
    }

    public String getVisaValidTillDate() {
        return visaValidTillDate;
    }

    public void setVisaValidTillDate(String visaValidTillDate) {
        this.visaValidTillDate = visaValidTillDate;
    }
    
    
}
