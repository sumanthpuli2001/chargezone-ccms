/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollLoanRemainingAmountDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class PayrollLoanRemainingAmountServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollLoanRemainingAmountService<T> {

    private PayrollLoanRemainingAmountDAO<T> payrollLoanRemainingAmountDAO;

    public PayrollLoanRemainingAmountDAO<T> getPayrollLoanRemainingAmountDAO() {
        return payrollLoanRemainingAmountDAO;
    }

    public void setPayrollLoanRemainingAmountDAO(PayrollLoanRemainingAmountDAO<T> payrollLoanRemainingAmountDAO) {
        this.payrollLoanRemainingAmountDAO = payrollLoanRemainingAmountDAO;
        setGenericsDAO(payrollLoanRemainingAmountDAO);
    }

    @Override
    public List<?> readByLoanReaminingAmount(EmployeeSalaryProcess employeeSalaryProcess) {
        return payrollLoanRemainingAmountDAO.readByLoanReaminingAmount(employeeSalaryProcess);
    }

    @Override
    public List<?> readByloanRemainingAmountslip(int id, String month, String year) {
         return payrollLoanRemainingAmountDAO.readByloanRemainingAmountslip(id, month, year);
    }
    @Override
    public List<?> getPayrollLoanDetails(EmployeeMaster employeeMaster) {
        return payrollLoanRemainingAmountDAO.getPayrollLoanDetails(employeeMaster);
    }

    @Override
    public void delete1(T object) {
       payrollLoanRemainingAmountDAO.delete1(object);
    }

    @Override
    public List<?> readByloanDepartment(String month, String year) {
     return payrollLoanRemainingAmountDAO.readByloanDepartment(month, year);
    }
    
}

    
