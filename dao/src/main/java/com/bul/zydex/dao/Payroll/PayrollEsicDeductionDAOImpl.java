/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollEsicDeduction;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollEsicDeductionDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollEsicDeductionDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollEsicDeduction.class;
    }

    @Override
    public List<?> readByEmployeEsicReport(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";
        String condition = "";

        query += " select a "
                + " From PayrollEsicDeduction a"
                + " left join a.employeeSalaryProcess b"
                + " where b.employeeMaster.id= " + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and b.month='" + employeeSalaryProcess.getMonth() + "'"
                + " and b.year='" + employeeSalaryProcess.getYear() + "'";

        return getHibernateTemplate().find(query);

    }

}
