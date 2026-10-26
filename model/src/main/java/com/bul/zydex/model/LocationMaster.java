/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author admin
 */
public class LocationMaster {
    
    private int id;
    private String locationName;
    private String locationCode;
    private int statusFlag;
    
    public LocationMaster() {
    }
    
    public LocationMaster(int id, String locationName, String locationCode, int statusFlag) {
        this.id = id;
        this.locationName = locationName;
        this.locationCode = locationCode;
        this.statusFlag = statusFlag;
    }

    public int getId() {
        return id;
    }

    public LocationMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getLocationName() {
        return locationName;
    }

    public LocationMaster setLocationName(String locationName) {
        this.locationName = locationName;
        return this;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public LocationMaster setLocationCode(String locationCode) {
        this.locationCode = locationCode;
        return this;
    }

    public int getStatusFlag() {
        return statusFlag;
    }

    public LocationMaster setStatusFlag(int statusFlag) {
        this.statusFlag = statusFlag;
        return this;
    }
    
    
    
}
