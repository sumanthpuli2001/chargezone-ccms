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
public class SapTenderMaster {
    
    private int id;
    private int tenderNo;
    private String vendorCode;
    private String collectionLastDate;
    private String rfqNo;
    private String prNo;
    
    public SapTenderMaster() {
    }
    
    public SapTenderMaster(int id, int tenderNo, String vendorCode, String collectionLastDate, String rfqNo, String prNo) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.vendorCode = vendorCode;
        this.collectionLastDate = collectionLastDate;
        this.rfqNo = rfqNo;
        this.prNo = prNo;
    }

    public int getId() {
        return id;
    }

    public SapTenderMaster setId(int id) {
        this.id = id;
        return this;
    }

    public int getTenderNo() {
        return tenderNo;
    }

    public SapTenderMaster setTenderNo(int tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public SapTenderMaster setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getCollectionLastDate() {
        return collectionLastDate;
    }

    public SapTenderMaster setCollectionLastDate(String collectionLastDate) {
        this.collectionLastDate = collectionLastDate;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public SapTenderMaster setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }

    public String getPrNo() {
        return prNo;
    }

    public SapTenderMaster setPrNo(String prNo) {
        this.prNo = prNo;
        return this;
    }
    
    
    
}
