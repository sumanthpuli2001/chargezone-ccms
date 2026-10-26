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
public class SapVendorTelephone {
    
    private int id;
    private String addrNumber;
    private String telNumber;
    private String r3User;
    
    public SapVendorTelephone() {
    }
    
    public SapVendorTelephone(int id, String addrNumber, String telNumber, String r3User) {
        this.id = id;
        this.addrNumber = addrNumber;
        this.telNumber = telNumber;
        this.r3User = r3User;
    }

    public int getId() {
        return id;
    }

    public SapVendorTelephone setId(int id) {
        this.id = id;
        return this;
    }

    public String getAddrNumber() {
        return addrNumber;
    }

    public SapVendorTelephone setAddrNumber(String addrNumber) {
        this.addrNumber = addrNumber;
        return this;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public SapVendorTelephone setTelNumber(String telNumber) {
        this.telNumber = telNumber;
        return this;
    }

    public String getR3User() {
        return r3User;
    }

    public SapVendorTelephone setR3User(String r3User) {
        this.r3User = r3User;
        return this;
    }
    
    
}
