/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import com.bul.zydex.model.EmployeePayrollIncentive;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeePayrollIncentiveDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeePayrollIncentiveDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeePayrollIncentive.class;
    }

    @Override
    public List<?> readByEmployeePayrollIncentive(String month, String Year) {
        String query = "";
        String condition = "";
        query += "Select a.id"
                + " From EmployeePayrollIncentive a "
                + " where a.month='" + month + "'"
                + " and a.year='" + Year + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeePayrollIncentivelistAmount(EmployeeIncentiveMonthwise employeeIncentiveMonthwise) {
        String query = "";
        String condition = "";
        query += "Select a.prodIncentiveAmount,a.incentiveAmount"
                + " From EmployeePayrollIncentive a "
                + " left join a.employeeIncentiveMonthwise b"
                + " Where b.id=" + employeeIncentiveMonthwise.getId();
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeePayrollIncentivelistAmountEdit(int id) {
        String query = "";
        String condition = "";
        query += "Select a.pDay,a.prodIncentivePerDay,a.basicRatePerDay,a.attenIncentiveDay,a.incentiveAmount,a.prodIncentiveAmount,b.id,a.id,c.id,a.month,a.year"
                + " From EmployeePayrollIncentive a "
                + " left join a.employeeIncentiveMonthwise b"
                + " left join a.employeeMaster c"
                + " Where a.id=" + id;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeePayrollIncentiveReport(String month, String Year) {
        String query = "";
        String condition = "";
        query += "Select c.employeeId,c.employeeName, a.pDay,a.prodIncentivePerDay,a.prodIncentiveAmount,a.basicRatePerDay,a.attenIncentiveDay,a.incentiveAmount,c.bankAccountNo"
                + " From EmployeePayrollIncentive a "
                + " left join a.employeeIncentiveMonthwise b"
                + " left join a.employeeMaster c"
                + " where a.month='" + month + "'"
                + " and a.year='" + Year + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByEmployeePayrollIncentiveReportnew(String month, String Year) {
        String query = "";
        String condition = "";
        query += "Select c.employeeId,c.employeeName, a.pDay,a.prodIncentivePerDay,a.prodIncentiveAmount,a.basicRatePerDay,a.attenIncentiveDay,a.incentiveAmount,c.bankAccountNo"
                + " From EmployeePayrollIncentive a "
                + " left join a.employeeIncentiveMonthwise b"
                + " left join a.employeeMaster c"
                + " where a.prodIncentiveAmount >=0"
                + "and a.month='" + month + "'"
                + " and a.year='" + Year + "'";
        return getHibernateTemplate().find(query);
    }

}
