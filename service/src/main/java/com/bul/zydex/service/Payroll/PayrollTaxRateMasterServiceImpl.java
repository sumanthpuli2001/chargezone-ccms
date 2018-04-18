/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollTaxRateMasterDao;
import com.bul.zydex.model.PayrollTaxRateMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxRateMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollTaxRateMasterService<T> 
{
    private PayrollTaxRateMasterDao<T> payrollTaxRateMasterDao;

    public PayrollTaxRateMasterDao<T> getPayrollTaxRateMasterDao() {
        return payrollTaxRateMasterDao;
    }

    public void setPayrollTaxRateMasterDao(PayrollTaxRateMasterDao<T> payrollTaxRateMasterDao) {
        this.payrollTaxRateMasterDao = payrollTaxRateMasterDao;
        setGenericsDAO(payrollTaxRateMasterDao);
    }


    @Override
    public PayrollTaxRateMaster readTaxRate() {
        return payrollTaxRateMasterDao.readTaxRate();
    }

    @Override
    public List<?> getAgeValues(Integer ageF, Integer ageT, Integer incomeF, Integer incomeT) {
        return payrollTaxRateMasterDao.getAgeValues(ageF, ageT, incomeF, incomeT);
    }
    
    
}
