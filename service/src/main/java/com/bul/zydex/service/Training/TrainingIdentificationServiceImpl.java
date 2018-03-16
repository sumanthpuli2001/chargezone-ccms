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
public class TrainingIdentificationServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingIdentificationService<T> {

    private TrainingIdentificationDAO<T> trainingIdentificationDAO;

    public TrainingIdentificationDAO<T> getTrainingIdentificationDAO() {
        return trainingIdentificationDAO;
    }

    public void setTrainingIdentificationDAO(TrainingIdentificationDAO<T> trainingIdentificationDAO) {
        this.trainingIdentificationDAO = trainingIdentificationDAO;
        setGenericsDAO(trainingIdentificationDAO);
    }

    @Override
    public List<?> gettrainingattendance(int id) {
        return trainingIdentificationDAO.gettrainingattendance(id);
    }

    @Override
    public List<?> getTrainerAttendance(int id) {
        return trainingIdentificationDAO.getTrainerAttendance(id);
    }

    @Override
    public Boolean checkExistance(int trainingId, int empId, int trainerId) {
         return trainingIdentificationDAO.checkExistance(trainingId,empId,trainerId);
    }

}
