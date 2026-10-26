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
public class CrcFormApprovalUser {

    private int id;
    private int crcFormApproval;
    private int crcForm;
    private String userId;
    private String level;
    private String approvalStatus;

    public CrcFormApprovalUser() {
    }

    public CrcFormApprovalUser(int id, int crcFormApproval, int crcForm, String userId, String level, String approvalStatus) {
	this.id = id;
	this.crcFormApproval = crcFormApproval;
	this.crcForm = crcForm;
	this.userId = userId;
	this.level = level;
	this.approvalStatus = approvalStatus;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getCrcFormApproval() {
	return crcFormApproval;
    }

    public void setCrcFormApproval(int crcFormApproval) {
	this.crcFormApproval = crcFormApproval;
    }

    public int getCrcForm() {
	return crcForm;
    }

    public void setCrcForm(int crcForm) {
	this.crcForm = crcForm;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getLevel() {
	return level;
    }

    public void setLevel(String level) {
	this.level = level;
    }

    public String getApprovalStatus() {
	return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
	this.approvalStatus = approvalStatus;
    }

    
    
    
    
    
    
    
}
