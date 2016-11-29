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
//        String query1 = "";
        String query = "";
//        query1 += " select a FROM AppraisalPerformanceCompetencyEvaluation a  "
//                + " LEFT JOIN a.competencyEvaluationMaster c "
//                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId();
////        List<?> list1 = getHibernateTemplate().find(query1);
//        List<?> list = null;
//        if (!list1.isEmpty() && 0 != list1.size()) {

//            appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) list1.get(list1.size() - 1);
   
            query += " "
                    + " SELECT a.id, a.appraisalPerformanceMaster,a.competencyEvaluationMaster, a.competencyEvaluationTextmaster, b.infoText,a.competencyStartYear,a.startyearRemark,a.competencyMidYear,a.midyearRemark,a.competencyEndYear,a.endyearRemark,a.competencyStartYearManager,a.startyearRemarkManager,a.midyearRemarkManager,a.endyearRemarkManager,a.competencyMidYearManager,a.competencyEndYearManager "
                    + " FROM AppraisalPerformanceCompetencyEvaluation a "
                    + " LEFT JOIN a.competencyEvaluationTextmaster b "
                    + " LEFT JOIN a.competencyEvaluationMaster c "
                    + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId();
//                    + " and a.competencyEvaluationMaster.id = " + appraisalPerformanceCompetencyEvaluation.getCompetencyEvaluationMaster().getId();

//            list = getHibernateTemplate().find(query);
//        }
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

    @Override
    public List<?> readByEmployeeWiseAppraisalPerformanceCompetencyEvaluationDetail(T object) {
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) object;
        String query = "";
        query += " "
                + " SELECT a.id, a.appraisalPerformanceMaster,a.competencyEvaluationMaster, a.competencyEvaluationTextmaster, b.infoText,a.competencyStartYear,a.startyearRemark,a.competencyMidYear,a.midyearRemark,a.competencyEndYear,a.endyearRemark,a.competencyStartYearManager,a.startyearRemarkManager,a.midyearRemarkManager,a.endyearRemarkManager,a.competencyMidYearManager,a.competencyEndYearManager "
                + " FROM AppraisalPerformanceCompetencyEvaluation a "
                + " LEFT JOIN a.competencyEvaluationTextmaster b "
                + " LEFT JOIN a.competencyEvaluationMaster c "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId();
//                + " and a.employeeStatus = 1";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByAppraisalPerformanceId(T object) {
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) object;
        String query = "";
        query += " "
                + "FROM AppraisalPerformanceCompetencyEvaluation a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId();

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public void deleteByManager(T object) {
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) object;
        String query = "";

        query += "  "
                + "delete FROM AppraisalPerformanceCompetencyEvaluation a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId()
                + " and a.managerStatus=1"
                + " and a.employeeStatus=0";

        getHibernateTemplate().bulkUpdate(query);
    }

    @Override
    public void finaldeletebyManager(T object) {
        AppraisalPerformanceCompetencyEvaluation appraisalPerformanceCompetencyEvaluation = (AppraisalPerformanceCompetencyEvaluation) object;
        String query = "";

        query += "  "
                + "delete FROM AppraisalPerformanceCompetencyEvaluation a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceCompetencyEvaluation.getAppraisalPerformanceMaster().getId()
                + " and a.employeeStatus=1";

        getHibernateTemplate().bulkUpdate(query);
    }
}
