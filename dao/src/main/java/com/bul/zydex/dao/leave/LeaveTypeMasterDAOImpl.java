/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LeaveTypeMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class LeaveTypeMasterDAOImpl<T> extends GenericsDAOImpl<T> implements LeaveTypeMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return LeaveTypeMaster.class;
    }

    @Override
    public List<?> readCarriedForwardLeave() {
        String query = "";
        query += " FROM LeaveTypeMaster a "
                + " WHERE a.carriedForwardStatus=1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readLeaveType(String type) {
        String query = "";
        query += " Select a FROM LeaveTypeMaster a "
                + " WHERE a.leaveType='" + type + "'";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readLeaveTypeEditRegistration(String type) {
        String query = "";
        query += " Select a.id"
                + " FROM LeaveTypeMaster a "
                + " WHERE a.leaveType='" + type + "'";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByUsBySickLeave(int id, int empId) {
        String query = "";
        
        query = " Select a from EmployeeLeaveBalance a Right Join a.leaveTypeMaster b"
                + " where b.leaveType = 'Sick Leave' and a.noOfLeaveRemain <= 0 and a.employeeMaster.id = " + empId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
