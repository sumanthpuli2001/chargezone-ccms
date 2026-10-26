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
public class TenderPriceApprovalComment {

    private int id;
    private int tenderApprovalId;
    private String userId;
    private String approvalComment;
    private String dateTime;
    private int approvalStatus;

    public TenderPriceApprovalComment() {
    }

    public TenderPriceApprovalComment(int id, int tenderApprovalId, String userId, String approvalComment, String dateTime, int approvalStatus) {
        this.id = id;
        this.tenderApprovalId = tenderApprovalId;
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

    public int getTenderApprovalId() {
        return tenderApprovalId;
    }

    public void setTenderApprovalId(int tenderApprovalId) {
        this.tenderApprovalId = tenderApprovalId;
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
