/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTechnicalBidTerms;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidTermsDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTechnicalBidTermsDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorTechnicalBidTerms.class;
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorTechnicalBidTerms a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String description) {
        String query = "";
        query += " FROM VendorTechnicalBidTerms a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" + username + "' and description = '" + description + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String description, int vendor_response, String remark) {
        String query = "";
        query += " update VendorTechnicalBidTerms a"
                + " set a.remark='" + remark + "', "
                + " a.vendorResponse=" + vendor_response + " "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "' and description = '" + description + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByReviseVendorBid(String refNo, String username, int revise_technical_bid_id) {
        String query = "";
        query += " FROM VendorTechnicalBidTerms a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" + username + "' and a.reviseVendorTechnicalBidId = '" + revise_technical_bid_id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateAdminVendorRefNo(String refNo, String username, String vendor_terms_desc, int parseInt, String terms_vendor_remark, int revise_id) {
        String query = "";
        query += " update VendorTechnicalBidTerms a"
                + " set a.buyerRemark='" + terms_vendor_remark + "', "
                + " a.buyerResponse=" + parseInt + " "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "' and description = '" + vendor_terms_desc + "' and a.reviseVendorTechnicalBidId = '" + revise_id + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void readByDelete(String refNo, String username) {
        String query = "";
        query += " delete from VendorTechnicalBidTerms a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";
         Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();

    }
}
