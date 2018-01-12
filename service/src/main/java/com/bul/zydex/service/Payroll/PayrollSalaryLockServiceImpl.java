/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollSalaryLockDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSalaryLockServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollSalaryLockService<T>{
     private PayrollSalaryLockDAO<T> payrollSalaryLockDAO;

    public PayrollSalaryLockDAO<T> getPayrollSalaryLockDAO() {
        return payrollSalaryLockDAO;
    }

    public void setPayrollSalaryLockDAO(PayrollSalaryLockDAO<T> payrollSalaryLockDAO) {
        this.payrollSalaryLockDAO = payrollSalaryLockDAO;
         setGenericsDAO(payrollSalaryLockDAO);
    }

    @Override
    public boolean payRollAmountCheckIsExist(T object) {
      return payrollSalaryLockDAO.payRollAmountCheckIsExist(object);
    }
     
}
