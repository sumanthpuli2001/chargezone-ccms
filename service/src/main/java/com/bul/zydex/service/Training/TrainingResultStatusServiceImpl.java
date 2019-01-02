/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingResultStatusDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingResultStatusServiceImpl<T>extends GenericsServiceImpl<T> implements TrainingResultStatusService<T>{
    private TrainingResultStatusDAO<T>trainingResultStatusDAO;

    public TrainingResultStatusDAO<T> getTrainingResultStatusDAO() {
        return trainingResultStatusDAO;
    }

    public void setTrainingResultStatusDAO(TrainingResultStatusDAO<T> trainingResultStatusDAO) {
        this.trainingResultStatusDAO = trainingResultStatusDAO;
        setGenericsDAO(trainingResultStatusDAO);
    }

    @Override
    public List<?> readByTrainigAssessmentResultId(int assessmentId) {
       return trainingResultStatusDAO.readByTrainigAssessmentResultId(assessmentId);
    }

    
  
    
    
    
}
