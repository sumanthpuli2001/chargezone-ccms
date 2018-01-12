/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollCommission;
import com.bul.zydex.service.Payroll.PayrollCommissionService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollCommissionAbstract  extends  CustomAbstract{
    
     protected PayrollCommissionService<PayrollCommission> payrollCommissionService;
       Validator payrollCommissionValidator;

    public PayrollCommissionService<PayrollCommission> getPayrollCommissionService() {
        return payrollCommissionService;
    }

    public void setPayrollCommissionService(PayrollCommissionService<PayrollCommission> payrollCommissionService) {
        this.payrollCommissionService = payrollCommissionService;
    }

    public Validator getPayrollCommissionValidator() {
        return payrollCommissionValidator;
    }

    public void setPayrollCommissionValidator(Validator payrollCommissionValidator) {
        this.payrollCommissionValidator = payrollCommissionValidator;
    }

    
    
    
    
}
