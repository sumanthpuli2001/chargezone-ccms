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
public class AuctionNoTemp {
    
    private int id;
    private String auctionNo;
    
    public AuctionNoTemp() {
    }
    
    public AuctionNoTemp(int id, String auctionNo) {
        
        this.id = id;
        this.auctionNo = auctionNo;    
    }

    public int getId() {
        return id;
    }

    public AuctionNoTemp setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionNoTemp setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }
    
    
    
}
