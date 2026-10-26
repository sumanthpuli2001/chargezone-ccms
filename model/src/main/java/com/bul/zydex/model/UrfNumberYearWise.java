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
public class UrfNumberYearWise {
    
    private int id;
    private String year;
    private String urfNoAp;
    private int status;
    
    public UrfNumberYearWise() {
    }
    
    public UrfNumberYearWise(int id, String year, String urfNoAp, int status) {
        this.id = id;
        this.year = year;
        this.urfNoAp = urfNoAp;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public UrfNumberYearWise setId(int id) {
        this.id = id;
        return this;
    }

    public String getYear() {
        return year;
    }

    public UrfNumberYearWise setYear(String year) {
        this.year = year;
        return this;
    }

    public String getUrfNoAp() {
        return urfNoAp;
    }

    public UrfNumberYearWise setUrfNoAp(String urfNoAp) {
        this.urfNoAp = urfNoAp;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public UrfNumberYearWise setStatus(int status) {
        this.status = status;
        return this;
    }
    
    
}
