/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.service.appraisalPerformance.CompetencyEvaluationMasterService;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationMasterAbstract extends CustomAbstract{ 
    protected Validator competencyEvaluationMasterValidator;
    protected CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService;

    public Validator getCompetencyEvaluationMasterValidator() {
        return competencyEvaluationMasterValidator;
    }

    public void setCompetencyEvaluationMasterValidator(Validator competencyEvaluationMasterValidator) {
        this.competencyEvaluationMasterValidator = competencyEvaluationMasterValidator;
    }

    public CompetencyEvaluationMasterService<CompetencyEvaluationMaster> getCompetencyEvaluationMasterService() {
        return competencyEvaluationMasterService;
    }

    public void setCompetencyEvaluationMasterService(CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService) {
        this.competencyEvaluationMasterService = competencyEvaluationMasterService;
    }
    
}
