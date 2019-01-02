/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingResultStatus;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingResultStatusDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingResultStatusDAO<T>{

    @Override
    protected Class getDomainClass() {
        return TrainingResultStatus.class;
    }

    @Override
    public List<?> readByTrainigAssessmentResultId(int assessmentId) {
         String query = "";
//                          0   1   2       3               4       5               6       7
        query += "Select a.id,b.id,a.obtainPercentage,a.obtainTotal,a.resultStatus"
                + " From TrainingResultStatus a"
                + " LEFT JOIN a.trainingAssessment b"
                + " Where b.id=" + assessmentId;

        return getHibernateTemplate().find(query);
    }
    
}
