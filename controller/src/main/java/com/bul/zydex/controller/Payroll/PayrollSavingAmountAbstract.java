/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import com.bul.zydex.model.PayrollSavingAmount;
import com.bul.zydex.service.Payroll.PayrollFormSixteenMasterService;
import com.bul.zydex.service.Payroll.PayrollSavingAmountService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSavingAmountAbstract  extends CustomAbstract {
    protected PayrollSavingAmountService<PayrollSavingAmount> payrollSavingAmountService;
     protected PayrollFormSixteenMasterService<PayrollFormSixteenMaster> payrollFormSixteenMasterService;
    protected Validator payrollSavingAmountValidator; 

    public PayrollSavingAmountService<PayrollSavingAmount> getPayrollSavingAmountService() {
        return payrollSavingAmountService;
    }

    public void setPayrollSavingAmountService(PayrollSavingAmountService<PayrollSavingAmount> payrollSavingAmountService) {
        this.payrollSavingAmountService = payrollSavingAmountService;
    }

    public PayrollFormSixteenMasterService<PayrollFormSixteenMaster> getPayrollFormSixteenMasterService() {
        return payrollFormSixteenMasterService;
    }

    public void setPayrollFormSixteenMasterService(PayrollFormSixteenMasterService<PayrollFormSixteenMaster> payrollFormSixteenMasterService) {
        this.payrollFormSixteenMasterService = payrollFormSixteenMasterService;
    }

    public Validator getPayrollSavingAmountValidator() {
        return payrollSavingAmountValidator;
    }

    public void setPayrollSavingAmountValidator(Validator payrollSavingAmountValidator) {
        this.payrollSavingAmountValidator = payrollSavingAmountValidator;
    }
    
    
    
    
}
