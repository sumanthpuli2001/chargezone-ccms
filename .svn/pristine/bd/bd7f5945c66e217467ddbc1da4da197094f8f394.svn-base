/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalPerformanceCompetencyEvaluation;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceCompetencyEvaluationDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalPerformanceCompetencyEvaluationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalPerformanceCompetencyEvaluation.class;
    }

    @Override
    public List<?> readAppraisalPerformanceCompetencyEvaluationDetail(T object) {
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) object;
        String query = "";
        query += " "
                + " SELECT a.id, a.appraisalPerformanceMaster,a.competencyEvaluationMaster, a.competencyEvaluationTextmaster, b.infoText,a.competencyStartYear,a.startyearRemark,a.competencyMidYear,a.midyearRemark,a.competencyEndYear,a.endyearRemark,a.competencyStartYearManager,a.startyearRemarkManager "
                + " FROM AppraisalPerformanceCompetencyEvaluation a "
                + " LEFT JOIN a.competencyEvaluationTextmaster b "
                + " LEFT JOIN a.competencyEvaluationMaster c "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId();

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public void delete1(T object) {
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) object;
        String query = "";

        query += "  "
                + "delete FROM AppraisalPerformanceCompetencyEvaluation a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId();

        getHibernateTemplate().bulkUpdate(query);
    }

}
