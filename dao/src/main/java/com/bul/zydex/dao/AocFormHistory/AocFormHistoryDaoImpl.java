/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocFormHistory;
import java.util.List;

/**
 *
 * @author Hitesh
 */
public class AocFormHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements AocFormHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocFormHistory.class;
    }

    @Override
    public List readBylasttimestatus(int id1) {
	String query = "";
	query += " FROM AocFormHistory a"
		+ " WHERE a.aocId = '" + id1 + "'";
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readByaocid(String id) {
	
	String query = "";
	query += " FROM AocFormHistory a"
		+ " WHERE a.aocId = '" + id + "'";
	return getHibernateTemplate().find(query);
	
    }
    
}
