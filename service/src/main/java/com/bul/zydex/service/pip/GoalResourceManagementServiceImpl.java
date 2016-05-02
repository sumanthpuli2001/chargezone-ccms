/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.GoalResourceManagementDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class GoalResourceManagementServiceImpl<T> extends GenericsServiceImpl<T> implements GoalResourceManagementService<T> {

    protected GoalResourceManagementDAO<T> goalResourceManagementDAO;

    public GoalResourceManagementDAO<T> getGoalResourceManagementDAO() {
        return goalResourceManagementDAO;
    }

    public void setGoalResourceManagementDAO(GoalResourceManagementDAO<T> goalResourceManagementDAO) {
        this.goalResourceManagementDAO = goalResourceManagementDAO;
        setGenericsDAO(goalResourceManagementDAO);
    }

    @Override
    public List<?> readGoalResourceByPipMaster(T object) {
        return goalResourceManagementDAO.readGoalResourceByPipMaster(object);
    }

}
