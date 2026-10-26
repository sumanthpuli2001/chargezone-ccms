/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionItemVendorBidHistoryDao;
import com.bul.zydex.model.AuctionItemVendorBidHistory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Bulwarks-1
 */
public class AuctionItemVendorBidHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionItemVendorBidHistoryService<T>  {

    
    private AuctionItemVendorBidHistoryDao<T> auctionItemVendorBidHistoryDao;

    public AuctionItemVendorBidHistoryDao<T> getAuctionItemVendorBidHistoryDao() {
        return auctionItemVendorBidHistoryDao;
    }

    public void setAuctionItemVendorBidHistoryDao(AuctionItemVendorBidHistoryDao<T> auctionItemVendorBidHistoryDao) {
        this.auctionItemVendorBidHistoryDao = auctionItemVendorBidHistoryDao;
        setGenericsDAO(auctionItemVendorBidHistoryDao);
    }

    @Override
    public List readVendorHistory(String auction_no, String vendor_code) {
      return auctionItemVendorBidHistoryDao.readVendorHistory(auction_no ,vendor_code);
    }

    @Override
    public List readByReverseAuction1(String refNo, int itemId, String vendor_code) {
        return auctionItemVendorBidHistoryDao.readByReverseAuction1(refNo, itemId, vendor_code);
    }

    @Override
    public List readByForwardAuction1(String refNo, int itemId, String vendor_code) {
        return auctionItemVendorBidHistoryDao.readByForwardAuction1(refNo, itemId, vendor_code);
    }

  
}


