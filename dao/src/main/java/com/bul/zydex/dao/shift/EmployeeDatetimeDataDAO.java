/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public interface EmployeeDatetimeDataDAO<T> extends GenericsDAO<T> {

    public List<?> readTodaysAndPreviousData(String empId, String endShiftTime);

    public List<?> readPuchDataDateWise(String date, int empId);

    public List<?> readPuchDataEmpIdWise(int empId);

    public List<?> readTodaysEmployeeData(String empId);

    public List<?> readEmployeeByCurrentDate();

    public List<?> todaysData(int id);

    public List<?> readYesterdayEmployeeData(String empId);

    public List<?> readEmployeeBySelectedDate(String date);

    public List<?> readYesterdayEmployeeDataBySelectedDate(String empId, String date);

    public List<?> readTodaysAndPreviousDataOnSelectedDate(String empId, String endShiftTime, String selectDate, String PreviousDate);

    public List<?> readSelectedDateEmployeeData(String empId, String date);

    public List<?> readEmployeePunchDateWise(int empId, String Date);

    public List<?> readEmployeeByDatevise(String date);

    public List<?> readOddPunchedEmployeeData(String date);


}
