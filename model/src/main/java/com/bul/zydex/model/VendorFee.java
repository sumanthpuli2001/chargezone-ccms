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
public class VendorFee {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String feeDate;
    private String feeAmount;
    private String draweeBank;
    private String attachment;
    private String chequeNo;
    
    public VendorFee() {
    }

    public VendorFee(int id, String refNo, String vendorCode, String feeDate, String feeAmount, String draweeBank, String attachment, String chequeNo) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.feeDate = feeDate;
        this.feeAmount = feeAmount;
        this.draweeBank = draweeBank;
        this.attachment = attachment;
        this.chequeNo = chequeNo;
    }

    public int getId() {
        return id;
    }

    public VendorFee setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorFee setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorFee setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getFeeDate() {
        return feeDate;
    }

    public VendorFee setFeeDate(String feeDate) {
        this.feeDate = feeDate;
        return this;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public VendorFee setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
        return this;
    }

    public String getDraweeBank() {
        return draweeBank;
    }

    public VendorFee setDraweeBank(String draweeBank) {
        this.draweeBank = draweeBank;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorFee setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public VendorFee setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
        return this;
    }

    public VendorFee readByVendorRefNo(String refNo, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
