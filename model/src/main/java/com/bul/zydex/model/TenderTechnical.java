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
public class TenderTechnical {
    
    private int id;
    private String refNo;
    private String remark;
    private String technicalDoc;
    private String technicalRemark;
    private String termsConditionDoc;
    private String termsConditionRemark;
    private String document;
    private String documentRemark;
    private String technicalRefNo;
    private String termsRefNo;
    private String documentRefNo;
    
    public TenderTechnical() {
    }

    public TenderTechnical(int id, String refNo, String remark, String technicalDoc, String technicalRemark, String termsConditionDoc, String termsConditionRemark, String document, String documentRemark, String technicalRefNo, String termsRefNo, String documentRefNo) {
        this.id = id;
        this.refNo = refNo;
        this.remark = remark;
        this.technicalDoc = technicalDoc;
        this.technicalRemark = technicalRemark;
        this.termsConditionDoc = termsConditionDoc;
        this.termsConditionRemark = termsConditionRemark;
        this.document = document;
        this.documentRemark = documentRemark;
        this.technicalRefNo = technicalRefNo;
        this.termsRefNo = termsRefNo;
        this.documentRefNo = documentRefNo;
    }

    public int getId() {
        return id;
    }

    public TenderTechnical setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderTechnical setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public TenderTechnical setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getTechnicalDoc() {
        return technicalDoc;
    }

    public TenderTechnical setTechnicalDoc(String technicalDoc) {
        this.technicalDoc = technicalDoc;
        return this;
    }

    public String getTechnicalRemark() {
        return technicalRemark;
    }

    public TenderTechnical setTechnicalRemark(String technicalRemark) {
        this.technicalRemark = technicalRemark;
        return this;
    }

    public String getTermsConditionDoc() {
        return termsConditionDoc;
    }

    public TenderTechnical setTermsConditionDoc(String termsConditionDoc) {
        this.termsConditionDoc = termsConditionDoc;
        return this;
    }

    public String getTermsConditionRemark() {
        return termsConditionRemark;
    }

    public TenderTechnical setTermsConditionRemark(String termsConditionRemark) {
        this.termsConditionRemark = termsConditionRemark;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public TenderTechnical setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public TenderTechnical setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark;
        return this;
    }

    public String getTechnicalRefNo() {
        return technicalRefNo;
    }

    public TenderTechnical setTechnicalRefNo(String technicalRefNo) {
        this.technicalRefNo = technicalRefNo;
        return this;
    }

    public String getTermsRefNo() {
        return termsRefNo;
    }

    public TenderTechnical setTermsRefNo(String termsRefNo) {
        this.termsRefNo = termsRefNo;
        return this;
    }

    public String getDocumentRefNo() {
        return documentRefNo;
    }

    public TenderTechnical setDocumentRefNo(String documentRefNo) {
        this.documentRefNo = documentRefNo;
        return this;
    }
    
    
    
}
