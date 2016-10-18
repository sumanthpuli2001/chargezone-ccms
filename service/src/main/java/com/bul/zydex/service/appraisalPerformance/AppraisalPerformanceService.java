/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.appraisalPerformance;

import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AppraisalPerformanceService<T> extends GenericsService<T> {

    public List<?> readEmployeesAppraisalPerformance(EmployeeMaster employeeMaster, boolean hr);

    public List<?> readByAppraisalPerformanceId(String employee, int year);

    public List<?> readByAppraisalPerformanceIdAndYearWise(String employeeId, int year);

    public Object[] readperformanceByHr(final int currentYear);

    public List<?> readperformanceByHr();

    public List<?> readOwnAppraisalPerformance(EmployeeMaster employeeMaster, int cyear);

    public List<?> readPMPSearchByEmployee(T object);

    public List<?> readIDPSearchByEmployee(T object);

    public List<?> readcompetencySearchByEmployee(T object);

    public List<?> readstageWiseSearchByEmployee(T object, AppraisalFillingData appraisalFillingData);

    public List<?> readEmpIdFromTabId(int id);

    public List<?> readIDPSearchByEmployeeWise(T object);
    
    public List<?> readPendingEmployeePmp(int employeeId, int year); 
    
    public List<?> readPendingEmployeePmpByManager(String employeeId, int year); 
    
    public List<?> readEmpIdByAppraisalPerformanceId(); 
}
