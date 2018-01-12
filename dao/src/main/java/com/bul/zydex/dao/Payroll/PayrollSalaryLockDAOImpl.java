/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PayrollSalaryLock;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollSalaryLockDAOImpl<T> extends GenericsDAOImpl<T> implements PayrollSalaryLockDAO<T>{

    @Override
    protected Class getDomainClass() {
         return PayrollSalaryLock.class;
    }

    @Override
    public boolean payRollAmountCheckIsExist(T object) {
      PayrollSalaryLock payrollSalaryLock = (PayrollSalaryLock) object;
        String query = "";
        query = "select a.id from PayrollSalaryLock a where "
                + " a.pmonth='" + payrollSalaryLock.getPmonth() + "'"
                + " and a.pyear='" + payrollSalaryLock.getPyear() + "'";
              

      
        List<?> list = getHibernateTemplate().find(query);
        if (list.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
    }
    

