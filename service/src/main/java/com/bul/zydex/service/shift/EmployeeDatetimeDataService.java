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

}
