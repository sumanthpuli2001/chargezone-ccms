/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollTaxDeclarationPeriodMaster;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeclarationPeriodMasterDaoImpl<T> extends GenericsDAOImpl<T> implements PayrollTaxDeclarationPeriodMasterDao<T>{

    @Override
    protected Class getDomainClass() {
        return PayrollTaxDeclarationPeriodMaster.class;
    }

    @Override
    public List<?> readDeclarationPeriod() {
        String query = "SELECT a.id, a.declarationThresholdDate, a.proofThresholdDate, b.title "
                + "FROM PayrollTaxDeclarationPeriodMaster a "
                + "left join a.payrollFinancialYear b";
        
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readPayrollTaxDeclarationPeriodMaster(int finicialYearID, String month, String year) {
      String query = "";
        String condition = "";
        String date = "01/" + month + "/" + year;

        query += " select a.id,a.declarationThresholdDate,a.proofThresholdDate"
                + " From PayrollTaxDeclarationPeriodMaster a"
                + " where a.payrollFinancialYear.id=" + finicialYearID
                + " and (str_to_date('" + date + "','%d/%m/%Y') between str_to_date(a.declarationThresholdDate,'%d/%m/%Y')"
                + " and str_to_date(a.proofThresholdDate,'%d/%m/%Y'))";
//              
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readPayrollTaxDeclarationPeriodMasterBefore(int finicialYearID, String month, String year) {
       String query = "";
        String condition = "";
        String date = "01/" + month + "/" + year;

        query += " select a.id,a.declarationThresholdDate,a.proofThresholdDate"
                + " From PayrollTaxDeclarationPeriodMaster a"
                + " where a.payrollFinancialYear.id=" + finicialYearID
                + " and (str_to_date('" + date + "','%d/%m/%Y') < str_to_date(a.declarationThresholdDate,'%d/%m/%Y'))";
               
//              
        return getHibernateTemplate().find(query); 
    }

    @Override
    public List<?> readPayrollTaxDeclarationPeriodMasterAfterProofDate(int finicialYearID, String month, String year) {
        String query = "";
        String condition = "";
        String date = "01/" + month + "/" + year;

        query += " select a.id,a.declarationThresholdDate,a.proofThresholdDate"
                + " From PayrollTaxDeclarationPeriodMaster a"
                + " where a.payrollFinancialYear.id=" + finicialYearID
                + " and (str_to_date('" + date + "','%d/%m/%Y') > str_to_date(a.proofThresholdDate,'%d/%m/%Y'))";
               
//              
        return getHibernateTemplate().find(query);   
    }

}