/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RecruitmentApprovalHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprApprovalHistory;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class MprApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements MprApprovalHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return MprApprovalHistory.class;
    }

    @Override
    public List<?> getByMprId(int mprId) {

        String query = "";
        //                  0       1               2               3           4       5               6           7           8          
        query += "select a.id,a.approvalUserName,a.approvalUserId,a.comment,a.status,a.statusMessage,a.createDate,a.createdBy,b.id "
                + " FROM MprApprovalHistory a "
                + " LEFT JOIN a.mprMaster b "
                + " WHERE b.id=" + mprId
                + " order by a.id desc ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> gethistory(int mprId) {
           String query = "";
        //                  0       1               2               3           4       5               6           7           8          
        query += "select a.id,a.approvalUserName,a.approvalUserId,a.comment,a.status,a.statusMessage,a.createDate,a.createdBy"
                + " FROM MprApprovalHistory a "
                + " WHERE a.applicationId=" + mprId
                + " order by a.id desc ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
