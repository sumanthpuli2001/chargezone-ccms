package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface EmployeeDatetimeDataService<T> extends GenericsService<T> {

    public List<?> readTodaysAndPreviousData(String empId, String endShiftTime);

    public List<?> readPuchDataDateWise(String date, int empId);
    
    public List<?> readPuchDataDateWiseAll(String date, int empId);

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

    public List<?> readEmployeePunchData(String empId);

    public String getShiftsTime(String empId);

    public String getEmailAddress(String empId);
    
    public List readAllPuchDataDateWise(String tdate, int id);

    public List readALLPuchOnlyDataDateWise(String startDate, int id);
   
}
