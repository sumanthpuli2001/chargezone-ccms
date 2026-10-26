package com.bul.zydex.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class VendorTermsConditionPriceBid {
    
     private int id;
     private String tenderNo;
     private String vendorCode;
     private String termsCondition;
     private String response;
     private String comment;
     private String description;

    public VendorTermsConditionPriceBid() {
    }

    public VendorTermsConditionPriceBid(int id, String tenderNo, String vendorCode, String termsCondition, String response, String comment, String description) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.vendorCode = vendorCode;
        this.termsCondition = termsCondition;
        this.response = response;
        this.comment = comment;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     
     

}
