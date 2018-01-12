/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeTypeWiseSalaryDAO;
import com.bul.zydex.model.EmployeeTypeWiseSalary;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeTypeWiseSalaryServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeTypeWiseSalaryService<T>{
    private EmployeeTypeWiseSalaryDAO<T> employeeTypeWiseSalaryDAO;

    public EmployeeTypeWiseSalaryDAO<T> getEmployeeTypeWiseSalaryDAO() {
        return employeeTypeWiseSalaryDAO;
    }

    public void setEmployeeTypeWiseSalaryDAO(EmployeeTypeWiseSalaryDAO<T> employeeTypeWiseSalaryDAO) {
        this.employeeTypeWiseSalaryDAO = employeeTypeWiseSalaryDAO;
        setGenericsDAO(employeeTypeWiseSalaryDAO);
    }

    @Override
    public List<?> readForAdditionalAmount(int empTypeId, int empSubTypeId) {
        return employeeTypeWiseSalaryDAO.readForAdditionalAmount(empTypeId, empSubTypeId);
    }

    @Override
    public List<?> readForMasterAdditionalAmount(int empTypeId, int empSubTypeId, int payrollSalaryId) {
        return employeeTypeWiseSalaryDAO.readForMasterAdditionalAmount(empTypeId, empSubTypeId, payrollSalaryId);
        
    }

    @Override
    public boolean isExist(EmployeeTypeWiseSalary employeeTypeWiseSalary) {
       
             boolean flag = false;
        List<?> list = employeeTypeWiseSalaryDAO.read();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            EmployeeTypeWiseSalary employeeTypeWiseSalary1 = (EmployeeTypeWiseSalary) i.next();
            if (employeeTypeWiseSalary1.getEmployeeTypeMaster().getId().intValue()
                    == employeeTypeWiseSalary.getEmployeeTypeMaster().getId() 
                    && employeeTypeWiseSalary1.getEmployeeSubType().getId().intValue() == employeeTypeWiseSalary.getEmployeeSubType().getId()
                    && employeeTypeWiseSalary1.getZydexLocationMaster().getId().intValue() == employeeTypeWiseSalary.getZydexLocationMaster().getId()) {

                flag = true;
                break;
            }

        }

        return flag;
    }
    
}
