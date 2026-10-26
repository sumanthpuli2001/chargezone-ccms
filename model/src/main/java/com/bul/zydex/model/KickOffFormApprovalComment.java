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
public class KickOffFormApprovalComment {

    private int id;
    private KickOffFormApproval kickOffFormApproval;
    private String userId;
    private String approvalComment;
    private String approvalStatus;

    public KickOffFormApprovalComment() {
    }

    public KickOffFormApprovalComment(int id, KickOffFormApproval kickOffFormApproval, String userId, String approvalComment, String approvalStatus) {
	this.id = id;
	this.kickOffFormApproval = kickOffFormApproval;
	this.userId = userId;
	this.approvalComment = approvalComment;
	this.approvalStatus = approvalStatus;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public KickOffFormApproval getKickOffFormApproval() {
	return kickOffFormApproval;
    }

    public void setKickOffFormApproval(KickOffFormApproval kickOffFormApproval) {
	this.kickOffFormApproval = kickOffFormApproval;
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

    
    
    
    
    
    
}
