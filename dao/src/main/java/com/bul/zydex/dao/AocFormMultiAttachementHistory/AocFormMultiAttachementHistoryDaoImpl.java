/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormMultiAttachementHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormMultiAttachmentHistory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AocFormMultiAttachementHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormMultiAttachementHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocFormMultiAttachmentHistory.class;
    }

    @Override
    public List readByMulti(int oaphistoryid) {
	String query = "";
	query += " FROM AocFormMultiAttachmentHistory a"
		+ " WHERE a.aocHistoryId = '" + oaphistoryid + "'";
	return getHibernateTemplate().find(query);
	
	
	
    }

    @Override
    public List readByMulti1(String id) {
	String query = "";
	query += " FROM AocFormMultiAttachmentHistory a"
		+ " WHERE a.aocHistoryId = '" + id + "'";
	return getHibernateTemplate().find(query);
	
    }

}
