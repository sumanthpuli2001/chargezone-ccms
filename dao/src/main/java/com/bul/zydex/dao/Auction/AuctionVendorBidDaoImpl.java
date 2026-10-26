/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionVendorBid;
import com.bul.zydex.model.AuctionVendor;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionVendorBidDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionVendorBidDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionVendorBid.class;
    }

    @Override
    public List readByAuctionNo(String auction_no, String username) {
        String query = "";
        query += " FROM AuctionVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AuctionVendorBid readByAuctionVendor(String auction_no, String username) {
        AuctionVendorBid auctionVendorBid = new AuctionVendorBid();
        String query = "";
        query += " FROM AuctionVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

    @Override
    public AuctionVendorBid readByL1(String auction_no) {
        AuctionVendorBid auctionVendorBid = new AuctionVendorBid();
        String query = "";
        query += " FROM AuctionVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' order by finalTotal";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

    @Override
    public AuctionVendorBid readByH1(String auction_no) {
        AuctionVendorBid auctionVendorBid = new AuctionVendorBid();
        String query = "";
        query += " FROM AuctionVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

    @Override
    public List readByReverseAuctionRank(String auction_no) {
        String query = "";
        query += " FROM AuctionVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' order by finalTotal";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByForwardAuctionRank(String auction_no) {
        String query = "";
        query += " FROM AuctionVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateInfo(String auction_no, String username, String start_price, String final_price, String formattedDate) {
        String query = "";
            query += " update AuctionVendorBid a"
                + " set a.dateTime='"+formattedDate+"', "
                + " a.vendorBasicStartPrice='"+start_price+"', "
                + " a.finalPrice='"+final_price+"', "
                + " a.finalTotal='"+final_price+"' "    
                + " WHERE a.auctionNo = '" + auction_no + "'  and a.vendorCode = '" + username + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByReverseAuction(String refNo) {
        String query = "";
        query += "select a.vendorCode, b.vendorName, a.currency, a.currencyConversion, a.finalTotal  FROM AuctionVendorBid a, AuctionVendor b"
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode order by CAST(a.finalTotal AS int)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByForwardAuction(String refNo) {
        String query = "";
        query += "select a.vendorCode, b.vendorName, a.currency, a.currencyConversion, a.finalTotal  FROM AuctionVendorBid a, AuctionVendor b"
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode order by CAST(a.finalTotal AS int) desc";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updatePrice(String refNo, String vendorCode, String start_price, String final_price) {
        String query = "";
            query += " update AuctionVendorBid a"
                + " set a.vendorBasicStartPrice='"+start_price+"', "
                + " a.finalPrice='"+final_price+"', "
                + " a.finalTotal='"+final_price+"' "    
                + " WHERE a.auctionNo = '" + refNo + "' and a.vendorCode = '" + vendorCode + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
    
}
