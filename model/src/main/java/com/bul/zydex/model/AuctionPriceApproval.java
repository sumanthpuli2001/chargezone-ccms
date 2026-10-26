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
public class AuctionPriceApproval {
    
    private int id;
    private String auctionNo;
    private int totalApproval;
    private int currentApproval;
    private int approvalStatus;
    private String approvalRemark;
    private String userId;
    private String dateTime;

    public AuctionPriceApproval() {
    }

    public AuctionPriceApproval(int id, String auctionNo, int totalApproval, int currentApproval, int approvalStatus, String approvalRemark, String userId, String dateTime) {
        this.id = id;
        this.auctionNo = auctionNo;
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

    public AuctionPriceApproval setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionPriceApproval setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public int getTotalApproval() {
        return totalApproval;
    }

    public AuctionPriceApproval setTotalApproval(int totalApproval) {
        this.totalApproval = totalApproval;
        return this;
    }

    public int getCurrentApproval() {
        return currentApproval;
    }

    public AuctionPriceApproval setCurrentApproval(int currentApproval) {
        this.currentApproval = currentApproval;
        return this;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public AuctionPriceApproval setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public AuctionPriceApproval setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AuctionPriceApproval setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public AuctionPriceApproval setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }
    
    
}
