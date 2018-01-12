/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollBonusDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollBonusServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollBonusService<T> {

    private PayrollBonusDAO<T> payrollBonusDAO;

    public PayrollBonusDAO<T> getPayrollBonusDAO() {
        return payrollBonusDAO;
    }

    public void setPayrollBonusDAO(PayrollBonusDAO<T> payrollBonusDAO) {
        this.payrollBonusDAO = payrollBonusDAO;
        setGenericsDAO(payrollBonusDAO);
    }

    @Override
    public List<?> readBonusAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        return payrollBonusDAO.readBonusAmount(employeeSalaryProcess);
    }

}
