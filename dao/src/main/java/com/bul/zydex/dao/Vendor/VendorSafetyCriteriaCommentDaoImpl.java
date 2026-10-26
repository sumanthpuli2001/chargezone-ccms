/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorSafetyCriteriaComment;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorSafetyCriteriaCommentDaoImpl<T> extends GenericsDAOImpl<T> implements VendorSafetyCriteriaCommentDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return VendorSafetyCriteriaComment.class;
    }

    @Override
    public List readByVendorInformationId(String VInformationId) {
      String query = "SELECT a";
        query += " FROM VendorSafetyCriteriaComment a"
                + " where a.vendorInformationId =" + VInformationId;

        List list1 = getHibernateTemplate().find(query);
        return list1;
    }
    
    
}
