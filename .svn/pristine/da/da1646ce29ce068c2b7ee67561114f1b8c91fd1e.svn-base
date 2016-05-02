/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.ImprovementGoalsHistoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ImprovementGoalsHistoryServiceImpl<T> extends GenericsServiceImpl<T>
        implements ImprovementGoalsHistoryService<T> {

    protected ImprovementGoalsHistoryDAO<T> improvementGoalsHistoryDAO;

    public ImprovementGoalsHistoryDAO<T> getImprovementGoalsHistoryDAO() {
        return improvementGoalsHistoryDAO;
    }

    public void setImprovementGoalsHistoryDAO(ImprovementGoalsHistoryDAO<T> improvementGoalsHistoryDAO) {
        this.improvementGoalsHistoryDAO = improvementGoalsHistoryDAO;
        setGenericsDAO(improvementGoalsHistoryDAO);
    }

    public List<?> readGoalHistory(String pip_Id, String goal_Id) {
        return improvementGoalsHistoryDAO.readGoalHistory(pip_Id, goal_Id);
    }

}
