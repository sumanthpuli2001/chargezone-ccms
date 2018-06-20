/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ProjectManagement;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ClientMaster;
import java.util.List;

/**
 *
 * @author Aman
 */
public class ClientMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ClientMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return ClientMaster.class;
    }

    @Override
    public List<?> readClientMaster() {
        String query ="";
        query +=" Select cm.id , cm.name , cm.emailId,cm.contactNo,cm.address"
                + " FROM ClientMaster cm";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> deleteClientMaster(String clientMasterId) {
        String query = "";
        query += "  "
                + " select a"
                + " FROM ClientMaster a "
                + " WHERE a.id = " + clientMasterId;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
    
}
