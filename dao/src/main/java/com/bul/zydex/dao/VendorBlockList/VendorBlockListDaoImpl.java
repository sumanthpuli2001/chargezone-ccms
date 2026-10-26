/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorBlockList;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorBlockList;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class VendorBlockListDaoImpl<T> extends GenericsDAOImpl<T> implements VendorBlockListDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorBlockList.class;

    }

    @Override
    public List readByVendorinfoid(String vendorInformationid) {

        String query = "";
        query += " FROM VendorBlockList a"
                + " WHERE a.vendorInfoId = '" + vendorInformationid + "'";
        return getHibernateTemplate().find(query);
    }

    
    
    

}
