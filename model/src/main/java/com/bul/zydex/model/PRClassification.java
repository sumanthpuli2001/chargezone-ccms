/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-5
 */
public class PRClassification {
 
    private int id;
    private String classificationName;
    private String prValue;
    private String bidRequired;

    public PRClassification() {
    }

    public PRClassification(int id, String classificationName, String prValue, String bidRequired) {
        this.id = id;
        this.classificationName = classificationName;
        this.prValue = prValue;
        this.bidRequired = bidRequired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public String getPrValue() {
        return prValue;
    }

    public void setPrValue(String prValue) {
        this.prValue = prValue;
    }

    public String getBidRequired() {
        return bidRequired;
    }

    public void setBidRequired(String bidRequired) {
        this.bidRequired = bidRequired;
    }
    
    
    
}
