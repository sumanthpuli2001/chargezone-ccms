/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalPerformanceActivities;

import java.util.List;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class AppraisalPerformanceActivitiesDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalPerformanceActivitiesDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalPerformanceActivities.class;
    }

    @Override
    public List<?> readByAppraisalKraGoalActivities(T object) {
        AppraisalPerformanceActivities appraisalPerformanceActivities = (AppraisalPerformanceActivities) object;

        String query = "";

        query += "  "
                + "FROM AppraisalPerformanceActivities a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceActivities.getAppraisalPerformanceMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public void delete1(T object) {
        AppraisalPerformanceActivities appraisalPerformanceActivities = (AppraisalPerformanceActivities) object;
        String query = "";

        query += "  "
                + "delete FROM AppraisalPerformanceActivities a "
                + " WHERE a.id = " + appraisalPerformanceActivities.getId();

        getHibernateTemplate().bulkUpdate(query);
    }
}
