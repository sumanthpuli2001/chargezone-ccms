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
public class DeliverableMulti {

    private int id;
    private String description;
    private String designCoordinator;
    private int oapId;
    private int aocId;
    private int deliverableId;
    private String designAssign;
    private Integer flagStatus;
    private String createdBy;
    private String createdDate;
    private String deliverableCreatedDate;
    private String deliverableApprovedBy;
    private String deliverableApprovedDate;
    private String projectManagerApprovedDate;
    
    

    public DeliverableMulti() {
    }

    public DeliverableMulti(int id, String description, String designCoordinator, int oapId, int aocId, int deliverableId, String designAssign, Integer flagStatus, String createdBy, String createdDate, String deliverableCreatedDate, String deliverableApprovedBy, String deliverableApprovedDate, String projectManagerApprovedDate) {
        this.id = id;
        this.description = description;
        this.designCoordinator = designCoordinator;
        this.oapId = oapId;
        this.aocId = aocId;
        this.deliverableId = deliverableId;
        this.designAssign = designAssign;
        this.flagStatus = flagStatus;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.deliverableCreatedDate = deliverableCreatedDate;
        this.deliverableApprovedBy = deliverableApprovedBy;
        this.deliverableApprovedDate = deliverableApprovedDate;
        this.projectManagerApprovedDate = projectManagerApprovedDate;
    }

   

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDesignCoordinator() {
	return designCoordinator;
    }

    public void setDesignCoordinator(String designCoordinator) {
	this.designCoordinator = designCoordinator;
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

    public int getDeliverableId() {
	return deliverableId;
    }

    public void setDeliverableId(int deliverableId) {
	this.deliverableId = deliverableId;
    }

    public String getDesignAssign() {
	return designAssign;
    }

    public void setDesignAssign(String designAssign) {
	this.designAssign = designAssign;
    }

    public Integer getFlagStatus() {
	return flagStatus;
    }

    public void setFlagStatus(Integer flagStatus) {
	this.flagStatus = flagStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDeliverableCreatedDate() {
        return deliverableCreatedDate;
    }

    public void setDeliverableCreatedDate(String deliverableCreatedDate) {
        this.deliverableCreatedDate = deliverableCreatedDate;
    }

    public String getDeliverableApprovedBy() {
        return deliverableApprovedBy;
    }

    public void setDeliverableApprovedBy(String deliverableApprovedBy) {
        this.deliverableApprovedBy = deliverableApprovedBy;
    }

    public String getDeliverableApprovedDate() {
        return deliverableApprovedDate;
    }

    public void setDeliverableApprovedDate(String deliverableApprovedDate) {
        this.deliverableApprovedDate = deliverableApprovedDate;
    }

    public String getProjectManagerApprovedDate() {
        return projectManagerApprovedDate;
    }

    public void setProjectManagerApprovedDate(String projectManagerApprovedDate) {
        this.projectManagerApprovedDate = projectManagerApprovedDate;
    }

   
   

   
}
