/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.Punch;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class PunchDAOImpl<T> extends GenericsDAOImpl<T> implements PunchDAO<T> {

    @Override
    protected Class getDomainClass() {
        return Punch.class;
    }

    public List<?> readByPunchUserId(T object) {
        Punch punch = (Punch) object;
        String query = "";

        query += "FROM Punch a"
                + " Where a.userMaster=" + punch.getUserMaster().getId();

        return getHibernateTemplate().find(query);
    }
}
