/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class VendorInvitationCategory {

    private int id;
    private String vendorId;
    private String groupId;
    private String groupCategoryId;
    private String groupSubCategoryId;

    public VendorInvitationCategory() {
    }

    public VendorInvitationCategory(int id, String vendorId, String groupId, String groupCategoryId, String groupSubCategoryId) {
        this.id = id;
        this.vendorId = vendorId;
        this.groupId = groupId;
        this.groupCategoryId = groupCategoryId;
        this.groupSubCategoryId = groupSubCategoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupCategoryId() {
        return groupCategoryId;
    }

    public void setGroupCategoryId(String groupCategoryId) {
        this.groupCategoryId = groupCategoryId;
    }

    public String getGroupSubCategoryId() {
        return groupSubCategoryId;
    }

    public void setGroupSubCategoryId(String groupSubCategoryId) {
        this.groupSubCategoryId = groupSubCategoryId;
    }
}
