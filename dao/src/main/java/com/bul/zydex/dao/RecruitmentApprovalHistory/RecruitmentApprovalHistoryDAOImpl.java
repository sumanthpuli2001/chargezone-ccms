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
        query += "select ";
//                + " FROM RecruitmentApprovalHistory a "
//                + " LEFT JOIN a.employeeMasterByApprover1Id b"
//                + " LEFT JOIN a.employeeMasterByEmployeeId c"
//                + " WHERE b.id='" + appId + "' and  a.id='" + tabId + "' and (a.status=0) ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
