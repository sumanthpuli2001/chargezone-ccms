/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffAttendences;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KickOffAttendences;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class KickOffAttendencesDaoImpl<T> extends GenericsDAOImpl<T> implements KickOffAttendencesDao<T> {

    @Override
    protected Class getDomainClass() {
	 return KickOffAttendences.class;
    }

    @Override
    public List readByid(String kickoffFormId) {
	String query = "";
	query += " FROM KickOffAttendences a"
		+ " WHERE a.kickoffFormId = '" + kickoffFormId + "'";
	return getHibernateTemplate().find(query);
	
	
	
    }

    @Override
    public List readByids(String id) {
	String query = "";
	query += " FROM KickOffAttendences a"
		+ " WHERE a.kickoffFormId = '" + id + "'";
	return getHibernateTemplate().find(query);
	
    }

    @Override
    public List readBykickOffFormid(int id1) {
	String query = "";
	query += " FROM KickOffAttendences a"
		+ " WHERE a.kickoffFormId = '" + id1 + "'";
	return getHibernateTemplate().find(query);
    }
    
}
//String query = "";
//	query += " FROM OapForm a"
//		+ " WHERE a.userId = '" + username + "'";
//	return getHibernateTemplate().find(query);