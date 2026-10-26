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
public class ServiceVendorTenderBid {
    
    private int id;
    private String tenderNo;
    private String vendorCode;
    private String fileName;
    private String itemTotal;
    private String selectCommon;
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
    private String grandTotal;
    private String otherRemark;
    private String currency;
    private String currencyRate;
    private String srNo;
        
            
    public ServiceVendorTenderBid() {
    }
    
    public ServiceVendorTenderBid(int id, String tenderNo, String vendorCode, String fileName, String itemTotal, String selectCommon, String discountType, String discountValue, String packingType, String packingValue, String freightType, String freightValue, String errectionValue, String chargesValue, String igstValue, String cgstValue, String sgstValue, String insuranceValue, String grandTotal, String otherRemark, String currency, String currencyRate, String srNo) {
        this.id = id;
        this.tenderNo = tenderNo;
        this.vendorCode = vendorCode;
        this.fileName = fileName;
        this.itemTotal = itemTotal;
        this.selectCommon = selectCommon;
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
        this.grandTotal = grandTotal;
        this.otherRemark = otherRemark;
        this.currency = currency;
        this.currencyRate = currencyRate;
        this.srNo = srNo;
        
    }

    public int getId() {
        return id;
    }

    public ServiceVendorTenderBid setId(int id) {
        this.id = id;
        return this;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public ServiceVendorTenderBid setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public ServiceVendorTenderBid setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public ServiceVendorTenderBid setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public ServiceVendorTenderBid setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
        return this;
    }

    public String getSelectCommon() {
        return selectCommon;
    }

    public ServiceVendorTenderBid setSelectCommon(String selectCommon) {
        this.selectCommon = selectCommon;
        return this;
    }

    public String getDiscountType() {
        return discountType;
    }

    public ServiceVendorTenderBid setDiscountType(String discountType) {
        this.discountType = discountType;
        return this;
    }

    public String getDiscountValue() {
        return discountValue;
    }

    public ServiceVendorTenderBid setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
        return this;
    }

    public String getPackingType() {
        return packingType;
    }

    public ServiceVendorTenderBid setPackingType(String packingType) {
        this.packingType = packingType;
        return this;
    }

    public String getPackingValue() {
        return packingValue;
    }

    public ServiceVendorTenderBid setPackingValue(String packingValue) {
        this.packingValue = packingValue;
        return this;
    }

    public String getFreightType() {
        return freightType;
    }

    public ServiceVendorTenderBid setFreightType(String freightType) {
        this.freightType = freightType;
        return this;
    }

    public String getFreightValue() {
        return freightValue;
    }

    public ServiceVendorTenderBid setFreightValue(String freightValue) {
        this.freightValue = freightValue;
        return this;
    }

    public String getErrectionValue() {
        return errectionValue;
    }

    public ServiceVendorTenderBid setErrectionValue(String errectionValue) {
        this.errectionValue = errectionValue;
        return this;
    }

    public String getChargesValue() {
        return chargesValue;
    }

    public ServiceVendorTenderBid setChargesValue(String chargesValue) {
        this.chargesValue = chargesValue;
        return this;
    }

    public String getIgstValue() {
        return igstValue;
    }

    public ServiceVendorTenderBid setIgstValue(String igstValue) {
        this.igstValue = igstValue;
        return this;
    }

    public String getCgstValue() {
        return cgstValue;
    }

    public ServiceVendorTenderBid setCgstValue(String cgstValue) {
        this.cgstValue = cgstValue;
        return this;
    }

    public String getSgstValue() {
        return sgstValue;
    }

    public ServiceVendorTenderBid setSgstValue(String sgstValue) {
        this.sgstValue = sgstValue;
        return this;
    }

    public String getInsuranceValue() {
        return insuranceValue;
    }

    public ServiceVendorTenderBid setInsuranceValue(String insuranceValue) {
        this.insuranceValue = insuranceValue;
        return this;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public ServiceVendorTenderBid setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
        return this;
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public ServiceVendorTenderBid setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public ServiceVendorTenderBid setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public ServiceVendorTenderBid setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
        return this;
    }

    public String getSrNo() {
        return srNo;
    }

    public ServiceVendorTenderBid setSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }
    
    
}
