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
public class AuthTenderTechnical {
  
    private int id;
    private String refNo;
    private String remark;
    private String technicalDoc;
    private String technicalRemark;
    private String termsConditionDoc;
    private String termsConditionRemark;
    private String document;
    private String documentRemark;
    
    public AuthTenderTechnical() {
    }

    public AuthTenderTechnical(int id, String refNo, String remark, String technicalDoc, String technicalRemark, String termsConditionDoc, String termsConditionRemark, String document, String documentRemark) {
        this.id = id;
        this.refNo = refNo;
        this.remark = remark;
        this.technicalDoc = technicalDoc;
        this.technicalRemark = technicalRemark;
        this.termsConditionDoc = termsConditionDoc;
        this.termsConditionRemark = termsConditionRemark;
        this.document = document;
        this.documentRemark = documentRemark;
    }

    public int getId() {
        return id;
    }

    public AuthTenderTechnical setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderTechnical setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public AuthTenderTechnical setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getTechnicalDoc() {
        return technicalDoc;
    }

    public AuthTenderTechnical setTechnicalDoc(String technicalDoc) {
        this.technicalDoc = technicalDoc;
        return this;
    }

    public String getTechnicalRemark() {
        return technicalRemark;
    }

    public AuthTenderTechnical setTechnicalRemark(String technicalRemark) {
        this.technicalRemark = technicalRemark;
        return this;
    }

    public String getTermsConditionDoc() {
        return termsConditionDoc;
    }

    public AuthTenderTechnical setTermsConditionDoc(String termsConditionDoc) {
        this.termsConditionDoc = termsConditionDoc;
        return this;
    }

    public String getTermsConditionRemark() {
        return termsConditionRemark;
    }

    public AuthTenderTechnical setTermsConditionRemark(String termsConditionRemark) {
        this.termsConditionRemark = termsConditionRemark;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public AuthTenderTechnical setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public AuthTenderTechnical setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark;
        return this;
    }
    
}
