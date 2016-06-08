/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.EmployeeDatetimeDataDAO;
import com.bul.zydex.dao.shift.TemporaryShiftAssignDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class EmployeeDatetimeDataServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeDatetimeDataService<T> {

    private EmployeeDatetimeDataDAO<T> employeeDatetimeDataDAO;

    public EmployeeDatetimeDataDAO<T> getEmployeeDatetimeDataDAO() {
        return employeeDatetimeDataDAO;
    }

    public void setEmployeeDatetimeDataDAO(EmployeeDatetimeDataDAO<T> employeeDatetimeDataDAO) {
        this.employeeDatetimeDataDAO = employeeDatetimeDataDAO;
        setGenericsDAO(employeeDatetimeDataDAO);
    }

    @Override
    public List<?> readTodaysAndPreviousData(String empId,String endShiftTime) {
        return employeeDatetimeDataDAO.readTodaysAndPreviousData(empId,endShiftTime);
    }

    @Override
    public List<?> readPuchDataDateWise(String date, int empId) {
        return employeeDatetimeDataDAO.readPuchDataDateWise(date, empId);
    }

    @Override
    public List<?> readPuchDataEmpIdWise(int empId) {
        return employeeDatetimeDataDAO.readPuchDataEmpIdWise(empId);
    }
    @Override
   public List<?> readTodaysEmployeeData(String empId) {
        return employeeDatetimeDataDAO.readTodaysEmployeeData(empId);
    }
    @Override
   public List<?> readEmployeeByCurrentDate() {
        return employeeDatetimeDataDAO.readEmployeeByCurrentDate();
    }
    @Override
    public List<?> todaysData(int id) {
        return employeeDatetimeDataDAO.todaysData(id);
    }
}
