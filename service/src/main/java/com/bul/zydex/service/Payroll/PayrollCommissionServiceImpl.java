/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollCommissionDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollCommissionServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollCommissionService<T> {

    private PayrollCommissionDAO<T> payrollCommissionDAO;

    public PayrollCommissionDAO<T> getPayrollCommissionDAO() {
        return payrollCommissionDAO;
    }

    public void setPayrollCommissionDAO(PayrollCommissionDAO<T> payrollCommissionDAO) {
        this.payrollCommissionDAO = payrollCommissionDAO;
        setGenericsDAO(payrollCommissionDAO);
    }

}
