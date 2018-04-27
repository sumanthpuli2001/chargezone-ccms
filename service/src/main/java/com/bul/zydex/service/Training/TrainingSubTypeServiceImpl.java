/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingSubTypeDAO;
import com.bul.zydex.model.TrainingSubType;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainingSubTypeServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingSubTypeService<T> {
private TrainingSubTypeDAO<T> trainingSubTypeDAO;

    public TrainingSubTypeDAO<T> getTrainingSubTypeDAO() {
        return trainingSubTypeDAO;
    }

    public void setTrainingSubTypeDAO(TrainingSubTypeDAO<T> trainingSubTypeDAO) {
        this.trainingSubTypeDAO = trainingSubTypeDAO;
        setGenericsDAO(trainingSubTypeDAO);
    }

    @Override
    public List<?> readtrainingSubTypeDetail() {
        return trainingSubTypeDAO.readtrainingSubTypeDetail();
    }

    @Override
    public List<?> readtrainingSubTypeByTrainingTypeId(int trainingTypeId) {
        return trainingSubTypeDAO.readtrainingSubTypeByTrainingTypeId(trainingTypeId);
    }

    @Override
    public boolean isExist(TrainingSubType trainingType) {
         TrainingSubType trainingSubType1 = (TrainingSubType) trainingType;

        List<?> list = trainingSubTypeDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            trainingType = (TrainingSubType) i.next();
            if (trainingType.getTrainingsubtype().equalsIgnoreCase(trainingSubType1.getTrainingsubtype())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<?> deletetrainigId(String trainingTypeId) {
        return trainingSubTypeDAO.deletetrainigId(trainingTypeId);
    }
}
