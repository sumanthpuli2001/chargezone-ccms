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
public class AuctionItemMaster {
    
    private int id;
    private String auctionNo;
    private String srNo;
    private String itemCode;
    private String itemName;
    private String itemDesc;
    private String itemRemark;
    private String uom;
    private String qty;
    
    public AuctionItemMaster() {
    }
    
    public AuctionItemMaster(int id, String auctionNo, String srNo, String itemCode, String itemName, String itemDesc, String itemRemark, String uom, String qty) {
        
        this.id = id;
        this.auctionNo = auctionNo;
        this.srNo = srNo;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemRemark = itemRemark;
        this.uom = uom;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public AuctionItemMaster setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionItemMaster setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public AuctionItemMaster setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public AuctionItemMaster setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public AuctionItemMaster setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public AuctionItemMaster setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
        return this;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public AuctionItemMaster setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public AuctionItemMaster setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public AuctionItemMaster setQty(String qty) {
        this.qty = qty;
        return this;
    }
    
    
}
