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
public class AuthTenderGeneralDoc {
    
    private int id;
    private String refNo;
    private String document;
    
    public AuthTenderGeneralDoc() {
    }

    public AuthTenderGeneralDoc(int id, String refNo, String document) {
        this.id = id;
        this.refNo = refNo;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public AuthTenderGeneralDoc setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderGeneralDoc setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public AuthTenderGeneralDoc setDocument(String document) {
        this.document = document;
        return this;
    }
    
}
