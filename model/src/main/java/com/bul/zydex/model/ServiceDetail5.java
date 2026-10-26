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
public class ServiceDetail5 {
    
    private int id;
    private String tenderNo;
    private String fileName;
    private String srNo;
    private String uom;
    private String itemDesc;
    private String qty;
    private String remark;
    private int headerNonheader;
    private String srNo1;
    private String refNo;
    
    public ServiceDetail5() {
    }
    
    public ServiceDetail5(int id, String tenderNo, String fileName, String srNo, String uom, String itemDesc, String qty, String remark, int headerNonheader, String srNo1, String refNo) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.fileName = fileName;
        this.srNo = srNo;
        this.uom = uom;
        this.itemDesc = itemDesc;
        this.qty = qty;
        this.remark = remark;
        this.headerNonheader = headerNonheader;
        this.srNo1  = srNo1;
        this.refNo = refNo;
    }

    public int getId() {
        return id;
    }

    public ServiceDetail5 setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public ServiceDetail5 setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ServiceDetail5 setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public ServiceDetail5 setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public ServiceDetail5 setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public ServiceDetail5 setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public ServiceDetail5 setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ServiceDetail5 setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public int getHeaderNonheader() {
        return headerNonheader;
    }

    public ServiceDetail5 setHeaderNonheader(int headerNonheader) {
        this.headerNonheader = headerNonheader;
        return this;
    }

    public String getSrNo1() {
        return srNo1;
    }

    public ServiceDetail5 setSrNo1(String srNo1) {
        this.srNo1 = srNo1;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public ServiceDetail5 setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }
    
    
}
