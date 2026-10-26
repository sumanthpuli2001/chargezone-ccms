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
public class OapLogMaster {

    private int id;
    private int oapId;
    private String activity;
    private String activityBy;
    private String date;
    private String status;
    private String comments;
     private int crcId;

    public OapLogMaster() {
    }

    public OapLogMaster(int id, int oapId, String activity, String activityBy, String date, String status, String comments, int crcId) {
        this.id = id;
        this.oapId = oapId;
        this.activity = activity;
        this.activityBy = activityBy;
        this.date = date;
        this.status = status;
        this.comments = comments;
        this.crcId = crcId;
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

    public int getCrcId() {
        return crcId;
    }

    public void setCrcId(int crcId) {
        this.crcId = crcId;
    }

    
    
    
}
