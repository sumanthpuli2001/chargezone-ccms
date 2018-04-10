/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RecruitmentApprovalHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RecruitmentApprovalHistory;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class RecruitmentApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements RecruitmentApprovalHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RecruitmentApprovalHistory.class;
    }

    @Override
    public List<?> getByRecruitementMasterId(int mppId) {
        String query = "";
        //      0       1               2               3           4       5               6           7           8
        query += "select a.id,a.approvalUserName,a.approvalUserId,a.comment,a.status,a.statusMessage,a.createDate,a.createdBy,b.id "
                + " FROM RecruitmentApprovalHistory a "
                + " LEFT JOIN a.recruitmentMaster b "
                + " WHERE b.id=" + mppId
                + " order by a.id desc ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> AppMppdelete(String APmppId) {
        String query = "";
        query += " "
                + " SELECT a"
                + " FROM RecruitmentApprovalHistory a "
                + " Where a.recruitmentMaster.id = " + APmppId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
