/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.expenseOtherType;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ExpenseOtherType;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ExpenseOtherTypeDAOImpl<T> extends GenericsDAOImpl<T> implements ExpenseOtherTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ExpenseOtherType.class;
    }

    @Override
    public List<?> readByExpenseMasterId(int id) {
        String query = "";
        query += " "
                + " FROM ExpenseOtherType a "
                + " WHERE a.expenseMaster.id=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByExpenseMasterApproveList(int id) {
        String query = "";
        query += " "
                + " FROM ExpenseOtherType a "
                + " WHERE a.status=0 and a.expenseMaster.id=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
