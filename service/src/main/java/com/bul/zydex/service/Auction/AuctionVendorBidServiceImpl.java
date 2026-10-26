/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionVendorBidDao;
import com.bul.zydex.model.AuctionVendorBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionVendorBidServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionVendorBidService<T> {
 
    private AuctionVendorBidDao<T> auctionVendorBidDao;

    public AuctionVendorBidDao<T> getAuctionVendorBidDao() {
        return auctionVendorBidDao;
    }

    public void setAuctionVendorBidDao(AuctionVendorBidDao<T> auctionVendorBidDao) {
        this.auctionVendorBidDao = auctionVendorBidDao;
        setGenericsDAO(auctionVendorBidDao);
    }

    @Override
    public List readByAuctionNo(String auction_no, String username) {
        return auctionVendorBidDao.readByAuctionNo(auction_no, username);
    }

    @Override
    public AuctionVendorBid readByAuctionVendor(String auction_no, String username) {
        return auctionVendorBidDao.readByAuctionVendor(auction_no, username);
    }

    @Override
    public AuctionVendorBid readByL1(String auction_no) {
        return auctionVendorBidDao.readByL1(auction_no);
    }

    @Override
    public AuctionVendorBid readByH1(String auction_no) {
        return auctionVendorBidDao.readByH1(auction_no);
    }

    @Override
    public List readByReverseAuctionRank(String auction_no) {
        return auctionVendorBidDao.readByReverseAuctionRank(auction_no);
    }

    @Override
    public List readByForwardAuctionRank(String auction_no) {
        return auctionVendorBidDao.readByForwardAuctionRank(auction_no);
    }

    @Override
    public void updateInfo(String auction_no, String username, String start_price, String final_price, String formattedDate) {
        auctionVendorBidDao.updateInfo(auction_no, username, start_price, final_price,formattedDate);
    }

    @Override
    public List readByReverseAuction(String refNo) {
        return auctionVendorBidDao.readByReverseAuction(refNo);
    }

    @Override
    public List readByForwardAuction(String refNo) {
        return auctionVendorBidDao.readByForwardAuction(refNo);
    }

    @Override
    public void updatePrice(String refNo, String vendorCode, String start_price, String final_price) {
        auctionVendorBidDao.updatePrice(refNo, vendorCode, start_price, final_price);
    }
}
