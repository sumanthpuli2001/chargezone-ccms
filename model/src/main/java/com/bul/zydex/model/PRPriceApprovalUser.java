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
public class PRPriceApprovalUser {

    private int id;
    private int prApprovalId;
    private String prNo;
   
    private String userId;
    private int level;
    private int approvalStatus;

    public PRPriceApprovalUser() {
    }

    public PRPriceApprovalUser(int id, int prApprovalId, String prNo, String userId, int level, int approvalStatus) {
        this.id = id;
        this.prApprovalId = prApprovalId;
        this.prNo = prNo;
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

    public int getPrApprovalId() {
        return prApprovalId;
    }

    public void setPrApprovalId(int prApprovalId) {
        this.prApprovalId = prApprovalId;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
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
