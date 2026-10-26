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
public class SapItemLongTxt {
    
    private int id;
    private String number;
    private String txt;
    private String PNumber;
    private String INumber;
    
    public SapItemLongTxt() {
    }
    
    public SapItemLongTxt(int id, String number, String txt, String PNumber, String INumber) {
        this.id = id;
        this.number = number;
        this.txt = txt;
        this.PNumber = PNumber;
        this.INumber = INumber;
    }

    public int getId() {
        return id;
    }

    public SapItemLongTxt setId(int id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public SapItemLongTxt setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getTxt() {
        return txt;
    }

    public SapItemLongTxt setTxt(String txt) {
        this.txt = txt;
        return this;
    }

    public String getPNumber() {
        return PNumber;
    }

    public SapItemLongTxt setPNumber(String PNumber) {
        this.PNumber = PNumber;
        return this;
    }

    public String getINumber() {
        return INumber;
    }

    public SapItemLongTxt setINumber(String INumber) {
        this.INumber = INumber;
        return this;
    }
    
    
    
}
