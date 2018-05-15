/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.EmployeeDatetimeDataDAO;
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
    public List<?> readTodaysAndPreviousData(String empId, String endShiftTime) {
        return employeeDatetimeDataDAO.readTodaysAndPreviousData(empId, endShiftTime);
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

    @Override
    public List<?> readYesterdayEmployeeData(String empId) {
        return employeeDatetimeDataDAO.readYesterdayEmployeeData(empId);
    }

    @Override
    public List<?> readEmployeeBySelectedDate(String date) {
        return employeeDatetimeDataDAO.readEmployeeBySelectedDate(date);
    }

    @Override
    public List<?> readYesterdayEmployeeDataBySelectedDate(String empId, String date) {
        return employeeDatetimeDataDAO.readYesterdayEmployeeDataBySelectedDate(empId, date);
    }

    @Override
    public List<?> readTodaysAndPreviousDataOnSelectedDate(String empId, String endShiftTime, String selectDate, String PreviousDate) {
        return employeeDatetimeDataDAO.readTodaysAndPreviousDataOnSelectedDate(empId, endShiftTime, selectDate, PreviousDate);
    }

    @Override
    public List<?> readSelectedDateEmployeeData(String empId, String date) {
        return employeeDatetimeDataDAO.readSelectedDateEmployeeData(empId, date);
    }

    @Override
    public List<?> readEmployeePunchDateWise(int empId, String Date) {
        return employeeDatetimeDataDAO.readEmployeePunchDateWise(empId, Date);
    }

    @Override
    public List<?> readEmployeeByDatevise(String date) {
        return employeeDatetimeDataDAO.readEmployeeByDatevise(date);
    }

    @Override
    public List<?> readOddPunchedEmployeeData(String date) {
        return employeeDatetimeDataDAO.readOddPunchedEmployeeData(date);
    }

}
