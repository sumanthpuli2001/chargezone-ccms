/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollTaxDeductionComponentDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollTaxDeductionComponentServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollTaxDeductionComponentService<T> {

    private PayrollTaxDeductionComponentDao<T> payrollTaxDeductionComponentDao;

    public PayrollTaxDeductionComponentDao<T> getPayrollTaxDeductionComponentDao() {
        return payrollTaxDeductionComponentDao;
    }

    public void setPayrollTaxDeductionComponentDao(PayrollTaxDeductionComponentDao<T> payrollTaxDeductionComponentDao) {
        this.payrollTaxDeductionComponentDao = payrollTaxDeductionComponentDao;
        setGenericsDAO(payrollTaxDeductionComponentDao);
    }

    @Override
    public List<?> readTaxDeductionComponentforFromSixteen(int taxdeductionMasterid) {
        return payrollTaxDeductionComponentDao.readTaxDeductionComponentforFromSixteen(taxdeductionMasterid);
    }

    @Override
    public List<?> readByComponentId(int parseInt) {
        return payrollTaxDeductionComponentDao.readByComponentId(parseInt);
    }

    @Override
    public List readSection() {
        return payrollTaxDeductionComponentDao.readSection();
    }

    @Override
    public List<?> readComponent() {
        return payrollTaxDeductionComponentDao.readComponent();
    }

}
