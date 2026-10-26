/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapLogMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapLogMaster;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapLogMasterDaoImpl<T> extends GenericsDAOImpl<T> implements OapLogMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return OapLogMaster.class;

    }

    @Override
    public List readByOapId(String id) {
        
        String query = "";
	query += " FROM OapLogMaster a"
		+ " WHERE a.oapId = '" + id + "'";
	return getHibernateTemplate().find(query);
    }

    @Override
    public List readBycrcid(String id) {
         String query = "";
	query += " FROM OapLogMaster a"
		+ " WHERE a.crcId = '" + id + "'";
	return getHibernateTemplate().find(query);
        
    }

}
