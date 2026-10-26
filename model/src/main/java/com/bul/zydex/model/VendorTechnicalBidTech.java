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
public class VendorTechnicalBidTech {
    
    private int id;
    private String refNo;
    private String vendorCode;
    private String description;
    private String details;
    private String attachmentRequired;
    private int vendorResponse;
    private String remark;
    private String attachment;
    private String itemCode;
    private String uom;
    private String qty;
    private String srNo;
    private int buyerResponse;
    private String buyerRemark;
    private int reviseVendorTechnicalBidId;
            
    public VendorTechnicalBidTech() {
    }

    public VendorTechnicalBidTech(int id, String refNo, String vendorCode, String description, String details, String attachmentRequired, int vendorResponse, String remark, String attachment, String itemCode, String uom, String qty, String srNo, int buyerResponse, String buyerRemark, int reviseVendorTechnicalBidId) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.description = description;
        this.details = details;
        this.attachmentRequired = attachmentRequired;
        this.vendorResponse = vendorResponse;
        this.remark = remark;
        this.attachment = attachment;
        this.itemCode = itemCode;
        this.uom = uom;
        this.qty = qty;
        this.srNo = srNo;
        this.buyerResponse = buyerResponse;
        this.buyerRemark = buyerRemark;
        this.reviseVendorTechnicalBidId = reviseVendorTechnicalBidId;
    }

    public int getId() {
        return id;
    }

    public VendorTechnicalBidTech setId(int id) {
        this.id = id;
        return this;
    }

    public String getRefNo() {
        return refNo;
    }

    public VendorTechnicalBidTech setRefNo(String refNo) {
        this.refNo = refNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public VendorTechnicalBidTech setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VendorTechnicalBidTech setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public VendorTechnicalBidTech setDetails(String details) {
        this.details = details;
        return this;
    }

    public String getAttachmentRequired() {
        return attachmentRequired;
    }

    public VendorTechnicalBidTech setAttachmentRequired(String attachmentRequired) {
        this.attachmentRequired = attachmentRequired;
        return this;
    }

    public int getVendorResponse() {
        return vendorResponse;
    }

    public VendorTechnicalBidTech setVendorResponse(int vendorResponse) {
        this.vendorResponse = vendorResponse;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public VendorTechnicalBidTech setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public VendorTechnicalBidTech setAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public VendorTechnicalBidTech setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public VendorTechnicalBidTech setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public VendorTechnicalBidTech setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public VendorTechnicalBidTech setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public int getBuyerResponse() {
        return buyerResponse;
    }

    public VendorTechnicalBidTech setBuyerResponse(int buyerResponse) {
        this.buyerResponse = buyerResponse;
        return this;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public VendorTechnicalBidTech setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
        return this;
    }

    public int getReviseVendorTechnicalBidId() {
        return reviseVendorTechnicalBidId;
    }

    public VendorTechnicalBidTech setReviseVendorTechnicalBidId(int reviseVendorTechnicalBidId) {
        this.reviseVendorTechnicalBidId = reviseVendorTechnicalBidId;
        return this;
    }
    
    
}
