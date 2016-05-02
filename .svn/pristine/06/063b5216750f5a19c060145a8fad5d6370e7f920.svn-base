/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.dao.pip.ImprovementGoalDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ImprovementGoalServiceImpl<T> extends GenericsServiceImpl<T> implements ImprovementGoalService<T> {

    protected ImprovementGoalDAO<T> improvementGoalDAO;

    public ImprovementGoalDAO<T> getImprovementGoalDAO() {
        return improvementGoalDAO;
    }

    public void setImprovementGoalDAO(ImprovementGoalDAO<T> improvementGoalDAO) {
        this.improvementGoalDAO = improvementGoalDAO;
        setGenericsDAO(improvementGoalDAO);
    }

    public List<?> readImprovementGoalByPipMaster(T object) {
        return improvementGoalDAO.readImprovementGoalByPipMaster(object);
    }

}
