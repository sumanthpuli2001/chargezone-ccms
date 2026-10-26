/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class ChargerMaster {
    
    private int id;
    private String chargerMaster;

    public ChargerMaster() {
    }

    public ChargerMaster(int id, String chargerMaster) {
        this.id = id;
        this.chargerMaster = chargerMaster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChargerMaster() {
        return chargerMaster;
    }

    public void setChargerMaster(String chargerMaster) {
        this.chargerMaster = chargerMaster;
    }
    
    
}
