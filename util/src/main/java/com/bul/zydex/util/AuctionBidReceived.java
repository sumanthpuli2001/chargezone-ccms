/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

/**
 *
 * @author admin
 */
public class AuctionBidReceived {

    private int id;
    private String auctionNo;
    private String vendorCode;
    private String vendorName;
    private String emailId;
    private String mobileNo;
    private String currency;
    private String currencyConversation;
    private String rank;
    private String startPrice;
    private String finalPrice;
    private String finalTotal;
    
    public AuctionBidReceived() {
    }
    
    public AuctionBidReceived(int id, String auctionNo, String vendorCode, String vendorName, String emailId, String mobileNo, String currency, String currencyConversation, String rank, String startPrice, String finalPrice, String finalTotal) {
        this.id = id;
        this.auctionNo = auctionNo;
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.currency = currency;
        this.currencyConversation = currencyConversation;
        this.rank = rank;
        this.startPrice = startPrice;
        this.finalPrice = finalPrice;
        this.finalTotal = finalTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public void setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyConversation() {
        return currencyConversation;
    }

    public void setCurrencyConversation(String currencyConversation) {
        this.currencyConversation = currencyConversation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(String finalTotal) {
        this.finalTotal = finalTotal;
    }
    
    
}
