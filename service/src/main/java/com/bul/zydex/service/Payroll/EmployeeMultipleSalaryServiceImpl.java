/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeMultipleSalaryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class EmployeeMultipleSalaryServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeMultipleSalaryService<T>{
    private EmployeeMultipleSalaryDAO<T> employeeMultipleSalaryDAO;

    public EmployeeMultipleSalaryDAO<T> getEmployeeMultipleSalaryDAO() {
        return employeeMultipleSalaryDAO;
    }

    public void setEmployeeMultipleSalaryDAO(EmployeeMultipleSalaryDAO<T> employeeMultipleSalaryDAO) {
        this.employeeMultipleSalaryDAO = employeeMultipleSalaryDAO;
        setGenericsDAO(employeeMultipleSalaryDAO);
    }

    @Override
    public List<?> readBytypeWiseSalary(int id) {
        return employeeMultipleSalaryDAO.readBytypeWiseSalary(id);
    }
    
}
