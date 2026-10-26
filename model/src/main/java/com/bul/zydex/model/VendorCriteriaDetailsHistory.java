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
public class VendorCriteriaDetailsHistory {
    private int id;
    private int vendorCriteriaMasterHistoryId;
    private String actionBy;
    private String date;
    private String criteriaName;
    private String criteriaDescription;
    private String mandatory;
    private String compulsary;
    private int vendorCriteriaMasterId;
    private String action;



    public VendorCriteriaDetailsHistory() {
    }

    public VendorCriteriaDetailsHistory(int id, int vendorCriteriaMasterHistoryId, String actionBy, String date, String criteriaName, String criteriaDescription, String mandatory, String compulsary, int vendorCriteriaMasterId, String action) {
        this.id = id;
        this.vendorCriteriaMasterHistoryId = vendorCriteriaMasterHistoryId;
        this.actionBy = actionBy;
        this.date = date;
        this.criteriaName = criteriaName;
        this.criteriaDescription = criteriaDescription;
        this.mandatory = mandatory;
        this.compulsary = compulsary;
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
        this.action = action;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorCriteriaMasterHistoryId() {
        return vendorCriteriaMasterHistoryId;
    }

    public void setVendorCriteriaMasterHistoryId(int vendorCriteriaMasterHistoryId) {
        this.vendorCriteriaMasterHistoryId = vendorCriteriaMasterHistoryId;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public String getCompulsary() {
        return compulsary;
    }

    public void setCompulsary(String compulsary) {
        this.compulsary = compulsary;
    }

    public int getVendorCriteriaMasterId() {
        return vendorCriteriaMasterId;
    }

    public void setVendorCriteriaMasterId(int vendorCriteriaMasterId) {
        this.vendorCriteriaMasterId = vendorCriteriaMasterId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    
}
