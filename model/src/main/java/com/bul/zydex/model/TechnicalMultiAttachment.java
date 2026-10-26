/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Administrator
 */
public class TechnicalMultiAttachment {

    private int id;
    private String refNo;
    private String vendorCode;
    private String attachment;
    private String dateTime;
    private String technicalPersonName;

    public TechnicalMultiAttachment() {
    }

    public TechnicalMultiAttachment(int id, String refNo, String vendorCode, String attachment, String dateTime, String technicalPersonName) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.attachment = attachment;
        this.dateTime = dateTime;
        this.technicalPersonName = technicalPersonName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTechnicalPersonName() {
        return technicalPersonName;
    }

    public void setTechnicalPersonName(String technicalPersonName) {
        this.technicalPersonName = technicalPersonName;
    }

}
