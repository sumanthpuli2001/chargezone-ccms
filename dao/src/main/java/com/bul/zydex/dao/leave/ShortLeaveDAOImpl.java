/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.leave;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ShortLeave;
import java.util.List;

/**
 *
 * @author Khurshid Khokhar <Khokharkhurshid123@gmail.com>
 */
public class ShortLeaveDAOImpl<T> extends GenericsDAOImpl<T> implements ShortLeaveDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ShortLeave.class;
    }

    @Override
    public boolean isExist(T object) {
        ShortLeave shortLeave = (ShortLeave) object;
        boolean flag = true;
        String query = "";

        query += " FROM ShortLeave a"
                + " WHERE a.zydexLocationMaster.id = " + shortLeave.getZydexLocationMaster().getId();

        List list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<?> readByDept(T object) {
        ShortLeave shortLeave = (ShortLeave) object;
        String query = "";

        query += " FROM ShortLeave a"
                + " WHERE a.zydexLocationMaster.id = " +shortLeave.getZydexLocationMaster().getId();

        return getHibernateTemplate().find(query);
    }
}
