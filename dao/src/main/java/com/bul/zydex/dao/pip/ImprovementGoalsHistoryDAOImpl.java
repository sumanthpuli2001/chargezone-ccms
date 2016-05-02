/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ImprovementGoalsHistory;
import com.bul.zydex.model.PerformanceImprovementPlanMaster;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ImprovementGoalsHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements ImprovementGoalsHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ImprovementGoalsHistory.class;
    }

    @Override
    public List<?> readGoalHistory(String pip_Id, String goal_Id) {
        String query = "";

        query += " Select a.editedGoals, d.employeeName, a.historyDate"
                + " FROM ImprovementGoalsHistory a"
                + " left join a.performanceImprovementPlanMaster b "
                + " left join a.improvementGoal c"
                + " left join a.employeeMaster d"
                + " Where b.id=" + pip_Id
                + " AND c.id =" + goal_Id;
//                + " and a.status=5";

        return getHibernateTemplate().find(query);
    }

}
