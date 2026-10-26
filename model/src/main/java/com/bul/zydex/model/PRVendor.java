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
public class PRVendor {
    
    private int id;
    private String prNo;
    
    private String vendorCode;
    private String vendorName; 
    private String address;
    private String emailId;
    private String mobileNo;
    private String contactPerson;
    private int checked;
    private String vendorRank;
    private String vendorRemark;
    private int vendorId;
    
    public PRVendor() {
    }

    public PRVendor(int id, String prNo, String vendorCode, String vendorName, String address, String emailId, String mobileNo, String contactPerson, int checked, String vendorRank, String vendorRemark, int vendorId) {
        this.id = id;
        this.prNo = prNo;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.address = address;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.contactPerson = contactPerson;
        this.checked = checked;
        this.vendorRank = vendorRank;
        this.vendorRemark = vendorRemark;
        this.vendorId = vendorId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getVendorRank() {
        return vendorRank;
    }

    public void setVendorRank(String vendorRank) {
        this.vendorRank = vendorRank;
    }

    public String getVendorRemark() {
        return vendorRemark;
    }

    public void setVendorRemark(String vendorRemark) {
        this.vendorRemark = vendorRemark;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    
    
}
