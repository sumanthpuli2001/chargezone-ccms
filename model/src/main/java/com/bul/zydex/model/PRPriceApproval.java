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
public class PRPriceApproval {

    private int id;
    private String prNo;
   
    private int totalApproval;
    private int currentApproval;
    private int approvalStatus;
    private String approvalRemark;
    private String userId;
    private String dateTime;

    public PRPriceApproval() {
    }

    public PRPriceApproval(int id, String prNo, int totalApproval, int currentApproval, int approvalStatus, String approvalRemark, String userId, String dateTime) {
        this.id = id;
        this.prNo = prNo;
        this.totalApproval = totalApproval;
        this.currentApproval = currentApproval;
        this.approvalStatus = approvalStatus;
        this.approvalRemark = approvalRemark;
        this.userId = userId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
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

    

}
