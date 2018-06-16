/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.RetirementAgeDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Hussain
 */
public class RetirementAgeServiceImpl<T> extends GenericsServiceImpl<T> implements RetirementAgeService<T> {
      private RetirementAgeDAO<T> retirementAgeDAO;

    public RetirementAgeDAO<T> getRetirementAgeDAO() {
        return retirementAgeDAO;
    }

    public void setRetirementAgeDAO(RetirementAgeDAO<T> retirementAgeDAO) {
        this.retirementAgeDAO = retirementAgeDAO;
        setGenericsDAO(retirementAgeDAO);
    }

    @Override
    public boolean isExist(T object) {
        return retirementAgeDAO.isExist(object);
    }
      
}
