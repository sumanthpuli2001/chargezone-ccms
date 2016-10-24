/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.mobileapp;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author admin
 */
public interface EmployeePunchForMobileAppDAO<T> extends GenericsDAO<T> {
  List<?> readEmpByCurrentDate();  
  
  List<?> readYesterdayEmployeeData(String empId);
  
  List<?> readTodaysAndPreviousData(String empId, String endShiftTime);
  
  List<?> readTodaysEmployeeData(String empId);
}
