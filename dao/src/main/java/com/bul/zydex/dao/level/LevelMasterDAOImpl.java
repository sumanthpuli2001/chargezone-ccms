/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.level;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.LevelMaster;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelMasterDAOImpl<T> extends GenericsDAOImpl<T> implements LevelMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return LevelMaster.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        LevelMaster levelMaster = (LevelMaster) object;
        List list = getHibernateTemplate().find("from LevelMaster where level='" + levelMaster.getLevel() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    @Override
    public List<?> readByName(String name) {
         String query = "";
          query += "From LevelMaster a "
//                + " Where a.level like '%" + name + "'";
                + " Where lower(trim(a.level)) ='" + name + "'";
       return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readByID(int emplevel) {
        String query = "";
        query += "From LevelMaster a "
              + " Where a.id =" + emplevel ;
        return getHibernateTemplate().find(query);
    }

}
