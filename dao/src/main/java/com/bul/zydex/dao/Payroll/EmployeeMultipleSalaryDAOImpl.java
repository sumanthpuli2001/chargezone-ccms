/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeMultipleSalary;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeMultipleSalaryDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeMultipleSalaryDAO<T>{

    @Override
    protected Class getDomainClass() {
      return EmployeeMultipleSalary.class;  
    }

    @Override
    public List<?> readBytypeWiseSalary(int id) {
        String query ="From EmployeeMultipleSalary "
                + "where employeeTypeWiseSalary.id = "+id;
        
        return getHibernateTemplate().find(query);
    }
    
    
    
}
