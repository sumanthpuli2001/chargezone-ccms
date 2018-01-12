/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollAdditionalAmount;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollAdditionalAmountDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollAdditionalAmountDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollAdditionalAmount.class;
    }

    @Override
    public List<?> readdaywise(int empId, String Date) {
        PayrollAdditionalAmount payrollAdditionalAmount = (PayrollAdditionalAmount) readById(empId);
        String query = "";
        String condition = "";

        query += "Select b.employeeId, b.employeeName,a.amount,a.date"
                + " From PayrollAdditionalAmount a"
                + " LEFT JOIN a.employeeMaster b";
//                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);

    }

    @Override
    public List<?> readDayWiseAdditionalAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += ""
                + " From PayrollAdditionalAmount a"
                + " where a.employeeMaster.id=" + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and DATE_FORMAT(STR_TO_DATE(date, '%d/%m/%Y'),'%m/%Y')=DATE_FORMAT(STR_TO_DATE('01/" + employeeSalaryProcess.getMonth() + "/" + employeeSalaryProcess.getYear() + "', '%d/%m/%Y'),'%m/%Y')";
//                + " Where 1=1" + condition;
        return getHibernateTemplate().find(query);
    }

}
