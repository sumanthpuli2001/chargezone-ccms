/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.SurveyMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.SurveyDocumentNo;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SurveyDocumentNoDaoImpl<T> extends GenericsDAOImpl<T> implements SurveyDocumentNoDao<T> {

    @Override
    protected Class getDomainClass() {
        return SurveyDocumentNo.class;
    }

    @Override
    public SurveyDocumentNo readByDocumentNo() {
        SurveyDocumentNo surveyDocumentNo = new SurveyDocumentNo();
	String query = "";
	query += " FROM SurveyDocumentNo a order by a.DocumentNo desc limit 1"
		+ " ";
	List<?> list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    surveyDocumentNo = (SurveyDocumentNo) list.get(0);
	}
	return surveyDocumentNo;
    }
    
    
}
