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
public class OapMasterUser {

    private int id;
    private OapMaster oapMaster;
    private String userId;
    private int level;

    public OapMasterUser() {
    }

    public OapMasterUser(int id, OapMaster oapMaster, String userId, int level) {
	this.id = id;
	this.oapMaster = oapMaster;
	this.userId = userId;
	this.level = level;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public OapMaster getOapMaster() {
	return oapMaster;
    }

    public void setOapMaster(OapMaster oapMaster) {
	this.oapMaster = oapMaster;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }

}
