/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTechnicalBidTermsAttachment;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class VendorTechnicalBidTermsAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTechnicalBidTermsAttachmentDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorTechnicalBidTermsAttachment.class;
    }

    @Override
    public List readAttachment(String refNo, String username, String desc) {
        String query = "";
        query += " FROM VendorTechnicalBidTermsAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+username+"' and a.description = '"+desc+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readVendorRefNo(String refNo, String vendorCode) {
        String query = "";
        query += " FROM VendorTechnicalBidTermsAttachment a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendorCode+"'";
        return getHibernateTemplate().find(query);
    }
}
