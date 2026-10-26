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
public class KickOffAttendences {

    private int id;
    private int kickoffFormId;
    private String name;
    private String rollInProject;
    private String email;
    private String cellNo;

    public KickOffAttendences() {
    }

    public KickOffAttendences(int id, int kickoffFormId, String name, String rollInProject, String email, String cellNo) {
	this.id = id;
	this.kickoffFormId = kickoffFormId;
	this.name = name;
	this.rollInProject = rollInProject;
	this.email = email;
	this.cellNo = cellNo;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getKickoffFormId() {
	return kickoffFormId;
    }

    public void setKickoffFormId(int kickoffFormId) {
	this.kickoffFormId = kickoffFormId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getRollInProject() {
	return rollInProject;
    }

    public void setRollInProject(String rollInProject) {
	this.rollInProject = rollInProject;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getCellNo() {
	return cellNo;
    }

    public void setCellNo(String cellNo) {
	this.cellNo = cellNo;
    }

    
    
    
    
}
