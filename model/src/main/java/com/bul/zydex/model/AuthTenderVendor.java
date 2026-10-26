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
public class AuthTenderVendor {
    
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
    
    public AuthTenderVendor() {
    }

    public AuthTenderVendor(int id, String refNo, String rfqNo, String vendorCode, String vendorName, String address, String emailId, String mobileNo, String contactPerson, int checked) {
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

    public AuthTenderVendor setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderVendor setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public AuthTenderVendor setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public AuthTenderVendor setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public AuthTenderVendor setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AuthTenderVendor setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public AuthTenderVendor setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public AuthTenderVendor setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public AuthTenderVendor setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public int getChecked() {
        return checked;
    }

    public AuthTenderVendor setChecked(int checked) {
        this.checked = checked;
        return this;
    }
    
}
