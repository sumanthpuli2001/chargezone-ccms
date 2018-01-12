/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollMaximumSavingTaxAmountDAO;
import com.bul.zydex.model.PayrollMaximumSavingTaxAmount;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollMaximumSavingTaxAmountServiceImpl<T> extends GenericsServiceImpl<T>
        implements PayrollMaximumSavingTaxAmountService<T> {

    private PayrollMaximumSavingTaxAmountDAO<T> payrollMaximumSavingTaxAmountDAO;

    public PayrollMaximumSavingTaxAmountDAO<T> getPayrollMaximumSavingTaxAmountDAO() {
        return payrollMaximumSavingTaxAmountDAO;
    }

    public void setPayrollMaximumSavingTaxAmountDAO(PayrollMaximumSavingTaxAmountDAO<T> payrollMaximumSavingTaxAmountDAO) {
        this.payrollMaximumSavingTaxAmountDAO = payrollMaximumSavingTaxAmountDAO;
        setGenericsDAO(payrollMaximumSavingTaxAmountDAO);
    }

    @Override
    public boolean isExist(PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount) {
   boolean flag = false;
        List<?> list = payrollMaximumSavingTaxAmountDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            PayrollMaximumSavingTaxAmount payrollMaximumSavingTaxAmount1 = (PayrollMaximumSavingTaxAmount) i.next();
            if (payrollMaximumSavingTaxAmount1.getZydexLocationMaster().getId().intValue()
                    == payrollMaximumSavingTaxAmount.getZydexLocationMaster().getId().intValue() && payrollMaximumSavingTaxAmount1.getGender()
                    == payrollMaximumSavingTaxAmount.getGender()) {

                flag = true;
                break;
            }

        }

        return flag;
    }
}
