/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.ClosePrMultiAttach;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ClosePrMultiAttach;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ClosePrMultiAttachDaoImpl<T> extends GenericsDAOImpl<T> implements ClosePrMultiAttachDao<T> {

    @Override
    protected Class getDomainClass() {
        return ClosePrMultiAttach.class;
    }

    @Override
    public List readByprNo(String prno) {

        String query = "";
        query += " FROM ClosePrMultiAttach a"
                + " WHERE a.prNo = '" + prno + "'";
        return getHibernateTemplate().find(query);

    }

}
