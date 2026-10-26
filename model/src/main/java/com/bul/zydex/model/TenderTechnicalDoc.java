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
public class TenderTechnicalDoc {

    private int id;
    private String refNo;
    private String document;
    private String rfqNo;

    
    public TenderTechnicalDoc() {
    }

    public TenderTechnicalDoc(int id, String refNo, String document, String rfqNo) {
        this.id = id;
        this.refNo = refNo;
        this.document = document;
        this.rfqNo = rfqNo;
    }

    public int getId() {
        return id;
    }

    public TenderTechnicalDoc setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderTechnicalDoc setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public TenderTechnicalDoc setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public TenderTechnicalDoc setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }
    
    
}
