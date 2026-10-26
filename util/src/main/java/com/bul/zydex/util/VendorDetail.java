/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

/**
 *
 * @author admin
 */
public class VendorDetail {

    private int id;
    private String refNo;
    private String vendorCode;
    private String vendorName;
    private String vendorAddress;
    private String vendorEmail;
    private String vendorMobile;
    private String bidTotal;
    private String regret;
    private String attachment;
    
    public VendorDetail() {
    }
    
    public VendorDetail(int id, String refNo, String vendorCode, String vendorName, String vendorAddress, String vendorEmail, String vendorMobile, String bidTotal, String regret, String attachment) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorEmail = vendorEmail;
        this.vendorMobile = vendorMobile;
        this.bidTotal = bidTotal;
        this.regret = regret;
        this.attachment = attachment;
    }

    public int getId() {
        return id;
    }

    public VendorDetail setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorDetail setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorDetail setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public VendorDetail setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public VendorDetail setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
        return this;
    }

    public String getVendorEmail() {
        return vendorEmail;
    }

    public VendorDetail setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
        return this;
    }

    public String getVendorMobile() {
        return vendorMobile;
    }

    public VendorDetail setVendorMobile(String vendorMobile) {
        this.vendorMobile = vendorMobile;
        return this;
    }

    public String getBidTotal() {
        return bidTotal;
    }

    public VendorDetail setBidTotal(String bidTotal) {
        this.bidTotal = bidTotal;
        return this;
    }

    public String getRegret() {
        return regret;
    }

    public VendorDetail setRegret(String regret) {
        this.regret = regret;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorDetail setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }
    
    
}
