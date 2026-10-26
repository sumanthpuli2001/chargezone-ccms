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
public class VendorRequestedInvitationCategory {
    private Integer id;
    private Integer vendodRequestId;
    private Integer groupId;
    private Integer groupCategoryId;
    private Integer groupSubCategoryId;

    public VendorRequestedInvitationCategory() {
    }

    public VendorRequestedInvitationCategory(Integer id, Integer vendodRequestId, Integer groupId, Integer groupCategoryId, Integer groupSubCategoryId) {
        this.id = id;
        this.vendodRequestId = vendodRequestId;
        this.groupId = groupId;
        this.groupCategoryId = groupCategoryId;
        this.groupSubCategoryId = groupSubCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVendodRequestId() {
        return vendodRequestId;
    }

    public void setVendodRequestId(Integer vendodRequestId) {
        this.vendodRequestId = vendodRequestId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupCategoryId() {
        return groupCategoryId;
    }

    public void setGroupCategoryId(Integer groupCategoryId) {
        this.groupCategoryId = groupCategoryId;
    }

    public Integer getGroupSubCategoryId() {
        return groupSubCategoryId;
    }

    public void setGroupSubCategoryId(Integer groupSubCategoryId) {
        this.groupSubCategoryId = groupSubCategoryId;
    }
    
    
    
    
}
