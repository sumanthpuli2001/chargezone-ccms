/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterHistory {
    private int id;
    private int vendorCriteriaMasterId;
    private String createdBy;
    private String createdDate;
    private String actionBy;

    public VendorCriteriaMasterHistory() {
    }

    public VendorCriteriaMasterHistory(int id, int vendorCriteriaMasterId, String createdBy, String createdDate, String actionBy) {
        this.id = id;
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.actionBy = actionBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorCriteriaMasterId() {
        return vendorCriteriaMasterId;
    }

    public void setVendorCriteriaMasterId(int vendorCriteriaMasterId) {
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
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

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }
    
}
