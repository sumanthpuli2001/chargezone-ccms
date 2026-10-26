/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class VendorApproval implements java.io.Serializable{
    
    private int id;
    private int vendorInformationId;
    private String activity;
    private String description;
    private String userId;
    private String dateTime;
    private String userRole;
    
    
    public VendorApproval() {
    }

    public VendorApproval(int id, int vendorInformationId, String activity, String description, String userId, String dateTime, String userRole) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.activity = activity;
        this.description = description;
        this.userId = userId;
        this.dateTime = dateTime;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public void setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    
    
}
