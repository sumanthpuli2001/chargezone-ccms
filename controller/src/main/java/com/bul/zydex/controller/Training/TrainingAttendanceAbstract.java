/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.TrainingAttendance;
import com.bul.zydex.service.Training.TrainingAttendanceService;

/**
 *
 * @author Aman
 */
public class TrainingAttendanceAbstract extends CustomAbstract{

    protected TrainingAttendanceService<TrainingAttendance> trainingAttendanceService;

    public TrainingAttendanceService<TrainingAttendance> getTrainingAttendanceService() {
        return trainingAttendanceService;
    }

    public void setTrainingAttendanceService(TrainingAttendanceService<TrainingAttendance> trainingAttendanceService) {
        this.trainingAttendanceService = trainingAttendanceService;
    }
    
    
    
}
