/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorTechnicalCriteria;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorTechnicalCriteriaDaoImpl<T> extends GenericsDAOImpl<T> implements VendorTechnicalCriteriaDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorTechnicalCriteria.class;
    }

    @Override
    public List readAll() {
        String query = "select a.id,b.groupName,c.groupCatogryName,d.subCategoryName,a.criteriaName,a.criteriaDescription, d.id, a.compulsaryFlag";
        query += " FROM VendorTechnicalCriteria a,GroupSubCategory d,GroupCategory c, GroupMaster b"
                + " WHERE a.groupMasterId =b.id"
                + " and a.groupCategoryId=c.id"
                + " and a.groupSubCategoryId=d.id group by d.subCategoryName";
        return getHibernateTemplate().find(query);
    }
    
    
     @Override
    public List readAllVendorTechnicalCriteria(int groupSubCategoryId, int groupMasterId, int groupCategoryId) {

     String query = "select a";
        query += " FROM VendorTechnicalCriteria a"
                + " WHERE a.groupMasterId =  '"+ groupMasterId +"'"
                + " and a.groupCategoryId = '"+ groupCategoryId +"'"
                + " and a.groupSubCategoryId='"+ groupSubCategoryId +"'";
         List<?> list = getHibernateTemplate().find(query);
        return list;
    
    
    }

}
