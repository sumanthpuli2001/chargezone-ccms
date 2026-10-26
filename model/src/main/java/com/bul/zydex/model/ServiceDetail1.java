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
public class ServiceDetail1 {
    
    private int id;
    private String srNo;
    private String uom;
    private String itemDesc;
    private String qty;
    private String remark;
    private String tenderNo;
    private String fileName;
    private String refNo;
    
    public ServiceDetail1() {
    }
    
    public ServiceDetail1(int id, String srNo, String uom, String itemDesc, String qty, String remark, String tenderNo, String fileName, String refNo) {
        this.id = id;
        this.srNo = srNo;
        this.uom = uom;
        this.itemDesc = itemDesc;
        this.qty = qty;
        this.remark = remark;
        this.tenderNo = tenderNo;
        this.fileName = fileName;
        this.refNo = refNo;
    }

    public int getId() {
        return id;
    }

    public ServiceDetail1 setId(int id) {
        this.id = id;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public ServiceDetail1 setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public ServiceDetail1 setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public ServiceDetail1 setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public ServiceDetail1 setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ServiceDetail1 setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public ServiceDetail1 setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ServiceDetail1 setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public ServiceDetail1 setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }
    
    
}
