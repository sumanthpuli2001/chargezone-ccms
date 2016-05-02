/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.expenseTravelType;

import com.bul.zydex.dao.expenseTravelType.ExpenseTravelTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author dhruv
 */
public class ExpenseTravelTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ExpenseTravelTypeService<T> {

    private ExpenseTravelTypeDAO<T> expenseTravelTypeDAO;

    public ExpenseTravelTypeDAO<T> getExpenseTravelTypeDAO() {
        return expenseTravelTypeDAO;
    }

    public void setExpenseTravelTypeDAO(ExpenseTravelTypeDAO<T> expenseTravelTypeDAO) {
        this.expenseTravelTypeDAO = expenseTravelTypeDAO;
        setGenericsDAO(expenseTravelTypeDAO);
    }

    @Override
    public List<?> readByExpenseMasterId(int id) {
        return expenseTravelTypeDAO.readByExpenseMasterId(id);
    }

    @Override
    public List<?> readByExpenseMasterApproveList(int id) {
        return expenseTravelTypeDAO.readByExpenseMasterApproveList(id);
    }

}
