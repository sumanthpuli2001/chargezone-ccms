/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionItemMaster;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionItemMasterDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionItemMasterDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionItemMaster.class;
    }

    @Override
    public List readRefNo(String ref_no) {
        String query = "";
        query += " FROM AuctionItemMaster a"
                + " WHERE a.auctionNo = '" + ref_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String ref_no) {
        String query = "";
            query += " delete from AuctionItemMaster a"
                + " WHERE a.auctionNo = '" + ref_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo) {
        String query = "";
            query += " update AuctionItemMaster a set a.auctionNo = '" + refNo + "'"
                + " WHERE a.auctionNo = '" + refNo1 + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
      @Override
    public List readByAuctionId(String auction_no) {
        String query = "";
        query += " FROM AuctionItemMaster a"
                + " WHERE a.auctionNo = '" + auction_no + "'";
        return getHibernateTemplate().find(query);
    }
      @Override
    public AuctionItemMaster readByVendorAuction(String auction_no, int item_id) {
        AuctionItemMaster auctionVendor = new AuctionItemMaster();
        String query = "";
        query += " FROM AuctionItemMaster a"
                   + " Where a.id =" + item_id 
                + " and a.auctionNo = '" + auction_no + "'";
        List<?> list = getHibernateTemplate().find(query);
    if (!list.isEmpty()) {
            auctionVendor = (AuctionItemMaster) list.get(0);
        }
        return auctionVendor;
    }
    
     @Override
    public AuctionItemMaster readByVendorAuctionItemList(String auction_no) {
        AuctionItemMaster auctionVendor = new AuctionItemMaster();
        String query = "";
        query += " FROM AuctionItemMaster a"
                   
                + " where a.auctionNo = '" + auction_no + "'";
        List<?> list = getHibernateTemplate().find(query);
    if (!list.isEmpty()) {
            auctionVendor = (AuctionItemMaster) list.get(0);
        }
        return auctionVendor;
    }
    
}
