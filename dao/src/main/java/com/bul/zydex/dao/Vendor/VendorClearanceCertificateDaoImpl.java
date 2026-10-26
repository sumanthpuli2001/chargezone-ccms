/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorClearanceCertificate;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorClearanceCertificateDaoImpl<T> extends GenericsDAOImpl<T> implements VendorClearanceCertificateDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorClearanceCertificate.class;
    }
    
    @Override
    public List readId(int id) {
        String query = "";
        query += " FROM VendorClearanceCertificate a"
                + " WHERE a.vendorInformationId = " + id + "";
        return getHibernateTemplate().find(query);
    }
    
    @Override
    public void deleteById(String checkedValues) {
        String query = "";
        query += " delete FROM VendorClearanceCertificate a"
                + " WHERE a.id = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
    
}
