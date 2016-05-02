/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.otherExpense;

import com.bul.zydex.dao.otherExpense.RelocationOrOtherExpenseDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class RelocationOrOtherExpenseServiceImpl<T> extends GenericsServiceImpl<T> implements RelocationOrOtherExpenseService<T> {

    private RelocationOrOtherExpenseDAO<T> relocationOrOtherExpenseDAO;

    public RelocationOrOtherExpenseDAO<T> getRelocationOrOtherExpenseDAO() {
        return relocationOrOtherExpenseDAO;
    }

    public void setRelocationOrOtherExpenseDAO(RelocationOrOtherExpenseDAO<T> relocationOrOtherExpenseDAO) {
        this.relocationOrOtherExpenseDAO = relocationOrOtherExpenseDAO;
        setGenericsDAO(relocationOrOtherExpenseDAO);
    }

    @Override
    public List<?> readByExpenseMasterId(int id) {
        return relocationOrOtherExpenseDAO.readByExpenseMasterId(id);
    }

    @Override
    public List<?> readByExpenseMasterApproveList(int id) {
        return relocationOrOtherExpenseDAO.readByExpenseMasterApproveList(id);
    }
}
