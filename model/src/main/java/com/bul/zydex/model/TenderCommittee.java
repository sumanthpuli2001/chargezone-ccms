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
public class TenderCommittee {
 
    private int id;
    private String tenderNo;
    private String userId;
    private int bidType;
    private int bidOpenStatus;
    private String bidOpenDate;
    private String fullName;
    
    public TenderCommittee() {
    }
    
    public TenderCommittee(int id, String tenderNo, String userId, int bidType, int bidOpenStatus, String bidOpenDate, String fullName) {
        
        this.id = id;
        this.tenderNo = tenderNo;    
        this.userId = userId;
        this.bidType = bidType;
        this.bidOpenStatus = bidOpenStatus;
        this.bidOpenDate = bidOpenDate;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public TenderCommittee setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public TenderCommittee setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TenderCommittee setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getBidType() {
        return bidType;
    }

    public TenderCommittee setBidType(int bidType) {
        this.bidType = bidType;
        return this;
    }

    public int getBidOpenStatus() {
        return bidOpenStatus;
    }

    public TenderCommittee setBidOpenStatus(int bidOpenStatus) {
        this.bidOpenStatus = bidOpenStatus;
        return this;
    }

    public String getBidOpenDate() {
        return bidOpenDate;
    }

    public TenderCommittee setBidOpenDate(String bidOpenDate) {
        this.bidOpenDate = bidOpenDate;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public TenderCommittee setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    
    
}
