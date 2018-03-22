/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainingMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingMasterService<T> {

    private TrainingMasterDAO<T> trainingMasterDAO;

    public TrainingMasterDAO<T> getTrainingMasterDAO() {
        return trainingMasterDAO;
    }

    public void setTrainingMasterDAO(TrainingMasterDAO<T> trainingMasterDAO) {
        this.trainingMasterDAO = trainingMasterDAO;
        setGenericsDAO(trainingMasterDAO);
    }

    @Override
    public void deletetrainingSubMaster(Integer id) {
        trainingMasterDAO.deletetrainingSubMaster(id);
    }

    @Override
    public List<?> fetchtrainingMaster(String date) {
      return  trainingMasterDAO.fetchtrainingMaster(date);
    }

    @Override
    public List<?> fetchtTrainingforFeedback(int traininigId, int user) {
        return  trainingMasterDAO.fetchtTrainingforFeedback(traininigId, user);
    }

   
}
