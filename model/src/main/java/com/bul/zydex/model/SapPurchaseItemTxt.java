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
public class SapPurchaseItemTxt {
    
    private int id;
    private String purNo;
    private String itemNo;
    private String txt;
    
    public SapPurchaseItemTxt() {
    }
    
    public SapPurchaseItemTxt(int id, String purNo, String itemNo, String txt) {
        this.id = id;
        this.purNo = purNo;
        this.itemNo = itemNo;
        this.txt = txt;
    }

    public int getId() {
        return id;
    }

    public SapPurchaseItemTxt setId(int id) {
        this.id = id;
        return this;
    }

    public String getPurNo() {
        return purNo;
    }

    public SapPurchaseItemTxt setPurNo(String purNo) {
        this.purNo = purNo;
        return this;
    }

    public String getItemNo() {
        return itemNo;
    }

    public SapPurchaseItemTxt setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public String getTxt() {
        return txt;
    }

    public SapPurchaseItemTxt setTxt(String txt) {
        this.txt = txt;
        return this;
    }
    
    
    
}
