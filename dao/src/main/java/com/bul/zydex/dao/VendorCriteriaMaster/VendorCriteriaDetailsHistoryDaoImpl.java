/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorCriteriaMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorCriteriaDetailsHistory;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorCriteriaDetailsHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements VendorCriteriaDetailsHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorCriteriaDetailsHistory.class;
    }

    @Override
    public List readByCriteriaMasterId(int id) {
        String query = "select a ";
        query += " FROM VendorCriteriaDetailsHistory a "
                + " where a.vendorCriteriaMasterId= " + id;
        return getHibernateTemplate().find(query);
    }

}
