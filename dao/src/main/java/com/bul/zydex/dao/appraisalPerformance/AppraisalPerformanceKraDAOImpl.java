/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalPerformanceKra;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceKraDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalPerformanceKraDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalPerformanceKra.class;
    }

    @Override
    public List<?> readByAppraisalKraGoal(T object) {
        AppraisalPerformanceKra appraisalPerformanceKra = (AppraisalPerformanceKra) object;

        String query = "";

        query += "  "
                + "FROM AppraisalPerformanceKra a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceKra.getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByAppraisalPerformancekraId(T object) {
        AppraisalPerformanceKra appraisalPerformanceKra = (AppraisalPerformanceKra) object;
        String query = "";

        query += "  "
                + "FROM AppraisalPerformanceKra a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceKra.getAppraisalPerformanceMaster().getId();

        return getHibernateTemplate().find(query);
    }

    @Override
    public void delete1(T object) {
        AppraisalPerformanceKra appraisalPerformanceKra = (AppraisalPerformanceKra) object;
        String query = "";

        query += "  "
                + "delete FROM AppraisalPerformanceKra a "
                + " WHERE a.id = " + appraisalPerformanceKra.getId();

        getHibernateTemplate().bulkUpdate(query);
    }
}
