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
public class StationType {

    private int id;
    private String stationType;

    public StationType() {
    }

    public StationType(int id, String stationType) {
	this.id = id;
	this.stationType = stationType;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getStationType() {
	return stationType;
    }

    public void setStationType(String stationType) {
	this.stationType = stationType;
    }

}
