/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.TermsCondition;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTermsConditionPriceBid;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VendorTermsConditionPriceBidDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTermsConditionPriceBidDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorTermsConditionPriceBid.class;
    }

    @Override
    public List readByRef(String ref, String username) {

        String query = "";
        query += " FROM VendorTermsConditionPriceBid a"
                + " WHERE a.tenderNo = '" + ref + "' and a.vendorCode = '" + username + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public VendorTermsConditionPriceBid readByTerms(String refNo, String username, String termsCondition) {
        VendorTermsConditionPriceBid vendorTermsConditionPriceBid = new VendorTermsConditionPriceBid();
        String query = "";
        query += " FROM VendorTermsConditionPriceBid a"
                + " WHERE a.tenderNo = '" + refNo + "' and a.vendorCode = '" + username + "' and a.termsCondition = '" + termsCondition + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorTermsConditionPriceBid = (VendorTermsConditionPriceBid) list.get(0);
        }
        return vendorTermsConditionPriceBid;
    }

}
