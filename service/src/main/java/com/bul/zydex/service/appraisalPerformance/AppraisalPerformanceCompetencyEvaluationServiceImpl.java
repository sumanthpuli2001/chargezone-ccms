/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalPerformanceCompetencyEvaluationDAO;
import com.bul.zydex.model.AppraisalPerformanceCompetencyEvaluation;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceCompetencyEvaluationServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalPerformanceCompetencyEvaluationService<T> {

    private AppraisalPerformanceCompetencyEvaluationDAO<T> appraisalPerformanceCompetencyEvaluationDAO;

    public AppraisalPerformanceCompetencyEvaluationDAO<T> getAppraisalPerformanceCompetencyEvaluationDAO() {
        return appraisalPerformanceCompetencyEvaluationDAO;
    }

    public void setAppraisalPerformanceCompetencyEvaluationDAO(AppraisalPerformanceCompetencyEvaluationDAO<T> appraisalPerformanceCompetencyEvaluationDAO) {
        this.appraisalPerformanceCompetencyEvaluationDAO = appraisalPerformanceCompetencyEvaluationDAO;
        setGenericsDAO(appraisalPerformanceCompetencyEvaluationDAO);
    }

    @Override
    public List<?> readAppraisalPerformanceCompetencyEvaluationDetail(T object) {
        return appraisalPerformanceCompetencyEvaluationDAO.readAppraisalPerformanceCompetencyEvaluationDetail(object);
    }

    @Override
    public void delete1(T object) {
        appraisalPerformanceCompetencyEvaluationDAO.delete1(object);
    }

    @Override
    public List<?> readByEmployeeWiseAppraisalPerformanceCompetencyEvaluationDetail(T object) {
        return appraisalPerformanceCompetencyEvaluationDAO.readByEmployeeWiseAppraisalPerformanceCompetencyEvaluationDetail(object);
    }

    @Override
    public List<?> readByAppraisalPerformanceId(T object) {
        return appraisalPerformanceCompetencyEvaluationDAO.readByAppraisalPerformanceId(object);
    }

    @Override
    public void deleteByManager(T object) {
        appraisalPerformanceCompetencyEvaluationDAO.deleteByManager(object);
    }

    @Override
    public void finaldeletebyManager(T object) {
        appraisalPerformanceCompetencyEvaluationDAO.finaldeletebyManager(object);
    }
    
    

}
