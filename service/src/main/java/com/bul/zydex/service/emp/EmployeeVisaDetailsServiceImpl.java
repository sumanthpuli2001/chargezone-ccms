/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.emp;

import com.bul.zydex.dao.emp.EmployeeVisaDetailsDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class EmployeeVisaDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeVisaDetailsService<T>{
    private EmployeeVisaDetailsDAO<T> employeeVisaDetailsDAO;

    public EmployeeVisaDetailsDAO<T> getEmployeeVisaDetailsDAO() {
        return employeeVisaDetailsDAO;
    }

    public void setEmployeeVisaDetailsDAO(EmployeeVisaDetailsDAO<T> employeeVisaDetailsDAO) {
        this.employeeVisaDetailsDAO = employeeVisaDetailsDAO;
        setGenericsDAO(employeeVisaDetailsDAO);
    }

    @Override
    public List<?> readByemployeeId(Integer id) {
        return employeeVisaDetailsDAO.readByemployeeId(id);
    }

    @Override
    public void deleteByemployeeId(Integer id) {
        employeeVisaDetailsDAO.deleteByemployeeId(id);
    }

    @Override
    public boolean employeeVisadetailsexist(Integer id) {
        return employeeVisaDetailsDAO.employeeVisadetailsexist(id);
    }
    
    
}
