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
public class TenderPreQualification {
    
    private int id;
    private String refNo;
    private String remark;
    private String document;
    private String documentRemark;
    private String documentRefNo;
    
    public TenderPreQualification() {
    }

    public TenderPreQualification(int id, String refNo, String remark, String document, String documentRemark, String documentRefNo) {
        this.id = id;
        this.refNo = refNo;
        this.remark = remark;
        this.document = document;
        this.documentRemark = documentRemark; 
        this.documentRefNo = documentRefNo;
        
    }

    public int getId() {
        return id;
    }

    public TenderPreQualification setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderPreQualification setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public TenderPreQualification setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public TenderPreQualification setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public TenderPreQualification setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark;
        return this;
    }

    public String getDocumentRefNo() {
        return documentRefNo;
    }

    public TenderPreQualification setDocumentRefNo(String documentRefNo) {
        this.documentRefNo = documentRefNo;
        return this;
    }
    
    
    
}
