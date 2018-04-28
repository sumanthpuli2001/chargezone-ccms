/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class LeaveEmployeeDetailsApprovalHistory {

    private Integer id;
    private LeaveEmployeeDetail leaveEmployeeDetail;
    private Integer approvalId;
    private String approvalName;
    private String comment;
    private Integer status;
    private String statusMessage;
    private Integer createdBy;
    private String createdDate;

    public LeaveEmployeeDetailsApprovalHistory() {
    }

    public LeaveEmployeeDetailsApprovalHistory(LeaveEmployeeDetail leaveEmployeeDetail) {
        this.leaveEmployeeDetail = leaveEmployeeDetail;
    }

    public LeaveEmployeeDetailsApprovalHistory(LeaveEmployeeDetail leaveEmployeeDetail, Integer approvalId, String approvalName, String comment, Integer status, String statusMessage, Integer createdBy, String createdDate) {
        this.leaveEmployeeDetail = leaveEmployeeDetail;
        this.approvalId = approvalId;
        this.approvalName = approvalName;
        this.comment = comment;
        this.status = status;
        this.statusMessage = statusMessage;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LeaveEmployeeDetail getLeaveEmployeeDetail() {
        return this.leaveEmployeeDetail;
    }

    public void setLeaveEmployeeDetail(LeaveEmployeeDetail leaveEmployeeDetail) {
        this.leaveEmployeeDetail = leaveEmployeeDetail;
    }

    public Integer getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalName() {
        return this.approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
