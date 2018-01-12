/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollRecurringAdditionalAmountDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollRecurringAdditionalAmountDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollRecurringAdditionalAmount.class;
    }
    
     @Override
    public List<?> readRecurringAdditionalAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";

        query += ""
                + " From PayrollRecurringAdditionalAmount a"
                + " where a.employeeMaster.id=" + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and DATE_FORMAT(STR_TO_DATE('01/" + employeeSalaryProcess.getMonth() + "/" + employeeSalaryProcess.getYear() + "', '%d/%m/%Y'),'%m/%Y')"
                + " BETWEEN DATE_FORMAT(STR_TO_DATE(startDate, '%d/%m/%Y'),'%m/%Y') AND DATE_FORMAT(STR_TO_DATE(endDate, '%d/%m/%Y'),'%m/%Y')";
        return getHibernateTemplate().find(query);
    }

}
