/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuctionItemVendorBid;
import com.bul.zydex.model.AuctionVendorBid;
import java.util.List;

/**
 *
 * @author Bulwarks-1
 */
public interface AuctionItemVendorBidDao<T> extends GenericsDAO<T> {
    
     public List readByAuctionNo(String auction_no, String username);
     
    public AuctionItemVendorBid readByAuctionVendorWithItem(String auction_no, String username ,int item_id);

    public List readByForwardAuctionRankWithItem(String auction_no , int item_id);

    public List readByReverseAuctionRankWithItem(String auction_no ,int item_id);

    public AuctionItemVendorBid readByH1WithItem(String auction_no, int item_id);

    public AuctionItemVendorBid readByL1WithItem(String auction_no, int item_id);

    public List readByAuctionNoWithItem(String auction_no, String username, int item_id);

    public void updateInfo(String auction_no, String username, String start_price, String final_price, String formattedDate, int item_id);

    public List readByAuctionId(String auction_no);

    public List readByReverseAuction(String refNo, int itemId);

    public List readByForwardAuction(String refNo, int itemId);

    public List readByReverseAuction1(String refNo, int itemId, String vendor_code);

    public List readByForwardAuction1(String refNo, int itemId, String vendor_code);

    public AuctionItemVendorBid readByH1(String auction_no);

    public AuctionItemVendorBid readByL1(String auction_no);

    public List readByForwardAuctionRank(String auction_no);

    public List readByReverseAuctionRank(String auction_no);

    public AuctionItemVendorBid readByAuctionVendor(String auction_no, String username );
}
