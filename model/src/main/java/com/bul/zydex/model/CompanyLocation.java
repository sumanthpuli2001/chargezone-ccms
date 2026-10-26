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
public class CompanyLocation {
    
    private int id;
    private String locationName;

    public CompanyLocation() {
    }

    public CompanyLocation(int id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public CompanyLocation setId(int id) {
        this.id = id;
        return this;
    }

    public String getLocationName() {
        return locationName;
    }

    public CompanyLocation setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }
    
    
}
