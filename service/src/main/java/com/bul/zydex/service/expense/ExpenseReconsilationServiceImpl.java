/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.expense;

import com.bul.zydex.dao.expense.ExpenseReconsilationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ExpenseReconsilationServiceImpl<T> extends GenericsServiceImpl<T> implements ExpenseReconsilationService<T> {

    private ExpenseReconsilationDAO<T> expenseReconsilationDAO;

    public ExpenseReconsilationDAO<T> getExpenseReconsilationDAO() {
        return expenseReconsilationDAO;
    }

    public void setExpenseReconsilationDAO(ExpenseReconsilationDAO<T> expenseReconsilationDAO) {
        this.expenseReconsilationDAO = expenseReconsilationDAO;
        setGenericsDAO(expenseReconsilationDAO);
    }

    @Override
    public List<?> readExpenseReconsilationByExpenseID(int expenseId) {
        return expenseReconsilationDAO.readExpenseReconsilationByExpenseID(expenseId);
    }

    @Override
    public List<?> readExpenseReconsilationFoApprover(int expenseId) {
        return expenseReconsilationDAO.readExpenseReconsilationFoApprover(expenseId);
    }

}
