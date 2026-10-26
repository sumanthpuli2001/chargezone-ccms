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
public class OapFormApprovalComment {

    private int id;
    private int oapFormApproval;
    private String userId;
    private String approvalComment;
    private String approvalStatus;
    private int oapForm;

    public OapFormApprovalComment() {
    }

    public OapFormApprovalComment(int id, int oapFormApproval, String userId, String approvalComment, String approvalStatus, int oapForm) {
	this.id = id;
	this.oapFormApproval = oapFormApproval;
	this.userId = userId;
	this.approvalComment = approvalComment;
	this.approvalStatus = approvalStatus;
	this.oapForm = oapForm;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getOapFormApproval() {
	return oapFormApproval;
    }

    public void setOapFormApproval(int oapFormApproval) {
	this.oapFormApproval = oapFormApproval;
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

    public String getApprovalStatus() {
	return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
	this.approvalStatus = approvalStatus;
    }

    public int getOapForm() {
	return oapForm;
    }

    public void setOapForm(int oapForm) {
	this.oapForm = oapForm;
    }

    
    
    
    
    
    
}
