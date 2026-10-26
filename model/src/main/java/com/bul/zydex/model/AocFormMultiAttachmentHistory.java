/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Hitesh
 */
public class AocFormMultiAttachmentHistory {

    private int id;
    private int aocForm;
    private String attachment;
    private String description;
    private String history;
    private int aocMultiId;
    private int aocHistoryId;

    public AocFormMultiAttachmentHistory() {
    }

    public AocFormMultiAttachmentHistory(int id, int aocForm, String attachment, String description, String history, int aocMultiId, int aocHistoryId) {
	this.id = id;
	this.aocForm = aocForm;
	this.attachment = attachment;
	this.description = description;
	this.history = history;
	this.aocMultiId=aocMultiId;
	this.aocHistoryId=aocHistoryId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getAocForm() {
	return aocForm;
    }

    public void setAocForm(int aocForm) {
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

    public String getHistory() {
	return history;
    }

    public void setHistory(String history) {
	this.history = history;
    }


    public int getAocHistoryId() {
	return aocHistoryId;
    }

    public void setAocHistoryId(int aocHistoryId) {
	this.aocHistoryId = aocHistoryId;
    }

    public int getAocMultiId() {
	return aocMultiId;
    }

    public void setAocMultiId(int aocMultiId) {
	this.aocMultiId = aocMultiId;
    }

}
