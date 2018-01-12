/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeTypeWiseSalaryDAOImpl<T> extends GenericsDAOImpl<T> implements EmployeeTypeWiseSalaryDAO<T>{

    @Override
    protected Class getDomainClass() {
       return EmployeeTypeWiseSalary.class;
     
    }
     @Override
    public List<?> readForAdditionalAmount(int empTypeId, int empSubTypeId) {
        
        String query=" Select c.id, c.text,"
                + " d.amountType, d.salaryTypeAmount "
                + " From EmployeeTypeWiseSalary a"
                + " left join a.employeeMultipleSalaries b"
                + " left join b.payrollSalaryType c"
                + " left join c.additionalAmountChecks d"
                + " where a.employeeTypeMaster.id="+empTypeId
                + " and a.employeeSubType.id="+empSubTypeId;
        
     return getHibernateTemplate().find(query);   
    }

    @Override
    public List<?> readForMasterAdditionalAmount(int empTypeId, int empSubTypeId, int payrollSalaryId) {
        
        String query=" Select c.id, c.text,"
                + " d.amountType, d.salaryTypeAmount "
                + " From EmployeeTypeWiseSalary a"
                + " left join a.employeeMultipleSalaries b"
                + " left join b.payrollSalaryType c"
                + " left join c.additionalAmountChecks d"
                + " where a.employeeTypeMaster.id="+empTypeId
                + " and a.employeeSubType.id="+empSubTypeId
                + " and c.id="+payrollSalaryId;
        
     return getHibernateTemplate().find(query);   
    }
    
}
