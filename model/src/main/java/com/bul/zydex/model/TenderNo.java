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
public class TenderNo {
    
    private int id;
    private String tenderNo;
    
    public TenderNo() {
    }
    
    public TenderNo(int id, String tenderNo) {
        this.id = id;
        this.tenderNo = tenderNo;
    }

    public int getId() {
        return id;
    }

    public TenderNo setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public TenderNo setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }
    
    
}
