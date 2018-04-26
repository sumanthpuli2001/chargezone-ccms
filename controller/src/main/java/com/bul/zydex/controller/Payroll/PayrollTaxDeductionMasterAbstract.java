/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import com.bul.zydex.service.Payroll.PayrollTaxDeductionComponentService;

import com.bul.zydex.service.Payroll.PayrollTaxDeductionMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;
/**
 *
 * @author DELL3
 */
public class PayrollTaxDeductionMasterAbstract extends CustomAbstract{
    
    protected PayrollTaxDeductionMasterService<PayrollTaxDeductionMaster> payrollTaxDeductionMasterService;
    protected PayrollTaxDeductionComponentService<PayrollTaxDeductionComponent> payrollTaxDeductionComponentService;
    protected Validator payrollTaxDeductionMasterValidator;
    protected Validator payrollTaxDeductionComponentValidator; 
    
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
 
    public Validator getPayrollTaxDeductionMasterValidator() {
        return payrollTaxDeductionMasterValidator;
    }

    public void setPayrollTaxDeductionMasterValidator(Validator payrollTaxDeductionMasterValidator) {
        this.payrollTaxDeductionMasterValidator = payrollTaxDeductionMasterValidator;
    }


    public Validator getPayrollTaxDeductionComponentValidator() {
        return payrollTaxDeductionComponentValidator;
    }

    public void setPayrollTaxDeductionComponentValidator(Validator payrollTaxDeductionComponentValidator) {
        this.payrollTaxDeductionComponentValidator = payrollTaxDeductionComponentValidator;
    }
            
    protected void sectionList(HttpServletRequest request) {
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = new PayrollTaxDeductionMaster();
        List<?> tdmList = payrollTaxDeductionMasterService.read();
        Map<Integer, String> tdm = new HashMap<>();
        for (Object o : tdmList) {
            payrollTaxDeductionMaster = (PayrollTaxDeductionMaster) o;
            tdm.put(payrollTaxDeductionMaster.getId(), payrollTaxDeductionMaster.getSection());
        }

        request.setAttribute("sectionsMap", tdm);
    }
}
