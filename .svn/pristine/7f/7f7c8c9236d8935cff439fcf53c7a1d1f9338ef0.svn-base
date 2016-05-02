/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LeaveEncashment;
import java.util.List;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class LeaveEncashmentDAOImpl<T> extends GenericsDAOImpl<T> implements LeaveEncashmentDAO<T> {

    @Override
    protected Class getDomainClass() {
        return LeaveEncashment.class;
    }

    @Override
    public List<?> readByEmpId(T object) {
        LeaveEncashment leaveEncashment = (LeaveEncashment) object;
        String query = "";

        query += " Select a.id,b.leaveType, a.totalLeave,a.noOfLeaveEncashment,a.createdDate,"
                + " Case when a.status = '0' then 'Pending' when a.status = '1' then 'Approved' when a.status = '2' then 'Rework' when a.status = '3' then 'Reject' else 'Other' end, a.status"
                + " FROM LeaveEncashment a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMasterByCreatorEmpId = " + leaveEncashment.getEmployeeMasterByCreatorEmpId().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmpNLeaveId(T object) {
        LeaveEncashment leaveEncashment = (LeaveEncashment) object;
        String query = "";

        query += " Select a.id,b.leaveType, a.totalLeave,a.noOfLeaveEncashment,a.createdDate,"
                + " Case when a.status = '0' then 'Pending' when a.status = '1' then 'Approved' else 'Other' end, a.status"
                + " FROM LeaveEncashment a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMasterByCreatorEmpId = " + leaveEncashment.getEmployeeMasterByCreatorEmpId().getId() + ""
                + " and a.leaveTypeMaster.id=" + leaveEncashment.getLeaveTypeMaster().getId() + " "
                + " and a.status='" + leaveEncashment.getStatus() + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readAll() {
        String query = "";

        query += " Select a.id,b.leaveType, a.totalLeave,a.noOfLeaveEncashment,a.createdDate,"
                + " Case when a.status = '0' then 'Pending' when a.status = '1' then 'Approved' else 'Other' end, a.status,"
                + " c.employeeName "
                + " FROM LeaveEncashment a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " LEFT JOIN a.employeeMasterByCreatorEmpId c";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readStatusByHr(T object) {
        LeaveEncashment leaveEncashment = (LeaveEncashment) object;

        String query = "";

        query += " Select a.id,b.leaveType, a.totalLeave,a.noOfLeaveEncashment,a.createdDate,"
                + " Case when a.status = '0' then 'Pending' when a.status = '1' then 'Approved' when a.status = '2' then 'Rework' when a.status = '3' then 'Reject' else 'Other' end, a.status,"
                + " c.employeeName "
                + " FROM LeaveEncashment a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " LEFT JOIN a.employeeMasterByCreatorEmpId c"
                + " where a.status =" + leaveEncashment.getStatus();

        return getHibernateTemplate().find(query);
    }
}
