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
public class VendorRequestApproval {

    private Integer id;
    private Integer vendorDetailsId;
    private Integer totalApproval;
    private Integer approvalStatus;
    private String approvalRemark;
    private String userId;
    private String currentApproval;

    public VendorRequestApproval() {
    }

    public VendorRequestApproval(Integer id, Integer vendorDetailsId, Integer totalApproval, Integer approvalStatus, String approvalRemark, String userId, String currentApproval) {
        this.id = id;
        this.vendorDetailsId = vendorDetailsId;
        this.totalApproval = totalApproval;
        this.approvalStatus = approvalStatus;
        this.approvalRemark = approvalRemark;
        this.userId = userId;
        this.currentApproval = currentApproval;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVendorDetailsId() {
        return vendorDetailsId;
    }

    public void setVendorDetailsId(Integer vendorDetailsId) {
        this.vendorDetailsId = vendorDetailsId;
    }

    public Integer getTotalApproval() {
        return totalApproval;
    }

    public void setTotalApproval(Integer totalApproval) {
        this.totalApproval = totalApproval;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrentApproval() {
        return currentApproval;
    }

    public void setCurrentApproval(String currentApproval) {
        this.currentApproval = currentApproval;
    }

}
