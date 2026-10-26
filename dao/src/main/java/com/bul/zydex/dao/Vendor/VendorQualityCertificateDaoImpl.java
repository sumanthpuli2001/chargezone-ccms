/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorQualityCertificate;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorQualityCertificateDaoImpl<T> extends GenericsDAOImpl<T> implements VendorQualityCertificateDao<T> {
        
    @Override
    protected Class getDomainClass() {
        return VendorQualityCertificate.class;
    }
    
    @Override
    public List readId(int id) {
        String query = "";
        query += " FROM VendorQualityCertificate a"
                + " WHERE a.vendorInformationId = " + id + "";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public void deleteById(String checkedValues) {
        String query = "";
        query += " delete FROM VendorQualityCertificate a"
                + " WHERE a.id = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
}
