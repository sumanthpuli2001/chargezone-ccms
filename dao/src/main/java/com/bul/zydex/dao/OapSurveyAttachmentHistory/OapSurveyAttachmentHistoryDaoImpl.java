/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapSurveyAttachmentHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapSurveyAttachmentHistory;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapSurveyAttachmentHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements OapSurveyAttachmentHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapSurveyAttachmentHistory.class;

    }

    @Override
    public List readByoaphistryid(String id) {
        String query = "";
	query += " FROM OapSurveyAttachmentHistory a"
		+ " WHERE a.oapFormHistoryId = '" + id + "'";
	return getHibernateTemplate().find(query);
    }

}
