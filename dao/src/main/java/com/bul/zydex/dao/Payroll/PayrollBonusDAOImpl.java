/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.model.PayrollBonus;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollBonusDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollBonusDAO<T> {

    @Override
    protected Class getDomainClass() {
        return PayrollBonus.class;
    }

    @Override
    public List<?> readBonusAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        String query = "";

        query += ""
                + " From PayrollBonus a"
                + " where a.employeeMaster.id=" + employeeSalaryProcess.getEmployeeMaster().getId()
                + " and DATE_FORMAT(STR_TO_DATE(date, '%d/%m/%Y'),'%m/%Y')=DATE_FORMAT(STR_TO_DATE('01/" + employeeSalaryProcess.getMonth() + "/" + employeeSalaryProcess.getYear() + "', '%d/%m/%Y'),'%m/%Y')";
        return getHibernateTemplate().find(query);
    }

}
