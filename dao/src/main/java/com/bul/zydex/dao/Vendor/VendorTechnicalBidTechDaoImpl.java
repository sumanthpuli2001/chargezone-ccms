/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTechnicalBidTech;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorTechnicalBidTechDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTechnicalBidTechDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorTechnicalBidTech.class;
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorTechnicalBidTech a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" +username+ "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String description) {
        String query = "";
        query += " FROM VendorTechnicalBidTech a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" +username+ "' and a.description = '" +description+ "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String description, int vendor_response, String remark) {
        String query = "";
        query += " update VendorTechnicalBidTech a"
                + " set a.remark='"+remark+"', "
                + " a.vendorResponse="+vendor_response+" "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.description = '" +description+ "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByReviseVendorBid(String refNo, String username, int revise_technical_bid_id) {
        String query = "";
        query += " FROM VendorTechnicalBidTech a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" +username+ "' and a.reviseVendorTechnicalBidId = '"+revise_technical_bid_id+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateAdminVendorRefNo(String refNo, String username, String vendor_tech_desc, int parseInt, String tech_vendor_remark, int revise_id) {
        String query = "";
        query += " update VendorTechnicalBidTech a"
                + " set a.buyerRemark='"+tech_vendor_remark+"', "
                + " a.buyerResponse="+parseInt+" "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.description = '" +vendor_tech_desc+ "' and a.reviseVendorTechnicalBidId = '"+revise_id+"'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public void readByDelete(String refNo, String username) {
        
         String query = "";
        query += " delete from VendorTechnicalBidTech a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"'";
         Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}

