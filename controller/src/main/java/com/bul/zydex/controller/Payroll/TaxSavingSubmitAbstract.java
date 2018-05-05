/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.model.TaxDeductionDecarationSubmit;
import com.bul.zydex.model.TaxDeductionDeclarationSavingStatus;
import com.bul.zydex.model.TaxSavingSubmit;
import com.bul.zydex.service.Payroll.PayrollFinancialYearService;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionComponentService;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionMasterService;
import com.bul.zydex.service.Payroll.TaxDeductionDecarationSubmitService;
import com.bul.zydex.service.Payroll.TaxDeductionDeclarationSavingStatusService;
import com.bul.zydex.service.Payroll.TaxSavingSubmitService;
import com.bul.zydex.service.emp.EmployeeMasterService;

/**
 *
 * @author DELL3
 */
public class TaxSavingSubmitAbstract extends CustomAbstract
{
    TaxSavingSubmitService<TaxSavingSubmit> taxSavingSubmitService;
    PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService;
    TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> taxDeductionDecarationSubmitService;
    PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService;
    PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService;
    TaxDeductionDeclarationSavingStatusService<TaxDeductionDeclarationSavingStatus> taxDeductionDeclarationSavingStatusService;
    
    public TaxSavingSubmitService<TaxSavingSubmit> getTaxSavingSubmitService() {
        return taxSavingSubmitService;
    }

    public void setTaxSavingSubmitService(TaxSavingSubmitService<TaxSavingSubmit> taxSavingSubmitService) {
        this.taxSavingSubmitService = taxSavingSubmitService;
    }

    public PayrollFinancialYearService<PayrollFinancialYear> getPayrollFinancialYearService() {
        return payrollFinancialYearService;
    }

    public void setPayrollFinancialYearService(PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService) {
        this.payrollFinancialYearService = payrollFinancialYearService;
    }

    
    public TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> getTaxDeductionDecarationSubmitService() {
        return taxDeductionDecarationSubmitService;
    }

    public void setTaxDeductionDecarationSubmitService(TaxDeductionDecarationSubmitService<TaxDeductionDecarationSubmit> taxDeductionDecarationSubmitService) {
        this.taxDeductionDecarationSubmitService = taxDeductionDecarationSubmitService;
    }

    public PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> getPayrollTaxDeductionMasterService() {
        return payrollTaxDeductionMasterService;
    }

    public void setPayrollTaxDeductionMasterService(PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService) {
        this.payrollTaxDeductionMasterService = payrollTaxDeductionMasterService;
    }

    public PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> getPayrollTaxDeductionComponentService() {
        return payrollTaxDeductionComponentService;
    }

    public void setPayrollTaxDeductionComponentService(PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService) {
        this.payrollTaxDeductionComponentService = payrollTaxDeductionComponentService;
    }

    public TaxDeductionDeclarationSavingStatusService<TaxDeductionDeclarationSavingStatus> getTaxDeductionDeclarationSavingStatusService() {
        return taxDeductionDeclarationSavingStatusService;
    }

    public void setTaxDeductionDeclarationSavingStatusService(TaxDeductionDeclarationSavingStatusService<TaxDeductionDeclarationSavingStatus> taxDeductionDeclarationSavingStatusService) {
        this.taxDeductionDeclarationSavingStatusService = taxDeductionDeclarationSavingStatusService;
    }

    
}
