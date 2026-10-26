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
public class TenderSendEmail {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String vendorName;
    private String vendorAddress;
    private String vendorEmail;
    private String vendorMobile;
    private int checkStatus;
    
    public TenderSendEmail() {
    }

    public TenderSendEmail(int id, String refNo, String rfqNo, String vendorCode, String vendorName, String vendorAddress, String vendorEmail, String vendorMobile, int checkStatus) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorEmail = vendorEmail;
        this.vendorMobile = vendorMobile;
        this.checkStatus = checkStatus;
    }

    public int getId() {
        return id;
    }

    public TenderSendEmail setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderSendEmail setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public TenderSendEmail setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public TenderSendEmail setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public TenderSendEmail setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
        return this;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public TenderSendEmail setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
        return this;
    }

    public String getVendorMobile() {
        return vendorMobile;
    }

    public TenderSendEmail setVendorMobile(String vendorMobile) {
        this.vendorMobile = vendorMobile;
        return this;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public TenderSendEmail setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }
    
    
}
