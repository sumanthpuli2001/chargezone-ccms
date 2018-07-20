/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.DepartmentMaster;
import com.bul.zydex.model.EmployeeDeductionAmount;
import com.bul.zydex.model.EmployeePolicyDetail;
import com.bul.zydex.model.PolicyCreate;
import com.bul.zydex.model.PolicyDropDown;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.PolicyReadHistory;
import com.bul.zydex.service.EmployeePolicyDetail.EmployeePolicyDetailService;
import com.bul.zydex.service.Payroll.EmployeeDeductionAmountService;
import com.bul.zydex.service.policy.PolicyCreateService;
import com.bul.zydex.service.policy.PolicyDropDownService;
import com.bul.zydex.service.policy.PolicyMasterService;
import com.bul.zydex.service.policy.PolicyReadHistoryService;
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
    protected PolicyCreateService<PolicyCreate> policyCreateService;
    protected PolicyDropDownService<PolicyDropDown> policyDropDownService;
    protected PolicyReadHistoryService<PolicyReadHistory> policyReadHistoryService;

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

    public PolicyCreateService<PolicyCreate> getPolicyCreateService() {
        return policyCreateService;
    }

    public void setPolicyCreateService(PolicyCreateService<PolicyCreate> policyCreateService) {
        this.policyCreateService = policyCreateService;
    }

    public PolicyDropDownService<PolicyDropDown> getPolicyDropDownService() {
        return policyDropDownService;
    }

    public void setPolicyDropDownService(PolicyDropDownService<PolicyDropDown> policyDropDownService) {
        this.policyDropDownService = policyDropDownService;
    }

    public PolicyReadHistoryService<PolicyReadHistory> getPolicyReadHistoryService() {
        return policyReadHistoryService;
    }

    public void setPolicyReadHistoryService(PolicyReadHistoryService<PolicyReadHistory> policyReadHistoryService) {
        this.policyReadHistoryService = policyReadHistoryService;
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
    protected void policyDropDownList(HttpServletRequest request) {
        PolicyDropDown policyDropDown = new PolicyDropDown();
        List<?> policyList = policyDropDownService.read();

        Map<Integer, String> policyd = new HashMap<>();
        for (Object o : policyList) {
            policyDropDown = (PolicyDropDown) o;
            policyd.put(policyDropDown.getId(), policyDropDown.getName());
        }
        request.setAttribute("policydp", policyd);
    }
}
