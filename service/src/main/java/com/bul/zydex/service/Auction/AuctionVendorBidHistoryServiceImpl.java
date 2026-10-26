/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionVendorBidHistoryDao;
import com.bul.zydex.model.AuctionVendorBidHistory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionVendorBidHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionVendorBidHistoryService<T> {
    
    private AuctionVendorBidHistoryDao<T> auctionVendorBidHistoryDao;

    public AuctionVendorBidHistoryDao<T> getAuctionVendorBidHistoryDao() {
        return auctionVendorBidHistoryDao;
    }

    public void setAuctionVendorBidHistoryDao(AuctionVendorBidHistoryDao<T> auctionVendorBidHistoryDao) {
        this.auctionVendorBidHistoryDao = auctionVendorBidHistoryDao;
        setGenericsDAO(auctionVendorBidHistoryDao);
    }

    @Override
    public List readVendorHistory(String auction_no, String vendor_code) {
        return auctionVendorBidHistoryDao.readVendorHistory(auction_no,vendor_code);
    }
}
