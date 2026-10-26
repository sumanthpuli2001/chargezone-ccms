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
public class AuctionNo {
    
    private int id;
    private String auctionNo;
    
    public AuctionNo() {
    }
    
    public AuctionNo(int id, String auctionNo) {
        
        this.id = id;
        this.auctionNo = auctionNo;    
    }

    public int getId() {
        return id;
    }

    public AuctionNo setId(int id) {
        this.id = id;
        return this;
    }

    public String getAuctionNo() {
        return auctionNo;
    }

    public AuctionNo setAuctionNo(String auctionNo) {
        this.auctionNo = auctionNo;
        return this;
    }
    
    
}
