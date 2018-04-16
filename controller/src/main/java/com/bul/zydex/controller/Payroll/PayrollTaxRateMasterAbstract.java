/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollTaxRateMaster;
import com.bul.zydex.service.Payroll.PayrollTaxRateMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author DELL3
 */
public class PayrollTaxRateMasterAbstract extends CustomAbstract
{
    protected PayrollTaxRateMasterService<PayrollTaxRateMaster> payrollTaxRateMasterService;
    protected Validator payrollTaxRateMasterValidator;

    public PayrollTaxRateMasterService<PayrollTaxRateMaster> getPayrollTaxRateMasterService() {
        return payrollTaxRateMasterService;
    }

    public void setPayrollTaxRateMasterService(PayrollTaxRateMasterService<PayrollTaxRateMaster> payrollTaxRateMasterService) {
        this.payrollTaxRateMasterService = payrollTaxRateMasterService;
    }

    public Validator getPayrollTaxRateMasterValidator() {
        return payrollTaxRateMasterValidator;
    }

    public void setPayrollTaxRateMasterValidator(Validator payrollTaxRateMasterValidator) {
        this.payrollTaxRateMasterValidator = payrollTaxRateMasterValidator;
    }    
    
}
