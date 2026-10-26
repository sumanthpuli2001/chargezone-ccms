/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocSurveyAttachmentHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocSurveyAttachment;
import com.bul.zydex.model.AocSurveyAttachmentHistory;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocSurveyAttachmentHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements AocSurveyAttachmentHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocSurveyAttachmentHistory.class;
    }

    @Override
    public List readByaocHistroyid(int oaphistoryid) {
         String query = "";
	query += " FROM AocSurveyAttachmentHistory a"
		+ " WHERE a.aocFormHistoryId = '" + oaphistoryid + "'";
	return getHibernateTemplate().find(query);
    }

  
    
}
