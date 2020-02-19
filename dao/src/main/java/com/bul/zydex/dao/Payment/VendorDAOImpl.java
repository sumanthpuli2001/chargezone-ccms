/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Vendors;
import java.util.List;

/**
 *
 * @author admin
 */
public class VendorDAOImpl<T> extends GenericsDAOImpl<T> implements VendorDAO<T> {
    
@Override
    protected Class getDomainClass() {
        return Vendors.class;
    }
    
    
    @Override
    public Vendors readByVendorCode(String vendorCode) {
        
        String query = "";

        query += "  "
                + " select v"
                + " FROM Vendors v "
                + " WHERE v.vendorCode=" + "'" + vendorCode + "'";
        List list = getHibernateTemplate().find(query);
        Vendors vendor = null;
        if(!list.isEmpty()){
            
          vendor= (Vendors) list.get(0);
        }
        return vendor;
}
}
