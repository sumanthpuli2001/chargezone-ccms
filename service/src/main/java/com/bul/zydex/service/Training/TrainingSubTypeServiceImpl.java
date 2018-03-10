/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingSubTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainingSubTypeServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingSubTypeService<T> {
private TrainingSubTypeDAO<T> trainingSubTypeDAO;

    public TrainingSubTypeDAO<T> getTrainingSubTypeDAO() {
        return trainingSubTypeDAO;
    }

    public void setTrainingSubTypeDAO(TrainingSubTypeDAO<T> trainingSubTypeDAO) {
        this.trainingSubTypeDAO = trainingSubTypeDAO;
        setGenericsDAO(trainingSubTypeDAO);
    }

    @Override
    public List<?> readtrainingSubTypeDetail() {
        return trainingSubTypeDAO.readtrainingSubTypeDetail();
    }
}
