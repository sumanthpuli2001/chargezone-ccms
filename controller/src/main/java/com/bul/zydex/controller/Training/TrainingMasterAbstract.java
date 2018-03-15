/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Training;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.Trainer;
import com.bul.zydex.model.TrainingMaster;
import com.bul.zydex.model.TrainingSubMaster;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.model.TrainingType;
import com.bul.zydex.service.Training.TrainerService;
import com.bul.zydex.service.Training.TrainingMasterService;
import com.bul.zydex.service.Training.TrainingSubMasterService;
import com.bul.zydex.service.Training.TrainingSubTypeService;
import com.bul.zydex.service.Training.TrainingTypeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DELL3
 */
public abstract class TrainingMasterAbstract extends CustomAbstract{
    protected TrainingTypeService<TrainingType> trainingTypeService;
    protected TrainingSubTypeService<TrainingSubType> trainingSubTypeService;
    protected TrainerService<Trainer> trainerService;
    protected TrainingMasterService<TrainingMaster> trainingMasterService;
    protected TrainingSubMasterService<TrainingSubMaster> trainingSubMasterService;

    public TrainingTypeService<TrainingType> getTrainingTypeService() {
        return trainingTypeService;
    }

    public void setTrainingTypeService(TrainingTypeService<TrainingType> trainingTypeService) {
        this.trainingTypeService = trainingTypeService;
    }

    public TrainingSubTypeService<TrainingSubType> getTrainingSubTypeService() {
        return trainingSubTypeService;
    }

    public void setTrainingSubTypeService(TrainingSubTypeService<TrainingSubType> trainingSubTypeService) {
        this.trainingSubTypeService = trainingSubTypeService;
    }

    public TrainerService<Trainer> getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService<Trainer> trainerService) {
        this.trainerService = trainerService;
    }

    public TrainingMasterService<TrainingMaster> getTrainingMasterService() {
        return trainingMasterService;
    }

    public void setTrainingMasterService(TrainingMasterService<TrainingMaster> trainingMasterService) {
        this.trainingMasterService = trainingMasterService;
    }

    public TrainingSubMasterService<TrainingSubMaster> getTrainingSubMasterService() {
        return trainingSubMasterService;
    }

    public void setTrainingSubMasterService(TrainingSubMasterService<TrainingSubMaster> trainingSubMasterService) {
        this.trainingSubMasterService = trainingSubMasterService;
    }
    
     protected void trainerList(HttpServletRequest request) {
        Trainer trainerMaster = new Trainer();
        List<?> trainerList = trainerService.read();
        Map<Integer, String> trn = new HashMap<>();
        for (Object o : trainerList) {
            trainerMaster = (Trainer) o;
            trn.put(trainerMaster.getId(), trainerMaster.getTrainerName());
        }

        request.setAttribute("trainerMap", trn);
    }
     protected void trainingtypeList(HttpServletRequest request) {
        TrainingType trainingTypeMaster = new TrainingType();
        List<?> trainingTypeList = trainingTypeService.read();
        Map<Integer, String> trn = new HashMap<>();
        for (Object o : trainingTypeList) {
            trainingTypeMaster = (TrainingType) o;
            trn.put(trainingTypeMaster.getId(), trainingTypeMaster.getTraining());
        }

        request.setAttribute("trainingTypeMap", trn);
    }
     protected void trainingSubtypeList(HttpServletRequest request) {
        TrainingSubType trainingSubTypeMaster = new TrainingSubType();
        List<?> trainingSubTypeList = trainingSubTypeService.read();
        Map<Integer, String> trnsb = new HashMap<>();
        for (Object o : trainingSubTypeList) {
            trainingSubTypeMaster = (TrainingSubType) o;
            trnsb.put(trainingSubTypeMaster.getId(), trainingSubTypeMaster.getTrainingsubtype());
        }

        request.setAttribute("trainingSubTypeMap", trnsb);
    }
}
