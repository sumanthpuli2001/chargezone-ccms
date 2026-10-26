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
public class TenderVendorDoc {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String document;
    private int documentType;
    private String documentRefNo;
    
    public TenderVendorDoc() {
    }

    public TenderVendorDoc(int id, String refNo, String vendorCode, String document, int documentType, String documentRefNo) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.document = document;
        this.documentType = documentType; 
        this.documentRefNo = documentRefNo;
    }

    public int getId() {
        return id;
    }

    public TenderVendorDoc setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderVendorDoc setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public TenderVendorDoc setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public TenderVendorDoc setDocument(String document) {
        this.document = document;
        return this;
    }

    public int getDocumentType() {
        return documentType;
    }

    public TenderVendorDoc setDocumentType(int documentType) {
        this.documentType = documentType;
        return this;
    }

    public String getDocumentRefNo() {
        return documentRefNo;
    }

    public TenderVendorDoc setDocumentRefNo(String documentRefNo) {
        this.documentRefNo = documentRefNo;
        return this;
    }
    
    
}
