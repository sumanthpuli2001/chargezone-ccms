/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollSalaryLock;
import com.bul.zydex.service.Payroll.PayrollSalaryLockService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSalaryLockAbstract extends CustomAbstract{
    protected PayrollSalaryLockService<PayrollSalaryLock> payrollSalaryLockService;
    protected Validator payrollSalaryLockValidator;

    public PayrollSalaryLockService<PayrollSalaryLock> getPayrollSalaryLockService() {
        return payrollSalaryLockService;
    }

    public void setPayrollSalaryLockService(PayrollSalaryLockService<PayrollSalaryLock> payrollSalaryLockService) {
        this.payrollSalaryLockService = payrollSalaryLockService;
    }

    public Validator getPayrollSalaryLockValidator() {
        return payrollSalaryLockValidator;
    }

    public void setPayrollSalaryLockValidator(Validator payrollSalaryLockValidator) {
        this.payrollSalaryLockValidator = payrollSalaryLockValidator;
    }
    
}
