/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.AppraisalPerformanceActivitiesDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class AppraisalPerformanceActivitiesServiceImpl<T> extends GenericsServiceImpl<T> implements AppraisalPerformanceActivitiesService<T> {

    protected AppraisalPerformanceActivitiesDAO<T> appraisalPerformanceActivitiesDAO;

    public AppraisalPerformanceActivitiesDAO<T> getAppraisalPerformanceActivitiesDAO() {
        return appraisalPerformanceActivitiesDAO;
    }

    public void setAppraisalPerformanceActivitiesDAO(AppraisalPerformanceActivitiesDAO<T> appraisalPerformanceActivitiesDAO) {
        this.appraisalPerformanceActivitiesDAO = appraisalPerformanceActivitiesDAO;
        setGenericsDAO(appraisalPerformanceActivitiesDAO);
    }

    @Override
    public List<?> readByAppraisalKraGoalActivities(T object) {
        return appraisalPerformanceActivitiesDAO.readByAppraisalKraGoalActivities(object);

    }

    @Override
    public void delete1(T object) {
        appraisalPerformanceActivitiesDAO.delete1(object);
    }

}
