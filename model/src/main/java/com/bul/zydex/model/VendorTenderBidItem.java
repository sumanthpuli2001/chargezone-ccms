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
public class VendorTenderBidItem {

    private int id;
    private String refNo;
    private String vendorCode;
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
    private String rate;
    private String netRate;
    private String hsnNo;
    private String vendorRemark;
    private String discountType;
    private String discountValue;
    private String packingType;
    private String packingValue;
    private String freightType;
    private String freightValue;
    private String errectionValue;
    private String chargesValue;
    private String igstValue;
    private String cgstValue;
    private String sgstValue;
    private String insuranceValue;
    private String totalValue;
    private String itemRegret;
    private String srNo;
    private String prNo;
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

    public VendorTenderBidItem() {
    }

    public VendorTenderBidItem(int id, String refNo, String vendorCode, String itemCode, String itemDescription, String remark, String uom, String qty, String attachmentRequired, String deliveryScheduleDate, String deliveryScheduleQty, String location, String purNo, String itemNo, String rate, String netRate, String hsnNo, String vendorRemark, String discountType, String discountValue, String packingType, String packingValue, String freightType, String freightValue, String errectionValue, String chargesValue, String igstValue, String cgstValue, String sgstValue, String insuranceValue, String totalValue, String itemRegret, String srNo, String prNo, int itemType, String accountAssigmentCategory, String accountAssigmentValue, String productType, String productGroup, String taxCode, String valuationPrice, String deliveryDate, String startDate, String endDate) {
	this.id = id;
	this.refNo = refNo;
	this.vendorCode = vendorCode;
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
	this.rate = rate;
	this.netRate = netRate;
	this.hsnNo = hsnNo;
	this.vendorRemark = vendorRemark;
	this.discountType = discountType;
	this.discountValue = discountValue;
	this.packingType = packingType;
	this.packingValue = packingValue;
	this.freightType = freightType;
	this.freightValue = freightValue;
	this.errectionValue = errectionValue;
	this.chargesValue = chargesValue;
	this.igstValue = igstValue;
	this.cgstValue = cgstValue;
	this.sgstValue = sgstValue;
	this.insuranceValue = insuranceValue;
	this.totalValue = totalValue;
	this.itemRegret = itemRegret;
	this.srNo = srNo;
	this.prNo = prNo;
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

    public String getAttachmentRequired() {
	return attachmentRequired;
    }

    public void setAttachmentRequired(String attachmentRequired) {
	this.attachmentRequired = attachmentRequired;
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

    public String getRate() {
	return rate;
    }

    public void setRate(String rate) {
	this.rate = rate;
    }

    public String getNetRate() {
	return netRate;
    }

    public void setNetRate(String netRate) {
	this.netRate = netRate;
    }

    public String getHsnNo() {
	return hsnNo;
    }

    public void setHsnNo(String hsnNo) {
	this.hsnNo = hsnNo;
    }

    public String getVendorRemark() {
	return vendorRemark;
    }

    public void setVendorRemark(String vendorRemark) {
	this.vendorRemark = vendorRemark;
    }

    public String getDiscountType() {
	return discountType;
    }

    public void setDiscountType(String discountType) {
	this.discountType = discountType;
    }

    public String getDiscountValue() {
	return discountValue;
    }

    public void setDiscountValue(String discountValue) {
	this.discountValue = discountValue;
    }

    public String getPackingType() {
	return packingType;
    }

    public void setPackingType(String packingType) {
	this.packingType = packingType;
    }

    public String getPackingValue() {
	return packingValue;
    }

    public void setPackingValue(String packingValue) {
	this.packingValue = packingValue;
    }

    public String getFreightType() {
	return freightType;
    }

    public void setFreightType(String freightType) {
	this.freightType = freightType;
    }

    public String getFreightValue() {
	return freightValue;
    }

    public void setFreightValue(String freightValue) {
	this.freightValue = freightValue;
    }

    public String getErrectionValue() {
	return errectionValue;
    }

    public void setErrectionValue(String errectionValue) {
	this.errectionValue = errectionValue;
    }

    public String getChargesValue() {
	return chargesValue;
    }

    public void setChargesValue(String chargesValue) {
	this.chargesValue = chargesValue;
    }

    public String getIgstValue() {
	return igstValue;
    }

    public void setIgstValue(String igstValue) {
	this.igstValue = igstValue;
    }

    public String getCgstValue() {
	return cgstValue;
    }

    public void setCgstValue(String cgstValue) {
	this.cgstValue = cgstValue;
    }

    public String getSgstValue() {
	return sgstValue;
    }

    public void setSgstValue(String sgstValue) {
	this.sgstValue = sgstValue;
    }

    public String getInsuranceValue() {
	return insuranceValue;
    }

    public void setInsuranceValue(String insuranceValue) {
	this.insuranceValue = insuranceValue;
    }

    public String getTotalValue() {
	return totalValue;
    }

    public void setTotalValue(String totalValue) {
	this.totalValue = totalValue;
    }

    public String getItemRegret() {
	return itemRegret;
    }

    public void setItemRegret(String itemRegret) {
	this.itemRegret = itemRegret;
    }

    public String getSrNo() {
	return srNo;
    }

    public void setSrNo(String srNo) {
	this.srNo = srNo;
    }

    public String getPrNo() {
	return prNo;
    }

    public void setPrNo(String prNo) {
	this.prNo = prNo;
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
