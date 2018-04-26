/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TaxSavingSubmit;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class TaxSavingSubmitDAOImpl<T> extends GenericsDAOImpl<T> implements TaxSavingSubmitDAO<T> {

    @Override
    protected Class getDomainClass() {
        return TaxSavingSubmit.class;
    }

    @Override
    public List<?> readTaxSavingSubmitForEmployee(EmployeeMaster employeeMaster) {
        String query = "";
        EmployeeMaster empMaster = (EmployeeMaster) employeeMaster;
        query += " SELECT b.employeeId, b.employeeName, b.id, c.id "
                + " FROM TaxSavingSubmit a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN a.payrollFinancialYear c";
        
        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List taxSubmitSearchIdCheck(T object) {
        TaxSavingSubmit taxSavingSubmit = (TaxSavingSubmit) object;

        String query = "";
        query += "select a from TaxSavingSubmit a where "
                + " a.payrollFinancialYear.id  = " + taxSavingSubmit.getPayrollFinancialYear().getId()
                + " and a.employeeMaster.id  = " + taxSavingSubmit.getEmployeeMaster().getId();
                
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readDataForSaving(int employeeId, int financialId) {
        String query = "";
        query += "SELECT a.id from TaxSavingSubmit a WHERE a.employeeMaster.id = " +employeeId+ " and a.payrollFinancialYear.id = " +financialId ;
        List list = getHibernateTemplate().find(query);
        return list;
    }

}
