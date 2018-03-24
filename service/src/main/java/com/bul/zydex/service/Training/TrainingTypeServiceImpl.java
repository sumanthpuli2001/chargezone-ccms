/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainingTypeServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingTypeService<T> {

    private TrainingTypeDAO<T> trainingTypeDAO;

    public TrainingTypeDAO<T> getTrainingTypeDAO() {
        return trainingTypeDAO;
    }

    public void setTrainingTypeDAO(TrainingTypeDAO<T> trainingTypeDAO) {
        this.trainingTypeDAO = trainingTypeDAO;
        setGenericsDAO(trainingTypeDAO);
    }

    @Override
    public List<?> readtrainingTypeDetail() {
        return trainingTypeDAO.readtrainingTypeDetail();
    }
    
      @Override
    public List<?> trainingTypeBystatus() {
        return trainingTypeDAO.trainingTypeBystatus();
    }
}
