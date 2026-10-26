/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-4
 */
public class TenderApprovalUser {
    
    private int id;
    private TenderApprovalSetting tenderApprovalSetting;
    private String userId;
    private int level;

    public TenderApprovalUser() {
    }

    public TenderApprovalUser(int id, TenderApprovalSetting tenderApprovalSetting, String userId, int level) {
        this.id = id;
        this.tenderApprovalSetting = tenderApprovalSetting;
        this.userId = userId;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TenderApprovalSetting getTenderApprovalSetting() {
        return tenderApprovalSetting;
    }

    public void setTenderApprovalSetting(TenderApprovalSetting tenderApprovalSetting) {
        this.tenderApprovalSetting = tenderApprovalSetting;
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

    @Override
    public String toString() {
        return "TenderApprovalUser{" + "id=" + id + ", tenderApprovalSetting=" + tenderApprovalSetting + ", userId=" + userId + ", level=" + level + '}';
    }
    
    
    
}
