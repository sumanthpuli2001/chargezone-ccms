/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollDeductionDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollDeductionServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollDeductionService<T> {

    private PayrollDeductionDAO<T> payrollDeductionDAO;

    public PayrollDeductionDAO<T> getPayrollDeductionDAO() {
        return payrollDeductionDAO;
    }

    public void setPayrollDeductionDAO(PayrollDeductionDAO<T> payrollDeductionDAO) {
        this.payrollDeductionDAO = payrollDeductionDAO;
        setGenericsDAO(payrollDeductionDAO);
    }

    @Override
    public List readDayWiseDeductionAmount(EmployeeSalaryProcess employeeSalaryProcess) {
       return payrollDeductionDAO.readDayWiseDeductionAmount(employeeSalaryProcess);
    }

}
