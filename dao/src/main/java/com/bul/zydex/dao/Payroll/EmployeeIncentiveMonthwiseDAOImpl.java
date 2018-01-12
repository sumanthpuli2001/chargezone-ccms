/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeIncentiveMonthwiseDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeIncentiveMonthwiseDAO<T> {

    @Override
    protected Class getDomainClass() {
        return EmployeeIncentiveMonthwise.class;
    }

    @Override
    public List<?> readEmployeeForIncentive(String pincentive, String aincentive, String month1, String year11) {
        String query = "";
        String condition = "";
        query += "Select a.employeeId, a.employeeName,c.presentDays,b.employeeBasicSalary,b.employeeLwp"
                + " From EmployeeMaster a "
                + " left join a.employeeSalaryProcesses b"
                + " left join b.employeeExcelRecord c"
                + " where b.month='" + month1 + "'"
                + " and b.year='" + year11 + "'";

//        query += " Select a.employeeId, a.employeeName,c.deductionAmount,"
//                + " (c.deductionAmount*8.33)/12 as epfAmount,"
//                + " (c.deductionAmount*3.67)/12 as apfAmount,"
//                + " a.id,b.id"
//                + " From EmployeeMaster a"
//                + " left join a.employeeSalaryProcesses b"
//                + " left join b.employeeDeductionAmounts c"
//                + " where c.deductionType ='Pf' " + condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public void readByEmployeeIncentiveMonthwise(String month, String Year) {
        String query = "";

        query += "  "
                + "delete FROM EmployeeIncentiveMonthwise a "
                + " where a.month='" + month + "'"
                + " and a.year='" + Year + "'";

        getHibernateTemplate().bulkUpdate(query);
    }

}
