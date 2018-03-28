/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.policy;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CtcAllowance;
import com.bul.zydex.service.policy.CtcAllowanceService;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class CtcAllowanceAbstract extends CustomAbstract {

    protected CtcAllowanceService<CtcAllowance> ctcAllowanceService;
    protected Validator CtcValidator;

    public CtcAllowanceService<CtcAllowance> getCtcAllowanceService() {
        return ctcAllowanceService;
    }

    public void setCtcAllowanceService(CtcAllowanceService<CtcAllowance> ctcAllowanceService) {
        this.ctcAllowanceService = ctcAllowanceService;
    }

    public Validator getCtcValidator() {
        return CtcValidator;
    }

    public void setCtcValidator(Validator CtcValidator) {
        this.CtcValidator = CtcValidator;
    }
   

}
