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
public class SapDeliSch {
    
    private int id;
    private String rfqNo;
    private String itemNumber;
    private String materialNumber;
    private String materialShortText;
    private String purchaseOrderQty;
    private String itemDeliDate;
    private String stageDate;
    
    public SapDeliSch() {
    }
    
    public SapDeliSch(int id, String rfqNo,String itemNumber,String materialNumber,String materialShortText,String purchaseOrderQty, String itemDeliDate, String stageDate) {
        this.id = id;
        this.rfqNo = rfqNo;
        this.itemNumber = itemNumber;
        this.materialNumber = materialNumber;
        this.materialShortText = materialShortText;
        this.purchaseOrderQty = purchaseOrderQty;
        this.itemDeliDate = itemDeliDate;
        this.stageDate = stageDate;
    }

    public int getId() {
        return id;
    }

    public SapDeliSch setId(int id) {
        this.id = id;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public SapDeliSch setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public SapDeliSch setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public SapDeliSch setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
        return this;
    }

    public String getMaterialShortText() {
        return materialShortText;
    }

    public SapDeliSch setMaterialShortText(String materialShortText) {
        this.materialShortText = materialShortText;
        return this;
    }

    public String getPurchaseOrderQty() {
        return purchaseOrderQty;
    }

    public SapDeliSch setPurchaseOrderQty(String purchaseOrderQty) {
        this.purchaseOrderQty = purchaseOrderQty;
        return this;
    }

    public String getItemDeliDate() {
        return itemDeliDate;
    }

    public SapDeliSch setItemDeliDate(String itemDeliDate) {
        this.itemDeliDate = itemDeliDate;
        return this;
    }

    public String getStageDate() {
        return stageDate;
    }

    public SapDeliSch setStageDate(String stageDate) {
        this.stageDate = stageDate;
        return this;
    }
    
    
    
}
