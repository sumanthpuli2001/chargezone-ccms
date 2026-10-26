/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class KickOffAttendencesHistory {

    private int id;
    private int kickoffFormId;
    private String name;
    private String rollInProject;
    private String email;
    private String cellNo;
    private int aocId;
    private String history;
    private int komAttendId;

    public KickOffAttendencesHistory() {
    }

    public KickOffAttendencesHistory(int id, int kickoffFormId, String name, String rollInProject, String email, String cellNo, int aocId, String history, int komAttendId) {
	this.id = id;
	this.kickoffFormId = kickoffFormId;
	this.name = name;
	this.rollInProject = rollInProject;
	this.email = email;
	this.cellNo = cellNo;
	this.aocId = aocId;
	this.history = history;
	this.komAttendId = komAttendId;
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

    public int getAocId() {
	return aocId;
    }

    public void setAocId(int aocId) {
	this.aocId = aocId;
    }

    public String getHistory() {
	return history;
    }

    public void setHistory(String history) {
	this.history = history;
    }

    public int getKomAttendId() {
	return komAttendId;
    }

    public void setKomAttendId(int komAttendId) {
	this.komAttendId = komAttendId;
    }

   
}
