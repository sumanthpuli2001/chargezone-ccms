/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.CompetencyEvaluationTextmasterDAO;
import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import com.bul.zydex.service.GenericsService;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationTextmasterServiceImpl <T> extends GenericsServiceImpl<T> implements CompetencyEvaluationTextmasterService<T>{
private CompetencyEvaluationTextmasterDAO<T> competencyEvaluationTextmasterDAO;

    public CompetencyEvaluationTextmasterDAO<T> getCompetencyEvaluationTextmasterDAO() {
        return competencyEvaluationTextmasterDAO;
    }

    public void setCompetencyEvaluationTextmasterDAO(CompetencyEvaluationTextmasterDAO<T> competencyEvaluationTextmasterDAO) {
        this.competencyEvaluationTextmasterDAO = competencyEvaluationTextmasterDAO;
        setGenericsDAO(competencyEvaluationTextmasterDAO);
    }

    @Override
    public List<?> readCompetencyEvaluationDetail() {
        return competencyEvaluationTextmasterDAO.readCompetencyEvaluationDetail();
    }

    @Override
    public List<?> readCompetencyEvaluationIdWiseDetail(T object) {
        return competencyEvaluationTextmasterDAO.readCompetencyEvaluationIdWiseDetail(object);
    }

}
