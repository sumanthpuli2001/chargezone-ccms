/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.policy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeCtcDetail;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeCtcDetailDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeCtcDetail.class;
    }

    @Override
    public List<?> fetchctcData(int empId) {
        String query = "";
        query += " select b.id,b.ctcName,a.amount,a.status,a.month,a.year"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " left join a.employeeMaster c"
                + " where c.id=" + empId;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readctc(int employeeid) {
        String query = "";
        query += "select a.amount,b.ctcName"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readEmployeeCtcDetail(int employeeid) {
        String query = "";
        query += "select a.amount,b.ctcName,b.id,a.month,a.year"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid;

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeCtcReport(int employeeid, String month, String year) {
        String query = "";
        query += "select a"
                + " FROM EmployeeCtcDetail a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid
                + " and a.year = '" + year + "'"
                + " and a.month = '" + month + "'";

        return getHibernateTemplate().find(query);
    }

}
