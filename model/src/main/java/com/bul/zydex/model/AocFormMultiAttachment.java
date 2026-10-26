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
public class AocFormMultiAttachment {

    private int id;
    private AocForm aocForm;
    private String attachment;
    private String description;

    public AocFormMultiAttachment() {
    }

    public AocFormMultiAttachment(int id, AocForm aocForm, String attachment, String description) {
	this.id = id;
	this.aocForm = aocForm;
	this.attachment = attachment;
	this.description = description;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public AocForm getAocForm() {
	return aocForm;
    }

    public void setAocForm(AocForm aocForm) {
	this.aocForm = aocForm;
    }

    public String getAttachment() {
	return attachment;
    }

    public void setAttachment(String attachment) {
	this.attachment = attachment;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }
    
    
    

}
