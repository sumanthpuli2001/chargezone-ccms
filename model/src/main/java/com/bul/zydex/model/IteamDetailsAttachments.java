/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Sumanth
 */
public class IteamDetailsAttachments {

    private int id;
    private String sno;
    private String iteamCode;
    private String iteamDescription;
    private String purpose;
    private String make;
    private String uom;
    private String qty;
    private int flagStatus;
    private int deliverableMultiId;
    private String accountCategory;
    private String accountValue;
    private String productType;
    private String productGroup;
    private String taxCode;
    private String price;
    private String deliveryDate;
    private String startDate;
    private String endDate;
    

    public IteamDetailsAttachments() {
    }

    public IteamDetailsAttachments(int id, String sno, String iteamCode, String iteamDescription, String purpose, String make, String uom, String qty, int flagStatus, int deliverableMultiId, String accountCategory, String accountValue, String productType, String productGroup, String taxCode, String price, String deliveryDate, String startDate, String endDate) {
        this.id = id;
        this.sno = sno;
        this.iteamCode = iteamCode;
        this.iteamDescription = iteamDescription;
        this.purpose = purpose;
        this.make = make;
        this.uom = uom;
        this.qty = qty;
        this.flagStatus = flagStatus;
        this.deliverableMultiId = deliverableMultiId;
        this.accountCategory = accountCategory;
        this.accountValue = accountValue;
        this.productType = productType;
        this.productGroup = productGroup;
        this.taxCode = taxCode;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

 

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getSno() {
	return sno;
    }

    public void setSno(String sno) {
	this.sno = sno;
    }

    public String getIteamCode() {
	return iteamCode;
    }

    public void setIteamCode(String iteamCode) {
	this.iteamCode = iteamCode;
    }

    public String getIteamDescription() {
	return iteamDescription;
    }

    public void setIteamDescription(String iteamDescription) {
	this.iteamDescription = iteamDescription;
    }

    public String getPurpose() {
	return purpose;
    }

    public void setPurpose(String purpose) {
	this.purpose = purpose;
    }

    public String getMake() {
	return make;
    }

    public void setMake(String make) {
	this.make = make;
    }

    public String getUom() {
	return uom;
    }

    public void setUom(String uom) {
	this.uom = uom;
    }

    public String getQty() {
	return qty;
    }

    public void setQty(String qty) {
	this.qty = qty;
    }

    public int getFlagStatus() {
	return flagStatus;
    }

    public void setFlagStatus(int flagStatus) {
	this.flagStatus = flagStatus;
    }

    public int getDeliverableMultiId() {
	return deliverableMultiId;
    }

    public void setDeliverableMultiId(int deliverableMultiId) {
	this.deliverableMultiId = deliverableMultiId;
    }

    public String getAccountCategory() {
        return accountCategory;
    }

    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    public String getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(String accountValue) {
        this.accountValue = accountValue;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }









}
