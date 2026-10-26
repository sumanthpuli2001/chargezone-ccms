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
public class VendorEmd {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String emdDate;
    private String emdAmount;
    private String draweeBank;
    private String attachment;
    private String cashCheque;
    private String chequeNo;
    
    public VendorEmd() {
    }

    public VendorEmd(int id, String refNo, String vendorCode, String emdDate, String emdAmount, String draweeBank, String attachment, String cashCheque, String chequeNo) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.emdDate = emdDate;
        this.emdAmount = emdAmount;
        this.draweeBank = draweeBank;
        this.attachment = attachment;
        this.cashCheque = cashCheque;
        this.chequeNo = chequeNo;
    }

    public int getId() {
        return id;
    }

    public VendorEmd setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorEmd setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorEmd setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getEmdDate() {
        return emdDate;
    }

    public VendorEmd setEmdDate(String emdDate) {
        this.emdDate = emdDate;
        return this;
    }

    public String getEmdAmount() {
        return emdAmount;
    }

    public VendorEmd setEmdAmount(String emdAmount) {
        this.emdAmount = emdAmount;
        return this;
    }

    public String getDraweeBank() {
        return draweeBank;
    }

    public VendorEmd setDraweeBank(String draweeBank) {
        this.draweeBank = draweeBank;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorEmd setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public String getCashCheque() {
        return cashCheque;
    }

    public VendorEmd setCashCheque(String cashCheque) {
        this.cashCheque = cashCheque;
        return this;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public VendorEmd setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
        return this;
    }

    public VendorEmd readByVendorRefNo(String refNo, String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
