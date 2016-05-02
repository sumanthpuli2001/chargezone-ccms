/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.ActivityGoalsDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ActivityGoalsServiceImpl<T> extends GenericsServiceImpl<T> implements ActivityGoalsService<T> {

    protected ActivityGoalsDAO<T> activityGoalsDAO;

    public ActivityGoalsDAO<T> getActivityGoalsDAO() {
        return activityGoalsDAO;
    }

    public void setActivityGoalsDAO(ActivityGoalsDAO<T> activityGoalsDAO) {
        this.activityGoalsDAO = activityGoalsDAO;
        setGenericsDAO(activityGoalsDAO);
    }

    public List<?> readActivityGoalByPipMaster(T object) {
        return activityGoalsDAO.readActivityGoalByPipMaster(object);
    }

}
