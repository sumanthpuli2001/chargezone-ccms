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
public class AocFormApprovalUser {

    private int id;
    private int aocFormApproval;
    private int aocForm;
    private String userId;
    private String level;
    private String approvalStatus;

    public AocFormApprovalUser() {
    }

    public AocFormApprovalUser(int id, int aocFormApproval, int aocForm, String userId, String level, String approvalStatus) {
	this.id = id;
	this.aocFormApproval = aocFormApproval;
	this.aocForm = aocForm;
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

    public int getAocFormApproval() {
	return aocFormApproval;
    }

    public void setAocFormApproval(int aocFormApproval) {
	this.aocFormApproval = aocFormApproval;
    }

    public int getAocForm() {
	return aocForm;
    }

    public void setAocForm(int aocForm) {
	this.aocForm = aocForm;
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
