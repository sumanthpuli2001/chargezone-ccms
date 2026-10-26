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
public class Deliverable {

    private int id;
    private String date;
    private String description;
    private int oapId;
    private int aocId;

    public Deliverable() {
    }

    public Deliverable(int id, String date, String description, int oapId, int aocId) {
	this.id = id;
	this.date = date;
	this.description = description;
	this.oapId = oapId;
	this.aocId = aocId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public int getOapId() {
	return oapId;
    }

    public void setOapId(int oapId) {
	this.oapId = oapId;
    }

    public int getAocId() {
	return aocId;
    }

    public void setAocId(int aocId) {
	this.aocId = aocId;
    }

    

}
