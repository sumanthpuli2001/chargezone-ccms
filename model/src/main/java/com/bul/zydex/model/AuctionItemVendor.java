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
public class AuctionItemVendor {

    private int id;
    private String auctionNo;
    private String vendorCode;
    private String vendorName;
    private String contactName;
    private String emailId;
    private String mobileNo;
    private String address;
    private String currency;
    private String currencyConversion;
    private String vendorBasicStartPrice;
    private String loadingFactorPer;
    private String loadingFactorVal;
    private String finalPrice;
    private int auctionItemMasterId;

    public AuctionItemVendor() {
    }

    public AuctionItemVendor(int id, String auctionNo, String vendorCode, String vendorName, String contactName, String emailId, String mobileNo, String address, String currency, String currencyConversion, String vendorBasicStartPrice, String loadingFactorPer, String loadingFactorVal, String finalPrice, int auctionItemMasterId) {

        this.id = id;
        this.auctionNo = auctionNo;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.contactName = contactName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.address = address;
        this.currency = currency;
        this.currencyConversion = currencyConversion;
        this.vendorBasicStartPrice = vendorBasicStartPrice;
        this.loadingFactorPer = loadingFactorPer;
        this.loadingFactorVal = loadingFactorVal;
        this.finalPrice = finalPrice;
        this.auctionItemMasterId = auctionItemMasterId;
    }

    public int getId() {
        return id;
    }

    public AuctionItemVendor setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionItemVendor setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public AuctionItemVendor setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getVendorName() {
        return vendorName;
    }

    public AuctionItemVendor setVendorName(String vendorName) {
        this.vendorName = vendorName;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public AuctionItemVendor setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public AuctionItemVendor setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public AuctionItemVendor setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AuctionItemVendor setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public AuctionItemVendor setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrencyConversion() {
        return currencyConversion;
    }

    public AuctionItemVendor setCurrencyConversion(String currencyConversion) {
        this.currencyConversion = currencyConversion;
        return this;
    }

    public String getVendorBasicStartPrice() {
        return vendorBasicStartPrice;
    }

    public AuctionItemVendor setVendorBasicStartPrice(String vendorBasicStartPrice) {
        this.vendorBasicStartPrice = vendorBasicStartPrice;
        return this;
    }

    public String getLoadingFactorPer() {
        return loadingFactorPer;
    }

    public AuctionItemVendor setLoadingFactorPer(String loadingFactorPer) {
        this.loadingFactorPer = loadingFactorPer;
        return this;
    }

    public String getLoadingFactorVal() {
        return loadingFactorVal;
    }

    public AuctionItemVendor setLoadingFactorVal(String loadingFactorVal) {
        this.loadingFactorVal = loadingFactorVal;
        return this;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public AuctionItemVendor setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public int getAuctionItemMasterId() {
        return auctionItemMasterId;
    }

    public void setAuctionItemMasterId(int auctionItemMasterId) {
        this.auctionItemMasterId = auctionItemMasterId;
    }

 
}
