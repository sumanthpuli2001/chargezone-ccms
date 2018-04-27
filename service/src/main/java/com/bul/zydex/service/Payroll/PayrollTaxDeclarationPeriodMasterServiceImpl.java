/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollTaxDeclarationPeriodMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeclarationPeriodMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollTaxDeclarationPeriodMasterService<T>{
   
    private PayrollTaxDeclarationPeriodMasterDao<T> payrollTaxDeclarationPeriodMasterDao;

    public PayrollTaxDeclarationPeriodMasterDao<T> getPayrollTaxDeclarationPeriodMasterDao() {
        return payrollTaxDeclarationPeriodMasterDao;
    }

    public void setPayrollTaxDeclarationPeriodMasterDao(PayrollTaxDeclarationPeriodMasterDao<T> payrollTaxDeclarationPeriodMasterDao) {
        this.payrollTaxDeclarationPeriodMasterDao = payrollTaxDeclarationPeriodMasterDao;
        setGenericsDAO(payrollTaxDeclarationPeriodMasterDao);
    }

    @Override
    public List<?> readDeclarationPeriod() {
        return payrollTaxDeclarationPeriodMasterDao.readDeclarationPeriod();
    }

    @Override
    public List<?> readPayrollTaxDeclarationPeriodMaster(int finicialYearID, String month, String year) {
     return payrollTaxDeclarationPeriodMasterDao.readPayrollTaxDeclarationPeriodMaster(finicialYearID, month, year);
    }

    @Override
    public List<?> readPayrollTaxDeclarationPeriodMasterBefore(int finicialYearID, String month, String year) {
       return payrollTaxDeclarationPeriodMasterDao.readPayrollTaxDeclarationPeriodMasterBefore(finicialYearID, month, year);
    }

    @Override
    public List<?> readPayrollTaxDeclarationPeriodMasterAfterProofDate(int finicialYearID, String month, String year) {
       return payrollTaxDeclarationPeriodMasterDao.readPayrollTaxDeclarationPeriodMasterAfterProofDate(finicialYearID, month, year);
    }
    
    
    
   

}
