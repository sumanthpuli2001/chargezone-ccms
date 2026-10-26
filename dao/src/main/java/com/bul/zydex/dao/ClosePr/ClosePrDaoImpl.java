/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ClosePr;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ClosePr;
import com.bul.zydex.model.PRMaster;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class ClosePrDaoImpl<T> extends GenericsDAOImpl<T> implements ClosePrDao<T> {

    @Override
    protected Class getDomainClass() {
        return ClosePr.class;
    }

    @Override
    public ClosePr readByPrID(int id) {

        ClosePr closepr = new ClosePr();
        String query = "";
        query += " FROM ClosePr a"
                + " WHERE a.prMasterId = '" + id + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            closepr = (ClosePr) list.get(0);
        }
        return closepr;
    }

}
