/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.mobileapp;

import com.bul.zydex.dao.mobileapp.EmployeePunchForMobileAppDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author admin
 * @param <T>
 */
public class EmployeePunchForMobileAppServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeePunchForMobileAppService<T>{

    private EmployeePunchForMobileAppDAO<T> employeePunchForMobileAppDAO;

    public EmployeePunchForMobileAppDAO<T> getEmployeePunchForMobileAppDAO() {
        return employeePunchForMobileAppDAO;
    }

    public void setEmployeePunchForMobileAppDAO(EmployeePunchForMobileAppDAO<T> employeePunchForMobileAppDAO) {
        this.employeePunchForMobileAppDAO = employeePunchForMobileAppDAO;
          setGenericsDAO(employeePunchForMobileAppDAO);
    }
    
    
}
