/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorInvitationCategory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class VendorInvitationCategoryDaoImpl<T> extends GenericsDAOImpl<T> implements VendorInvitationCategoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorInvitationCategory.class;
    }

//    @Override
//    public VendorInvitationCategory readIds(int i) {
//
//        VendorInvitationCategory vendorInvitationCategory = new VendorInvitationCategory();
//        String query = "";
//        query += " FROM  VendorInvitationCategory a , GroupMaster b ,GroupCategory c , GroupSubCategory d  "
//                + " WHERE a.vendorId = '" + i + "'"
//                + " and a.groupId = b.id"
//                + " and a.groupCategoryId = c.id"
//                + " and a.groupSubCategoryId = d.id";
//
//        List<?> list = getHibernateTemplate().find(query);
//        if (!list.isEmpty()) {
//            vendorInvitationCategory = (VendorInvitationCategory) list.get(0);
//        }
//        return vendorInvitationCategory;
//    }
    @Override
    public List readIds(int i) {
        String query = "select a.id,a.vendorId,b.groupName,c.groupCatogryName,d.subCategoryName";
        query += " FROM  VendorInvitationCategory a , GroupMaster b ,GroupCategory c , GroupSubCategory d  "
                + " WHERE a.vendorId = '" + i + "'"
                + " and a.groupId = b.id"
                + " and a.groupCategoryId = c.id"
                + " and a.groupSubCategoryId = d.id";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByAll(int vendorInvtId) {
        String query = "select a.id,a.vendorId,c.subCategoryName,b.criteriaName, b.criteriaDescription, c.id ,e.id, e.groupName, b.compulsaryFlag";
        query += " FROM  VendorInvitationCategory a, VendorTechnicalCriteria b, GroupSubCategory c , GroupMaster e  "
                + " WHERE a.vendorId = '" + vendorInvtId + "'"
                + " and a.groupId = b.groupMasterId"
                + " and a.groupCategoryId = b.groupCategoryId"
                + " and a.groupSubCategoryId = b.groupSubCategoryId and a.groupSubCategoryId = c.id and a.groupId= e.id";
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByVendorInvtlistId(int vendorInvtId) {
        String query = "select a";

        query += " FROM VendorInvitationCategory a"
                + " WHERE a.vendorId = '" + vendorInvtId + "'";
        List list = getHibernateTemplate().find(query);
        return list;

    }
    
    @Override
    public VendorInvitationCategory readByVendorInvtId(int vendorInvtId) {
        String query = "";
        VendorInvitationCategory vendorInvitationCategory = new VendorInvitationCategory();
        query += " FROM VendorInvitationCategory a"
                + " WHERE a.vendorId = '" + vendorInvtId + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorInvitationCategory = (VendorInvitationCategory) list.get(0);
        }
        return vendorInvitationCategory;
    }
    
}