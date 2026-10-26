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
public class CommMasterAttachment {
    
    private int id;
    private String vendorCode;
    private String tenderNo;
    private String subject;
    private String attachment;
    
    public CommMasterAttachment() {
    }
    
    public CommMasterAttachment(int id, String vendorCode, String tenderNo, String subject, String attachment) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.tenderNo = tenderNo;
        this.subject = subject;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public CommMasterAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public CommMasterAttachment setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public CommMasterAttachment setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CommMasterAttachment setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public CommMasterAttachment setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }
    
    
}
