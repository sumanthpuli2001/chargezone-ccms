/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Deliverable;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Deliverable;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DeliverableDaoImpl<T> extends GenericsDAOImpl<T> implements DeliverableDao<T> {

    @Override
    protected Class getDomainClass() {
	return Deliverable.class;
    }

    @Override
    public Deliverable readByoapid(String id) {
	Deliverable deliverable = new Deliverable();
	String query = "";
	query += " FROM Deliverable a"
		+ " WHERE a.oapId =  '" + id + "'";
	List list = getHibernateTemplate().find(query);

	if (!list.isEmpty()) {
	    deliverable = (Deliverable) list.get(0);

	}
	return deliverable;
	
	
	
    }

    @Override
    public Deliverable readByAOcid(String id) {
	Deliverable deliverable = new Deliverable();
	String query = "";
	query += " FROM Deliverable a"
		+ " WHERE a.aocId =  '" + id + "'";
	List list = getHibernateTemplate().find(query);

	if (!list.isEmpty()) {
	    deliverable = (Deliverable) list.get(0);

	}
	return deliverable;
    }
    
}
