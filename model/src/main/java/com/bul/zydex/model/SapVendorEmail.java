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
public class SapVendorEmail {
    
    private int id;
    private String addrNumber;
    private String smtpAddr;
    
    public SapVendorEmail() {
    }
    
    public SapVendorEmail(int id, String addrNumber, String smtpAddr) {
        this.id = id;
        this.addrNumber = addrNumber;
        this.smtpAddr = smtpAddr;
    }

    public int getId() {
        return id;
    }

    public SapVendorEmail setId(int id) {
        this.id = id;
        return this;
    }

    public String getAddrNumber() {
        return addrNumber;
    }

    public SapVendorEmail setAddrNumber(String addrNumber) {
        this.addrNumber = addrNumber;
        return this;
    }

    public String getSmtpAddr() {
        return smtpAddr;
    }

    public SapVendorEmail setSmtpAddr(String smtpAddr) {
        this.smtpAddr = smtpAddr;
        return this;
    }
    
    
}
