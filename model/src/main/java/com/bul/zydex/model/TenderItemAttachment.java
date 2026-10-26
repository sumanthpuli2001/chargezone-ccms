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
public class TenderItemAttachment {
    
    private int id;
    private String refNo;
    private String purNo;
    private String itemNo;
    private String attachment;
    
    public TenderItemAttachment() {
    }

    public TenderItemAttachment(int id, String refNo, String purNo, String itemNo, String attachment) {
        this.id = id;
        this.refNo = refNo;
        this.purNo = purNo;
        this.itemNo = itemNo;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public TenderItemAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderItemAttachment setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getPurNo() {
        return purNo;
    }

    public TenderItemAttachment setPurNo(String purNo) {
        this.purNo = purNo;
        return this;
    }

    public String getItemNo() {
        return itemNo;
    }

    public TenderItemAttachment setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public TenderItemAttachment setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }
    
    
}
