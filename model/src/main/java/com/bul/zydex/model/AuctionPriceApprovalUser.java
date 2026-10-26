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
public class AuctionPriceApprovalUser {
    
    private int id;
    private int auctionApprovalId;
    private String auctionNo;
    private String userId;
    private int level;
    private int approvalStatus;

    public AuctionPriceApprovalUser() {
    }

    public AuctionPriceApprovalUser(int id, int auctionApprovalId, String auctionNo, String userId, int level, int approvalStatus) {
        this.id = id;
        this.auctionApprovalId = auctionApprovalId;
        this.auctionNo = auctionNo;
        this.userId = userId;
        this.level = level;
        this.approvalStatus = approvalStatus;
    }

    public int getId() {
        return id;
    }

    public AuctionPriceApprovalUser setId(int id) {
        this.id = id;
        return this;
    }

    public int getAuctionApprovalId() {
        return auctionApprovalId;
    }

    public AuctionPriceApprovalUser setAuctionApprovalId(int auctionApprovalId) {
        this.auctionApprovalId = auctionApprovalId;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionPriceApprovalUser setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AuctionPriceApprovalUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public AuctionPriceApprovalUser setLevel(int level) {
        this.level = level;
        return this;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public AuctionPriceApprovalUser setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }
    
    
}
