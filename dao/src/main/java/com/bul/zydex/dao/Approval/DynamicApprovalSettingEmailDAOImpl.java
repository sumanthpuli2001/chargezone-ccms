/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DynamicApprovalSettingEmail;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DynamicApprovalSettingEmailDAOImpl<T> extends GenericsDAOImpl<T> implements DynamicApprovalSettingEmailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return DynamicApprovalSettingEmail.class;
    }

    @Override
    public List<?> readByApproverCycleId(int ApproverCycleId) {
        String query = "";

        query += " Select d "
                + " from DynamicApprovalSettingEmail d "
                + " left join d.dynamicApprovalSettingId da "
                + " where d.dynamicApprovalSettingId.id = " + ApproverCycleId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByDnamicApprovalSettingId(int ApproverId) {
        String query = "";

        query += " Select d "
                + " from DynamicApprovalSettingEmail d "
                + " left join d.dynamicApprovalSettingId da "
                + " where d.dynamicApprovalSettingId.id = " + ApproverId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deleteByApproverSettingId(int ApproverId) {
        String query = "";

        query += " Delete from DynamicApprovalSettingEmail d "
                + " Where d.dynamicApprovalSettingId.id =" + ApproverId;

        getHibernateTemplate().bulkUpdate(query);
    }

    @Override
    public List<?> readByModuleName(String moduleName) {
        String query = "";

        query += " Select d "
                + " from DynamicApprovalSettingEmail d "
                + " left join d.dynamicApprovalSettingId da "
                + " left join da.module m "
                + " where m.name like '" + moduleName + "' ";
        return getHibernateTemplate().find(query);
    }

}
