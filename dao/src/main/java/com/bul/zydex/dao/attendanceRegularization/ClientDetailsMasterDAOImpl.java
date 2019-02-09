/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.attendanceRegularization;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ClientDetailsMaster;
import com.bul.zydex.model.LocationMaster;
import java.util.List;

/**
 *
 * @author Success
 */
public class ClientDetailsMasterDAOImpl<T> extends GenericsDAOImpl<T> implements ClientDetailsMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
          return ClientDetailsMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        ClientDetailsMaster clientDetailsMaster = (ClientDetailsMaster) object;
        List<?> list = getHibernateTemplate().find("from ClientDetailsMaster  where clientName ='" + clientDetailsMaster.getClientName() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    
}
