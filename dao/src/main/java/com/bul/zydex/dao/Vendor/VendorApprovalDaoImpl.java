/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorApproval;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements VendorApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorApproval.class;
    }

    @Override
    public List readId(int id) {
        String query = "";
        query += " FROM VendorApproval a"
                + " WHERE a.vendorInformationId = " + id + "";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readForVendorRecycled(int id) {
        String query = "";
        query += "FROM VendorApproval a "
                + "WHERE a.vendorInformationId = " + id + " "
                + "AND activity IN ('Buyer Recycle', 'Auditor Recycle', 'Procurement Head Recycle')";

        return getHibernateTemplate().find(query);

    }
}
