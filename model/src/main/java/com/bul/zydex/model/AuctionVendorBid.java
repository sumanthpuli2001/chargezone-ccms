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
public class AuctionVendorBid {
 
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
    
    public AuctionVendorBid() {
    }
    
    public AuctionVendorBid(int id, String auctionNo, String vendorCode, String currency, String currencyConversion, String vendorBasicStartPrice, String loadingFactorPer, String loadingFactorVal, String finalPrice, String finalTotal, String dateTime) {
        
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

    public AuctionVendorBid setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionVendorBid setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public AuctionVendorBid setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public AuctionVendorBid setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrencyConversion() {
        return currencyConversion;
    }

    public AuctionVendorBid setCurrencyConversion(String currencyConversion) {
        this.currencyConversion = currencyConversion;
        return this;
    }

    public String getVendorBasicStartPrice() {
        return vendorBasicStartPrice;
    }

    public AuctionVendorBid setVendorBasicStartPrice(String vendorBasicStartPrice) {
        this.vendorBasicStartPrice = vendorBasicStartPrice;
        return this;
    }

    public String getLoadingFactorPer() {
        return loadingFactorPer;
    }

    public AuctionVendorBid setLoadingFactorPer(String loadingFactorPer) {
        this.loadingFactorPer = loadingFactorPer;
        return this;
    }

    public String getLoadingFactorVal() {
        return loadingFactorVal;
    }

    public AuctionVendorBid setLoadingFactorVal(String loadingFactorVal) {
        this.loadingFactorVal = loadingFactorVal;
        return this;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public AuctionVendorBid setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public String getFinalTotal() {
        return finalTotal;
    }

    public AuctionVendorBid setFinalTotal(String finalTotal) {
        this.finalTotal = finalTotal;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public AuctionVendorBid setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }
    
    

}
