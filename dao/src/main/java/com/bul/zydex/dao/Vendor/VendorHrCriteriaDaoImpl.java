/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorHrCriteria;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorHrCriteriaDaoImpl<T> extends GenericsDAOImpl<T> implements VendorHrCriteriaDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorHrCriteria.class;
    }

    @Override
    public List readByAll() {
        String query = "select a.id,b.groupName,a.criteriaName,a.criteriaDescription, a.compulsaryFlag";
        query += " FROM VendorHrCriteria a, GroupMaster b"
                + " WHERE a.groupId =b.id";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByGroupName(String vendorInvtId) {
        String query = "select a.id,b.groupName,a.criteriaName,a.criteriaDescription,a.mandatory, a.compulsaryFlag";
        query += " FROM VendorInvitationCategory v , VendorHrCriteria a, GroupMaster b"
                + " WHERE a.groupId =b.id"
                + " and b.id=v.groupId"
                + " and v.vendorId = '" + vendorInvtId + "' group by a.criteriaName order by a.groupId";

        return getHibernateTemplate().find(query);
    }

}
