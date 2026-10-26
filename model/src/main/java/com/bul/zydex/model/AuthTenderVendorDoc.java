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
public class AuthTenderVendorDoc {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String document;
    private int documentType;
    
    public AuthTenderVendorDoc() {
    }

    public AuthTenderVendorDoc(int id, String refNo, String vendorCode, String document, int documentType) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.document = document;
        this.documentType = documentType; 
    }

    public int getId() {
        return id;
    }

    public AuthTenderVendorDoc setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderVendorDoc setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public AuthTenderVendorDoc setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public AuthTenderVendorDoc setDocument(String document) {
        this.document = document;
        return this;
    }

    public int getDocumentType() {
        return documentType;
    }

    public AuthTenderVendorDoc setDocumentType(int documentType) {
        this.documentType = documentType;
        return this;
    }
    
}
