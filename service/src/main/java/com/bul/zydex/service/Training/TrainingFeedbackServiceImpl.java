
package com.bul.zydex.service.Training;

import com.bul.zydex.service.Training.*;
import com.bul.zydex.dao.Training.TrainingFeedbackDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */

public class TrainingFeedbackServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingFeedbackService<T> {
     private TrainingFeedbackDAO<T> trainingFeedbackDAO;

    public TrainingFeedbackDAO<T> getTrainingFeedbackDAO() {
        return trainingFeedbackDAO;
    }

    public void setTrainingFeedbackDAO(TrainingFeedbackDAO<T> trainingFeedbackDAO) {
        this.trainingFeedbackDAO = trainingFeedbackDAO;
        setGenericsDAO(trainingFeedbackDAO);
    }
      @Override
    public boolean isExist(T t) {
        return trainingFeedbackDAO.isExist(t); //To change body of generated methods, choose Tools | Templates.
    }
   

    public TrainingFeedbackDAO<T> getTrainingFeedbackDAO1() {
        return trainingFeedbackDAO;
    }

    public void setTrainingFeedbackDAO1(TrainingFeedbackDAO<T> trainingFeedbackDAO) {
        this.trainingFeedbackDAO = trainingFeedbackDAO;
        setGenericsDAO(trainingFeedbackDAO);
    }
    
      @Override
    public List<?> read() {
        return trainingFeedbackDAO.read();
    }

    
}
