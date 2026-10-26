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
public class PRBusinessType {
    
    private int id;
    private String businessType;

    public PRBusinessType() {
    }

    public PRBusinessType(int id, String businessType) {
        this.id = id;
        this.businessType = businessType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    
    
}
