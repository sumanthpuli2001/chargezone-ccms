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
public class TenderAdditionalDoc {
    
    private int id;
    private String refNo;
    private String document;
    private String rfqNo;
    
    public TenderAdditionalDoc() {
    }

    public TenderAdditionalDoc(int id, String refNo, String document, String rfqNo) {
        this.id = id;
        this.refNo = refNo;
        this.document = document;
        this.rfqNo = rfqNo;
    }

    public int getId() {
        return id;
    }

    public TenderAdditionalDoc setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderAdditionalDoc setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public TenderAdditionalDoc setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public TenderAdditionalDoc setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }
    
    
}
