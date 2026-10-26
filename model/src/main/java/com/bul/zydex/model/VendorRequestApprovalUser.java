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
public class VendorRequestApprovalUser {
    private Integer id;
    private Integer vendorRequestApprovalId;
    private Integer vendorRequestDetailsId;
    private String userId;
    private Integer level;
    private Integer approvalStatus;

    public VendorRequestApprovalUser() {
    }

    public VendorRequestApprovalUser(Integer id, Integer vendorRequestApprovalId, Integer vendorRequestDetailsId, String userId, Integer level, Integer approvalStatus) {
        this.id = id;
        this.vendorRequestApprovalId = vendorRequestApprovalId;
        this.vendorRequestDetailsId = vendorRequestDetailsId;
        this.userId = userId;
        this.level = level;
        this.approvalStatus = approvalStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVendorRequestApprovalId() {
        return vendorRequestApprovalId;
    }

    public void setVendorRequestApprovalId(Integer vendorRequestApprovalId) {
        this.vendorRequestApprovalId = vendorRequestApprovalId;
    }

    public Integer getVendorRequestDetailsId() {
        return vendorRequestDetailsId;
    }

    public void setVendorRequestDetailsId(Integer vendorRequestDetailsId) {
        this.vendorRequestDetailsId = vendorRequestDetailsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    
}
