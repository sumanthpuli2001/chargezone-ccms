/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DesignCoordinatorMultiAttach;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DesignCoordinatorMultiAttach;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DesignCoordinatorMultiAttachDaoImpl<T> extends GenericsDAOImpl<T> implements DesignCoordinatorMultiAttachDao<T> {

    @Override
    protected Class getDomainClass() {
	return DesignCoordinatorMultiAttach.class;
    }

    @Override
    public List readBydelmultiid(int oapformid) {
	String query = "";

	query += " FROM DesignCoordinatorMultiAttach a"
		+ " WHERE a.oapId = '" + oapformid + "'";
		
	return getHibernateTemplate().find(query);

    }

    @Override
    public List readBydelmultiid1( int aocformid) {
	String query = "";

	query += " FROM DesignCoordinatorMultiAttach a"
		+ " WHERE a.aocId = '" + aocformid + "'";
		
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readBydelimultiid(String id1) {
	String query = "";

	query += " FROM DesignCoordinatorMultiAttach a"
		+ " WHERE a.deliverableMultiId = '" + id1 + "'";
		
	return getHibernateTemplate().find(query);
	
    }

    @Override
    public DesignCoordinatorMultiAttach readBydelmultiids(int oapid) {
	String query = "";
	DesignCoordinatorMultiAttach designCoordinatorMultiAttach = new DesignCoordinatorMultiAttach();
	query += " FROM DesignCoordinatorMultiAttach a"
		+ " WHERE a.oapId = '" + oapid + "'";
	List<?> list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    designCoordinatorMultiAttach = (DesignCoordinatorMultiAttach) list.get(0);
	}
	return designCoordinatorMultiAttach;
	
    }

    @Override
    public DesignCoordinatorMultiAttach readBydelmultiidsaoc(int aocid) {
	String query = "";
	DesignCoordinatorMultiAttach designCoordinatorMultiAttach = new DesignCoordinatorMultiAttach();
	query += " FROM DesignCoordinatorMultiAttach a"
		+ " WHERE a.aocId = '" + aocid + "'";
	List<?> list = getHibernateTemplate().find(query);
	if (!list.isEmpty()) {
	    designCoordinatorMultiAttach = (DesignCoordinatorMultiAttach) list.get(0);
	}
	return designCoordinatorMultiAttach;
	
	
    }

}
