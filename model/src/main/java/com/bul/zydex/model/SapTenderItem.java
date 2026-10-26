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
public class SapTenderItem {
    
    private int id;
    private String itemCode;
    private String itemDesc;
    private String category;
    private String location;
    private String type;
    private String uom;
    private String qty;
    private String deliSch;
    private String deliSchDate;
    private String tenderNo;
    private String purNo;
    private String itemNo;
    private String srNo;
    private String prNo;
    
    public SapTenderItem() {
    }
    
    public SapTenderItem(int id, String itemCode, String itemDesc, String category, String location, String type, String uom, String qty, String deliSch, String deliSchDate, String tenderNo, String purNo, String itemNo, String srNo, String prNo) {
        this.id = id;
        this.itemCode = itemCode;
        this.itemDesc = itemDesc;
        this.category = category;
        this.location = location;
        this.type = type;
        this.uom = uom;
        this.qty = qty;
        this.deliSch = deliSch;
        this.deliSchDate = deliSchDate;
        this.tenderNo = tenderNo;
        this.purNo = purNo;
        this.itemNo = itemNo;
        this.srNo = srNo;
        this.prNo = prNo;
    }

    public int getId() {
        return id;
    }

    public SapTenderItem setId(int id) {
        this.id = id;
        return this;
    }

    public String getItemCode() {
        return itemCode;
    }

    public SapTenderItem setItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public SapTenderItem setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public SapTenderItem setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public SapTenderItem setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getType() {
        return type;
    }

    public SapTenderItem setType(String type) {
        this.type = type;
        return this;
    }

    public String getUom() {
        return uom;
    }

    public SapTenderItem setUom(String uom) {
        this.uom = uom;
        return this;
    }

    public String getQty() {
        return qty;
    }

    public SapTenderItem setQty(String qty) {
        this.qty = qty;
        return this;
    }

    public String getDeliSch() {
        return deliSch;
    }

    public SapTenderItem setDeliSch(String deliSch) {
        this.deliSch = deliSch;
        return this;
    }

    public String getDeliSchDate() {
        return deliSchDate;
    }

    public SapTenderItem setDeliSchDate(String deliSchDate) {
        this.deliSchDate = deliSchDate;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public SapTenderItem setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getPurNo() {
        return purNo;
    }

    public SapTenderItem setPurNo(String purNo) {
        this.purNo = purNo;
        return this;
    }

    public String getItemNo() {
        return itemNo;
    }

    public SapTenderItem setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public SapTenderItem setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    public String getPrNo() {
        return prNo;
    }

    public SapTenderItem setPrNo(String prNo) {
        this.prNo = prNo;
        return this;
    }
    
    
    
}
