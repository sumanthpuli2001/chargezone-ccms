/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingSubMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainingSubMasterServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingSubMasterService<T> {

    private TrainingSubMasterDAO<T> trainingSubMasterDAO;

    public TrainingSubMasterDAO<T> getTrainingSubMasterDAO() {
        return trainingSubMasterDAO;
    }

    public void setTrainingSubMasterDAO(TrainingSubMasterDAO<T> trainingSubMasterDAO) {
        this.trainingSubMasterDAO = trainingSubMasterDAO;
        setGenericsDAO(trainingSubMasterDAO);
    }

    @Override
    public List<?> ListeventDates(String eventDate) {
        return trainingSubMasterDAO.ListeventDates(eventDate);
    }

    
}
