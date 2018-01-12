/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollRecurringAdditionalAmount;
import com.bul.zydex.service.Payroll.PayrollRecurringAdditionalAmountService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollRecurringAdditionalAmountAbstract extends CustomAbstract{
    protected PayrollRecurringAdditionalAmountService<PayrollRecurringAdditionalAmount> payrollRecurringAdditionalAmountService;
    Validator payrollRecurringAdditionalAmountValidator;

    public PayrollRecurringAdditionalAmountService<PayrollRecurringAdditionalAmount> getPayrollRecurringAdditionalAmountService() {
        return payrollRecurringAdditionalAmountService;
    }

    public void setPayrollRecurringAdditionalAmountService(PayrollRecurringAdditionalAmountService<PayrollRecurringAdditionalAmount> payrollRecurringAdditionalAmountService) {
        this.payrollRecurringAdditionalAmountService = payrollRecurringAdditionalAmountService;
    }

    public Validator getPayrollRecurringAdditionalAmountValidator() {
        return payrollRecurringAdditionalAmountValidator;
    }

    public void setPayrollRecurringAdditionalAmountValidator(Validator payrollRecurringAdditionalAmountValidator) {
        this.payrollRecurringAdditionalAmountValidator = payrollRecurringAdditionalAmountValidator;
    }
    
}
