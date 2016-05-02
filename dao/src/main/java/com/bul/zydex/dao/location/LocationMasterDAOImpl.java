/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.location;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LocationMaster;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public class LocationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements LocationMasterDAO<T> {

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        LocationMaster locationMaster = (LocationMaster) object;
        List<?> list = getHibernateTemplate().find("from LocationMaster  where location ='" + locationMaster.getLocation() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readEmpByLocation() {
        String hqryString = "select lm.location, count(em.id) from LocationMaster lm"
                + " right join lm.employeeMasters em"
                + " where (em.dateOfLeaving is null or em.dateOfLeaving = '') "
                + " or STR_TO_DATE(em.dateOfLeaving,'%d/%m/%Y - %H:%i') > now()"
                + " group by em.locationMaster.id"
                + " order by lm.location";
        return getHibernateTemplate().find(hqryString);
    }

    @Override
    protected Class getDomainClass() {
        return LocationMaster.class;
    }

     @Override
    public List<?> readByName(String workLocation) {
         String query = "";
          query += "From LocationMaster a "
//                + " Where a.location like '%" + workLocation + "'";
                + " Where lower(trim(a.location)) ='" + workLocation + "'";
       return getHibernateTemplate().find(query);
    }
}
