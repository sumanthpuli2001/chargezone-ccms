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
public class PRPriceApprovalComment {

    private int id;
    private int prApprovalId;
    private String userId;
    private String approvalComment;
    private String dateTime;
    private int approvalStatus;

    public PRPriceApprovalComment() {
    }

    public PRPriceApprovalComment(int id, int prApprovalId, String userId, String approvalComment, String dateTime, int approvalStatus) {
        this.id = id;
        this.prApprovalId = prApprovalId;
        this.userId = userId;
        this.approvalComment = approvalComment;
        this.dateTime = dateTime;
        this.approvalStatus = approvalStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrApprovalId() {
        return prApprovalId;
    }

    public void setPrApprovalId(int prApprovalId) {
        this.prApprovalId = prApprovalId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

   
   
}
