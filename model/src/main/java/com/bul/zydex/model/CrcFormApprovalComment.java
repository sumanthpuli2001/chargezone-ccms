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
public class CrcFormApprovalComment {

    private int id;
    private CrcFormApproval crcFormApproval;
    private String userId;
    private String approvalComment;
    private String approvalStatus;

    public CrcFormApprovalComment() {
    }

    public CrcFormApprovalComment(int id, CrcFormApproval crcFormApproval, String userId, String approvalComment, String approvalStatus) {
	this.id = id;
	this.crcFormApproval = crcFormApproval;
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

    public CrcFormApproval getCrcFormApproval() {
	return crcFormApproval;
    }

    public void setCrcFormApproval(CrcFormApproval crcFormApproval) {
	this.crcFormApproval = crcFormApproval;
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
