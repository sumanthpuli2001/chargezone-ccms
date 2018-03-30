/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.policy;

import com.bul.zydex.dao.policy.EmployeeCtcDetailDAO;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeCtcDetailServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeCtcDetailService<T> {
      private  EmployeeCtcDetailDAO<T> employeeCtcDetailDAO;

    public EmployeeCtcDetailDAO<T> getEmployeeCtcDetailDAO() {
        return employeeCtcDetailDAO;
    }

    public void setEmployeeCtcDetailDAO(EmployeeCtcDetailDAO<T> employeeCtcDetailDAO) {
        this.employeeCtcDetailDAO = employeeCtcDetailDAO;
        setGenericsDAO(employeeCtcDetailDAO);
    }

    @Override
    public List<?> fetchctcData(int empId) {
      return employeeCtcDetailDAO.fetchctcData(empId);
    }

    @Override
    public List<?> readctc(int employeeid) {
       return employeeCtcDetailDAO.readctc(employeeid);
    }

    
      
}
