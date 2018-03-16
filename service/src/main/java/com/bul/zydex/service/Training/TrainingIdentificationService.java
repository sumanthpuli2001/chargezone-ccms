/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface TrainingIdentificationService<T> extends GenericsService<T>{
   
    public List<?> gettrainingattendance(int id);
    public List<?> getTrainerAttendance(int id);
    public Boolean checkExistance(int trainingId,int empId, int trainerId);
}
