/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.AdditionalAmountCheckDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class AdditionalAmountCheckServiceImpl<T> extends GenericsServiceImpl<T> implements AdditionalAmountCheckService<T>{
      private AdditionalAmountCheckDAO<T> additionalAmountCheckDAO;

    public AdditionalAmountCheckDAO<T> getAdditionalAmountCheckDAO() {
        return additionalAmountCheckDAO;
    }

    public void setAdditionalAmountCheckDAO(AdditionalAmountCheckDAO<T> additionalAmountCheckDAO) {
        this.additionalAmountCheckDAO = additionalAmountCheckDAO;
        setGenericsDAO(additionalAmountCheckDAO);
    }
      
}
