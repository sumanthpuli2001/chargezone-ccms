/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.model.AuctionItemMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionItemMasterService<T> extends GenericsService<T> {

    public List readRefNo(String ref_no);

    public void deleteRefNo(String ref_no);

    public void updateAuctionNo(String refNo1, String refNo);
    
    public List readByAuctionId(String auction_no);
    
    public AuctionItemMaster readByVendorAuction(String auction_no, int item_id);
      
    public AuctionItemMaster readByVendorAuctionItemList(String auction_no);
    
}
