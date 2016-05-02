/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalPerformanceBehaviorsDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class AppraisalPerformanceBehaviorsServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalPerformanceBehaviorsService<T> {

    private AppraisalPerformanceBehaviorsDAO<T> appraisalPerformanceBehaviorsDAO;

    public AppraisalPerformanceBehaviorsDAO<T> getAppraisalPerformanceBehaviorsDAO() {
        return appraisalPerformanceBehaviorsDAO;
    }

    public void setAppraisalPerformanceBehaviorsDAO(AppraisalPerformanceBehaviorsDAO<T> appraisalPerformanceBehaviorsDAO) {
        this.appraisalPerformanceBehaviorsDAO = appraisalPerformanceBehaviorsDAO;
        setGenericsDAO(appraisalPerformanceBehaviorsDAO);
    }

    @Override
    public List<?> readBehaviorsDetail(T object) {
        return appraisalPerformanceBehaviorsDAO.readBehaviorsDetail(object);
    }

    @Override
    public List<?> readperformanceRatingList(final int currentYear, int id) {
        return appraisalPerformanceBehaviorsDAO.readperformanceRatingList(currentYear, id);
    }

}
