/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapMasterUser;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.OapMasterUser;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class OapMasterUserDaoImpl<T> extends GenericsDAOImpl<T> implements OapMasterUserDao<T> {

    @Override
    protected Class getDomainClass() {
	return OapMasterUser.class;
    }

    @Override
    public List<?> readByIdToList1(String id) {
	 String query = "";
        query += " FROM OapMasterUser c"
              + " WHERE c.oapMaster.id = '" + id + "'";
        return getHibernateTemplate().find(query);
	
    }

    @Override
    public List readByIdToList(String approvalName) {
	 String query = "";
        query += " FROM OapMasterUser c"
              + " WHERE c.oapMaster.id = '" + approvalName + "'";
        return getHibernateTemplate().find(query);
	
    }

}
 