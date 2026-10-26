/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class CrcFormApproval {

    private int id;
    private CrcForm crcForm;
    private String totalApproval;
    private String approvalStatus;
    private String approvalRemark;
    private String userId;
    private String currentApproval;
    private String partiallyApproveDate;

    public CrcFormApproval() {
    }

    public CrcFormApproval(int id, CrcForm crcForm, String totalApproval, String approvalStatus, String approvalRemark, String userId, String currentApproval, String partiallyApproveDate) {
	this.id = id;
	this.crcForm = crcForm;
	this.totalApproval = totalApproval;
	this.approvalStatus = approvalStatus;
	this.approvalRemark = approvalRemark;
	this.userId = userId;
	this.currentApproval = currentApproval;
	this.partiallyApproveDate = partiallyApproveDate;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public CrcForm getCrcForm() {
	return crcForm;
    }

    public void setCrcForm(CrcForm crcForm) {
	this.crcForm = crcForm;
    }

    public String getTotalApproval() {
	return totalApproval;
    }

    public void setTotalApproval(String totalApproval) {
	this.totalApproval = totalApproval;
    }

    public String getApprovalStatus() {
	return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
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

    public String getPartiallyApproveDate() {
	return partiallyApproveDate;
    }

    public void setPartiallyApproveDate(String partiallyApproveDate) {
	this.partiallyApproveDate = partiallyApproveDate;
    }

}
