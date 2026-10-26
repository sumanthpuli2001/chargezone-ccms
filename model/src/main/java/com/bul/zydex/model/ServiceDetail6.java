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
public class ServiceDetail6 {
    
    private int id;
    private String tenderNo;
    private String fileName;
    private String srNo;
    private String pcType;
    private String itemDescription;
    private String uom;
    private int qty;
    private int amcRequiredDays;
    private String refNo;
    
    public ServiceDetail6() {
    }
    
    public ServiceDetail6(int id, String tenderNo, String fileName, String srNo , String pcType, String itemDescription, String uom, int qty, int amcRequiredDays, String refNo) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.fileName = fileName;
        this.srNo = srNo;
        this.pcType = pcType;
        this.itemDescription = itemDescription;
        this.uom = uom;
        this.qty = qty;
        this.amcRequiredDays = amcRequiredDays;
        this.refNo = refNo;
    }

    public int getId() {
        return id;
    }

    public ServiceDetail6 setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public ServiceDetail6 setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ServiceDetail6 setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public ServiceDetail6 setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getPcType() {
        return pcType;
    }

    public ServiceDetail6 setPcType(String pcType) {
        this.pcType = pcType;
        return this;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public ServiceDetail6 setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public ServiceDetail6 setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public int getQty() {
        return qty;
    }

    public ServiceDetail6 setQty(int qty) {
        this.qty = qty;
        return this;
    }

    public int getAmcRequiredDays() {
        return amcRequiredDays;
    }

    public ServiceDetail6 setAmcRequiredDays(int amcRequiredDays) {
        this.amcRequiredDays = amcRequiredDays;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public ServiceDetail6 setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }
    
    
}
