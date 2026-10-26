/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionVendorBidHistory;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionVendorBidHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionVendorBidHistoryDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionVendorBidHistory.class;
    }

    @Override
    public List readVendorHistory(String auction_no, String vendor_code) {
        String query = "";
        query += " FROM AuctionVendorBidHistory a"
                + " WHERE a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + vendor_code + "'";
        return getHibernateTemplate().find(query);
    }
}
