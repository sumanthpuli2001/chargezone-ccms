/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocLogMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AocLogMaster;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class AocLogMasterDaoImpl<T> extends GenericsDAOImpl<T> implements AocLogMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return AocLogMaster.class;

    }

    @Override
    public List readByAocId(String id) {
        
        String query = "";
	query += " FROM AocLogMaster a"
		+ " WHERE a.aocId = '" + id + "'";
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readByKomid(String id) {
          String query = "";
	query += " FROM AocLogMaster a"
		+ " WHERE a.komId = '" + id + "'";
	return getHibernateTemplate().find(query);
        
    }

}
