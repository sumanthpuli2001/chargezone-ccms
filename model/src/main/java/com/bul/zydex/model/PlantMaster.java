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
public class PlantMaster {
    
    private int id;
    private String plantName;
    private String plantCode;
    private int statusFlag;
    private String location;
    
    public PlantMaster() {
    }
    
    public PlantMaster(int id, String plantName, String plantCode, int statusFlag, String location) {
        this.id = id;
        this.plantName = plantName;
        this.plantCode = plantCode;
        this.statusFlag = statusFlag;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public PlantMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getPlantName() {
        return plantName;
    }

    public PlantMaster setPlantName(String plantName) {
        this.plantName = plantName;
        return this;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public PlantMaster setPlantCode(String plantCode) {
        this.plantCode = plantCode;
        return this;
    }

    public int getStatusFlag() {
        return statusFlag;
    }

    public PlantMaster setStatusFlag(int statusFlag) {
        this.statusFlag = statusFlag;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PlantMaster setLocation(String location) {
        this.location = location;
        return this;
    }
    
    
}
