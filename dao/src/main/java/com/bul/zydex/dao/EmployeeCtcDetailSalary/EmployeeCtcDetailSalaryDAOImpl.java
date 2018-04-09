/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.EmployeeCtcDetailSalary;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeCtcDetailSalary;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailSalaryDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeCtcDetailSalaryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeCtcDetailSalary.class;
    }

    @Override
    public List<?> readEmployeeCtcDetailSalary(int employeeid, String month, String year, int ctcid) {
        String query = "";
        query += "select Sum(a.amount),b.ctcName"
                + " FROM EmployeeCtcDetailSalary a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid
                + " and a.ctcAllowance.id=" + ctcid
                + " and a.yearly = '" + year + "'"
                + " and a.monthly = '" + month + "'";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeCtcReport(int employeeid, String month, String year) {
        String query = "";
        query += "select a"
                + " FROM EmployeeCtcDetailSalary a "
                + " left join a.ctcAllowance b"
                + " where a.employeeMaster.id=" + employeeid
                + " and a.year = '" + year + "'"
                + " and a.month = '" + month + "'";

        return getHibernateTemplate().find(query);
    }

}
