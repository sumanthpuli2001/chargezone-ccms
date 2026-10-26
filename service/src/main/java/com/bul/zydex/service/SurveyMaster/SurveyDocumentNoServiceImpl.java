/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SurveyMaster;

import com.bul.zydex.dao.SurveyMaster.SurveyDocumentNoDao;
import com.bul.zydex.model.SurveyDocumentNo;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Admin
 */
public class SurveyDocumentNoServiceImpl<T> extends GenericsServiceImpl<T> implements SurveyDocumentNoService<T> {
    
     private SurveyDocumentNoDao<T> surveyDocumentNoDao;

    public SurveyDocumentNoDao<T> getSurveyDocumentNoDao() {
        return surveyDocumentNoDao;
    }

    public void setSurveyDocumentNoDao(SurveyDocumentNoDao<T> surveyDocumentNoDao) {
        this.surveyDocumentNoDao = surveyDocumentNoDao;
        setGenericsDAO(surveyDocumentNoDao);
    }

    @Override
    public SurveyDocumentNo readByDocumentNo() {
        return surveyDocumentNoDao.readByDocumentNo();
    }
    
}
