/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.dao.Auction.AuctionItemVendorBidDao;
import com.bul.zydex.model.AuctionItemVendorBid;
import com.bul.zydex.model.AuctionVendorBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class AuctionItemVendorBidServiceImpl<T> extends GenericsServiceImpl<T> implements AuctionItemVendorBidService<T> {
 
    private AuctionItemVendorBidDao<T> auctionItemVendorBidDao;

 

    public AuctionItemVendorBidDao<T> getAuctionItemVendorBidDao() {
        return auctionItemVendorBidDao;
    }

    public void setAuctionItemVendorBidDao(AuctionItemVendorBidDao<T> auctionItemVendorBidDao) {
        this.auctionItemVendorBidDao = auctionItemVendorBidDao;
        setGenericsDAO(auctionItemVendorBidDao);
    }

    @Override
    public AuctionItemVendorBid readByAuctionVendorWithItem(String auction_no, String username ,int item_id) {
       return auctionItemVendorBidDao.readByAuctionVendorWithItem(auction_no, username ,item_id);
    }

    @Override
    public List readByAuctionNo(String auction_no, String username) {
       return auctionItemVendorBidDao.readByAuctionNo( auction_no, username);
    }

    @Override
    public List readByForwardAuctionRankWithItem(String auction_no , int item_id) {
       return auctionItemVendorBidDao.readByForwardAuctionRankWithItem(auction_no,item_id);
    }

    @Override
    public List readByReverseAuctionRankWithItem(String auction_no ,int item_id) {
            return auctionItemVendorBidDao.readByReverseAuctionRankWithItem( auction_no , item_id);
    }

    @Override
    public AuctionItemVendorBid readByH1WithItem(String auction_no ,int item_id) {
            return auctionItemVendorBidDao.readByH1WithItem(auction_no ,item_id);
    }

    @Override
     public AuctionItemVendorBid readByL1WithItem(String auction_no ,int item_id) {
        return auctionItemVendorBidDao.readByL1WithItem( auction_no ,item_id);
    }

    @Override
    public List readByAuctionNoWithItem(String auction_no, String username, int item_id) {
        return auctionItemVendorBidDao.readByAuctionNoWithItem( auction_no, username, item_id);
    }

    @Override
    public void updateInfo(String auction_no, String username, String start_price, String final_price, String formattedDate, int item_id) {
         auctionItemVendorBidDao.updateInfo(auction_no,  username,  start_price, final_price, formattedDate,item_id);
    }

    @Override
    public List readByAuctionId(String auction_no) {
      return auctionItemVendorBidDao.readByAuctionId(auction_no);
    }

    @Override
    public List readByReverseAuction(String refNo ,int itemId) {
       return auctionItemVendorBidDao.readByReverseAuction(refNo ,itemId);
    }

    @Override
    public List readByForwardAuction(String refNo , int itemId) {
       return auctionItemVendorBidDao.readByForwardAuction(refNo,itemId);
    }

    @Override
    public List readByReverseAuction1(String refNo, int itemId, String vendor_code) {
       return auctionItemVendorBidDao.readByReverseAuction1(refNo, itemId, vendor_code);
    }

    @Override
    public List readByForwardAuction1(String refNo, int itemId, String vendor_code) {
        return auctionItemVendorBidDao.readByForwardAuction1(refNo, itemId, vendor_code);
    }

    @Override
    public AuctionItemVendorBid readByL1(String auction_no) {
       return auctionItemVendorBidDao.readByL1(auction_no);
    }

    @Override
    public AuctionItemVendorBid readByH1(String auction_no) {
         return auctionItemVendorBidDao.readByH1(auction_no);
    }

    @Override
    public List readByReverseAuctionRank(String auction_no) {
       return auctionItemVendorBidDao.readByReverseAuctionRank(auction_no);
    }

    @Override
    public List readByForwardAuctionRank(String auction_no) {
    return auctionItemVendorBidDao.readByForwardAuctionRank(auction_no);
    }

    @Override
    public AuctionItemVendorBid readByAuctionVendor(String auction_no, String username) {
        return auctionItemVendorBidDao.readByAuctionVendor(auction_no, username);
    }


  
}
