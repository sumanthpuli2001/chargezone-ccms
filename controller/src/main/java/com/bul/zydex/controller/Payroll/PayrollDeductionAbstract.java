/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollDeduction;
import com.bul.zydex.service.Payroll.PayrollDeductionService;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class  PayrollDeductionAbstract extends CustomAbstract{
     protected PayrollDeductionService<PayrollDeduction> payrollDeductionService;
     protected  Validator PayrollDeductionValidator;

    public PayrollDeductionService<PayrollDeduction> getPayrollDeductionService() {
        return payrollDeductionService;
    }

    public void setPayrollDeductionService(PayrollDeductionService<PayrollDeduction> payrollDeductionService) {
        this.payrollDeductionService = payrollDeductionService;
    }

    public Validator getPayrollDeductionValidator() {
        return PayrollDeductionValidator;
    }

    public void setPayrollDeductionValidator(Validator PayrollDeductionValidator) {
        this.PayrollDeductionValidator = PayrollDeductionValidator;
    }
     
    
}
