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
public class AuthTenderPreQualification {
    
    private int id;
    private String refNo;
    private String remark;
    private String document;
    private String documentRemark;
    
    public AuthTenderPreQualification() {
    }

    public AuthTenderPreQualification(int id, String refNo, String remark, String document, String documentRemark) {
        this.id = id;
        this.refNo = refNo;
        this.remark = remark;
        this.document = document;
        this.documentRemark = documentRemark; 
    }

    public int getId() {
        return id;
    }

    public AuthTenderPreQualification setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderPreQualification setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public AuthTenderPreQualification setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public AuthTenderPreQualification setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public AuthTenderPreQualification setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark;
        return this;
    }
    
}
