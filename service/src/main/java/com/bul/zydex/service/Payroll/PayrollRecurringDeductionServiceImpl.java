/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollRecurringDeductionDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollRecurringDeductionServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollRecurringDeductionService<T> {

    private PayrollRecurringDeductionDAO<T> payrollRecurringDeductionDAO;

    public PayrollRecurringDeductionDAO<T> getPayrollRecurringDeductionDAO() {
        return payrollRecurringDeductionDAO;
    }

    public void setPayrollRecurringDeductionDAO(PayrollRecurringDeductionDAO<T> payrollRecurringDeductionDAO) {
        this.payrollRecurringDeductionDAO = payrollRecurringDeductionDAO;
        setGenericsDAO(payrollRecurringDeductionDAO);
    }

    @Override
    public List<?> readRecurringDeductionAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        return payrollRecurringDeductionDAO.readRecurringDeductionAmount(employeeSalaryProcess);
    }

}
