/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingIdentificationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingIdentificationServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingIdentificationService<T>{
    
    private TrainingIdentificationDAO<T> trainingIdentificationDAO;

    public TrainingIdentificationDAO<T> getTrainingIdentificationDAO() {
        return trainingIdentificationDAO;
    }

    public void setTrainingIdentificationDAO(TrainingIdentificationDAO<T> trainingIdentificationDAO) {
        this.trainingIdentificationDAO = trainingIdentificationDAO;
        setGenericsDAO(trainingIdentificationDAO);
    }

    @Override
    public List<?> readTrainingIdentificationList() {
        return trainingIdentificationDAO.readTrainingIdentificationList();
    }

    @Override
    public List<?> readTrainingList(int userid) {
        return trainingIdentificationDAO.readTrainingList(userid);
    }

    @Override
    public List<?> readTraingFeedback() {
        return trainingIdentificationDAO.readTraingFeedback();
    }
    
    
    
}
