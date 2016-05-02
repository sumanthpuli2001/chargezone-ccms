/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.CompetencyEvaluationMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationMasterServiceImpl <T> extends GenericsServiceImpl<T> implements CompetencyEvaluationMasterService<T>{
    private CompetencyEvaluationMasterDAO<T> competencyEvaluationMasterDAO;

    public CompetencyEvaluationMasterDAO<T> getCompetencyEvaluationMasterDAO() {
        return competencyEvaluationMasterDAO;
    }

    public void setCompetencyEvaluationMasterDAO(CompetencyEvaluationMasterDAO<T> competencyEvaluationMasterDAO) {
        this.competencyEvaluationMasterDAO = competencyEvaluationMasterDAO;
        setGenericsDAO(competencyEvaluationMasterDAO);
    }
    
}
