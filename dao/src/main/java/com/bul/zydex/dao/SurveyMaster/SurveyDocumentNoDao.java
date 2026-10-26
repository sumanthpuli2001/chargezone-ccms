/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SurveyMaster;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.SurveyDocumentNo;

/**
 *
 * @author Admin
 */
public interface SurveyDocumentNoDao<T> extends GenericsDAO<T> {

    public SurveyDocumentNo readByDocumentNo();
    
}
