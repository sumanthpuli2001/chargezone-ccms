/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ActivityGoals;
import com.bul.zydex.model.GoalResourceManagement;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class GoalResourceManagementDAOImpl<T> extends GenericsDAOImpl<T> implements GoalResourceManagementDAO<T> {

    @Override
    protected Class getDomainClass() {
        return GoalResourceManagement.class;
    }

    @Override
    public List<?> readGoalResourceByPipMaster(T object) {
        GoalResourceManagement goalResourceManagement = (GoalResourceManagement) object;
        String query = "";

        query += ""
                + " FROM GoalResourceManagement a"
                + " Where a.performanceImprovementPlanMaster=" + goalResourceManagement.getPerformanceImprovementPlanMaster().getId();

        return getHibernateTemplate().find(query);
    }
}
