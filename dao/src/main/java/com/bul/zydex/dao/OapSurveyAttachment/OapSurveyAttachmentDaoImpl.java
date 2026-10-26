/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapSurveyAttachment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapSurveyAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapSurveyAttachmentDaoImpl<T> extends GenericsDAOImpl<T> implements OapSurveyAttachmentDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapSurveyAttachment.class;
    }

    @Override
    public List readByoapId(String id) {
        
        String query = "";
	query += " FROM OapSurveyAttachment a"
		+ " WHERE a.oapId = '" + id + "'";
	return getHibernateTemplate().find(query);
    }

    @Override
    public OapSurveyAttachment readByoapFormId(String OapId) {

      String query = "";
        OapSurveyAttachment oapSurveyAttachment = new OapSurveyAttachment();
        query += " FROM OapSurveyAttachment a"
                + " WHERE a.oapId = '" + OapId + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            oapSurveyAttachment = (OapSurveyAttachment) list.get(0);
        }
        return oapSurveyAttachment;
    
    
    }
    
}
