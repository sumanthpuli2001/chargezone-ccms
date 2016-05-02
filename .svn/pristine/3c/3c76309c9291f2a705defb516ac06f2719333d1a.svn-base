/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.COffLeaveRequest;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class COffLeaveRequestDAOImpl<T> extends GenericsDAOImpl<T> implements COffLeaveRequestDAO<T> {

    @Override
    protected Class getDomainClass() {
        return COffLeaveRequest.class;
    }

    @Override
    public List<?> userWiseCoffList(int id) {
        String query = "";
        query += " FROM COffLeaveRequest a"
                + " Where a.userMaster.id=" + id;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> approverWiseCoffList(int id) {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.dateOf,a.noOfHoursWork,a.leaveFor,a.remark,a.status"
                + " FROM COffLeaveRequest a,"
                + " EmployeeMaster b"
                + " Where a.userMaster.id=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> userPendingRequest(int id) {
        String query = "";
        query += " FROM COffLeaveRequest a"
                + " Where a.userMaster.id=" + id
                + " and status= 0";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> approverWiseCoffPendingList(int id) {
        String query = "";
        query += " SELECT a.id,b.employeeName,a.dateOf,a.noOfHoursWork,a.leaveFor,a.remark,a.status"
                + " FROM COffLeaveRequest a,"
                + " EmployeeMaster b"
                + " Where a.userMaster.id=b.userMaster.id"
                + " and b.reportingManagerLevel1=" + id
                + " and status= 0";

        return getHibernateTemplate().find(query);
    }
}
