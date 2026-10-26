/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class DiscomMaster {
     private int id;
    private String discomType;
    private String state;

    public DiscomMaster() {
    }

    public DiscomMaster(int id, String discomType, String state) {
        this.id = id;
        this.discomType = discomType;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscomType() {
        return discomType;
    }

    public void setDiscomType(String discomType) {
        this.discomType = discomType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
