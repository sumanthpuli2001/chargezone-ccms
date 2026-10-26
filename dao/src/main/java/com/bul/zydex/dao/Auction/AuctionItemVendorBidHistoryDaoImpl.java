/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionItemVendorBidHistory;
import java.util.List;

/**
 *
 * @author Bulwarks-1
 */
public class AuctionItemVendorBidHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionItemVendorBidHistoryDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionItemVendorBidHistory.class;
    }

  @Override
    public List readVendorHistory(String auction_no, String vendor_code) {
        String query = "";
        query += " FROM AuctionItemVendorBidHistory a"
                + " WHERE a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + vendor_code + "'";
        List <?> li =  getHibernateTemplate().find(query);
        return li;
    }
    
     @Override
    public List readByReverseAuction1(String refNo, int itemId ,String vendor_code) {
        String query = "";
        query += "select distinct a.vendorCode, b.vendorName, a.finalTotal,a.dateTime, a.auctionItemMasterId, a.auctionNo,a.dateTime"
                + " FROM AuctionItemVendorBidHistory a, AuctionItemVendor b "
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode " 
                + " and a.auctionItemMasterId= " + itemId
                + " and a.vendorCode= '" + vendor_code + "'"
                + " order by a.finalTotal asc  ";

     List <?> li = getHibernateTemplate().find(query);
                 return li;
    }
    
     @Override
    public List readByForwardAuction1(String refNo ,int itemId ,String vendor_code) {
        String query = "";
        query += "select distinct a.vendorCode, b.vendorName, a.currency, a.currencyConversion, a.finalTotal,a.dateTime, a.auctionItemMasterId "  
                + " FROM AuctionItemVendorBidHistory a, AuctionItemVendor b "
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode " 
                + " and a.auctionItemMasterId= " + itemId
                + " and a.vendorCode= '" + vendor_code + "'" 
                + " order by a.finalTotal desc ";

        List <?> li = getHibernateTemplate().find(query);
        return li;
    }
}


