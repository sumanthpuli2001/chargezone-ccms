/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.AppraisalPerformanceCompetencyEvaluation;
import com.bul.zydex.model.CompetencyEvaluationMaster;
import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import com.bul.zydex.service.appraisalPerformance.AppraisalPerformanceCompetencyEvaluationService;
import com.bul.zydex.service.appraisalPerformance.CompetencyEvaluationMasterService;
import com.bul.zydex.service.appraisalPerformance.CompetencyEvaluationTextmasterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationTextmasterAbstract extends CustomAbstract{
    protected Validator competencyEvaluationTextmasterValidator;
    protected CompetencyEvaluationTextmasterService<CompetencyEvaluationTextmaster> competencyEvaluationTextmasterService;
    protected CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService;
    protected AppraisalPerformanceCompetencyEvaluationService<AppraisalPerformanceCompetencyEvaluation> appraisalPerformanceCompetencyEvaluationService;

    public Validator getCompetencyEvaluationTextmasterValidator() {
        return competencyEvaluationTextmasterValidator;
    }

    public void setCompetencyEvaluationTextmasterValidator(Validator competencyEvaluationTextmasterValidator) {
        this.competencyEvaluationTextmasterValidator = competencyEvaluationTextmasterValidator;
    }

    public CompetencyEvaluationTextmasterService<CompetencyEvaluationTextmaster> getCompetencyEvaluationTextmasterService() {
        return competencyEvaluationTextmasterService;
    }

    public void setCompetencyEvaluationTextmasterService(CompetencyEvaluationTextmasterService<CompetencyEvaluationTextmaster> competencyEvaluationTextmasterService) {
        this.competencyEvaluationTextmasterService = competencyEvaluationTextmasterService;
    }

    public CompetencyEvaluationMasterService<CompetencyEvaluationMaster> getCompetencyEvaluationMasterService() {
        return competencyEvaluationMasterService;
    }

    public void setCompetencyEvaluationMasterService(CompetencyEvaluationMasterService<CompetencyEvaluationMaster> competencyEvaluationMasterService) {
        this.competencyEvaluationMasterService = competencyEvaluationMasterService;
    }

    public AppraisalPerformanceCompetencyEvaluationService<AppraisalPerformanceCompetencyEvaluation> getAppraisalPerformanceCompetencyEvaluationService() {
        return appraisalPerformanceCompetencyEvaluationService;
    }

    public void setAppraisalPerformanceCompetencyEvaluationService(AppraisalPerformanceCompetencyEvaluationService<AppraisalPerformanceCompetencyEvaluation> appraisalPerformanceCompetencyEvaluationService) {
        this.appraisalPerformanceCompetencyEvaluationService = appraisalPerformanceCompetencyEvaluationService;
    }

    
    protected void competencyList(HttpServletRequest request) {
        CompetencyEvaluationMaster competencyEvaluationMaster=new CompetencyEvaluationMaster();
        List<?> competencyList = competencyEvaluationMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : competencyList) {
            competencyEvaluationMaster = (CompetencyEvaluationMaster) o;
            dm.put(competencyEvaluationMaster.getId(), competencyEvaluationMaster.getTitle());
        }

        request.setAttribute("competencyMap", dm);
    }
    
}
