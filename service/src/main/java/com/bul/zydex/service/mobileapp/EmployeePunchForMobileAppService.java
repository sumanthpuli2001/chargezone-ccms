/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.mobileapp;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface EmployeePunchForMobileAppService<T> extends GenericsService<T> {

    List<?> readEmpByCurrentDate();

    List<?> readYesterdayEmployeeData(String empId);

    List<?> readTodaysAndPreviousData(String empId, String endShiftTime);

    List<?> readTodaysEmployeeData(String empId);

    List<?> readPuchDataDateWise(String date, int empId);
}
