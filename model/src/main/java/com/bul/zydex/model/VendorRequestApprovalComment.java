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
public class VendorRequestApprovalComment {
    private Integer  id;
    private Integer  vendorRequestApprovalId;
    private String userId;
    private String approvalComment;
     private Integer approvalStatus;
     private Integer vendorRequestDetailsId;

    public VendorRequestApprovalComment() {
    }

    public VendorRequestApprovalComment(Integer id, Integer vendorRequestApprovalId, String userId, String approvalComment, Integer approvalStatus, Integer vendorRequestDetailsId) {
        this.id = id;
        this.vendorRequestApprovalId = vendorRequestApprovalId;
        this.userId = userId;
        this.approvalComment = approvalComment;
        this.approvalStatus = approvalStatus;
        this.vendorRequestDetailsId = vendorRequestDetailsId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Integer getVendorRequestDetailsId() {
        return vendorRequestDetailsId;
    }

    public void setVendorRequestDetailsId(Integer vendorRequestDetailsId) {
        this.vendorRequestDetailsId = vendorRequestDetailsId;
    }
     
    
}
