/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormHistory;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CrcFormHistory;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CrcFormHistoryDaoImpl<T> extends GenericsDAOImpl<T> implements CrcFormHistoryDao<T> {

    @Override
    protected Class getDomainClass() {
	return CrcFormHistory.class;
    }

    @Override
    public List readBylasttimestatus(String id) {
	String query = "";
	query += " FROM CrcFormHistory a"
		+ " WHERE a.crcId = '" + id + "'";
	return getHibernateTemplate().find(query);

    }

   
}
