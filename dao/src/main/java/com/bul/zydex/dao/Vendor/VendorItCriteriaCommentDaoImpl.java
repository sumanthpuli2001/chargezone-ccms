/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorItCriteriaComment;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorItCriteriaCommentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorItCriteriaCommentDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorItCriteriaComment.class;
    } 
    
     @Override
    public List readByVendorInformationId(String VInformationId) {
        String query = "SELECT a";
        query += " FROM VendorItCriteriaComment a"
                + " where a.vendorInformationId =" + VInformationId;

        List list1 = getHibernateTemplate().find(query);
        return list1;
    }
    
}
