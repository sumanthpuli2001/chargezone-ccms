/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TrainingAssessment;

/**
 *
 * @author Aman
 */
public class TrainingAssessmentDAOImpl<T>extends GenericsDAOImpl<T> implements TrainingAssessmentDAO<T>{

    @Override
    protected Class getDomainClass() {
        return TrainingAssessment.class;
    }
    
}
