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
public class TenderVendor {
    
    private int id;
    private String refNo;
    private String rfqNo;
    private String vendorCode;
    private String vendorName;
    private String address;
    private String emailId;
    private String mobileNo;
    private String contactPerson;
    private int checked;
    
    public TenderVendor() {
    }

    public TenderVendor(int id, String refNo, String rfqNo, String vendorCode, String vendorName, String address, String emailId, String mobileNo, String contactPerson, int checked) {
        this.id = id;
        this.refNo = refNo;
        this.rfqNo = rfqNo;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.address = address;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.contactPerson = contactPerson;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public TenderVendor setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderVendor setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public TenderVendor setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public TenderVendor setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public TenderVendor setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public TenderVendor setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public TenderVendor setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public TenderVendor setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public TenderVendor setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public int getChecked() {
        return checked;
    }

    public TenderVendor setChecked(int checked) {
        this.checked = checked;
        return this;
    }
    
    
}
