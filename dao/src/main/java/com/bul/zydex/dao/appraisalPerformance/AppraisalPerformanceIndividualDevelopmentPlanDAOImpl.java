/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AppraisalPerformanceIndividualDevelopmentPlan;
import java.util.List;

/**
 *
 * @author admin
 */
public class AppraisalPerformanceIndividualDevelopmentPlanDAOImpl<T> extends GenericsDAOImpl<T> implements AppraisalPerformanceIndividualDevelopmentPlanDAO<T> {

    @Override
    protected Class getDomainClass() {
        return AppraisalPerformanceIndividualDevelopmentPlan.class;
    }

    @Override
    public List<?> readIndividualDevelopmentPlanDetail(T object) {
        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) object;
        String query = "";
        query += " "
                ///                + " SELECT a.id, a.appraisalPerformanceMaster"
                + " FROM AppraisalPerformanceIndividualDevelopmentPlan a "
                + " WHERE a.appraisalPerformanceMaster = " + appraisalPerformanceIndividualDevelopmentPlan.getAppraisalPerformanceMaster().getId();

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public void delete1(T object) {
        AppraisalPerformanceIndividualDevelopmentPlan appraisalPerformanceIndividualDevelopmentPlan = (AppraisalPerformanceIndividualDevelopmentPlan) object;
        String query = "";

        query += "  "
                + "delete FROM AppraisalPerformanceIndividualDevelopmentPlan a "
                + " WHERE a.id = " + appraisalPerformanceIndividualDevelopmentPlan.getId();

        getHibernateTemplate().bulkUpdate(query);
    }
}
