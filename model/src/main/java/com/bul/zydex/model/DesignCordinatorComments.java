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
public class DesignCordinatorComments {

    private int id;
    private int oapId;
    private int aocId;
    private int deliverableId;
    private String comments;
    private String userId;
    private int flagStatus;
    private String dateTime;

    public DesignCordinatorComments() {
    }

    public DesignCordinatorComments(int id, int oapId, int aocId, int deliverableId, String comments, String userId, int flagStatus, String dateTime) {
        this.id = id;
        this.oapId = oapId;
        this.aocId = aocId;
        this.deliverableId = deliverableId;
        this.comments = comments;
        this.userId = userId;
        this.flagStatus = flagStatus;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
        this.flagStatus = flagStatus;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    
}
