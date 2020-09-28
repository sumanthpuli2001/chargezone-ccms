
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.UserMaster;
import java.util.List;
import org.hibernate.Query;

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
                + " WHERE a.loginName = '" + user.getLoginName() + "'";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> read(T object) {
        UserMaster user2 = (UserMaster) object;
        String hqlString = "from UserMaster um where um.loginName='"
                + user2.getLoginName()
                + "'"
                + " AND um.password='"
                + user2.getPassword()
                + "'";
        return getHibernateTemplate().find(hqlString);
    }

    @Override
    public UserMaster read(String loginname) {
        UserMaster userMaster = new UserMaster();
        String query = "";
        query += " FROM UserMaster a"
                + " WHERE a.loginName = '" + loginname + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            userMaster = (UserMaster) list.get(0);
        }
        return userMaster;
    }

    @Override
    public void deleteByLoginName(String loginName) {

        String query = "";
        query = " delete FROM UserMaster a"
                + " WHERE a.loginName = '" + loginName + "'";

        Query q = getSessionFactory().openSession().createQuery(query);
            q.executeUpdate();

    }

   @Override
    public List readByDrow() {

        String query = "";
        query += " FROM UserMaster a"
                + " WHERE a.dRow = 'N' ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List readByDrowDisable() {
        String query = "";
        query += " FROM UserMaster a"
                + " WHERE a.dRow = 'Y' ";
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
