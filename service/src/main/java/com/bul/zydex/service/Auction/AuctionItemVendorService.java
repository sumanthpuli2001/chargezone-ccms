/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.model.AuctionItemVendor;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuctionItemVendorService<T> extends GenericsService<T> {

      public List readByRefNo(String ref_no ,int item_no);
      
      public List readByItemId(int item_no);
        
      public List readByRefVendor(String ref_no, String vendor_code ,int item_no );
      
       public List readByIds(String ref_no, int item_no);
       
       public List readByAuctionNo(String ref_no, String vendor_code);
       
        public AuctionItemVendor readByVendorAuction(String auction_no, String username);

    public List readByAuctionId(String auction_no);
  
     public List readAuctionItemVendor(String ref_no, int item_no);

    public void updateAuctionNo(String refNo1, String refNo);
}