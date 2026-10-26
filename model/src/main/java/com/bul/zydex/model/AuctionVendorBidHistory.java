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
public class AuctionVendorBidHistory {
    
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
    
    public AuctionVendorBidHistory() {
    }
    
    public AuctionVendorBidHistory(int id, String auctionNo, String vendorCode, String currency, String currencyConversion, String vendorBasicStartPrice, String loadingFactorPer, String loadingFactorVal, String finalPrice, String finalTotal, String dateTime) {
        
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
    }

    public int getId() {
        return id;
    }

    public AuctionVendorBidHistory setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionVendorBidHistory setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public AuctionVendorBidHistory setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public AuctionVendorBidHistory setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrencyConversion() {
        return currencyConversion;
    }

    public AuctionVendorBidHistory setCurrencyConversion(String currencyConversion) {
        this.currencyConversion = currencyConversion;
        return this;
    }

    public String getVendorBasicStartPrice() {
        return vendorBasicStartPrice;
    }

    public AuctionVendorBidHistory setVendorBasicStartPrice(String vendorBasicStartPrice) {
        this.vendorBasicStartPrice = vendorBasicStartPrice;
        return this;
    }

    public String getLoadingFactorPer() {
        return loadingFactorPer;
    }

    public AuctionVendorBidHistory setLoadingFactorPer(String loadingFactorPer) {
        this.loadingFactorPer = loadingFactorPer;
        return this;
    }

    public String getLoadingFactorVal() {
        return loadingFactorVal;
    }

    public AuctionVendorBidHistory setLoadingFactorVal(String loadingFactorVal) {
        this.loadingFactorVal = loadingFactorVal;
        return this;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public AuctionVendorBidHistory setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public String getFinalTotal() {
        return finalTotal;
    }

    public AuctionVendorBidHistory setFinalTotal(String finalTotal) {
        this.finalTotal = finalTotal;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public AuctionVendorBidHistory setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }
    
    
}
