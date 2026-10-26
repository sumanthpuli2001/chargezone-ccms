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
public class VendorAttachment {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String attachment;
    private int attachmentType;
    
    public VendorAttachment() {
    }

    public VendorAttachment(int id, String refNo, String vendorCode, String attachment, int attachmentType) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.attachment = attachment;
        this.attachmentType = attachmentType;
        
    }

    public int getId() {
        return id;
    }

    public VendorAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorAttachment setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorAttachment setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorAttachment setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public int getAttachmentType() {
        return attachmentType;
    }

    public VendorAttachment setAttachmentType(int attachmentType) {
        this.attachmentType = attachmentType;
        return this;
    }
    
    
}
