/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollRecurringDeduction;
import com.bul.zydex.service.Payroll.PayrollRecurringDeductionService;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class PayrollRecurringDeductionAbstract extends CustomAbstract {

    protected PayrollRecurringDeductionService<PayrollRecurringDeduction> payrollRecurringDeductionService;
    protected Validator PayrollRecurringDeductionValidator;

    public PayrollRecurringDeductionService<PayrollRecurringDeduction> getPayrollRecurringDeductionService() {
        return payrollRecurringDeductionService;
    }

    public void setPayrollRecurringDeductionService(PayrollRecurringDeductionService<PayrollRecurringDeduction> payrollRecurringDeductionService) {
        this.payrollRecurringDeductionService = payrollRecurringDeductionService;
    }

    public Validator getPayrollRecurringDeductionValidator() {
        return PayrollRecurringDeductionValidator;
    }

    public void setPayrollRecurringDeductionValidator(Validator PayrollRecurringDeductionValidator) {
        this.PayrollRecurringDeductionValidator = PayrollRecurringDeductionValidator;
    }

}
