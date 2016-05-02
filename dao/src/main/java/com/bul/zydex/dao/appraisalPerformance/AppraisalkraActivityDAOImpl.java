/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalkraActivity;
import java.util.List;

/**
 *
 * @author HRINTRA
 */
public class AppraisalkraActivityDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalkraActivityDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalkraActivity.class;
    }
    
     @Override
    public List<?> readByKraGoalName(T object) {
          AppraisalkraActivity appraisalkraActivity = (AppraisalkraActivity) object; 
        String query = "";

        query += " FROM AppraisalkraActivity a"
                + " WHERE a.appraisalPerformanceMaster = " + appraisalkraActivity.getAppraisalPerformanceMaster().getId()
                + " AND a.status='KRAGOAL'";

        return getHibernateTemplate().find(query);
    }
     @Override
    public List<?> readByActivitiesName(T object) {
          AppraisalkraActivity appraisalkraActivity = (AppraisalkraActivity) object; 
        String query = "";

        query += " FROM AppraisalkraActivity a"
                + " WHERE a.appraisalPerformanceMaster = " + appraisalkraActivity.getAppraisalPerformanceMaster().getId()
                + " AND a.status='ACTIVITIES'";

        return getHibernateTemplate().find(query);
    }

}
