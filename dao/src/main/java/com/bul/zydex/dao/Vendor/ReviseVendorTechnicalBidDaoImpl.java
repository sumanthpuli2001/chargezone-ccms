/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ReviseVendorTechnicalBid;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author Bulwark-5
 */
public class ReviseVendorTechnicalBidDaoImpl<T> extends GenericsDAOImpl<T> implements ReviseVendorTechnicalBidDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ReviseVendorTechnicalBid.class;
    }

    @Override
    public List readByVendorRefNo(String refNo, String username) {
        String query = "";
        query += " FROM ReviseVendorTechnicalBid a"
                + " WHERE a.refNo = '" + refNo + "' and vendorCode = '" +username+ "' order by a.id desc";
        return getHibernateTemplate().find(query);
    }
}
