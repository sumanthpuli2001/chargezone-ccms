/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author tailo
 */
public class PRApprovalComment {
    
    private int id;
    private String prNo;
    private String dateTime;
    private String comment;
    private String approvalStatus;
    private String userId;

    public PRApprovalComment() {
    }

    public PRApprovalComment(int id, String prNo, String dateTime, String comment, String approvalStatus, String userId) {
        this.id = id;
        this.prNo = prNo;
        this.dateTime = dateTime;
        this.comment = comment;
        this.approvalStatus = approvalStatus;
        this.userId = userId;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
   
    
}
