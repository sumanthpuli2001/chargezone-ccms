/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.probation;

import com.bul.zydex.dao.probation.ProbationPeriodDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author AJAY
 */
public class ProbationPeriodServiceImpl<T> extends GenericsServiceImpl<T>
        implements ProbationPeriodService<T> {

    protected ProbationPeriodDAO<T> probationPeriodDAO;

    public ProbationPeriodDAO<T> getProbationPeriodDAO() {
        return probationPeriodDAO;
    }

    public void setProbationPeriodDAO(ProbationPeriodDAO<T> probationPeriodDAO) {
        this.probationPeriodDAO = probationPeriodDAO;
        setGenericsDAO(probationPeriodDAO);
    }

    @Override
    public List<?> readprobationPeriod() {
        return probationPeriodDAO.readprobationPeriod();
    }

    @Override
    public boolean isExist(T object) {
        return probationPeriodDAO.isExist(object);
    }

    @Override
    public List<?> readbyDesignation(int id) {
        return probationPeriodDAO.readbyDesignation(id);
    }

}
