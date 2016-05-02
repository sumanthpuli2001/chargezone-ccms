/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CompetencyEvaluationTextmaster;
import java.util.List;

/**
 *
 * @author admin
 */
public class CompetencyEvaluationTextmasterDAOImpl<T> extends GenericsDAOImpl<T> implements CompetencyEvaluationTextmasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return CompetencyEvaluationTextmaster.class;
    }
    @Override
    public List<?> readCompetencyEvaluationDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.infoText, b.title "
                + " FROM CompetencyEvaluationTextmaster a "
                + " LEFT JOIN a.competencyEvaluationMaster b ";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    @Override
    public List<?> readCompetencyEvaluationIdWiseDetail(T object) {
        CompetencyEvaluationTextmaster competencyEvaluationTextmaster=(CompetencyEvaluationTextmaster) object;
        String query = "";
        query += " "
                + " SELECT a.id, a.infoText "
                + " FROM CompetencyEvaluationTextmaster a "
                
                + " WHERE a.competencyEvaluationMaster = " + competencyEvaluationTextmaster.getCompetencyEvaluationMaster().getId();
//                + " SELECT a.id, a.infoText, b.title "
//                + " FROM CompetencyEvaluationTextmaster a "
//                + " LEFT JOIN a.competencyEvaluationMaster b "
//                + " WHERE a.competencyEvaluationMaster = " + competencyEvaluationTextmaster.getCompetencyEvaluationMaster().getId();
 
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
