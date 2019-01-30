/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Success
 */
public class OTRegularization implements java.io.Serializable {

    private Integer id;
    private EmployeeMaster employeeMaster;
    private ClientDetailsMaster clientDetailsMaster;
    private int userMasterId;
    private String startDateTime;
    private String endDateTime;
    private String reason;
    private int status;
    private String managerRemark;
    private String approvedDate;
    private String dateOfSubmit;
    private String differentCompare;
    private String arType;
    private String startDateAr;
    private String endDateAr;

    public OTRegularization() {
    }

    public OTRegularization(Integer id, EmployeeMaster employeeMaster, int userMasterId, String startDateTime, String endDateTime, String reason, int status, String managerRemark, String approvedDate, String dateOfSubmit, String differentCompare, String arType, String startDateAr, String endDateAr,ClientDetailsMaster clientDetailsMaster) {
        this.id = id;
        this.employeeMaster = employeeMaster;
        this.userMasterId = userMasterId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.reason = reason;
        this.status = status;
        this.managerRemark = managerRemark;
        this.approvedDate = approvedDate;
        this.dateOfSubmit = dateOfSubmit;
        this.differentCompare = differentCompare;
        this.arType = arType;
        this.startDateAr = startDateAr;
        this.endDateAr = endDateAr;
        this.clientDetailsMaster = clientDetailsMaster;
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

    public int getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(int userMasterId) {
        this.userMasterId = userMasterId;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getDifferentCompare() {
        return differentCompare;
    }

    public void setDifferentCompare(String differentCompare) {
        this.differentCompare = differentCompare;
    }

    public String getArType() {
        return arType;
    }

    public void setArType(String arType) {
        this.arType = arType;
    }

    public String getStartDateAr() {
        return startDateAr;
    }

    public void setStartDateAr(String startDateAr) {
        this.startDateAr = startDateAr;
    }

    public String getEndDateAr() {
        return endDateAr;
    }

    public void setEndDateAr(String endDateAr) {
        this.endDateAr = endDateAr;
    }

    public ClientDetailsMaster getClientDetailsMaster() {
        return clientDetailsMaster;
    }

    public void setClientDetailsMaster(ClientDetailsMaster clientDetailsMaster) {
        this.clientDetailsMaster = clientDetailsMaster;
    }
    
}
