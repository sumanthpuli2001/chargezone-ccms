/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapVendorEmail;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class SapVendorEmailDaoImpl<T> extends GenericsDAOImpl<T> implements SapVendorEmailDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return SapVendorEmailDao.class;
    }

    @Override
    public List readByAddrNum(String ADRNR) {
        String query = "";
        query += " FROM SapVendorEmail a"
                + " WHERE a.addrNumber = '" + ADRNR + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void truncate() {
        String query = "";
            query += " delete from SapVendorEmail a ";
                
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }
}
