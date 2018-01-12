/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollAdditionalAmount;
import com.bul.zydex.service.Payroll.PayrollAdditionalAmountService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public abstract class PayrollAdditionalAmountAbstract extends CustomAbstract {

    protected PayrollAdditionalAmountService<PayrollAdditionalAmount> payrollAdditionalAmountService;
    protected Validator payrollAdditionalAmountValidator;

    public PayrollAdditionalAmountService<PayrollAdditionalAmount> getPayrollAdditionalAmountService() {
        return payrollAdditionalAmountService;
    }

    public void setPayrollAdditionalAmountService(PayrollAdditionalAmountService<PayrollAdditionalAmount> payrollAdditionalAmountService) {
        this.payrollAdditionalAmountService = payrollAdditionalAmountService;
    }

    public Validator getPayrollAdditionalAmountValidator() {
        return payrollAdditionalAmountValidator;
    }

    public void setPayrollAdditionalAmountValidator(Validator payrollAdditionalAmountValidator) {
        this.payrollAdditionalAmountValidator = payrollAdditionalAmountValidator;
    }

}
