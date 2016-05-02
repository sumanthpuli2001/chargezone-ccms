/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.service.policy.PolicyMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class PolicyMasterAbstract extends CustomAbstract {

    protected PolicyMasterService<PolicyMaster> policyMasterService;
    protected Validator policyMasterValidator;

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

}
