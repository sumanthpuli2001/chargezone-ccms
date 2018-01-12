/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollSavingAmountDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSavingAmountServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollSavingAmountService<T>{
      private PayrollSavingAmountDAO<T> payrollSavingAmountDAO;

    public PayrollSavingAmountDAO<T> getPayrollSavingAmountDAO() {
        return payrollSavingAmountDAO;
    }

    public void setPayrollSavingAmountDAO(PayrollSavingAmountDAO<T> payrollSavingAmountDAO) {
        this.payrollSavingAmountDAO = payrollSavingAmountDAO;
        setGenericsDAO(payrollSavingAmountDAO);
    }

    @Override
    public List<?> readCheckEmployeeSaving(int empId, int yearid) {
       return payrollSavingAmountDAO.readCheckEmployeeSaving(empId, yearid);
    }
      
}
