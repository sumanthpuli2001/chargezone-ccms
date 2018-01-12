/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollSalaryType;

/**
 *
 * @author Nishant
 */
public class PayrollSalaryTypeDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollSalaryTypeDAO<T> {

    @Override
    protected Class getDomainClass() {
          return PayrollSalaryType.class;
    }
    
}
