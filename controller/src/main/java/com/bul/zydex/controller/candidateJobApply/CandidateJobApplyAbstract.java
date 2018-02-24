/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.candidateJobApply;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.CandidateApplyJob;
import com.bul.zydex.model.VacancyMaster;
import com.bul.zydex.service.CandidateJobApply.CandidateJobApplyService;
import com.bul.zydex.service.Vacancy.VacancyMasterService;

/**
 *
 * @author Aman
 */
public class CandidateJobApplyAbstract extends CustomAbstract{
    
    protected CandidateJobApplyService<CandidateApplyJob>candidateJobApplyService;
    protected VacancyMasterService<VacancyMaster>vacancyMasterService;

    public CandidateJobApplyService<CandidateApplyJob> getCandidateJobApplyService() {
        return candidateJobApplyService;
    }

    public void setCandidateJobApplyService(CandidateJobApplyService<CandidateApplyJob> candidateJobApplyService) {
        this.candidateJobApplyService = candidateJobApplyService;
    }

    public VacancyMasterService<VacancyMaster> getVacancyMasterService() {
        return vacancyMasterService;
    }

    public void setVacancyMasterService(VacancyMasterService<VacancyMaster> vacancyMasterService) {
        this.vacancyMasterService = vacancyMasterService;
    }
    
    
}
