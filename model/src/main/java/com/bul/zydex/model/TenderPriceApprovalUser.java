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
public class TenderPriceApprovalUser {

    private int id;
    private int tenderApprovalId;
    private String tenderNo;
    private String vendorCode;
    private String userId;
    private int level;
    private int approvalStatus;

    public TenderPriceApprovalUser() {
    }

    public TenderPriceApprovalUser(int id, int tenderApprovalId, String tenderNo, String vendorCode, String userId, int level, int approvalStatus) {
        this.id = id;
        this.tenderApprovalId = tenderApprovalId;
        this.tenderNo = tenderNo;
        this.vendorCode = vendorCode;
        this.userId = userId;
        this.level = level;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    
}
