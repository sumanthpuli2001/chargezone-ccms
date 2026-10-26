/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ServiceRights;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class ServiceRightsDaoImpl<T> extends GenericsDAOImpl<T> implements ServiceRightsDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return ServiceRights.class;
    }

    @Override
    public ServiceRights ReadDepartmentLocation(String department, String location) {
        ServiceRights serviceRights = new ServiceRights();
        String query = "";
        query += " FROM ServiceRights a"
                + " WHERE a.department = '" + department + "' and a.location = '"+location+"'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            serviceRights = (ServiceRights) list.get(0);
        }
        return serviceRights;
    }
}
