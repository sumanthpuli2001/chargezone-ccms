/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorRequestedInvitationCategory;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorRequestedInvitationCategoryDaoImpl<T> extends GenericsDAOImpl<T> implements VendorRequestedInvitationCategoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorRequestedInvitationCategory.class;
    }

    @Override
    public List readByVendorRequestId(String id) {
        String query = "select a.id,a.vendodRequestId,b.groupName,c.groupCatogryName,d.subCategoryName";
        query += " FROM  VendorRequestedInvitationCategory a , GroupMaster b ,GroupCategory c , GroupSubCategory d  "
                + " WHERE a.vendodRequestId = '" + id + "'"
                + " and a.groupId = b.id"
                + " and a.groupCategoryId = c.id"
                + " and a.groupSubCategoryId = d.id";
        List list = getHibernateTemplate().find(query);
        return list;
    }

}
