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
public class TenderRegret {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private int flag;
    private String remark;
    
    
    public TenderRegret() {
    }

    public TenderRegret(int id, String refNo, String vendorCode, int flag, String remark) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.flag = flag;
        this.remark = remark;
        
    }

    public int getId() {
        return id;
    }

    public TenderRegret setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public TenderRegret setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public TenderRegret setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public int getFlag() {
        return flag;
    }

    public TenderRegret setFlag(int flag) {
        this.flag = flag;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public TenderRegret setRemark(String remark) {
        this.remark = remark;
        return this;
    }
    
    
}
