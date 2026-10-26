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
public class AocLogMaster {

    private int id;
    private int aocId;
    private String activity;
    private String activityBy;
    private String date;
    private String status;
    private String comments;
    private int komId;

    public AocLogMaster() {
    }

    public AocLogMaster(int id, int aocId, String activity, String activityBy, String date, String status, String comments, int komId) {
        this.id = id;
        this.aocId = aocId;
        this.activity = activity;
        this.activityBy = activityBy;
        this.date = date;
        this.status = status;
        this.comments = comments;
        this.komId = komId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAocId() {
        return aocId;
    }

    public void setAocId(int aocId) {
        this.aocId = aocId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityBy() {
        return activityBy;
    }

    public void setActivityBy(String activityBy) {
        this.activityBy = activityBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getKomId() {
        return komId;
    }

    public void setKomId(int komId) {
        this.komId = komId;
    }

  
}
