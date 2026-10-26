/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorRecycleMailScheduler;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorRecycleMailScheduler;
import java.util.List;

/**
 *
 * @author Bulwark-5
 */
public class VendorRecycleMailSchedulerDaoImpl<T> extends GenericsDAOImpl<T> implements VendorRecycleMailSchedulerDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorRecycleMailScheduler.class;
    }

    @Override
    public VendorRecycleMailScheduler readByInfoId(int vInfoId) {

        VendorRecycleMailScheduler vendorRecycleMailScheduler = new VendorRecycleMailScheduler();
        String query = "";
        query += " FROM VendorRecycleMailScheduler a"
                + " WHERE a.vendorInfoId = " + vInfoId + "";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorRecycleMailScheduler = (VendorRecycleMailScheduler) list.get(0);
        }
        return vendorRecycleMailScheduler;
    }

    @Override
    public List readByInfoIdList(int vInfoId) {

        String query = "";
        query += " FROM VendorRecycleMailScheduler a"
                + " WHERE a.vendorInfoId = '" + vInfoId + "'";
        return getHibernateTemplate().find(query);
    }

}
