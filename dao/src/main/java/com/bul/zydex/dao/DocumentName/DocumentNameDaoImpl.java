/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DocumentName;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DocumentName;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class DocumentNameDaoImpl<T> extends GenericsDAOImpl<T> implements DocumentNameDao<T> {

    @Override
    protected Class getDomainClass() {
	return DocumentName.class;
    }

    @Override
    public List readAll() {

	 String query = "SELECT a.id,a.state, a.discomId, a.connectionTypeId, COUNT(a),b.connectionType,c.discomType "
                + " FROM DocumentName a ,ConnectionType b , DiscomMaster c"
                + " Where a.connectionTypeId=b.id"
                + " And a.discomId=c.id"
                + " GROUP BY a.state, a.discomId, a.connectionTypeId";

        return getHibernateTemplate().find(query);

    }

    @Override
    public List readBystate(String state) {
	String query = "";
	query += " FROM DocumentName a"
		+ " WHERE a.state = '" + state + "'";
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readByStateName(String state) {
	String query = "";
	query += " FROM DocumentName a"
		+ " WHERE a.state = '" + state + "'";
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readyBydisconn(int discom, int connection) {
	String query = "";
	query += " FROM DocumentName a"
		+ " WHERE a.discomId = '" + discom + "'"
		+ " And a.connectionTypeId = '" + connection + "'";
	return getHibernateTemplate().find(query);

    }

    @Override
    public List readByall() {

	String query = "Select a.id, a.documentName, a.compalsuary, c.connectionType, b.discomType";
	query += " FROM DocumentName a, DiscomMaster b, ConnectionType c"
		+ " WHERE a.discomId = b.id"
		+ " And a.connectionTypeId = c.id";

	return getHibernateTemplate().find(query);

    }

}
