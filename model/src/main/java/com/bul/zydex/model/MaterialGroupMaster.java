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
public class MaterialGroupMaster {
    
    private int id;
    private String materialGroupName;

    public MaterialGroupMaster() {
    }

    public MaterialGroupMaster(int id, String materialGroupName) {
        this.id = id;
        this.materialGroupName = materialGroupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterialGroupName() {
        return materialGroupName;
    }

    public void setMaterialGroupName(String materialGroupName) {
        this.materialGroupName = materialGroupName;
    }

   

   

   
    
    

    
}
