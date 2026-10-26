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
public class VendorPreBidAttachment {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String description;
    private String attachmentRequired;
    private String attachment;
            
    public VendorPreBidAttachment() {
    }

    public VendorPreBidAttachment(int id, String refNo, String vendorCode, String description, String attachmentRequired, String attachment) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.description = description;
        this.attachmentRequired = attachmentRequired;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public VendorPreBidAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorPreBidAttachment setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorPreBidAttachment setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VendorPreBidAttachment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAttachmentRequired() {
        return attachmentRequired;
    }

    public VendorPreBidAttachment setAttachmentRequired(String attachmentRequired) {
        this.attachmentRequired = attachmentRequired;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorPreBidAttachment setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }
    
    
}
