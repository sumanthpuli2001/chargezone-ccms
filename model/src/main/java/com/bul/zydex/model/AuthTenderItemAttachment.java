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
public class AuthTenderItemAttachment {
    
    private int id;
    private String refNo;
    private String purNo;
    private String itemNo;
    private String attachment;
    
    public AuthTenderItemAttachment() {
    }

    public AuthTenderItemAttachment(int id, String refNo, String purNo, String itemNo, String attachment) {
        this.id = id;
        this.refNo = refNo;
        this.purNo = purNo;
        this.itemNo = itemNo;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public AuthTenderItemAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderItemAttachment setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getPurNo() {
        return purNo;
    }

    public AuthTenderItemAttachment setPurNo(String purNo) {
        this.purNo = purNo;
        return this;
    }

    public String getItemNo() {
        return itemNo;
    }

    public AuthTenderItemAttachment setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public AuthTenderItemAttachment setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }
    
}
