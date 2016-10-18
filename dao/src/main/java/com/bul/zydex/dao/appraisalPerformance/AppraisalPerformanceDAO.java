/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AppraisalFillingData;
import com.bul.zydex.model.AppraisalPerformanceMaster;
import com.bul.zydex.model.EmployeeMaster;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AppraisalPerformanceDAO<T> extends GenericsDAO<T> {

    public List<?> readEmployeesAppraisalPerformance(EmployeeMaster employeeMaster, boolean hr);

    public List<?> readByAppraisalPerformanceId(String employeeId, int year);

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
