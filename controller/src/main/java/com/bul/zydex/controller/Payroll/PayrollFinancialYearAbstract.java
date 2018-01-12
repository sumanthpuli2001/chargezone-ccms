/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.service.Payroll.PayrollFinancialYearService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public abstract class PayrollFinancialYearAbstract extends CustomAbstract{
    
    protected PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService;
    protected Validator payrollFinancialYearValidator;

    public PayrollFinancialYearService<PayrollFinancialYear> getPayrollFinancialYearService() {
        return payrollFinancialYearService;
    }

    public void setPayrollFinancialYearService(PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService) {
        this.payrollFinancialYearService = payrollFinancialYearService;
    }

    public Validator getPayrollFinancialYearValidator() {
        return payrollFinancialYearValidator;
    }

    public void setPayrollFinancialYearValidator(Validator payrollFinancialYearValidator) {
        this.payrollFinancialYearValidator = payrollFinancialYearValidator;
    }

  

    
}
