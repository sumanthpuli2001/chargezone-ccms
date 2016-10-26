/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.mobileapp;

import com.bul.zydex.dao.mobileapp.EmployeePunchForMobileAppDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public class EmployeePunchForMobileAppServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeePunchForMobileAppService<T> {

    private EmployeePunchForMobileAppDAO<T> employeePunchForMobileAppDAO;

    public EmployeePunchForMobileAppDAO<T> getEmployeePunchForMobileAppDAO() {
        return employeePunchForMobileAppDAO;
    }

    public void setEmployeePunchForMobileAppDAO(EmployeePunchForMobileAppDAO<T> employeePunchForMobileAppDAO) {
        this.employeePunchForMobileAppDAO = employeePunchForMobileAppDAO;
        setGenericsDAO(employeePunchForMobileAppDAO);
    }

    @Override
    public List<?> readEmpByCurrentDate() {
        return employeePunchForMobileAppDAO.readEmpByCurrentDate();
    }

    @Override
    public List<?> readYesterdayEmployeeData(String empId) {
     return employeePunchForMobileAppDAO.readYesterdayEmployeeData(empId);
    }

    @Override
    public List<?> readTodaysAndPreviousData(String empId, String endShiftTime) {
       return employeePunchForMobileAppDAO.readTodaysAndPreviousData(empId,endShiftTime);
    }

    @Override
    public List<?> readTodaysEmployeeData(String empId) {
          return employeePunchForMobileAppDAO.readTodaysEmployeeData(empId);
    }

    @Override
    public List<?> readPuchDataDateWise(String date, int empId) {
       return employeePunchForMobileAppDAO.readPuchDataDateWise(date, empId);
    }

}
