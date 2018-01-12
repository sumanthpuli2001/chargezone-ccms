/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;

import com.bul.zydex.model.PayrollStationWiseSavingTax;
import com.bul.zydex.service.Payroll.PayrollStationWiseSavingTaxService;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class  PayrollStationWiseSavingTaxAbstract extends CustomAbstract {
    
     protected PayrollStationWiseSavingTaxService<PayrollStationWiseSavingTax> payrollStationWiseSavingTaxService;
    protected Validator payrollStationWiseSavingTaxValidator; 

    public PayrollStationWiseSavingTaxService<PayrollStationWiseSavingTax> getPayrollStationWiseSavingTaxService() {
        return payrollStationWiseSavingTaxService;
    }

    public void setPayrollStationWiseSavingTaxService(PayrollStationWiseSavingTaxService<PayrollStationWiseSavingTax> payrollStationWiseSavingTaxService) {
        this.payrollStationWiseSavingTaxService = payrollStationWiseSavingTaxService;
    }

    public Validator getPayrollStationWiseSavingTaxValidator() {
        return payrollStationWiseSavingTaxValidator;
    }

    public void setPayrollStationWiseSavingTaxValidator(Validator payrollStationWiseSavingTaxValidator) {
        this.payrollStationWiseSavingTaxValidator = payrollStationWiseSavingTaxValidator;
    }
    
    
}
