/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Sap;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SapVendorMaster;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class SapVendorMasterDaoImpl<T> extends GenericsDAOImpl<T> implements SapVendorMasterDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return SapVendorMasterDao.class;
    }

    @Override
    public void truncate() {
        String query = "";
            query += " delete from SapVendorMaster a ";
                
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readAll() {
        String query = "";
        query += " FROM SapVendorMaster a "
                + " ";
        return getHibernateTemplate().find(query);
    }
}
