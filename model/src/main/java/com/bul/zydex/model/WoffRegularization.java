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
public class WoffRegularization implements java.io.Serializable {

    private Integer id;
    private String rotationDate;
    private String reasonForWoff;
    private String approvalComment;
    private String dateOfSubmit;
    private String dateOfApproval;
    private EmployeeMaster approverId;
    private UserMaster userMasterId;
    private ShiftMaster shiftMasterPrevious;

    private Integer status;
     private String dayWoff;

    public WoffRegularization() {
    }

    public WoffRegularization(String rotationDate,String reasonForWoff, String approvalComment, String dateOfSubmit, String dateOfApproval, EmployeeMaster approverId, UserMaster userMasterId, ShiftMaster shiftMasterPrevious, Integer status,String dayWoff) {
        this.rotationDate = rotationDate;
        this.reasonForWoff = reasonForWoff;
        this.approvalComment = approvalComment;
        this.dateOfSubmit = dateOfSubmit;
        this.dateOfApproval = dateOfApproval;
        this.approverId = approverId;
        this.userMasterId = userMasterId;
        this.shiftMasterPrevious = shiftMasterPrevious;

        this.status = status;
        this.dayWoff = dayWoff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRotationDate() {
        return rotationDate;
    }

    public void setRotationDate(String rotationDate) {
        this.rotationDate = rotationDate;
    }

    public String getReasonForWoff() {
        return reasonForWoff;
    }

    public void setReasonForWoff(String reasonForWoff) {
        this.reasonForWoff = reasonForWoff;
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

    public ShiftMaster getShiftMasterPrevious() {
        return shiftMasterPrevious;
    }

    public void setShiftMasterPrevious(ShiftMaster shiftMasterPrevious) {
        this.shiftMasterPrevious = shiftMasterPrevious;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDayWoff() {
        return dayWoff;
    }

    public void setDayWoff(String dayWoff) {
        this.dayWoff = dayWoff;
    }
    

}
