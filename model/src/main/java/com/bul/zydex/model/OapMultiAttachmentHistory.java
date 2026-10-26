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
public class OapMultiAttachmentHistory {

    private int id;
    private int oapForm;
    private String attachment;
    private String description;
    private String history;
    private int oapHistoryId;
    private int oapMultiId;

    public OapMultiAttachmentHistory() {
    }

    public OapMultiAttachmentHistory(int id, int oapForm, String attachment, String description, String history, int oapHistoryId, int oapMultiId) {
	this.id = id;
	this.oapForm = oapForm;
	this.attachment = attachment;
	this.description = description;
	this.history = history;
	this.oapHistoryId = oapHistoryId;
	this.oapMultiId = oapMultiId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getOapForm() {
	return oapForm;
    }

    public void setOapForm(int oapForm) {
	this.oapForm = oapForm;
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

    public int getOapHistoryId() {
	return oapHistoryId;
    }

    public void setOapHistoryId(int oapHistoryId) {
	this.oapHistoryId = oapHistoryId;
    }

    public int getOapMultiId() {
	return oapMultiId;
    }

    public void setOapMultiId(int oapMultiId) {
	this.oapMultiId = oapMultiId;
    }

}
