/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.EmployeeIncentiveMonthwiseDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class EmployeeIncentiveMonthwiseServiceImpl<T> extends GenericsServiceImpl<T> implements EmployeeIncentiveMonthwiseService<T> {

    private EmployeeIncentiveMonthwiseDAO<T> employeeIncentiveMonthwiseDAO;

    public EmployeeIncentiveMonthwiseDAO<T> getEmployeeIncentiveMonthwiseDAO() {
        return employeeIncentiveMonthwiseDAO;
    }

    public void setEmployeeIncentiveMonthwiseDAO(EmployeeIncentiveMonthwiseDAO<T> employeeIncentiveMonthwiseDAO) {
        this.employeeIncentiveMonthwiseDAO = employeeIncentiveMonthwiseDAO;
        setGenericsDAO(employeeIncentiveMonthwiseDAO);
    }

    @Override
    public List<?> readEmployeeForIncentive(String pincentive, String aincentive, String month1, String year11) {
        return employeeIncentiveMonthwiseDAO.readEmployeeForIncentive(pincentive, aincentive, month1, year11);
    }

    @Override
    public void readByEmployeeIncentiveMonthwise(String month, String Year) {
         employeeIncentiveMonthwiseDAO.readByEmployeeIncentiveMonthwise(month, Year);
    }

}
