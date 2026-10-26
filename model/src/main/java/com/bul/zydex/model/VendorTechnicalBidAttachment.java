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
public class VendorTechnicalBidAttachment {
 
    private int id;
    private String refNo;
    private String vendorCode;
    private String description;
    private String attachmentRequired;
    private String attachment;
    
    private String document;
    private int venderResponse;
    private String remark;
    private Integer buyerResponse;
    private String buyerRemark;
            
    public VendorTechnicalBidAttachment() {
    }

    public VendorTechnicalBidAttachment(int id, String refNo, String vendorCode, String description, String attachmentRequired, String attachment, String document, int venderResponse, String remark, Integer buyerResponse, String buyerRemark) {
        this.id = id;
        this.refNo = refNo;
        this.vendorCode = vendorCode;
        this.description = description;
        this.attachmentRequired = attachmentRequired;
        this.attachment = attachment;
        this.document = document;
        this.venderResponse = venderResponse;
        this.remark = remark;
        this.buyerResponse = buyerResponse;
        this.buyerRemark = buyerRemark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachmentRequired() {
        return attachmentRequired;
    }

    public void setAttachmentRequired(String attachmentRequired) {
        this.attachmentRequired = attachmentRequired;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public int getVenderResponse() {
        return venderResponse;
    }

    public void setVenderResponse(int venderResponse) {
        this.venderResponse = venderResponse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBuyerResponse() {
        return buyerResponse;
    }

    public void setBuyerResponse(Integer buyerResponse) {
        this.buyerResponse = buyerResponse;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

   
    
}
