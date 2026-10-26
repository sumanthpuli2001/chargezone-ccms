/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuthTenderVendorDoc;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuthTenderVendorDocDaoImpl<T> extends GenericsDAOImpl<T> implements AuthTenderVendorDocDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuthTenderVendorDoc.class;
    }

    @Override
    public List readGeneralDoc(String refNo, String vendor_code, int i) {
        String query = "";
        query += " FROM AuthTenderVendorDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"' and a.documentType = "+i+"";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readAdditionalDoc(String refNo, String vendor_code, int i) {
        String query = "";
        query += " FROM AuthTenderVendorDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"' and a.documentType = "+i+"";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readTechnicalDoc(String refNo, String vendor_code, int i) {
        String query = "";
        query += " FROM AuthTenderVendorDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"' and a.documentType = "+i+"";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByRefNo(String refNo, String vendor_code) {
        String query = "";
        query += " FROM AuthTenderVendorDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDocRefNo(String refNo, String vendor_code, String attachment) {
        String query = "";
        query += " FROM AuthTenderVendorDoc a"
                + " WHERE a.refNo = '" + refNo + "' and a.vendorCode = '"+vendor_code+"' and a.document = '"+attachment+"'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteRefNo(String refNo) {
        String query = "";
            query += " delete from AuthTenderVendorDoc a"
                + " WHERE a.refNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
