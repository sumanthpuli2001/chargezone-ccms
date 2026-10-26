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
public class VendorTechnicalBidTechAttachment {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String description;
    private String attachment;
            
    public VendorTechnicalBidTechAttachment() {
    }

    public VendorTechnicalBidTechAttachment(int id, String refNo, String vendorCode, String description, String attachment) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.description = description;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public VendorTechnicalBidTechAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorTechnicalBidTechAttachment setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorTechnicalBidTechAttachment setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VendorTechnicalBidTechAttachment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorTechnicalBidTechAttachment setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }
    
    
}
