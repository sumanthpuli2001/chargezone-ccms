/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorClearanceCertificate;
import com.bul.zydex.model.VendorCustomerRefrence;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorCustomerRefrenceDaoImpl<T> extends GenericsDAOImpl<T> implements VendorCustomerRefrenceDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorCustomerRefrence.class;
    }

    
    
     @Override
    public List readId(int id) {
        String query = "";
        query += " FROM VendorCustomerRefrence a"
                + " WHERE a.vendorInformationId = " + id + "";
        return getHibernateTemplate().find(query);
    }
    
     @Override
    public void deleteById(String checkedValues) {
        String query = "";
        query += " delete FROM VendorCustomerRefrence a"
                + " WHERE a.id = '" + checkedValues + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
