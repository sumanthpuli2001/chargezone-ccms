/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AdditionalAmountCheck;
import com.bul.zydex.model.PayrollSalaryType;
import com.bul.zydex.service.Payroll.AdditionalAmountCheckService;
import com.bul.zydex.service.Payroll.PayrollSalaryTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class AdditionalAmountCheckAbstract extends CustomAbstract{
    
     protected AdditionalAmountCheckService<AdditionalAmountCheck> additionalAmountCheckService;
    protected PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService;
    protected Validator additionalAmountCheckValidator;

    public AdditionalAmountCheckService<AdditionalAmountCheck> getAdditionalAmountCheckService() {
        return additionalAmountCheckService;
    }

    public void setAdditionalAmountCheckService(AdditionalAmountCheckService<AdditionalAmountCheck> additionalAmountCheckService) {
        this.additionalAmountCheckService = additionalAmountCheckService;
    }

    public PayrollSalaryTypeService<PayrollSalaryType> getPayrollSalaryTypeService() {
        return payrollSalaryTypeService;
    }

    public void setPayrollSalaryTypeService(PayrollSalaryTypeService<PayrollSalaryType> payrollSalaryTypeService) {
        this.payrollSalaryTypeService = payrollSalaryTypeService;
    }

    public Validator getAdditionalAmountCheckValidator() {
        return additionalAmountCheckValidator;
    }

    public void setAdditionalAmountCheckValidator(Validator additionalAmountCheckValidator) {
        this.additionalAmountCheckValidator = additionalAmountCheckValidator;
    }
    protected void SalaryTypeList(HttpServletRequest request) {
        List<?> SalaryTypeList = payrollSalaryTypeService.read();
        Map<Integer, String> map = new HashMap();
        for (Object obj : SalaryTypeList) {
            PayrollSalaryType payrollSalaryType = (PayrollSalaryType) obj;
            map.put(payrollSalaryType.getId(), payrollSalaryType.getText());
        }
        request.setAttribute("SalaryTypeList", map);
    }
}
