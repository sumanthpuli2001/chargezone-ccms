/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

import java.util.List;

/**
 *
 * @author admin
 */
public class MaterialTypeMaster {
    
    private int id;
    private String materialType;

    public MaterialTypeMaster() {
    }

    public MaterialTypeMaster(int id, String materialType) {
        this.id = id;
        this.materialType = materialType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    
    
   
    
    
}
