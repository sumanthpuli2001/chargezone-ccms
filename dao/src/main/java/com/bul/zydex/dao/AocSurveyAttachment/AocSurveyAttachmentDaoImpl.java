/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocSurveyAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocSurveyAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocSurveyAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements AocSurveyAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
         return AocSurveyAttachment.class;
    }

    @Override
    public List readByaocId(String aocformid) {
         String query = "";
	query += " FROM AocSurveyAttachment a"
		+ " WHERE a.aocId = '" + aocformid + "'";
	return getHibernateTemplate().find(query);
        
        
        
    }

    @Override
    public AocSurveyAttachment readByaocFormId(String aocId) {

     String query = "";
        AocSurveyAttachment aocSurveyAttachment = new AocSurveyAttachment();
        query += " FROM AocSurveyAttachment a"
                + " WHERE a.aocId = '" + aocId + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            aocSurveyAttachment = (AocSurveyAttachment) list.get(0);
        }
        return aocSurveyAttachment;
    
    
    }
    
}
