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
public class PRNoTemp {
    
    private int id;
    private String prNo;
    
    public PRNoTemp() {
    }

    public PRNoTemp(int id, String prNo) {
        this.id = id;
        this.prNo = prNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }
    
   
}
