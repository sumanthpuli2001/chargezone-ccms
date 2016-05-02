
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.UserMaster;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class UserMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
        UserMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return UserMaster.class;
    }

    @Override
    public List<?> readByUserName(T object) {
        UserMaster user = (UserMaster) object;
        String query = "";
        query += " FROM UserMaster a"
                + " WHERE a.userName = '" + user.getUserName() + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    public boolean isExist(String userName) {
        String query = "";
        query += " FROM UserMaster a"
                + " WHERE a.userName='" + userName + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<?> read(T object) {
        UserMaster user2 = (UserMaster) object;
        String hqlString = "from UserMaster um where um.userName='"
                + user2.getUserName()
                + "'"
                + " AND um.password='"
                + user2.getPassword()
                + "'";
        return getHibernateTemplate().find(hqlString);
    }

}
