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
public class DesignCoordinatorMultiAttach {
   private int id ;
   private int deliverableMultiId ;
   private String description;
   private  String attachement;
   private int oapId;
    private int aocId;

    public DesignCoordinatorMultiAttach() {
    }

    public DesignCoordinatorMultiAttach(int id, int deliverableMultiId, String description, String attachement, int oapId, int aocId) {
	this.id = id;
	this.deliverableMultiId = deliverableMultiId;
	this.description = description;
	this.attachement = attachement;
	this.oapId = oapId;
	this.aocId = aocId;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getDeliverableMultiId() {
	return deliverableMultiId;
    }

    public void setDeliverableMultiId(int deliverableMultiId) {
	this.deliverableMultiId = deliverableMultiId;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getAttachement() {
	return attachement;
    }

    public void setAttachement(String attachement) {
	this.attachement = attachement;
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
