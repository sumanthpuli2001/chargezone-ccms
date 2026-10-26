/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Administrator
 */
public class PoDetails {
    
    private int id;
    private String prNo;
    private String tenderNo;
    private String poNo;
    private String poDate;
    private String vendorCode;
    private String vendorName;
    private String poValue;
    private int noDocumentAttached;
    private int status;

    public PoDetails() {
    }

    public PoDetails(int id, String prNo, String tenderNo, String poNo, String poDate, String vendorCode, String vendorName, String poValue, int noDocumentAttached, int status) {
        this.id = id;
        this.prNo = prNo;
        this.tenderNo = tenderNo;
        this.poNo = poNo;
        this.poDate = poDate;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.poValue = poValue;
        this.noDocumentAttached = noDocumentAttached;
        this.status = status;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getPoValue() {
        return poValue;
    }

    public void setPoValue(String poValue) {
        this.poValue = poValue;
    }

    public int getNoDocumentAttached() {
        return noDocumentAttached;
    }

    public void setNoDocumentAttached(int noDocumentAttached) {
        this.noDocumentAttached = noDocumentAttached;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
    
}
