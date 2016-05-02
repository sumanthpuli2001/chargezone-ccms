/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.expenseOtherType;

import com.bul.zydex.dao.expenseOtherType.ExpenseOtherTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ExpenseOtherTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ExpenseOtherTypeService<T> {

    private ExpenseOtherTypeDAO<T> expenseOtherTypeDAO;

    public ExpenseOtherTypeDAO<T> getExpenseOtherTypeDAO() {
        return expenseOtherTypeDAO;
    }

    public void setExpenseOtherTypeDAO(ExpenseOtherTypeDAO<T> expenseOtherTypeDAO) {
        this.expenseOtherTypeDAO = expenseOtherTypeDAO;
        setGenericsDAO(expenseOtherTypeDAO);
    }

    @Override
    public List<?> readByExpenseMasterId(int id) {
        return expenseOtherTypeDAO.readByExpenseMasterId(id);
    }

    @Override
    public List<?> readByExpenseMasterApproveList(int id) {
        return expenseOtherTypeDAO.readByExpenseMasterApproveList(id);
    }

}
