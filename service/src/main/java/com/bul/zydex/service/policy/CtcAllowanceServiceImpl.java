/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.policy;

import com.bul.zydex.dao.policy.CtcAllowanceDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class CtcAllowanceServiceImpl<T> extends GenericsServiceImpl<T> implements CtcAllowanceService<T> {

    private CtcAllowanceDAO<T> ctcAllowanceDAO;

    public CtcAllowanceDAO<T> getCtcAllowanceDAO() {
        return ctcAllowanceDAO;
    }

    public void setCtcAllowanceDAO(CtcAllowanceDAO<T> ctcAllowanceDAO) {
        this.ctcAllowanceDAO = ctcAllowanceDAO;
        setGenericsDAO(ctcAllowanceDAO);
    }

    @Override
    public boolean isExist(T object) {
        return ctcAllowanceDAO.isExist(object);
    }

    @Override
    public List<?> readsalSearch() {
       return ctcAllowanceDAO.readsalSearch();
    }

}
