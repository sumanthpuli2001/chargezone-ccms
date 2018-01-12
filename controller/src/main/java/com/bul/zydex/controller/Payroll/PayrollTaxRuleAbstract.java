/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollTaxRule;
import com.bul.zydex.service.Payroll.PayrollTaxRuleService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollTaxRuleAbstract extends CustomAbstract {

    protected PayrollTaxRuleService<PayrollTaxRule> payrollTaxRuleService;
    Validator payrollTaxRuleValidator;

    public PayrollTaxRuleService<PayrollTaxRule> getPayrollTaxRuleService() {
        return payrollTaxRuleService;
    }

    public void setPayrollTaxRuleService(PayrollTaxRuleService<PayrollTaxRule> payrollTaxRuleService) {
        this.payrollTaxRuleService = payrollTaxRuleService;
    }

    public Validator getPayrollTaxRuleValidator() {
        return payrollTaxRuleValidator;
    }

    public void setPayrollTaxRuleValidator(Validator payrollTaxRuleValidator) {
        this.payrollTaxRuleValidator = payrollTaxRuleValidator;
    }

}
