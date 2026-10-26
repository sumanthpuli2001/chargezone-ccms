/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorFinancialApprovalDetails;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorFinancialApprovalDetails;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class VendorFinancialApprovalDetailsDaoImpl<T> extends GenericsDAOImpl<T> implements VendorFinancialApprovalDetailsDao<T> {

    @Override
    protected Class getDomainClass() {

        return VendorFinancialApprovalDetails.class;

    }

    @Override
    public VendorFinancialApprovalDetails readByVendorInformationId(int vendorInfoId) {

        VendorFinancialApprovalDetails vendorFinancialApprovalDetails = new VendorFinancialApprovalDetails();
        String query = "";
        query += " FROM VendorFinancialApprovalDetails a"
                + " WHERE a.vendorInfoId = " + vendorInfoId;
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorFinancialApprovalDetails = (VendorFinancialApprovalDetails) list.get(0);
        }
        return vendorFinancialApprovalDetails;

    }

}
