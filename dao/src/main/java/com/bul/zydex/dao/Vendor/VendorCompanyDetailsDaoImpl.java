/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorCompanyDetails;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorCompanyDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements VendorCompanyDetailsDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorCompanyDetails.class;
    }

    @Override
    public List readByVendorMail(String email) {
        String query = "";
        query += " FROM VendorCompanyDetails a"
                + " WHERE a.vendorCode ='" + email + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByInformationId(String vendorInformationid) {
   String query = "";
        query += " FROM VendorCompanyDetails a"
                + " WHERE a.vendorInformationId ='" + vendorInformationid + "'";

        return getHibernateTemplate().find(query);    }
}
