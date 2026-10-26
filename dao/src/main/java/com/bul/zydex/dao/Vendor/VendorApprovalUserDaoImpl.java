/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorApprovalUser;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements VendorApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorApprovalUser.class;
    }

    @Override
    public List<?> readByIdToList(String id) {
        String query = "";
        query += " FROM VendorApprovalUser a"
                + " WHERE a.vendorApprovalSetting.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByIdToList1(String approval) {
 String query = "";
        query += " FROM VendorApprovalUser c"
              + " WHERE c.vendorApprovalSetting.id = '" + approval + "'";
        return getHibernateTemplate().find(query);
	    }

}
