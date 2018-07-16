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
    public List<?> readTrainingIdentificationList() {
        return trainingIdentificationDAO.readTrainingIdentificationList();
    }

    @Override
    public List<?> readTrainingList(String eventDate,int userid) {
        return trainingIdentificationDAO.readTrainingList(eventDate,userid);
    }

    @Override
    public List<?> readTraingFeedback() {
        return trainingIdentificationDAO.readTraingFeedback();
    }
    
    
    
    public List<?> gettrainingattendance(int id) {
        return trainingIdentificationDAO.gettrainingattendance(id);
    }

    @Override
    public List<?> getTrainerAttendance(int id) {
        return trainingIdentificationDAO.getTrainerAttendance(id);
    }

    @Override
    public Boolean checkExistance(int trainingId, int empId, int trainerId, String eventdate) {
         return trainingIdentificationDAO.checkExistance(trainingId,empId,trainerId,eventdate);
    }

    @Override
    public List<?> ListeventDates(String eventDate, int userId) {
        return trainingIdentificationDAO.ListeventDates(eventDate, userId);
    }

    @Override
    public List<?> checkTraineeAvailableStatus(int trainingId, int empId) {
        return trainingIdentificationDAO.checkTraineeAvailableStatus(trainingId, empId);
    }

    @Override
    public List<?> readEmployeeAndTraining(int trainingId, int id) {
        return trainingIdentificationDAO.readEmployeeAndTraining(trainingId,id);
    }

    @Override
    public List<?> readTrainingById(String trainingId) {
         return trainingIdentificationDAO.readTrainingById(trainingId);
    }

}
