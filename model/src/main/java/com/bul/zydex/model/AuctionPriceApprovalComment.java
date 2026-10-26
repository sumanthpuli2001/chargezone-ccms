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
public class AuctionPriceApprovalComment {
    
    private int id;
    private int auctionApprovalId;
    private String userId;
    private String approvalComment;
    private String dateTime;
    private int approvalStatus;

    public AuctionPriceApprovalComment() {
    }

    public AuctionPriceApprovalComment(int id, int auctionApprovalId, String userId, String approvalComment, String dateTime, int approvalStatus) {
        this.id = id;
        this.auctionApprovalId = auctionApprovalId;
        this.userId = userId;
        this.approvalComment = approvalComment;
        this.dateTime = dateTime;
        this.approvalStatus = approvalStatus;
    }

    public int getId() {
        return id;
    }

    public AuctionPriceApprovalComment setId(int id) {
        this.id = id;
        return this;
    }

    public int getAuctionApprovalId() {
        return auctionApprovalId;
    }

    public AuctionPriceApprovalComment setAuctionApprovalId(int auctionApprovalId) {
        this.auctionApprovalId = auctionApprovalId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AuctionPriceApprovalComment setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public AuctionPriceApprovalComment setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public AuctionPriceApprovalComment setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public AuctionPriceApprovalComment setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }
    
    
}
