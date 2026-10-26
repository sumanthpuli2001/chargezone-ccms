/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionItemVendorBid;
import com.bul.zydex.model.AuctionVendorBid;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Bulwarks-1
 */
public class AuctionItemVendorBidDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionItemVendorBidDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionItemVendorBid.class;
    }
        @Override
    public List readByAuctionNo(String auction_no, String username) {
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                + " WHERE a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AuctionItemVendorBid readByAuctionVendorWithItem(String auction_no, String username ,int item_id) {
        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                 +  " where a.auctionItemMasterId= " + item_id
                + " and a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionItemVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

    @Override
       public List readByForwardAuctionRankWithItem(String auction_no , int item_id) {
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                +  " where a.auctionItemMasterId= " + item_id
                + " and a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        return getHibernateTemplate().find(query);
    }

      @Override
    public List readByReverseAuctionRankWithItem(String auction_no ,int item_id) {
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                 +  " where a.auctionItemMasterId= " + item_id
                + " and a.auctionNo = '" + auction_no + "' order by finalTotal";
        return getHibernateTemplate().find(query);
    }

         @Override
     public AuctionItemVendorBid readByH1WithItem(String auction_no ,int item_id) {
        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                +  " where a.auctionItemMasterId= " + item_id
                + " and a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionItemVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

    @Override
       public AuctionItemVendorBid readByL1WithItem(String auction_no ,int item_id) {
        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                + " where a.auctionItemMasterId= " + item_id
                + " and a.auctionNo = '" + auction_no + "' order by finalTotal";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionItemVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

 @Override
    public List readByAuctionNoWithItem(String ref_no, String vendor_code ,int item_id) {
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                + " Where a.auctionNo = '" + ref_no 
                + "' and a.vendorCode = '" + vendor_code + "'"
                + " and a.auctionItemMasterId= " + item_id;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }
 @Override
    public void updateInfo(String auction_no, String username, String start_price, String final_price, String formattedDate ,int item_id) {
        String query = "";
            query += " update AuctionItemVendorBid a"
                + " set a.dateTime='"+formattedDate+"', "
                + " a.vendorBasicStartPrice='"+start_price+"', "
                + " a.finalPrice='"+final_price+"', "
                + " a.finalTotal='"+final_price+"' "
                + " WHERE a.auctionNo = '" + auction_no + "'  and a.vendorCode = '" + username + "'"
                + " and a.auctionItemMasterId= '" + item_id +"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByAuctionId(String auction_no) {
//        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                + " where a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        List<?> list = getHibernateTemplate().find(query);
        
        return list;
    }
        @Override
    public List readByReverseAuction(String refNo, int itemId) {
        String query = "";
        query += "select distinct a.vendorCode, b.vendorName, a.finalTotal,a.dateTime, a.auctionItemMasterId, a.auctionNo,a.dateTime"
                + " FROM AuctionItemVendorBid a, AuctionItemVendor b "
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode " 
                + " and a.auctionItemMasterId= " + itemId
                + " order by a.finalTotal asc ";

     List <?> li = getHibernateTemplate().find(query);
                 return li;
    }

    @Override
    public List readByForwardAuction(String refNo ,int itemId) {
        String query = "";
        query += "select a.vendorCode, b.vendorName, a.currency, a.currencyConversion, a.finalTotal,a.dateTime, a.auctionItemMasterId "  
                + " FROM AuctionItemVendorBid a, AuctionItemVendor b "
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode " 
                + " and a.auctionItemMasterId= " + itemId
                + " order by a.finalTotal desc ";

        List <?> li = getHibernateTemplate().find(query);
        return li;
    }
 @Override
    public List readByReverseAuction1(String refNo, int itemId ,String vendor_code) {
        String query = "";
        query += "select  a.vendorCode, b.vendorName, a.finalTotal,a.dateTime, a.auctionItemMasterId, a.auctionNo,a.dateTime"
                + " FROM AuctionItemVendorBid a, AuctionItemVendor b "
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
        query += "select a.vendorCode, b.vendorName, a.currency, a.currencyConversion, a.finalTotal,a.dateTime, a.auctionItemMasterId "  
                + " FROM AuctionItemVendorBid a, AuctionItemVendor b "
                + " WHERE a.auctionNo = '" + refNo + "' and a.auctionNo = b.auctionNo and a.vendorCode = b.vendorCode " 
                + " and a.auctionItemMasterId= " + itemId
                + " and a.vendorCode= '" + vendor_code + "'" 
                + " order by a.finalTotal desc ";

        List <?> li = getHibernateTemplate().find(query);
        return li;
    }
    
            @Override
     public AuctionItemVendorBid readByH1(String auction_no ) {
        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
               
                + " where a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionItemVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }

    @Override
       public AuctionItemVendorBid readByL1(String auction_no ) {
        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
               
                + " where a.auctionNo = '" + auction_no + "' order by finalTotal";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionItemVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }
       
      @Override
       public List readByForwardAuctionRank(String auction_no ) {
        String query = "";
        query += " FROM AuctionItemVendorBid a"

                + " where a.auctionNo = '" + auction_no + "' order by finalTotal desc";
        return getHibernateTemplate().find(query);
    }

      @Override
    public List readByReverseAuctionRank(String auction_no ) {
        String query = "";
        query += " FROM AuctionItemVendorBid a"
         
                + " where a.auctionNo = '" + auction_no + "' order by finalTotal";
        return getHibernateTemplate().find(query);
    }   
       
    
    @Override
    public AuctionItemVendorBid readByAuctionVendor(String auction_no, String username ) {
        AuctionItemVendorBid auctionVendorBid = new AuctionItemVendorBid();
        String query = "";
        query += " FROM AuctionItemVendorBid a"
                + " where a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendorBid = (AuctionItemVendorBid) list.get(0);
        }
        return auctionVendorBid;
    }
   
       
}

