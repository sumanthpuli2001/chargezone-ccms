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
public class AuthTenderItemMaster {
    
    private int id;
    private String refNo;
    private String itemCode;
    private String itemDescription;
    private String remark;
    private String uom;
    private String qty;
    private String attachmentRequired;
    private String deliveryScheduleDate;
    private String deliveryScheduleQty;
    private String location;
    private String purNo;
    private String itemNo;
    private String srNo;
    
    public AuthTenderItemMaster() {
    }

    public AuthTenderItemMaster(int id, String refNo, String itemCode, String itemDescription, String remark, String uom, String qty, String attachmentRequired, String deliveryScheduleDate, String deliveryScheduleQty, String location, String purNo, String itemNo, String srNo) {
        this.id = id;
        this.refNo = refNo;
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.remark = remark;
        this.uom = uom;
        this.qty = qty;
        this.attachmentRequired = attachmentRequired;
        this.deliveryScheduleDate = deliveryScheduleDate;
        this.deliveryScheduleQty = deliveryScheduleQty;
        this.location = location;
        this.purNo = purNo;
        this.itemNo = itemNo;
        this.srNo = srNo;
    }

    public int getId() {
        return id;
    }

    public AuthTenderItemMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public AuthTenderItemMaster setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public AuthTenderItemMaster setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public AuthTenderItemMaster setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public AuthTenderItemMaster setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public AuthTenderItemMaster setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public AuthTenderItemMaster setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getAttachmentRequired() {
        return attachmentRequired;
    }

    public AuthTenderItemMaster setAttachmentRequired(String attachmentRequired) {
        this.attachmentRequired = attachmentRequired;
        return this;
    }

    public String getDeliveryScheduleDate() {
        return deliveryScheduleDate;
    }

    public AuthTenderItemMaster setDeliveryScheduleDate(String deliveryScheduleDate) {
        this.deliveryScheduleDate = deliveryScheduleDate;
        return this;
    }

    public String getDeliveryScheduleQty() {
        return deliveryScheduleQty;
    }

    public AuthTenderItemMaster setDeliveryScheduleQty(String deliveryScheduleQty) {
        this.deliveryScheduleQty = deliveryScheduleQty;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public AuthTenderItemMaster setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getPurNo() {
        return purNo;
    }

    public AuthTenderItemMaster setPurNo(String purNo) {
        this.purNo = purNo;
        return this;
    }

    public String getItemNo() {
        return itemNo;
    }

    public AuthTenderItemMaster setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public AuthTenderItemMaster setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }
    
    
    
}
