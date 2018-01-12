/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollSavingType;
import com.bul.zydex.service.Payroll.PayrollSavingTypeService;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class PayrollSavingTypeAbstract extends CustomAbstract {

    protected PayrollSavingTypeService<PayrollSavingType> payrollSavingTypeService;
    protected Validator payrollSavingTypeValidator;

    public PayrollSavingTypeService<PayrollSavingType> getPayrollSavingTypeService() {
        return payrollSavingTypeService;
    }

    public void setPayrollSavingTypeService(PayrollSavingTypeService<PayrollSavingType> payrollSavingTypeService) {
        this.payrollSavingTypeService = payrollSavingTypeService;
    }

    public Validator getPayrollSavingTypeValidator() {
        return payrollSavingTypeValidator;
    }

    public void setPayrollSavingTypeValidator(Validator payrollSavingTypeValidator) {
        this.payrollSavingTypeValidator = payrollSavingTypeValidator;
    }

}
