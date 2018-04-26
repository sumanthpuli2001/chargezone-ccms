/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollTaxDeductionMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollTaxDeductionMasterService<T> {

    private PayrollTaxDeductionMasterDao<T> payrollTaxDeductionMasterDao;

    public PayrollTaxDeductionMasterDao<T> getPayrollTaxDeductionMasterDao() {
        return payrollTaxDeductionMasterDao;
    }

    public void setPayrollTaxDeductionMasterDao(PayrollTaxDeductionMasterDao<T> payrollTaxDeductionMasterDao) {
        this.payrollTaxDeductionMasterDao = payrollTaxDeductionMasterDao;
        setGenericsDAO(payrollTaxDeductionMasterDao);
    }

    @Override
    public List<?> readTaxDeduction() {
        return payrollTaxDeductionMasterDao.readTaxDeduction(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> readSectionByName(String sectionName) {
        return payrollTaxDeductionMasterDao.readSectionByName(sectionName);
    }

    @Override
    public List readSection() {
        return payrollTaxDeductionMasterDao.readSection();
    }

    @Override
    public List<?> readTaxDeductionForFormSixteen() {
        return payrollTaxDeductionMasterDao.readTaxDeductionForFormSixteen();
    }

    @Override
    public List<?> readByComponentId(int parseInt) {
        return payrollTaxDeductionMasterDao.readByComponentId(parseInt);
    }

    @Override
    public List<?> readTaxDeductionForFormSixteenFetch(int taxMasterid) {
        return payrollTaxDeductionMasterDao.readTaxDeductionForFormSixteenFetch(taxMasterid);
    }

    @Override
    public List readSectionAmount() {
      return payrollTaxDeductionMasterDao.readSectionAmount();
    }

}
