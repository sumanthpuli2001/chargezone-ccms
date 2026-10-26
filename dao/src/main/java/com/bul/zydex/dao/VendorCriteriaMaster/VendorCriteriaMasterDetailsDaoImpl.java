/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorCriteriaMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorCriteriaMasterDetails;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaMasterDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements VendorCriteriaMasterDetailsDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorCriteriaMasterDetails.class;
    }

    @Override
    public List readByCriteriaMasterId(String criteriaMasterId) {
        String query = "select a ";
        query += " FROM VendorCriteriaMasterDetails a "
                + " where a.vendorCriteriaMasterId= " + criteriaMasterId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByCriteriaMasterId(int criteriaMasterId) {
        String query = "delete FROM VendorCriteriaMasterDetails a "
                + " where a.vendorCriteriaMasterId= " + criteriaMasterId;
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

}
