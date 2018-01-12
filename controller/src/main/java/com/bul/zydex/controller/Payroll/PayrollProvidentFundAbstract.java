/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollProvidentFund;
import com.bul.zydex.service.Payroll.PayrollProvidentFundService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProvidentFundAbstract extends CustomAbstract {

    protected PayrollProvidentFundService<PayrollProvidentFund> payrollProvidentFundService;
    protected Validator payrollProvidentFundValidator;

    public PayrollProvidentFundService<PayrollProvidentFund> getPayrollProvidentFundService() {
        return payrollProvidentFundService;
    }

    public void setPayrollProvidentFundService(PayrollProvidentFundService<PayrollProvidentFund> payrollProvidentFundService) {
        this.payrollProvidentFundService = payrollProvidentFundService;
    }

    public Validator getPayrollProvidentFundValidator() {
        return payrollProvidentFundValidator;
    }

    public void setPayrollProvidentFundValidator(Validator payrollProvidentFundValidator) {
        this.payrollProvidentFundValidator = payrollProvidentFundValidator;
    }

}
