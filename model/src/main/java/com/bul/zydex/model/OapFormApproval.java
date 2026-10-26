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
public class OapFormApproval {

    private int id;
    private OapForm oapForm;
    private String totalApproval;
    private String approvalStatus;
    private String approvalRemark;
    private String userId;
    private String currentApproval;

    public OapFormApproval() {
    }

    public OapFormApproval(int id, OapForm oapForm, String totalApproval, String approvalStatus, String approvalRemark, String userId, String currentApproval) {
	this.id = id;
	this.oapForm = oapForm;
	this.totalApproval = totalApproval;
	this.approvalStatus = approvalStatus;
	this.approvalRemark = approvalRemark;
	this.userId = userId;
	this.currentApproval = currentApproval;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public OapForm getOapForm() {
	return oapForm;
    }

    public void setOapForm(OapForm oapForm) {
	this.oapForm = oapForm;
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

    
    
    
}
