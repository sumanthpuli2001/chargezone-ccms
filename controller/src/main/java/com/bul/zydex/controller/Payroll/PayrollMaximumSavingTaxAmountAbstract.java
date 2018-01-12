/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollMaximumSavingTaxAmount;
import com.bul.zydex.service.Payroll.PayrollMaximumSavingTaxAmountService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public abstract class PayrollMaximumSavingTaxAmountAbstract extends CustomAbstract {

    protected PayrollMaximumSavingTaxAmountService<PayrollMaximumSavingTaxAmount> payrollMaximumSavingTaxAmountService;
    protected Validator payrollMaximumSavingTaxAmountValidator;

    public PayrollMaximumSavingTaxAmountService<PayrollMaximumSavingTaxAmount> getPayrollMaximumSavingTaxAmountService() {
        return payrollMaximumSavingTaxAmountService;
    }

    public void setPayrollMaximumSavingTaxAmountService(PayrollMaximumSavingTaxAmountService<PayrollMaximumSavingTaxAmount> payrollMaximumSavingTaxAmountService) {
        this.payrollMaximumSavingTaxAmountService = payrollMaximumSavingTaxAmountService;
    }

    public Validator getPayrollMaximumSavingTaxAmountValidator() {
        return payrollMaximumSavingTaxAmountValidator;
    }

    public void setPayrollMaximumSavingTaxAmountValidator(Validator payrollMaximumSavingTaxAmountValidator) {
        this.payrollMaximumSavingTaxAmountValidator = payrollMaximumSavingTaxAmountValidator;
    }

}
