/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollRecurringAdditionalAmountDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollRecurringAdditionalAmountServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollRecurringAdditionalAmountService<T> {

    private PayrollRecurringAdditionalAmountDAO<T> payrollRecurringAdditionalAmountDAO;

    public PayrollRecurringAdditionalAmountDAO<T> getPayrollRecurringAdditionalAmountDAO() {
        return payrollRecurringAdditionalAmountDAO;
    }

    public void setPayrollRecurringAdditionalAmountDAO(PayrollRecurringAdditionalAmountDAO<T> payrollRecurringAdditionalAmountDAO) {
        this.payrollRecurringAdditionalAmountDAO = payrollRecurringAdditionalAmountDAO;
        setGenericsDAO(payrollRecurringAdditionalAmountDAO);
    }

    @Override
    public List<?> readRecurringAdditionalAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        return payrollRecurringAdditionalAmountDAO.readRecurringAdditionalAmount(employeeSalaryProcess);
    }

}
