/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import java.text.DateFormat;
import org.springframework.validation.Validator;

/**
 *
 * @author Nishant
 */
public abstract class PayrollSalaryTypeAbstract extends CustomAbstract {

    protected PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService;
    protected Validator payrollSalaryTypeValidator;

    public PayrollSalaryTypeService<PayrollSalaryType> getaPayrollSalaryTypeService() {
        return payrollSalaryTypeService;
    }

    public void setPayrollSalaryTypeService(PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService) {
        this.payrollSalaryTypeService = payrollSalaryTypeService;
    }

    public Validator getPayrollSalaryTypeValidator() {
        return payrollSalaryTypeValidator;
    }

    public void setPayrollSalaryTypeValidator(Validator payrollSalaryTypeValidator) {
        this.payrollSalaryTypeValidator = payrollSalaryTypeValidator;
    }


}
