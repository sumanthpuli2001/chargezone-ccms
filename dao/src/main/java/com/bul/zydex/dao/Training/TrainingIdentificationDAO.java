/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface TrainingIdentificationDAO<T>extends GenericsDAO<T>{

    public List<?> readTrainingIdentificationList();

    public List<?> readTrainingList(int userid);

    public List<?> readTraingFeedback();
    
  
    public List<?> gettrainingattendance(int id);
    public List<?> getTrainerAttendance(int id);
    public Boolean checkExistance(int trainingId,int empId, int trainerId);
}
