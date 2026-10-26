/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionItemVendor;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionItemVendorDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionItemVendorDao<T> {

    @Override
    protected Class getDomainClass() {
      return AuctionItemVendor.class;
    }

    @Override
    public List readByRefNo(String ref_no, int item_no) {
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " WHERE a.auctionNo =" + ref_no 
                + " and a.auctionItemMasterId =" + item_no ;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    
     @Override
    public List readByRefVendor(String ref_no, String vendor_code ,int item_no) {
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " Where a.auctionNo = '" + ref_no + "' and a.vendorCode = '" + vendor_code + "'"
                + " and a.auctionItemMasterId= " + item_no;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
   
    public List readByItemId( int item_no) {
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " Where a.auctionItemMasterId =" + item_no ;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    
        @Override
    public List readByIds(String ref_no, int item_no) {
        String query = "select a.id";
        query += " FROM AuctionItemVendor a"
                + " WHERE a.auctionNo =" + ref_no 
                + " and a.auctionItemMasterId =" + item_no ;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }
        @Override
   
    public List readByAuctionNo(String ref_no, String vendor_code) {
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " Where a.auctionNo =" + ref_no 
                + "and a.vendorCode = '" + vendor_code + "'" ;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }
        @Override
    public AuctionItemVendor readByVendorAuction(String auction_no, String username ) {
        AuctionItemVendor auctionVendor = new AuctionItemVendor();
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " where a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendor = (AuctionItemVendor) list.get(0);
        }
        return auctionVendor;
    }

    @Override
    public List readByAuctionId(String auction_no) {
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " Where a.auctionNo =" + auction_no ;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    
        @Override
    public List readAuctionItemVendor(String ref_no, int item_no) {
        String query = "";
        query += " FROM AuctionItemVendor a"
                + " WHERE a.auctionNo =" + ref_no 
                + " and a.auctionItemMasterId =" + item_no ;
         List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo) {
        String query = "";
            query += " update AuctionItemVendor a set a.auctionNo = '" + refNo + "'"
                + " WHERE a.auctionNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
    }


 

