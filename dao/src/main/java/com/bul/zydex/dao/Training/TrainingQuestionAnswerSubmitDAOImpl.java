/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingQuestionAnswerSubmit;
import java.util.List;

/**
 *
 * @author Aman
 */
public class TrainingQuestionAnswerSubmitDAOImpl<T> extends GenericsDAOImpl<T> implements TrainingQuestionAnswerSubmitDAO<T>{

    @Override
    protected Class getDomainClass() {
        return TrainingQuestionAnswerSubmit.class;
    }
    
    @Override
    public List<?> readByTrainigAssessmentId(int assessmentId) {
        String query = "";
//                          0   1   2       3               4       5               6       7
        query += "Select a.id,b.id,c.id,a.questionAns.id,c.ansId,a.description,c.marks,d.id"
                + " From TrainingQuestionAnswerSubmit a"
                + " LEFT JOIN a.trainingAssessment b"
                + " LEFT JOIN a.questionLibrary c"
                + " LEFT JOIN a.questionAns d"
                + " Where b.id=" + assessmentId;

        return getHibernateTemplate().find(query);
    }
    
}
