/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.UpdateAppraisalPerformanceActivities;
import com.bul.zydex.model.UpdateAppraisalPerformanceKra;
import java.util.List;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class UpdateAppraisalPerformanceActivitiesDAOImpl<T> extends GenericsDAOImpl<T> implements UpdateAppraisalPerformanceActivitiesDAO<T>{

    @Override
    protected Class getDomainClass() {
       return UpdateAppraisalPerformanceActivities.class;
    }
    @Override
    public List<?> readByUpdateKragoalActivity(T object) {

        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) object;
        String query = "";


        query += " Select a.id,a.kraActivity, a.metricActivity, a.updateDate, a.changedBy"
                + " FROM UpdateAppraisalPerformanceActivities a"
                + " LEFT JOIN a.appraisalPerformanceActivities b"
                + " WHERE a.appraisalPerformanceActivities.id = " + updateAppraisalPerformanceActivities.getAppraisalPerformanceActivities().getId();

        return getHibernateTemplate().find(query);
    }
    @Override
    public List<?> readByUserUpdateKraOther(T object) {
        UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) object; 
        String query = "";

        query += " FROM UpdateAppraisalPerformanceActivities a"
                + " WHERE a.appraisalPerformanceActivities.id = " + updateAppraisalPerformanceActivities.getId();

        return getHibernateTemplate().find(query);
    }
    
    @Override
    public List<?> readByKraIdForDeleteActivity(T object) {
          UpdateAppraisalPerformanceActivities updateAppraisalPerformanceActivities = (UpdateAppraisalPerformanceActivities) object; 
        String query = "";

        query += " FROM UpdateAppraisalPerformanceActivities a"
                + " WHERE a.appraisalPerformanceActivities = " + updateAppraisalPerformanceActivities.getAppraisalPerformanceActivities().getId();

        return getHibernateTemplate().find(query);
    }
}
