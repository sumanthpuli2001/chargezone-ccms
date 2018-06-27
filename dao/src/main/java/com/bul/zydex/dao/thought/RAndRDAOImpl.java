/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.thought;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RAndR;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class RAndRDAOImpl<T> extends GenericsDAOImpl<T> implements RAndRDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RAndR.class;
    }

    @Override
    public List<?> readrandrDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.imagesPath, a.disc"
                + " FROM RAndR a "
                + " ORDER BY a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public boolean isExist(String name) {
        boolean flag = false;
        List list = getHibernateTemplate().find("from RAndR where disc='" + name + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }
}
