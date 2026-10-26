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
public class VendorCustomerRefrence implements java.io.Serializable{
    
    private int id;
    private int vendorInformationId;
    private String companyName;
    private String contactPersonName;
    private String contactDetails;
    
            
    public VendorCustomerRefrence() {
    }

    public VendorCustomerRefrence(int id, int vendorInformationId, String companyName, String contactPersonName, String contactDetails) {
        this.id = id;
        this.vendorInformationId = vendorInformationId;
        this.companyName = companyName;
        this.contactPersonName = contactPersonName;
        this.contactDetails = contactDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorInformationId() {
        return vendorInformationId;
    }

    public void setVendorInformationId(int vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
    
    
    
    
}
