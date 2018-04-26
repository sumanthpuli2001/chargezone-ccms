/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
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
                + " and a.status = " + 1;
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

}
