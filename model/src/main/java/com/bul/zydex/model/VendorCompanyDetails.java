/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class VendorCompanyDetails {
    
    private int id;
    private String vendorCompanyName;
    private String vendorPO;
    private String vendorCode;
    private String vendorEmail;
    private String vendorInformationId;

    public VendorCompanyDetails() {
        
    }
    
    public VendorCompanyDetails(int id, String vendorCompanyName, String vendorPO, String vendorCode, String vendorEmail, String vendorInformationId) {
        this.id = id;
        this.vendorCompanyName = vendorCompanyName;
        this.vendorPO = vendorPO;
        this.vendorCode = vendorCode;
        this.vendorEmail = vendorEmail;
        this.vendorInformationId = vendorInformationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorCompanyName() {
        return vendorCompanyName;
    }

    public void setVendorCompanyName(String vendorCompanyName) {
        this.vendorCompanyName = vendorCompanyName;
    }

    public String getVendorPO() {
        return vendorPO;
    }

    public void setVendorPO(String vendorPO) {
        this.vendorPO = vendorPO;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    public String getVendorInformationId() {
        return vendorInformationId;
    }

    public void setVendorInformationId(String vendorInformationId) {
        this.vendorInformationId = vendorInformationId;
    }
    
    
    
}
