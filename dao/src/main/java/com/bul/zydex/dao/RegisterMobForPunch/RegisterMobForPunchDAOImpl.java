/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RegisterMobForPunch;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RegisterMobForPunch;
import java.util.List;

/**
 *
 * @author BlackBull
 */
public class RegisterMobForPunchDAOImpl<T> extends GenericsDAOImpl<T> implements RegisterMobForPunchDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RegisterMobForPunch.class;
    }

    @Override
    public List<?> readByEmpId(int id) {
       String query = "";

        query += "  "
                + "FROM RegisterMobForPunch a "
                + " WHERE a.employeeMaster = " + id;

        return getHibernateTemplate().find(query);
    }

}
