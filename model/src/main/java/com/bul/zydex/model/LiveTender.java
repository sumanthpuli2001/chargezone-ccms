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
public class LiveTender {
    
    private int id;
    private String tenderno;
    private String description;
    private String tenderdoc;
    
    public LiveTender() {
    }
    
    public LiveTender(int id, String tenderno, String description, String tenderdoc) {
        this.id = id;
        this.tenderno = tenderno;
        this.description = description;
        this.tenderdoc = tenderdoc;
        
    }

    public int getId() {
        return id;
    }

    public LiveTender setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderno() {
        return tenderno;
    }

    public LiveTender setTenderno(String tenderno) {
        this.tenderno = tenderno;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LiveTender setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTenderdoc() {
        return tenderdoc;
    }

    public LiveTender setTenderdoc(String tenderdoc) {
        this.tenderdoc = tenderdoc;
        return this;
    }
    
    
    
}
