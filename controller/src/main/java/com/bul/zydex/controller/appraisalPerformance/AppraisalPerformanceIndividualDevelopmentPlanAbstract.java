/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalPerformanceIndividualDevelopmentPlan;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceIndividualDevelopmentPlanService;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceIndividualDevelopmentPlanAbstract extends CustomAbstract{
     protected Validator AppraisalPerformanceIndividualDevelopmentPlanValidator;
     protected AppraisalPerformanceIndividualDevelopmentPlanService<AppraisalPerformanceIndividualDevelopmentPlan>appraisalPerformanceIndividualDevelopmentPlanService;

    public Validator getAppraisalPerformanceIndividualDevelopmentPlanValidator() {
        return AppraisalPerformanceIndividualDevelopmentPlanValidator;
    }

    public void setAppraisalPerformanceIndividualDevelopmentPlanValidator(Validator AppraisalPerformanceIndividualDevelopmentPlanValidator) {
        this.AppraisalPerformanceIndividualDevelopmentPlanValidator = AppraisalPerformanceIndividualDevelopmentPlanValidator;
    }

    public AppraisalPerformanceIndividualDevelopmentPlanService<AppraisalPerformanceIndividualDevelopmentPlan> getAppraisalPerformanceIndividualDevelopmentPlanService() {
        return appraisalPerformanceIndividualDevelopmentPlanService;
    }

    public void setAppraisalPerformanceIndividualDevelopmentPlanService(AppraisalPerformanceIndividualDevelopmentPlanService<AppraisalPerformanceIndividualDevelopmentPlan> appraisalPerformanceIndividualDevelopmentPlanService) {
        this.appraisalPerformanceIndividualDevelopmentPlanService = appraisalPerformanceIndividualDevelopmentPlanService;
    }

}
