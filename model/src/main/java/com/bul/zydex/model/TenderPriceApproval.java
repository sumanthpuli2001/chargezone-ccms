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
public class TenderPriceApproval {

    private int id;
    private String tenderNo;
    private String vendorCode;
    private int totalApproval;
    private int currentApproval;
    private int approvalStatus;
    private String approvalRemark;
    private String userId;
    private String dateTime;
    private String attachment;

    public TenderPriceApproval() {
    }

    public TenderPriceApproval(int id, String tenderNo, String vendorCode, int totalApproval, int currentApproval, int approvalStatus, String approvalRemark, String userId, String dateTime, String attachment) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.vendorCode = vendorCode;
        this.totalApproval = totalApproval;
        this.currentApproval = currentApproval;
        this.approvalStatus = approvalStatus;
        this.approvalRemark = approvalRemark;
        this.userId = userId;
        this.dateTime = dateTime;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public int getTotalApproval() {
        return totalApproval;
    }

    public void setTotalApproval(int totalApproval) {
        this.totalApproval = totalApproval;
    }

    public int getCurrentApproval() {
        return currentApproval;
    }

    public void setCurrentApproval(int currentApproval) {
        this.currentApproval = currentApproval;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

}
