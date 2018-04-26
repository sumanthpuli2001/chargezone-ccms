/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollTaxDeclarationPeriodMaster;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.service.Payroll.PayrollFinancialYearService;
import com.bul.zydex.service.Payroll.PayrollTaxDeclarationPeriodMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;
/**
 *
 * @author DELL3
 */
public class PayrollTaxDeclarationPeriodMasterAbstract extends CustomAbstract
{
    protected PayrollTaxDeclarationPeriodMasterService<PayrollTaxDeclarationPeriodMaster> payrollTaxDeclarationPeriodMasterService;
    protected PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService;
    protected Validator payrollTaxDeclarationPeriodMasterValidator;
    
    public PayrollTaxDeclarationPeriodMasterService<PayrollTaxDeclarationPeriodMaster> getPayrollTaxDeclarationPeriodMasterService() {
        return payrollTaxDeclarationPeriodMasterService;
    }

    public void setPayrollTaxDeclarationPeriodMasterService(PayrollTaxDeclarationPeriodMasterService<PayrollTaxDeclarationPeriodMaster> payrollTaxDeclarationPeriodMasterService) {
        this.payrollTaxDeclarationPeriodMasterService = payrollTaxDeclarationPeriodMasterService;
    }
    
    public PayrollFinancialYearService<PayrollFinancialYear> getPayrollFinancialYearService() {
        return payrollFinancialYearService;
    }

    public void setPayrollFinancialYearService(PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService) {
        this.payrollFinancialYearService = payrollFinancialYearService;
    }
    

    public Validator getPayrollTaxDeclarationPeriodMasterValidator() {
        return payrollTaxDeclarationPeriodMasterValidator;
    }

    public void setPayrollTaxDeclarationPeriodMasterValidator(Validator payrollTaxDeclarationPeriodMasterValidator) {
        this.payrollTaxDeclarationPeriodMasterValidator = payrollTaxDeclarationPeriodMasterValidator;
    }
    
    protected void financialYearList(HttpServletRequest request) {
        PayrollFinancialYear payrollFinancialYear = new PayrollFinancialYear();
        List<?> tdpmList = payrollFinancialYearService.read();
        Map<Integer, String> tdmp = new HashMap<>();
        for (Object o : tdpmList) {
            payrollFinancialYear = (PayrollFinancialYear) o;
            tdmp.put(payrollFinancialYear.getId(), payrollFinancialYear.getTitle());
        }
        request.setAttribute("financialYearMap", tdmp);
    }

}
