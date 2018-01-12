/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PayrollFinancialYear;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import com.bul.zydex.service.Payroll.PayrollFinancialYearService;
import com.bul.zydex.service.Payroll.PayrollFormSixteenMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFormSixteenMasterAbstract extends  CustomAbstract {
    
     protected PayrollFormSixteenMasterService<PayrollFormSixteenMaster> payrollFormSixteenMasterService;
    Validator payrollFormSixteenMasterValidator;
     protected PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService;

    public PayrollFormSixteenMasterService<PayrollFormSixteenMaster> getPayrollFormSixteenMasterService() {
        return payrollFormSixteenMasterService;
    }

    public void setPayrollFormSixteenMasterService(PayrollFormSixteenMasterService<PayrollFormSixteenMaster> payrollFormSixteenMasterService) {
        this.payrollFormSixteenMasterService = payrollFormSixteenMasterService;
    }

    public Validator getPayrollFormSixteenMasterValidator() {
        return payrollFormSixteenMasterValidator;
    }

    public void setPayrollFormSixteenMasterValidator(Validator payrollFormSixteenMasterValidator) {
        this.payrollFormSixteenMasterValidator = payrollFormSixteenMasterValidator;
    }

    public PayrollFinancialYearService<PayrollFinancialYear> getPayrollFinancialYearService() {
        return payrollFinancialYearService;
    }

    public void setPayrollFinancialYearService(PayrollFinancialYearService<PayrollFinancialYear> payrollFinancialYearService) {
        this.payrollFinancialYearService = payrollFinancialYearService;
    }
    
    protected void financialYearList(HttpServletRequest request){
        List<?> finacialYearList = payrollFinancialYearService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : finacialYearList) {
            PayrollFinancialYear payrollFinancialYear = (PayrollFinancialYear)obj;
            map.put(payrollFinancialYear.getId(), payrollFinancialYear.getTitle());
        }
        request.setAttribute("financialYearMap", map);
    }
   
    
   
    
}
