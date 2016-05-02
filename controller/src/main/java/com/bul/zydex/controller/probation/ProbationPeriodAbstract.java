/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.probation;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ProbationPeriod;
import com.bul.zydex.service.probation.ProbationPeriodService;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class ProbationPeriodAbstract extends CustomAbstract {

    protected ProbationPeriodService<ProbationPeriod> probationPeriodService;
    protected Validator probationPeriodValidator;

    public ProbationPeriodService<ProbationPeriod> getProbationPeriodService() {
        return probationPeriodService;
    }

    public void setProbationPeriodService(ProbationPeriodService<ProbationPeriod> probationPeriodService) {
        this.probationPeriodService = probationPeriodService;
    }

    public Validator getProbationPeriodValidator() {
        return probationPeriodValidator;
    }

    public void setProbationPeriodValidator(Validator probationPeriodValidator) {
        this.probationPeriodValidator = probationPeriodValidator;
    }

}
