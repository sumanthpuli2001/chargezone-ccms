/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionVendorBid;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AuctionVendorBidDao<T> extends GenericsDAO<T> {

    public List readByAuctionNo(String auction_no, String username);

    public AuctionVendorBid readByAuctionVendor(String auction_no, String username);

    public AuctionVendorBid readByL1(String auction_no);

    public AuctionVendorBid readByH1(String auction_no);

    public List readByReverseAuctionRank(String auction_no);

    public List readByForwardAuctionRank(String auction_no);

    public void updateInfo(String auction_no, String username, String start_price, String final_price, String formattedDate);

    public List readByReverseAuction(String refNo);

    public List readByForwardAuction(String refNo);

    public void updatePrice(String refNo, String vendorCode, String start_price, String final_price);
    
}
