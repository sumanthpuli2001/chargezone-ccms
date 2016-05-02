/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.expense;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ExpenseReconsilation;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ExpenseReconsilationDAOImpl<T> extends GenericsDAOImpl<T> implements ExpenseReconsilationDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ExpenseReconsilation.class;
    }

    @Override
    public List<?> readExpenseReconsilationByExpenseID(int expenseId) {
        String query = "";
        query += " "
                + " FROM ExpenseReconsilation a "
                //                + " LEFT JOIN a.expenseMaster b"
                + " WHERE a.expenseMaster=" + expenseId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readExpenseReconsilationFoApprover(int expenseId) {
        String query = "";
        query += " Select (Select concat('Amount (',c.currencyName,'(',c.currencyCode,')',')') From CurrencyMaster c where c.id = a.currencyType) AS currency ,a.expenseInReport, a.expensePaid, a.cashAdvance, a.cashReturned, a.varianceOwed"
                + " FROM ExpenseReconsilation a "
                + " LEFT JOIN a.expenseMaster b"
                + " WHERE a.expenseMaster=" + expenseId;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
