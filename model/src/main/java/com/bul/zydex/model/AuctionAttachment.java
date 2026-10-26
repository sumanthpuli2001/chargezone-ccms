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
public class AuctionAttachment {
    
    private int id;
    private String auctionNo;
    private String attachmentDoc;
    private int attachmentType;
    private String rfqNo;
    
    public AuctionAttachment() {
    }
    
    public AuctionAttachment(int id, String auctionNo, String attachmentDoc, int attachmentType, String rfqNo) {
        
        this.id = id;
        this.auctionNo = auctionNo;    
        this.attachmentDoc = attachmentDoc;
        this.attachmentType = attachmentType;
        this.rfqNo = rfqNo;
    }

    public int getId() {
        return id;
    }

    public AuctionAttachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionAttachment setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getAttachmentDoc() {
        return attachmentDoc;
    }

    public AuctionAttachment setAttachmentDoc(String attachmentDoc) {
        this.attachmentDoc = attachmentDoc;
        return this;
    }

    public int getAttachmentType() {
        return attachmentType;
    }

    public AuctionAttachment setAttachmentType(int attachmentType) {
        this.attachmentType = attachmentType;
        return this;
    }

    public String getRfqNo() {
        return rfqNo;
    }

    public AuctionAttachment setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
        return this;
    }
    
    
}
