/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RetirementAge;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class RetirementAgeDAOImpl<T> extends GenericsDAOImpl<T> implements RetirementAgeDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RetirementAge.class;
    }
    
      @Override
    public boolean isExist(T object) {
        boolean flag = false;
        RetirementAge retirementAge = (RetirementAge) object;
        List list = getHibernateTemplate().find("from RetirementAge where retireAge='" + retirementAge.getRetireAge() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    
}
