/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormMultiAttachementHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapMultiAttachmentHistory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OapFormMultiAttachementHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements OapFormMultiAttachementHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapMultiAttachmentHistory.class;
    }

    @Override
    public List readByMulti(int oaphistoryid) {
	
	String query = "";
	query += " FROM OapMultiAttachmentHistory a"
		+ " WHERE a.oapHistoryId = '" + oaphistoryid + "'";
	return getHibernateTemplate().find(query);
	
	
    }

    @Override
    public List readByMulti1(String id) {
	
	String query = "";
	query += " FROM OapMultiAttachmentHistory a"
		+ " WHERE a.oapHistoryId = '" + id + "'";
	return getHibernateTemplate().find(query);
	
    }

}
