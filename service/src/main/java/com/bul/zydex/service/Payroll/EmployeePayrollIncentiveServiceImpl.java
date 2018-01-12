/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeePayrollIncentiveDAO;
import com.bul.zydex.model.EmployeeIncentiveMonthwise;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeePayrollIncentiveServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeePayrollIncentiveService<T>{
 private EmployeePayrollIncentiveDAO<T> employeePayrollIncentiveDAO; 

    public EmployeePayrollIncentiveDAO<T> getEmployeePayrollIncentiveDAO() {
        return employeePayrollIncentiveDAO;
    }

    public void setEmployeePayrollIncentiveDAO(EmployeePayrollIncentiveDAO<T> employeePayrollIncentiveDAO) {
        this.employeePayrollIncentiveDAO = employeePayrollIncentiveDAO;
        setGenericsDAO(employeePayrollIncentiveDAO);
    }

    @Override
    public List<?> readByEmployeePayrollIncentive(String month, String Year) {
      return employeePayrollIncentiveDAO.readByEmployeePayrollIncentive(month, Year);
    }

    @Override
    public List<?> readByEmployeePayrollIncentivelistAmount(EmployeeIncentiveMonthwise employeeIncentiveMonthwise) {
     return employeePayrollIncentiveDAO.readByEmployeePayrollIncentivelistAmount(employeeIncentiveMonthwise);
    }

    @Override
    public List<?> readByEmployeePayrollIncentivelistAmountEdit(int id) {
      return employeePayrollIncentiveDAO.readByEmployeePayrollIncentivelistAmountEdit(id);
    }

    @Override
    public List<?> readByEmployeePayrollIncentiveReport(String month, String Year) {
      return employeePayrollIncentiveDAO.readByEmployeePayrollIncentiveReport(month, Year);
    }

    @Override
    public List<?> readByEmployeePayrollIncentiveReportnew(String month, String Year) {
      return employeePayrollIncentiveDAO.readByEmployeePayrollIncentiveReportnew(month, Year);
    }
 
}
