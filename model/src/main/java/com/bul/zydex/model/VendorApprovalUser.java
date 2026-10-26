/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class VendorApprovalUser {

    private int id;
    private VendorApprovalSetting vendorApprovalSetting;
    private String userId;
    private int level;

    public VendorApprovalUser() {
    }

    public VendorApprovalUser(int id, VendorApprovalSetting vendorApprovalSetting, String userId, int level) {
        this.id = id;
        this.vendorApprovalSetting = vendorApprovalSetting;
        this.userId = userId;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VendorApprovalSetting getVendorApprovalSetting() {
        return vendorApprovalSetting;
    }

    public void setVendorApprovalSetting(VendorApprovalSetting vendorApprovalSetting) {
        this.vendorApprovalSetting = vendorApprovalSetting;
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

   
}
