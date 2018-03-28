/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainingAssessmentDAO;
import com.bul.zydex.model.TrainingAssessment;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingAssessmentServiceImpl<T> extends GenericsServiceImpl<T> implements TrainingAssessmentService<T> {

    private TrainingAssessmentDAO<T> trainingAssessmentDAO;

    public TrainingAssessmentDAO<T> getTrainingAssessmentDAO() {
        return trainingAssessmentDAO;
    }

    public void setTrainingAssessmentDAO(TrainingAssessmentDAO<T> trainingAssessmentDAO) {
        this.trainingAssessmentDAO = trainingAssessmentDAO;
        setGenericsDAO(trainingAssessmentDAO);

    }

    @Override
    public List<?> readOnlineAssementCandidateTraningList(int empid) {
        return trainingAssessmentDAO.readOnlineAssementCandidateTraningList(empid);
    }

    @Override
    public List<?> readTrainingAssementList(int trainingMasterId, int empId) {
        return trainingAssessmentDAO.readTrainingAssementList(trainingMasterId,empId);
    }

}
