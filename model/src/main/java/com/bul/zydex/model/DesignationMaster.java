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
public class DesignationMaster {
    
    private int id;
    private String designationName;

    public DesignationMaster() {
    }

    public DesignationMaster(int id, String designationName) {
        this.id = id;
        this.designationName = designationName;
    }

    public int getId() {
        return id;
    }

    public DesignationMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getDesignationName() {
        return designationName;
    }

    public DesignationMaster setDesignationName(String designationName) {
        this.designationName = designationName;
        return this;
    }
    
    
    
}
