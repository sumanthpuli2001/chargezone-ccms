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
public class CommMaster {
    
    private int id;
    private String vendorCode;
    private String tenderNo;
    private String subject;
    private String msg;
    private String isread;
    private String msgdatetime;
    private String userId;
    private String idAdmin;
    private String isintendor;
    
    public CommMaster() {
    }
    
    public CommMaster(int id, String vendorCode, String tenderNo, String subject, String msg, String isread, String msgdatetime, String userId, String idAdmin, String isintendor) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.tenderNo = tenderNo;
        this.subject = subject;
        this.msg = msg;
        this.isread = isread;
        this.msgdatetime = msgdatetime;
        this.userId = userId;
        this.idAdmin = idAdmin;
        this.isintendor = isintendor;
    }

    public int getId() {
        return id;
    }

    public CommMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public CommMaster setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public CommMaster setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public CommMaster setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CommMaster setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getIsread() {
        return isread;
    }

    public CommMaster setIsread(String isread) {
        this.isread = isread;
        return this;
    }

    public String getMsgdatetime() {
        return msgdatetime;
    }

    public CommMaster setMsgdatetime(String msgdatetime) {
        this.msgdatetime = msgdatetime;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public CommMaster setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public CommMaster setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
        return this;
    }

    public String getIsintendor() {
        return isintendor;
    }

    public CommMaster setIsintendor(String isintendor) {
        this.isintendor = isintendor;
        return this;
    }
    
    
}
