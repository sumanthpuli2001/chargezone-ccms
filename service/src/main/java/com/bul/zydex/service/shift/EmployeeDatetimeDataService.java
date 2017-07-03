package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.List;

public interface EmployeeDatetimeDataService<T> extends GenericsService<T> {

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
   
}
