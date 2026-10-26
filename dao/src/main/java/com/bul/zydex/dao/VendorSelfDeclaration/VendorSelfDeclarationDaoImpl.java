/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorSelfDeclaration;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorSelfDeclaration;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorSelfDeclarationDaoImpl<T> extends GenericsDAOImpl<T> implements VendorSelfDeclarationDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorSelfDeclaration.class;
    }

    @Override
    public VendorSelfDeclaration readByVendorInformationId(int i1) {

        VendorSelfDeclaration vendorSelfDeclaration = new VendorSelfDeclaration();
        String query = "";
        query += " FROM VendorSelfDeclaration a"
                + " WHERE a.vendorInformationId = " + i1;
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorSelfDeclaration = (VendorSelfDeclaration) list.get(0);
        }
        return vendorSelfDeclaration;

    }

    @Override
    public List readBytwoflag(int twoflag, String VInformationId) {
        
         String query = "";
        query += " FROM VendorSelfDeclaration a"
                + " WHERE a. vendorInformationId= '" + VInformationId + "'"
                + " And a.desDecOneFlag= '" + twoflag + "'"
                + " And a.desDecTwoFlag= '" + twoflag + "'"
                + " And a.litigationHistoryDesFlag= '" + twoflag + "'"
                + " And a.politicalContributionDesFlag= '" + twoflag + "'"
                + " And a.conflictInsterestDesFlag= '" + twoflag + "'"
                + " And a.executiveJudicialDesFlag= '" + twoflag + "'"
                + " And a.politicallyExposedDesOneFlag= '" + twoflag + "'"
                + " And a.politicallyExposedDesTwoFlag= '" + twoflag + "'"
                + " And a.politicallyExposedDesThreeFlag= '" + twoflag + "'"
                + " And a.natureServicesOneFlag= '" + twoflag + "'"
                + " And a.natureServicesTwoFlag= '" + twoflag + "'"
                + " And a.ndaOneFlag= '" + twoflag + "'"
                + " And a.ndaTwoFlag= '" + twoflag + "'";
                
        
           return getHibernateTemplate().find(query);
    }

}
