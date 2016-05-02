/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ImprovementGoalsHistoryDAO<T> extends GenericsDAO<T> {

    public List<?> readGoalHistory(String pip_Id, String goal_Id);

}
