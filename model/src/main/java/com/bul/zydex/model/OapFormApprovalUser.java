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
public class OapFormApprovalUser {

    private int id;
    private int oapFormApproval;
    private int oapForm;
    private String userId;
    private String level;
    private String approvalStatus;

    public OapFormApprovalUser() {
    }

    public OapFormApprovalUser(int id, int oapFormApproval, int oapForm, String userId, String level, String approvalStatus) {
	this.id = id;
	this.oapFormApproval = oapFormApproval;
	this.oapForm = oapForm;
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

    public int getOapFormApproval() {
	return oapFormApproval;
    }

    public void setOapFormApproval(int oapFormApproval) {
	this.oapFormApproval = oapFormApproval;
    }

    public int getOapForm() {
	return oapForm;
    }

    public void setOapForm(int oapForm) {
	this.oapForm = oapForm;
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
