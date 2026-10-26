/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorRequestDetails;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements VendorRequestDetailsDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorRequestDetails.class;
    }

    @Override
    public List readByUserName(String username) {
        String query = "select a.id , a.createdBy ,a.email,a.company,a.phoneNo,a.contactaName,a.flagStatus";
        query += " FROM VendorRequestDetails a"
                + " WHERE a.createdBy =  '" + username + "'";
   
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByAprrove1() {
          String query = "select a.id , a.address ,a.email,a.company,a.phoneNo,a.contactaName,a.flagStatus";
        query += " FROM VendorRequestDetails a"
                + " WHERE a.flagStatus =  " + 2;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
