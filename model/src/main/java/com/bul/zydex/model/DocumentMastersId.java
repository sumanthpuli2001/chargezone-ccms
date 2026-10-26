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
public class DocumentMastersId {

    private int id;
    private String documentId;

    public DocumentMastersId() {
    }

    public DocumentMastersId(int id, String documentId) {
	this.id = id;
	this.documentId = documentId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDocumentId() {
	return documentId;
    }

    public void setDocumentId(String documentId) {
	this.documentId = documentId;
    }
    
    
    
}
