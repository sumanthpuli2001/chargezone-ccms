/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LeaveEmployeeDetailsApprovalHistory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LeaveEmployeeDetailsApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements LeaveEmployeeDetailsApprovalHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return LeaveEmployeeDetailsApprovalHistory.class;
    }

    @Override
    public List<?> getByLeaveEmpDetailId(int leaveEmpId) {

        String query = "";

        query += " Select a.id,a.approvalName, a.comment, a.statusMessage, a.createdDate "
                + " FROM LeaveEmployeeDetailsApprovalHistory a"
                + " LEFT JOIN a.leaveEmployeeDetail b"
                + " WHERE b.id=" + leaveEmpId
                + " ORDER BY a.id desc";

        return getHibernateTemplate().find(query);

    }

}
