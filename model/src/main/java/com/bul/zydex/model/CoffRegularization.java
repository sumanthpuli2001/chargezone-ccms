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
public class CoffRegularization implements java.io.Serializable {

    private Integer id;
    private String startDateCoff;
    private String endDateCoff;

    private String approvalComment;
    private String dateOfSubmit;
    private String dateOfApproval;
    private EmployeeMaster approverId;
    private UserMaster userMasterId;

    private Integer status;
    private String coffType;

    public CoffRegularization() {
    }

    public CoffRegularization(Integer id, String startDateCoff, String endDateCoff, String approvalComment, String dateOfSubmit, String dateOfApproval, EmployeeMaster approverId, UserMaster userMasterId, Integer status, String coffType) {
        this.id = id;
        this.startDateCoff = startDateCoff;
        this.endDateCoff = endDateCoff;
        this.approvalComment = approvalComment;
        this.dateOfSubmit = dateOfSubmit;
        this.dateOfApproval = dateOfApproval;
        this.approverId = approverId;
        this.userMasterId = userMasterId;
        this.status = status;
        this.coffType = coffType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDateCoff() {
        return startDateCoff;
    }

    public void setStartDateCoff(String startDateCoff) {
        this.startDateCoff = startDateCoff;
    }

    public String getEndDateCoff() {
        return endDateCoff;
    }

    public void setEndDateCoff(String endDateCoff) {
        this.endDateCoff = endDateCoff;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public String getDateOfSubmit() {
        return dateOfSubmit;
    }

    public void setDateOfSubmit(String dateOfSubmit) {
        this.dateOfSubmit = dateOfSubmit;
    }

    public String getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(String dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public EmployeeMaster getApproverId() {
        return approverId;
    }

    public void setApproverId(EmployeeMaster approverId) {
        this.approverId = approverId;
    }

    public UserMaster getUserMasterId() {
        return userMasterId;
    }

    public void setUserMasterId(UserMaster userMasterId) {
        this.userMasterId = userMasterId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCoffType() {
        return coffType;
    }

    public void setCoffType(String coffType) {
        this.coffType = coffType;
    }
    
}
