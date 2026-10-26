/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Auction;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Bulwarks-1
 */
public interface AuctionItemVendorBidHistoryService<T> extends GenericsService<T> { 
    
    
    public List readVendorHistory(String auction_no, String vendor_code);
    
     public List readByReverseAuction1(String refNo, int itemId ,String vendor_code);
     
     public List readByForwardAuction1(String refNo ,int itemId ,String vendor_code);
        
}

    

