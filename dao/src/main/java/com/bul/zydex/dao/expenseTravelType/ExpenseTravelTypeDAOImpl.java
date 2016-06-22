/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.expenseTravelType;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ExpenseTravelType;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ExpenseTravelTypeDAOImpl<T> extends GenericsDAOImpl<T> implements ExpenseTravelTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ExpenseTravelType.class;
    }

    @Override
    public List<?> readByExpenseMasterId(int id) {
        String query = "";
        query += " "
                + " FROM ExpenseTravelType a "
                + " WHERE a.expenseMaster.id=" + id
                + " ORDER BY a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByExpenseMasterApproveList(int id) {
        String query = "";
        query += " "
                + " FROM ExpenseTravelType a "
                + " WHERE a.status=0 and  a.expenseMaster.id=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
