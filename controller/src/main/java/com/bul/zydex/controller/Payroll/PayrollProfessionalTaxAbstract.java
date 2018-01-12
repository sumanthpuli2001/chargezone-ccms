/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollProfessionalTax;
import com.bul.zydex.service.Payroll.PayrollProfessionalTaxService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public class PayrollProfessionalTaxAbstract extends CustomAbstract {

    protected PayrollProfessionalTaxService<PayrollProfessionalTax> payrollProfessionalTaxService;
    protected Validator payrollProfessionalTaxValidator;

    public PayrollProfessionalTaxService<PayrollProfessionalTax> getPayrollProfessionalTaxService() {
        return payrollProfessionalTaxService;
    }

    public void setPayrollProfessionalTaxService(PayrollProfessionalTaxService<PayrollProfessionalTax> payrollProfessionalTaxService) {
        this.payrollProfessionalTaxService = payrollProfessionalTaxService;
    }

    public Validator getPayrollProfessionalTaxValidator() {
        return payrollProfessionalTaxValidator;
    }

    public void setPayrollProfessionalTaxValidator(Validator payrollProfessionalTaxValidator) {
        this.payrollProfessionalTaxValidator = payrollProfessionalTaxValidator;
    }

}
