/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.policy.PolicyMasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class PolicyMasterAbstract extends CustomAbstract {

    protected PolicyMasterService<PolicyMaster> policyMasterService;
    protected Validator policyMasterValidator;
    protected EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService;
    protected EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService;

    public PolicyMasterService<PolicyMaster> getPolicyMasterService() {
        return policyMasterService;
    }

    public void setPolicyMasterService(PolicyMasterService<PolicyMaster> policyMasterService) {
        this.policyMasterService = policyMasterService;
    }

    public Validator getPolicyMasterValidator() {
        return policyMasterValidator;
    }

    public void setPolicyMasterValidator(Validator policyMasterValidator) {
        this.policyMasterValidator = policyMasterValidator;
    }

    public EmployeeDeductionAmountService<EmployeeDeductionAmount> getEmployeeDeductionAmountService() {
        return employeeDeductionAmountService;
    }

    public void setEmployeeDeductionAmountService(EmployeeDeductionAmountService<EmployeeDeductionAmount> employeeDeductionAmountService) {
        this.employeeDeductionAmountService = employeeDeductionAmountService;
    }

    public EmployeePolicyDetailService<EmployeePolicyDetail> getEmployeePolicyDetailService() {
        return employeePolicyDetailService;
    }

    public void setEmployeePolicyDetailService(EmployeePolicyDetailService<EmployeePolicyDetail> employeePolicyDetailService) {
        this.employeePolicyDetailService = employeePolicyDetailService;
    }
    

    protected void policyList(HttpServletRequest request) {
        PolicyMaster policyMaster = new PolicyMaster();
        List<?> policyList = policyMasterService.read();

        Map<Integer, String> policy = new HashMap<>();
        for (Object o : policyList) {
            policyMaster = (PolicyMaster) o;
            policy.put(policyMaster.getId(), policyMaster.getPolicyName());
        }
        request.setAttribute("policy", policy);
    }
}
