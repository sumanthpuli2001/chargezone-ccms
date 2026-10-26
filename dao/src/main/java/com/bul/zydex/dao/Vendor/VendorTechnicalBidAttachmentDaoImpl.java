/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTechnicalBidAttachment;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorTechnicalBidAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTechnicalBidAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorTechnicalBidAttachment.class;
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorTechnicalBidAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String attachment_desc) {
        String query = "";
        query += " FROM VendorTechnicalBidAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" + username + "' and description = '" + attachment_desc + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String attachment_desc, String attachment_comp, String attachment) {
        String query = "";
        query += " update VendorTechnicalBidAttachment a"
                + " set a.description='" + attachment_desc + "', "
                + " a.attachmentRequired='" + attachment_comp + "', "
                + " a.attachment='" + attachment + "' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "' and description = '" + attachment_desc + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public VendorTechnicalBidAttachment readByTechdoc(String refNo, String username, String tech_attachment_desc) {
        VendorTechnicalBidAttachment vendorTechnicalBidAttachment = new VendorTechnicalBidAttachment();
        String query = "";
        query += " FROM VendorTechnicalBidAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "' and a.description = '" + tech_attachment_desc + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorTechnicalBidAttachment = (VendorTechnicalBidAttachment) list.get(0);
        }
        return vendorTechnicalBidAttachment;
    }

    @Override
    public void readByDelete(String refNo, String username) {
        String query = "";
        query += "Delete FROM VendorTechnicalBidAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '" + username + "'";  
        
         Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
                }

 
}
