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
public class OnCall {
    
    private Integer id;
    private String fromDate;
    private String toDate;
    private String description;
    private EmployeeMaster employeeMaster;
    private int userMasterId;
    private int status;
    private String managerRemark;
    private String approvedDate;
    private String dateOfSubmit;

    public OnCall() {
    }

    public OnCall(Integer id, String fromDate, String toDate, String description, EmployeeMaster employeeMaster, int userMasterId, int status, String managerRemark, String approvedDate, String dateOfSubmit) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.employeeMaster = employeeMaster;
        this.userMasterId = userMasterId;
        this.status = status;
        this.managerRemark = managerRemark;
        this.approvedDate = approvedDate;
        
        this.dateOfSubmit = dateOfSubmit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmployeeMaster getEmployeeMaster() {
        return employeeMaster;
    }

    public void setEmployeeMaster(EmployeeMaster employeeMaster) {
        this.employeeMaster = employeeMaster;
    }

    public int getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(int userMasterId) {
        this.userMasterId = userMasterId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getManagerRemark() {
        return managerRemark;
    }

    public void setManagerRemark(String managerRemark) {
        this.managerRemark = managerRemark;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getDateOfSubmit() {
        return dateOfSubmit;
    }

    public void setDateOfSubmit(String dateOfSubmit) {
        this.dateOfSubmit = dateOfSubmit;
    }
    
    
    
    
    
    
}
