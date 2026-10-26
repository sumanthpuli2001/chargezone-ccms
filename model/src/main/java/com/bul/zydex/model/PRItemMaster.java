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
public class PRItemMaster {

    private int id;
    private String prNo;
    private String itemCode;
    private String itemDescription;
    private String remark;
    private String uom;
    private String qty;

    private String deliveryScheduleDate;
    private String deliveryScheduleQty;
    private String location;
    private String purNo;
    private String itemNo;
    private String srNo;
    private int itemType;

    private String accountAssigmentCategory;
    private String accountAssigmentValue;
    private String productType;
    private String productGroup;
    private String taxCode;
    private String valuationPrice;
    private String deliveryDate;
    private String startDate;
    private String endDate;

    public PRItemMaster() {
    }

    public PRItemMaster(int id, String prNo, String itemCode, String itemDescription, String remark, String uom, String qty, String deliveryScheduleDate, String deliveryScheduleQty, String location, String purNo, String itemNo, String srNo, int itemType, String accountAssigmentCategory, String accountAssigmentValue, String productType, String productGroup, String taxCode, String valuationPrice, String deliveryDate, String startDate, String endDate) {
	this.id = id;
	this.prNo = prNo;
	this.itemCode = itemCode;
	this.itemDescription = itemDescription;
	this.remark = remark;
	this.uom = uom;
	this.qty = qty;
	this.deliveryScheduleDate = deliveryScheduleDate;
	this.deliveryScheduleQty = deliveryScheduleQty;
	this.location = location;
	this.purNo = purNo;
	this.itemNo = itemNo;
	this.srNo = srNo;
	this.itemType = itemType;
	this.accountAssigmentCategory = accountAssigmentCategory;
	this.accountAssigmentValue = accountAssigmentValue;
	this.productType = productType;
	this.productGroup = productGroup;
	this.taxCode = taxCode;
	this.valuationPrice = valuationPrice;
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

    public String getPrNo() {
	return prNo;
    }

    public void setPrNo(String prNo) {
	this.prNo = prNo;
    }

    public String getItemCode() {
	return itemCode;
    }

    public void setItemCode(String itemCode) {
	this.itemCode = itemCode;
    }

    public String getItemDescription() {
	return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
    }

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
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

    public String getDeliveryScheduleDate() {
	return deliveryScheduleDate;
    }

    public void setDeliveryScheduleDate(String deliveryScheduleDate) {
	this.deliveryScheduleDate = deliveryScheduleDate;
    }

    public String getDeliveryScheduleQty() {
	return deliveryScheduleQty;
    }

    public void setDeliveryScheduleQty(String deliveryScheduleQty) {
	this.deliveryScheduleQty = deliveryScheduleQty;
    }

    public String getLocation() {
	return location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getPurNo() {
	return purNo;
    }

    public void setPurNo(String purNo) {
	this.purNo = purNo;
    }

    public String getItemNo() {
	return itemNo;
    }

    public void setItemNo(String itemNo) {
	this.itemNo = itemNo;
    }

    public String getSrNo() {
	return srNo;
    }

    public void setSrNo(String srNo) {
	this.srNo = srNo;
    }

    public int getItemType() {
	return itemType;
    }

    public void setItemType(int itemType) {
	this.itemType = itemType;
    }

    public String getAccountAssigmentCategory() {
	return accountAssigmentCategory;
    }

    public void setAccountAssigmentCategory(String accountAssigmentCategory) {
	this.accountAssigmentCategory = accountAssigmentCategory;
    }

    public String getAccountAssigmentValue() {
	return accountAssigmentValue;
    }

    public void setAccountAssigmentValue(String accountAssigmentValue) {
	this.accountAssigmentValue = accountAssigmentValue;
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

    public String getValuationPrice() {
	return valuationPrice;
    }

    public void setValuationPrice(String valuationPrice) {
	this.valuationPrice = valuationPrice;
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
