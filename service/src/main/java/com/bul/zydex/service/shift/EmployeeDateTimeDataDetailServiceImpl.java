/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.EmployeeDateTimeDataDetailDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Teja
 */
public class EmployeeDateTimeDataDetailServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeDateTimeDataDetailService<T> 
{
    private EmployeeDateTimeDataDetailDAO<T> employeeDateTimeDataDetailDAO;

    public EmployeeDateTimeDataDetailDAO<T> getEmployeeDateTimeDataDetailDAO() {
        return employeeDateTimeDataDetailDAO;
    }

    public void setEmployeeDateTimeDataDetailDAO(EmployeeDateTimeDataDetailDAO<T> employeeDateTimeDataDetailDAO) {
        this.employeeDateTimeDataDetailDAO = employeeDateTimeDataDetailDAO;
        setGenericsDAO(employeeDateTimeDataDetailDAO);
    }
    
    
}
