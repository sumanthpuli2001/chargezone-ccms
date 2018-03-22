/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingAttendanceDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingAttendanceServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingAttendanceService<T>{
    
    private TrainingAttendanceDAO<T> trainingAttendanceDAO;

    public TrainingAttendanceDAO<T> getTrainingAttendanceDAO() {
        return trainingAttendanceDAO;
    }

    public void setTrainingAttendanceDAO(TrainingAttendanceDAO<T> trainingAttendanceDAO) {
        this.trainingAttendanceDAO = trainingAttendanceDAO;
        setGenericsDAO(trainingAttendanceDAO);
    }

    @Override
    public List<?> gettrainingattendance(String eventDate, int id) {
       return trainingAttendanceDAO.gettrainingattendance(eventDate, id);
    }

    @Override
    public List<?> gettrainerTasks(String eventDate, int id) {
        return trainingAttendanceDAO.gettrainerTasks(eventDate, id);
    }

    @Override
    public Boolean checkFeedbackstatus(int id) {
         return trainingAttendanceDAO.checkFeedbackstatus(id);
    }
    
    
    
}
