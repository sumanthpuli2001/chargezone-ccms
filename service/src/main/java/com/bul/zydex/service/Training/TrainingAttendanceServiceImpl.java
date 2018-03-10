/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingAttendanceDAO;
import com.bul.zydex.service.GenericsServiceImpl;

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
    
    
    
}
