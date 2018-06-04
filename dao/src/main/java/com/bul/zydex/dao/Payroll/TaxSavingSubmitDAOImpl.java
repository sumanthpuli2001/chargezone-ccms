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
    public boolean isExist(Integer empID, Integer finicailyear) {
        boolean flag = true;

        String query = "";
        query += ""
                + " From TaxSavingSubmit a "
                + " where a.employeeMaster = " + empID
                + " and a.payrollFinancialYear = " + finicailyear;
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        List<?> list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<?> readTaxSavingSubmit(int EmplID, int finicailyear) {
        String query = "";
        query += " select a"
                + " From TaxSavingSubmit a "
                + " where a.employeeMaster = " + EmplID
                + " and a.payrollFinancialYear = " + finicailyear;
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTaxSavingSubmitSalaryGenerate(int EmplID, int finicailyear) {
        String query = "";
        query += " select a"
                + " From TaxSavingSubmit a "
                + " where a.employeeMaster = " + EmplID
                + " and a.payrollFinancialYear = " + finicailyear
                + " and a.status = " + 2;
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readTaxSavingSubmitSalaryGenerateAfterDate(int EmplID, int finicailyear) {
        String query = "";
        query += " select a"
                + " From TaxSavingSubmit a "
                + " where a.employeeMaster = " + EmplID
                + " and a.payrollFinancialYear = " + finicailyear
                + " and a.status = " + 2;
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        return getHibernateTemplate().find(query);
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
        query += "SELECT a.id from TaxSavingSubmit a WHERE a.employeeMaster.id = " + employeeId + " and a.payrollFinancialYear.id = " + financialId;
        List list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readTaxSavingSubmitForEmployee(EmployeeMaster employeeMaster, String Financial_year) {
        String query = "";
        EmployeeMaster empMaster = (EmployeeMaster) employeeMaster;
        query += " SELECT b.employeeId, b.employeeName, b.id, c.id "
                + " FROM TaxSavingSubmit a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN a.payrollFinancialYear c"
                + " WHERE c.id = " + Financial_year;

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readTaxSavingSubmitEmployeeSaving(int EmplID, int finicailyear) {
        String query = "";
        query += " Select b.employeeId, b.employeeName, b.id, c.id,a.status"
                + " From TaxSavingSubmit a "
                + " LEFT JOIN a.employeeMaster b "
                + " LEFT JOIN a.payrollFinancialYear c"
                + " where a.employeeMaster = " + EmplID
                + " and a.payrollFinancialYear = " + finicailyear;
//                + " AND STR_TO_DATE(a.startDateTime,'%d/%m/%Y %H:%i') BETWEEN STR_TO_DATE('" + poolCarRequest.getStartDateTime() + " 00:00','%d/%m/%Y %H:%i') AND STR_TO_DATE('" + poolCarRequest.getEndDateTime() + " 00:00','%d/%m/%Y %H:%i')";

        return getHibernateTemplate().find(query);
//         query += " Select a.employeeId, a.employeeName, a.id, b.id"
//                + " From EmployeeMaster a,"
//                + " PayrollFinancialYear b,"
//                + " TaxSavingSubmit c"
//                + " Where (a.zydexLocationMaster.id = b.zydexLocationMaster.id or (b.id=c.payrollFinancialYear.id and a.id=c.employeeMaster.id))"
////                + " and b.id=c.payrollFinancialYear.id"
//                //                + " and a.id=c.employeeMaster.id"
//                + " and 1=1 " + condition;
    }
}
