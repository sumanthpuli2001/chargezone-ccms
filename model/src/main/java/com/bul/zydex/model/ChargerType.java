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
public class ChargerType {
    
    
    private int id;
    private String chargerType;

    public ChargerType() {
    }

    public ChargerType(int id, String chargerType) {
        this.id = id;
        this.chargerType = chargerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChargerType() {
        return chargerType;
    }

    public void setChargerType(String chargerType) {
        this.chargerType = chargerType;
    }
    
    
    
}
