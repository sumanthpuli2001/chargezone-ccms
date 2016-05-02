/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.dao.appraisalPerformance.UpdateAppraisalPerformanceActivitiesDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class UpdateAppraisalPerformanceActivitiesServiceImpl<T> extends GenericsServiceImpl<T> implements UpdateAppraisalPerformanceActivitiesService<T> {
    protected UpdateAppraisalPerformanceActivitiesDAO<T> updateAppraisalPerformanceActivitiesDAO;

    public UpdateAppraisalPerformanceActivitiesDAO<T> getUpdateAppraisalPerformanceActivitiesDAO() {
        return updateAppraisalPerformanceActivitiesDAO;
    }

    public void setUpdateAppraisalPerformanceActivitiesDAO(UpdateAppraisalPerformanceActivitiesDAO<T> updateAppraisalPerformanceActivitiesDAO) {
        this.updateAppraisalPerformanceActivitiesDAO = updateAppraisalPerformanceActivitiesDAO;
        setGenericsDAO(updateAppraisalPerformanceActivitiesDAO);
    } 

    @Override
    public List<?> readByUpdateKragoalActivity(T object) {
        return updateAppraisalPerformanceActivitiesDAO.readByUpdateKragoalActivity(object);
    }

    @Override
    public List<?> readByUserUpdateKraOther(T object) {
        return updateAppraisalPerformanceActivitiesDAO.readByUserUpdateKraOther(object);
    }
    @Override
     public List<?> readByKraIdForDeleteActivity(T object) {
        return updateAppraisalPerformanceActivitiesDAO.readByKraIdForDeleteActivity(object);
    }

    
    
}
