/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollAdditionalAmountDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollAdditionalAmountServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollAdditionalAmountService<T> {

    private PayrollAdditionalAmountDAO<T> payrollAdditionalAmountDAO;

    public PayrollAdditionalAmountDAO<T> getPayrollAdditionalAmountDAO() {
        return payrollAdditionalAmountDAO;
    }

    public void setPayrollAdditionalAmountDAO(PayrollAdditionalAmountDAO<T> payrollAdditionalAmountDAO) {
        this.payrollAdditionalAmountDAO = payrollAdditionalAmountDAO;
        setGenericsDAO(payrollAdditionalAmountDAO);
    }

    @Override
    public List readdaywise(int empId, String Date) {
        return payrollAdditionalAmountDAO.readdaywise(empId, Date);
    }

    @Override
    public List readDayWiseAdditionalAmount(EmployeeSalaryProcess employeeSalaryProcess) {
       return payrollAdditionalAmountDAO.readDayWiseAdditionalAmount(employeeSalaryProcess);
    }

}
