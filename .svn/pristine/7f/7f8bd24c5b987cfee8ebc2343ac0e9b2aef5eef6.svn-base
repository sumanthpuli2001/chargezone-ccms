/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ActivityGoals;
import com.bul.zydex.model.PerformanceImprovementPlanMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ActivityGoalsDAOImpl<T> extends GenericsDAOImpl<T> implements ActivityGoalsDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ActivityGoals.class;
    }

    @Override
    public List<?> readActivityGoalByPipMaster(T object) {
        ActivityGoals activityGoals = (ActivityGoals) object;
        String query = "";

        query += ""
                + " FROM ActivityGoals a"
                + " Where a.performanceImprovementPlanMaster=" + activityGoals.getPerformanceImprovementPlanMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
