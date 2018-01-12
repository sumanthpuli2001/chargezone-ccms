/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.company;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.Company;
import com.bul.zydex.service.company.CompanyMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author OptiPlex
 */
public abstract class CompanyMasterAbstract extends CustomAbstract {

    protected CompanyMasterService<Company> companyMasterService;
    protected Validator CompanyMasterValidator;

    public CompanyMasterService<Company> getCompanyMasterService() {
        return companyMasterService;
    }

    public void setCompanyMasterService(CompanyMasterService<Company> companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    public Validator getCompanyMasterValidator() {
        return CompanyMasterValidator;
    }

    public void setCompanyMasterValidator(Validator CompanyMasterValidator) {
        this.CompanyMasterValidator = CompanyMasterValidator;
    }

  
}
