/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollBonus;
import com.bul.zydex.service.Payroll.PayrollBonusService;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollBonusAbstract extends  CustomAbstract{
      protected PayrollBonusService<PayrollBonus> payrollBonusService;
    Validator payrollBonusValidator;

    public PayrollBonusService<PayrollBonus> getPayrollBonusService() {
        return payrollBonusService;
    }

    public void setPayrollBonusService(PayrollBonusService<PayrollBonus> payrollBonusService) {
        this.payrollBonusService = payrollBonusService;
    }

    public Validator getPayrollBonusValidator() {
        return payrollBonusValidator;
    }

    public void setPayrollBonusValidator(Validator payrollBonusValidator) {
        this.payrollBonusValidator = payrollBonusValidator;
    }
   
}
