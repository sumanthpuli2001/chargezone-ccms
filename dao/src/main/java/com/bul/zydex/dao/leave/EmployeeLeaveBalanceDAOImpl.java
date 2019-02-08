/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeLeaveBalance;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class EmployeeLeaveBalanceDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeLeaveBalanceDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeLeaveBalance.class;
    }

    @Override
    public List<?> readByEmpId(T object) {
        EmployeeLeaveBalance employeeLeaveBalance = (EmployeeLeaveBalance) object;
        String query = "";

        query += " Select b.leaveType, a.noOfLeaveRemain, b.id"
                + " FROM EmployeeLeaveBalance a"
                + " LEFT JOIN a.leaveTypeMaster b"
                + " WHERE a.employeeMaster = " + employeeLeaveBalance.getEmployeeMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readleaveWiseBalance(T object) {
        EmployeeLeaveBalance employeeLeaveBalance = (EmployeeLeaveBalance) object;

        String query = "";
        query += ""
                + " From EmployeeLeaveBalance a "
                + " WHERE a.leaveTypeMaster.id = " + employeeLeaveBalance.getLeaveTypeMaster().getId()
                + " AND a.employeeMaster.id = " + employeeLeaveBalance.getEmployeeMaster().getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByleaveTypeId(T object) {
        EmployeeLeaveBalance employeeLeaveBalance = (EmployeeLeaveBalance) object;

        String query = "";
        query += ""
                + " From EmployeeLeaveBalance a "
                + " WHERE a.leaveTypeMaster.id = " + employeeLeaveBalance.getLeaveTypeMaster().getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmpIdAndLeaveTypeId(int empId, int levtyId) {

        String query = "";
        query += ""
                + " From EmployeeLeaveBalance a "
                + " WHERE a.leaveTypeMaster.id = " + levtyId
                + " and a.employeeMaster.id = " + empId;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmpId(int empId) {
        String query = "Select a"
                + " From EmployeeLeaveBalance a"
                + " left join a.leaveTypeMaster b"
                + " where a.employeeMaster=" + empId
                + " and (b.leaveType = 'Casual Leave' or b.leaveType = 'Sick Leave')";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByLeave(Integer empId, int leaveId) {
          String query = "";
        query += ""
                + " From EmployeeLeaveBalance a "
                + " WHERE a.leaveTypeMaster = " + leaveId
                + " AND a.employeeMaster = " + empId;
        return getHibernateTemplate().find(query);
    }

}
