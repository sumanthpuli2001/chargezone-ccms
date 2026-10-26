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
public class AuctionItemVendorBidHistory {
    
    private int id;
    private String auctionNo;
    private String vendorCode;
    private String currency;
    private String currencyConversion;
    private String vendorBasicStartPrice;
    private String loadingFactorPer;
    private String loadingFactorVal;
    private String finalPrice;
    private String finalTotal;
    private String dateTime;
    private int auctionItemMasterId;

    
    public AuctionItemVendorBidHistory() {
    }
    
    public AuctionItemVendorBidHistory(int id, String auctionNo, String vendorCode, String currency, String currencyConversion, String vendorBasicStartPrice, String loadingFactorPer, String loadingFactorVal, String finalPrice, String finalTotal, String dateTime,int auctionItemMasterId) {
        
        this.id = id;
        this.auctionNo = auctionNo;    
        this.vendorCode = vendorCode;
        this.currency = currency;
        this.currencyConversion = currencyConversion;
        this.vendorBasicStartPrice = vendorBasicStartPrice;
        this.loadingFactorPer = loadingFactorPer;
        this.loadingFactorVal = loadingFactorVal;
        this.finalPrice = finalPrice;
        this.finalTotal = finalTotal;
        this.dateTime = dateTime;
        this.auctionItemMasterId = auctionItemMasterId;
    }

    public int getId() {
        return id;
    }

    public AuctionItemVendorBidHistory setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionItemVendorBidHistory setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public AuctionItemVendorBidHistory setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public AuctionItemVendorBidHistory setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrencyConversion() {
        return currencyConversion;
    }

    public AuctionItemVendorBidHistory setCurrencyConversion(String currencyConversion) {
        this.currencyConversion = currencyConversion;
        return this;
    }

    public String getVendorBasicStartPrice() {
        return vendorBasicStartPrice;
    }

    public AuctionItemVendorBidHistory setVendorBasicStartPrice(String vendorBasicStartPrice) {
        this.vendorBasicStartPrice = vendorBasicStartPrice;
        return this;
    }

    public String getLoadingFactorPer() {
        return loadingFactorPer;
    }

    public AuctionItemVendorBidHistory setLoadingFactorPer(String loadingFactorPer) {
        this.loadingFactorPer = loadingFactorPer;
        return this;
    }

    public String getLoadingFactorVal() {
        return loadingFactorVal;
    }

    public AuctionItemVendorBidHistory setLoadingFactorVal(String loadingFactorVal) {
        this.loadingFactorVal = loadingFactorVal;
        return this;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public AuctionItemVendorBidHistory setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public String getFinalTotal() {
        return finalTotal;
    }

    public AuctionItemVendorBidHistory setFinalTotal(String finalTotal) {
        this.finalTotal = finalTotal;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public AuctionItemVendorBidHistory setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public int getAuctionItemMasterId() {
        return auctionItemMasterId;
    }

    public void setAuctionItemMasterId(int auctionItemMasterId) {
        this.auctionItemMasterId = auctionItemMasterId;
    }


    
    
}
