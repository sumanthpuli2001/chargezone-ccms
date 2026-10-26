/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorPreBidAttachment;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorPreBidAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorPreBidAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorPreBidAttachment.class;
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM VendorPreBidAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" +username+ "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readVendorRefNo(String refNo, String username, String pre_attachment_desc) {
        String query = "";
        query += " FROM VendorPreBidAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" +username+ "' and description = '" +pre_attachment_desc+ "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendorRefNo(String refNo, String username, String pre_attachment_desc, String pre_attachment_comp, String pre_attachment) {
        String query = "";
        query += " update VendorPreBidAttachment a"
                + " set a.description='"+pre_attachment_desc+"', "
                + " a.attachmentRequired='"+pre_attachment_comp+"', "
                + " a.attachment='"+pre_attachment+"' "
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and description = '" +pre_attachment_desc+ "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
}
