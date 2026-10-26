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
public class KickOffFormApprovalUser {

    private int id;
    private int kickOffFormApproval;
    private int kickOffForm;
    private String userId;
    private String level;
    private String approvalStatus;

    public KickOffFormApprovalUser() {
    }

    public KickOffFormApprovalUser(int id, int kickOffFormApproval, int kickOffForm, String userId, String level, String approvalStatus) {
	this.id = id;
	this.kickOffFormApproval = kickOffFormApproval;
	this.kickOffForm = kickOffForm;
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

    public int getKickOffFormApproval() {
	return kickOffFormApproval;
    }

    public void setKickOffFormApproval(int kickOffFormApproval) {
	this.kickOffFormApproval = kickOffFormApproval;
    }

    public int getKickOffForm() {
	return kickOffForm;
    }

    public void setKickOffForm(int kickOffForm) {
	this.kickOffForm = kickOffForm;
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
