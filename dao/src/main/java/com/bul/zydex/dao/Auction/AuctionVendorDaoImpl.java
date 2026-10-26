/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionVendor;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionVendorDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionVendorDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionVendor.class;
    }

    @Override
    public List readByRefNo(String ref_no) {
        String query = "";
        query += " FROM AuctionVendor a"
                + " WHERE a.auctionNo = '" + ref_no + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefVendor(String ref_no, String vendor_code) {
        String query = "";
        query += " FROM AuctionVendor a"
                + " WHERE a.auctionNo = '" + ref_no + "' and a.vendorCode = '"+vendor_code+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateRefNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, String start_price, String loading_factor_per, String loading_factor_val, String final_price, int checkVendorId) {
        String query = "";
            query += " update AuctionVendor a"
            //    + " set a.emailId='"+email_id+"', "
            //    + " a.mobileNo='"+mobile_no+"', "
                + " set a.auctionNo='"+refNo+"', "
                + " a.emailId='"+email_id+"', "
                + " a.mobileNo='"+mobile_no+"', "
                + " a.vendorBasicStartPrice="+start_price+", "
                + " a.loadingFactorPer="+loading_factor_per+", "
                + " a.loadingFactorVal="+loading_factor_val+", "
                + " a.finalPrice="+final_price+" "    
                + " WHERE a.auctionNo = '" + refNo1 + "' and a.vendorCode = '" + vendor_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public AuctionVendor readByVendorAuction(String auction_no, String username) {
        AuctionVendor auctionVendor = new AuctionVendor();
        String query = "";
        query += " FROM AuctionVendor a"
                + " WHERE a.auctionNo = '" + auction_no + "' and a.vendorCode = '" + username + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionVendor = (AuctionVendor) list.get(0);
        }
        return auctionVendor;
    }

    @Override
    public void updateAuctionNo(String refNo1, String refNo, String vendor_code, String email_id, String mobile_no, String start_price, String loading_factor_per, String loading_factor_val, String final_price, int checkVendorId) {
        String query = "";
            query += " update AuctionVendor a"
                + " set a.auctionNo='"+refNo+"', "
                + " a.emailId='"+email_id+"', "
                + " a.mobileNo='"+mobile_no+"', "
                + " a.vendorBasicStartPrice="+start_price+", "
                + " a.loadingFactorPer="+loading_factor_per+", "
                + " a.loadingFactorVal="+loading_factor_val+", "
                + " a.finalPrice="+final_price+" "    
                + " WHERE a.auctionNo = '" + refNo1 + "' and a.vendorCode = '" + vendor_code + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByRefNoL1(String auction_no) {
        String query = "";
        query += " FROM AuctionVendor a"
                + " WHERE a.auctionNo = '" + auction_no + "' order by CAST(a.finalPrice AS int)";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNoH1(String auction_no) {
        String query = "";
        query += " FROM AuctionVendor a"
                + " WHERE a.auctionNo = '" + auction_no + "' order by CAST(a.finalPrice AS int) desc";
        return getHibernateTemplate().find(query);
    }
}
