/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Payroll;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.RetirementAge;
import com.bul.zydex.service.Payroll.RetirementAgeService;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class RetirementAgeAbstract extends CustomAbstract {

    protected RetirementAgeService<RetirementAge> retirementAgeService;
    protected Validator companyMasterValidator;

    public RetirementAgeService<RetirementAge> getRetirementAgeService() {
        return retirementAgeService;
    }

    public void setRetirementAgeService(RetirementAgeService<RetirementAge> retirementAgeService) {
        this.retirementAgeService = retirementAgeService;
    }

    public Validator getCompanyMasterValidator() {
        return companyMasterValidator;
    }

    public void setCompanyMasterValidator(Validator companyMasterValidator) {
        this.companyMasterValidator = companyMasterValidator;
    }

    
    
    }
