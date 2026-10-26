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
public class DocumentName {

    private int id;
    private String documentName;
    private String state;
    private String compalsuary;
    private int discomId;
    private int connectionTypeId;

    public DocumentName() {
    }

    public DocumentName(int id, String documentName, String state, String compalsuary, int discomId, int connectionTypeId) {
	this.id = id;
	this.documentName = documentName;
	this.state = state;
	this.compalsuary = compalsuary;
	this.discomId = discomId;
	this.connectionTypeId = connectionTypeId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDocumentName() {
	return documentName;
    }

    public void setDocumentName(String documentName) {
	this.documentName = documentName;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getCompalsuary() {
	return compalsuary;
    }

    public void setCompalsuary(String compalsuary) {
	this.compalsuary = compalsuary;
    }

    public int getDiscomId() {
	return discomId;
    }

    public void setDiscomId(int discomId) {
	this.discomId = discomId;
    }

    public int getConnectionTypeId() {
	return connectionTypeId;
    }

    public void setConnectionTypeId(int connectionTypeId) {
	this.connectionTypeId = connectionTypeId;
    }

   
}
