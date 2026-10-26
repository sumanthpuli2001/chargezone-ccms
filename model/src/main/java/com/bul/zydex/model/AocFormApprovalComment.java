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
public class AocFormApprovalComment {

    private int id;
    private int aocFormApproval;
    private String userId;
    private String approvalComment;
    private String approvalStatus;
    private int aocForm;

    public AocFormApprovalComment() {
    }

    public AocFormApprovalComment(int id, int aocFormApproval, String userId, String approvalComment, String approvalStatus, int aocForm) {
	this.id = id;
	this.aocFormApproval = aocFormApproval;
	this.userId = userId;
	this.approvalComment = approvalComment;
	this.approvalStatus = approvalStatus;
	this.aocForm = aocForm;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getAocFormApproval() {
	return aocFormApproval;
    }

    public void setAocFormApproval(int aocFormApproval) {
	this.aocFormApproval = aocFormApproval;
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

    public int getAocForm() {
	return aocForm;
    }

    public void setAocForm(int aocForm) {
	this.aocForm = aocForm;
    }

    
    
    
    
    
    
    
    
}
