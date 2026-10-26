/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Bulwark-5
 */
public class ReviseVendorTechnicalBid {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String technicalDeviation;
    private String technicalRemark;
    private String dateTime;

    public ReviseVendorTechnicalBid() {
    }

    public ReviseVendorTechnicalBid(int id, String refNo, String vendorCode, String technicalDeviation, String technicalRemark, String dateTime) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.technicalDeviation = technicalDeviation;
        this.technicalRemark = technicalRemark;
        this.dateTime = dateTime;
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

    public String getTechnicalDeviation() {
        return technicalDeviation;
    }

    public void setTechnicalDeviation(String technicalDeviation) {
        this.technicalDeviation = technicalDeviation;
    }

    public String getTechnicalRemark() {
        return technicalRemark;
    }

    public void setTechnicalRemark(String technicalRemark) {
        this.technicalRemark = technicalRemark;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    
    
}
