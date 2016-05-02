/*
 *
 * Author Dhaval
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ImprovementGoal;
import com.bul.zydex.model.PerformanceImprovementPlanMaster;
import java.util.List;

/**
 *
 * @author Dhaval
 */
public class ImprovementGoalDAOImpl<T> extends GenericsDAOImpl<T> implements ImprovementGoalDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ImprovementGoal.class;
    }

    @Override
    public List<?> readImprovementGoalByPipMaster(T object) {
        ImprovementGoal improvementGoal = (ImprovementGoal) object;
        String query = "";

        query += ""
                + " FROM ImprovementGoal a"
                + " Where a.performanceImprovementPlanMaster=" + improvementGoal.getPerformanceImprovementPlanMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
